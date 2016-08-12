package com.mycompany.capstoneblog.dao;

import com.mycompany.capstoneblog.dto.Article;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import static java.util.stream.Collectors.toSet;
import org.jsoup.Jsoup;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class ArticleDAODbImpl implements ArticleDAO {

    private JdbcTemplate jdbcTemplate;

    // Statuses are as follows:
    //=========================
    // 1: Active
    // 2: Inactive
    // 3: Pending for review
    // 4: Future (approved but haven't posted yet)
    //Single Article
    //================
    private static final String SQL_SELECT_ARTICLE
            = "SELECT * FROM Article WHERE articleID = ?";

    private static final String SQL_INSERT_ARTICLE
            = "INSERT INTO Article (articleHead, articleBody, postingDate, takeDownDate, activeStatus, staticPage, hashtag) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_CHANGE_ARTICLE_STATUS
            = "UPDATE Article SET activeStatus = ? WHERE articleID = ?";

    private static final String SQL_UPDATE_ARTICLE
            = "UPDATE Article SET articleHead = ?, articleBody = ?, postingDate = ?, takeDownDate = ?, activeStatus = ?, staticPage = ?, hashtag = ? WHERE articleID = ?";

    private static final String SQL_DELETE_ARTICLE
            = "DELETE FROM Article WHERE articleID = ?";

    //Lists of Articles
    //===================
    private static final String SQL_SELECT_ACTIVE_ARTICLES
            = "SELECT * FROM Article WHERE postingDate <= now() and takeDownDate >= now() AND staticPage = false AND activeStatus !=3 AND activeStatus !=4 ORDER BY postingDate DESC, articleHead";

    private static final String SQL_SELECT_ARTICLES_FOR_REVIEW
            = "SELECT * FROM Article WHERE activeStatus = 3 ORDER BY postingDate DESC, articleHead";

    private static final String SQL_SELECT_ARTICLES_PENDING_PUBLISH
            = "SELECT * FROM Article WHERE activeStatus = 4 ORDER BY postingDate DESC, articleHead";

    private static final String SQL_SELECT_ALL_STATIC_PAGES
            = "SELECT * FROM Article WHERE staticPage = true ORDER BY postingDate DESC, articleHead";

    private static final String SQL_SELECT_ACTIVE_STATIC_PAGES
            = "SELECT * FROM Article WHERE staticPage = true AND activeStatus = 1 ORDER BY postingDate DESC, articleHead";

    private static final String SQL_SELECT_STATIC_PAGE_HEADERS
            = "SELECT articleHead FROM Article WHERE staticPage = true AND activeStatus = 1 ORDER BY postingDate DESC, articleHead";

    //Hashtags
    //=========

    //Double check query
    private static final String SQL_SELECT_ALL_HASHTAGS
            = "SELECT DISTINCT hashtag FROM Article";

    //Double check query
    private static final String SQL_SELECT_BY_HASHTAG
            = "SELECT * FROM Article  WHERE hashtag like %?%";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Single Article CRUD
    //======================
    @Override
    public Article getArticleByID(int articleID) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ARTICLE,
                    new ArticleMapper(), articleID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Article addArticle(Article article) {

        if (article.getActiveStatus() != 1) {
            article.setActiveStatus(3);
        }
        jdbcTemplate.update(SQL_INSERT_ARTICLE,
                article.getArticleHead(),
                article.getArticleBody(),
                article.getPostingDate(),
                article.getTakeDownDate(),
                article.getActiveStatus(),
                article.isStaticPage(),
                grabHashtags(article.getArticleBody()));

        article.setArticleID(jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class));
        return new Article();
    }

    @Override
    public void editArticle(Article article) {
        jdbcTemplate.update(SQL_UPDATE_ARTICLE, article.getArticleHead(),
                article.getArticleBody(), article.getPostingDate(),
                article.getTakeDownDate(), article.getActiveStatus(),
                article.isStaticPage(), grabHashtags(article.getArticleBody()), 
                article.getArticleID());
    }

    @Override
    public void removeArticle(int articleID) {
        jdbcTemplate.update(SQL_DELETE_ARTICLE, articleID);
    }

    @Override
    public void changeArticleStatus(int status, int articleID) {
        jdbcTemplate.update(SQL_CHANGE_ARTICLE_STATUS, status, articleID);
    }

    //Get Lists
    //==========
    @Override
    public List<Article> getActiveArticles() {
        return jdbcTemplate.query(SQL_SELECT_ACTIVE_ARTICLES, new ArticleMapper());
    }

    @Override
    public List<Article> getFutureArticles() {
        return jdbcTemplate.query(SQL_SELECT_ARTICLES_PENDING_PUBLISH, new ArticleMapper());
    }

    @Override
    public List<Article> getArticlesForReview() {
        return jdbcTemplate.query(SQL_SELECT_ARTICLES_FOR_REVIEW, new ArticleMapper());
    }

    @Override
    public List<String> getStaticPageHeaders() {
        return jdbcTemplate.query(SQL_SELECT_STATIC_PAGE_HEADERS, new StringMapper("articleHeader"));
    }

    @Override
    public List<String> getStaticPageBodies() {
        return new ArrayList<String>();
    }

    @Override
    public List<Article> getAllStaticPages() {
        return jdbcTemplate.query(SQL_SELECT_ALL_STATIC_PAGES, new ArticleMapper());
    }

    @Override
    public List<Article> getActiveStaticPages() {
        return jdbcTemplate.query(SQL_SELECT_ACTIVE_STATIC_PAGES, new ArticleMapper());
    }

    //Hashtags
    //=========
    @Override
    public String grabHashtags(String articleBody) {
        String noHTMLTags = Jsoup.parse(articleBody).text();
        String[] words = noHTMLTags.split(" ");
        HashSet<String> hashtags = new HashSet<>();
        String tags = "";
        for (String word : words) {
            if (word.startsWith("#")) {
                hashtags.add(word);
            }
        }
        return hashtags.stream().map((w) -> w).reduce(tags, String::concat);
    }
    

    @Override
    public List<Article> searchByHashTag(String hashtag) {
        return jdbcTemplate.query(SQL_SELECT_BY_HASHTAG, new ArticleMapper(), hashtag);
    }

    @Override
    public HashSet<String> getAllHashTags() {
        ArrayList<String> tagsFromDB = new ArrayList <>(jdbcTemplate.query(SQL_SELECT_ALL_HASHTAGS, new StringMapper("hashtag")));
        return (HashSet) tagsFromDB.stream().collect(toSet());
    }

    private static final class ArticleMapper implements RowMapper<Article> {

        @Override
        public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
            Article article = new Article();
            article.setArticleBody(rs.getString("articleBody"));
            article.setActiveStatus(rs.getInt("activeStatus"));
            article.setArticleID(rs.getInt("articleID"));
            article.setArticleHead(rs.getString("articleHead"));
            article.setPostingDate(rs.getDate("postingDate"));
            article.setTakeDownDate(rs.getDate("takeDownDate"));
            article.setHashtags(rs.getString("hashtag"));

            return article;
        }
    }

    private static final class StringMapper implements RowMapper<String> {

        private String column;

        public StringMapper(String column) {
            this.column = column;
        }

        @Override
        public String mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getString(column);
        }
    }

}