package com.example.android_ui_webservice.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class WebService {
    String apiPath;
    ServiceHandler sh;

    WebService(){
        String apiPath = "http://webservicecommande-85865.euw1.nitrousbox.com/";
        ServiceHandler sh = new ServiceHandler();
    }

    public List<Category> getCategoriesAndAticles(){
        List<Category> cats = this.getCategories();
        List<Article> arts = this.getProducts();

        for(Category c:cats){
            for(Article a:arts){
                if(a.getCatId()==c.getId()){
                    c.addArticle(a);
                }
            }
        }
        return cats;
    }


    public List<Category> getCategories(){
        List<Category> res = new ArrayList<Category>();

        String apiRes = sh.makeServiceCall(apiPath+ "categories.json" , ServiceHandler.GET);
        if(apiRes == null || apiRes == "") return res;

        try {
            JSONArray arrayCat = new JSONArray (apiRes);

            for(int i=0;i<arrayCat.length();i++ ) {
                JSONObject cat = arrayCat.getJSONObject(i);

                int idCat = cat.getInt("id");
                String nomCat = cat.getString("name");

                cat.getJSONArray("");

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return res;
    }

    public List<Article> getProducts(){
        List<Article> res = new ArrayList<Article>();

        String apiRes = sh.makeServiceCall(apiPath+ "products.json" , ServiceHandler.GET);
        if(apiRes == null || apiRes == "") return res;

        try {
            JSONArray arrayProd = new JSONArray (apiRes);

            for(int i=0;i<arrayProd.length();i++ ) {
                JSONObject prod = arrayProd.getJSONObject(i);

                int idProduct = prod.getInt("id");
                String nameProduct = prod.getString("name");
                Double price = prod.getDouble("price");
                String urlImg = prod.getString("url_image");
                int catId = prod.getInt("category_id");
                Article ar = new Article(idProduct,urlImg,nameProduct,  "description",price,catId);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res;
    }
}
