package com.example.android_ui_webservice.app;

import java.io.Serializable;

/**
 * Created by marc on 06/03/14.
 */
public class Article implements Serializable{

    private int id;
    private String img;
    private String name;
    private Double price;
    private int catId;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Article(int id, String img, String name, String desc ,Double price, int catId){
        this.id = id;
        this.img = img;
        this.name = name;
        this.price = price;
        this.catId = catId;
        this.description = desc;
    }

    public int getCatId(){
        return this.catId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
