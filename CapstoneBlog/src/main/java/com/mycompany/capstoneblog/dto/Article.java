/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstoneblog.dto;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author apprentice
 */
public class Article {
    //private String content;
    private ArrayList<String> hashtags = new ArrayList<>();
    private int articleID;
    private String articleBody;
    private Date postingDate;
    private Date takeDownDate;
    private int status;
    private boolean staticPage;
    
    /**
     * @return the content
     */
    public String getArticleBody() {
        return articleBody;
    }

    /**
     * @param content the content to set
     */
    public void setArticleBody(String content) {
        this.articleBody = content;
    }

    /**
     * @return the hashtags
     */
    public ArrayList<String> getHashtags() {
        return hashtags;
    }

    /**
     * @param hashtags the hashtags to set
     */
    public void setHashtags(ArrayList<String> hashtags) {
        this.hashtags = hashtags;
    }

    /**
     * @return the articleID
     */
    public int getArticleID() {
        return articleID;
    }

    /**
     * @param articleID the articleID to set
     */
    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    /**
     * @return the postingDate
     */
    public Date getPostingDate() {
        return postingDate;
    }

    /**
     * @param postingDate the postingDate to set
     */
    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    /**
     * @return the takeDownDate
     */
    public Date getTakeDownDate() {
        return takeDownDate;
    }

    /**
     * @param takeDownDate the takeDownDate to set
     */
    public void setTakeDownDate(Date takeDownDate) {
        this.takeDownDate = takeDownDate;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the staticPage
     */
    public boolean isStaticPage() {
        return staticPage;
    }

    /**
     * @param staticPage the staticPage to set
     */
    public void setStaticPage(boolean staticPage) {
        this.staticPage = staticPage;
    }
}
