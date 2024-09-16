package com.example.hotnews.Models;

import java.io.Serializable;
import java.util.List;

public class NewsApiResponse implements Serializable {
    String Status;
    int totalResults;
    List<NewsHeadLines> articles;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsHeadLines> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsHeadLines> articles) {
        this.articles = articles;
    }
}
