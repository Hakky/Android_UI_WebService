package com.example.android_ui_webservice.app;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable{
    private int id;
    private String name;
    private List<Article> articles = new ArrayList<Article>();


    public Category(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void addArticle(Article a){
        articles.add(a);
    }

    public List<Article> getArticles(){
        return articles;
    }

    public void setName(String name) {
        this.name = name;
    }

}
