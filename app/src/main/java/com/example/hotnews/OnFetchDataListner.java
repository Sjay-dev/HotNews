package com.example.hotnews;

import com.example.hotnews.Models.NewsHeadLines;

import java.util.List;

public interface OnFetchDataListner<NewsApiResponse> {
    void onFetchData(List<NewsHeadLines> list , String message);
    void onError(String name);
}
