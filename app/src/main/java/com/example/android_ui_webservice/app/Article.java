package com.example.android_ui_webservice.app;

import java.io.Serializable;

/**
 * Created by marc on 06/03/14.
 */
public class Article implements Serializable{

    private int id;
    private String img;
    private String name;
    private String description;
    private Double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Article(String img, String name, String description, Double price){
        this.img = img;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
