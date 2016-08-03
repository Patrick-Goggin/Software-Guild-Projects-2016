/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstoneblog.dao;

import com.mycompany.capstoneblog.dto.Article;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class ArticleDAODbImpl implements ArticleDAO {
private JdbcTemplate jdbcTemplate;
    // #2b - We are using Setter Injection to direct Spring to hand us an instance of
    // the JdbcTemplate (see the Spring Configuration section below for configuration
    // details).
private static final String SQL_INSERT_ARTICLE
            = "insert into article (articleHead, hashtag) values (?, ?)";
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Article> getActiveArticles() {
        
        
        return new ArrayList<Article>();
    }
    
@Override
    public List<Article>getFutureArticles(){
        
    return new ArrayList<Article>();
    }
    
    
@Override
    public List<Article>getArticlesForReview(){
        
    
        
    return new ArrayList<Article>();
    }
    
    
@Override
    public List<String>getStaticPageHeaders(){
        
    return new ArrayList<String>();
    }
    
    
@Override
    public List<String>getStaticPageBodies(){
        
    return new ArrayList<String>();
    }
    
@Override
    public List<Article>getStaticPages(){
        
    return new ArrayList<Article>()
            ;}
    
@Override
    public List<Article>searchByHashTag(String hashtag){
        
        return new ArrayList<Article>();
    }
    
    
@Override
    public Article getArticleByID(int articleID){
       
        return new Article();
    }
    
@Override
    public void changeArticleStatus(int status){
        
    }
    
@Override
    public void removeArticle(int articleID){
        
    }
    
    
@Override
    public void editArticle(Article article){
     
        
    ;}
   // public Article addArticle(Article post);
@Override
    public void addHashTag(ArrayList<String> hashtags, int articleID){
        
      
    }
    
    
@Override
    public List<String> getAllHashTags(){
        
        return new ArrayList<String>();
    }
    
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Article addArticle(Article article) {
        
        
        return new Article();
    }

    private static final class PostMapper implements RowMapper<Article> {

        @Override
        public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
            Article post = new Article();
            post.setArticleBody(rs.getString("content"));
        
            return post;
        }
    }
}
