/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstoneblog.dao;

import com.mycompany.capstoneblog.dto.Article;
//import com.mycompany.capstoneblog.dto.Hashtag;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface ArticleDAO {
    public List<Article> getActiveArticles();
    public List<Article>getFutureArticles();
    public List<Article>getArticlesForReview();
    public List<String>getStaticPageHeaders();
    public List<String>getStaticPageBodies();
    public List<Article>getStaticPages();
    public List<Article>searchByHashTag(String hashtag);
    public Article getArticleByID(int articleID);
    public void changeArticleStatus(int status);
    public void removeArticle(int articleID);
    public void editArticle(Article article);
    public Article addArticle(Article article);
    public void addHashTag(ArrayList<String> hashtags, int articleID);
    public List<String> getAllHashTags();
}
