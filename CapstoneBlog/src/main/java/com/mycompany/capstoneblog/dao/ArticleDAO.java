/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstoneblog.dao;

import com.mycompany.capstoneblog.dto.Article;
import java.util.HashSet;
import java.util.List;


/**
 *
 * @author apprentice
 */
public interface ArticleDAO {

    public List<Article> getActiveArticles();

    public List<Article> getFutureArticles();

    public List<Article> getArticlesForReview();

    public List<String> getStaticPageHeaders();

    public List<String> getStaticPageBodies();

    public List<Article> getActiveStaticPages();

    public List<Article> getAllStaticPages();

    public List<Article> searchByHashTag(String hashtag);

    public Article getArticleByID(int articleID);

    public void changeArticleStatus(int status, int articleID);

    public void removeArticle(int articleID);

    public void editArticle(Article article);

    public Article addArticle(Article article);
    
    public String grabHashtags(String articleBody);

    public HashSet<String> getAllHashTags();


}


