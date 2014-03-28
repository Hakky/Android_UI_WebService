package com.example.android_ui_webservice.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class WebService {
    String apiPath;
    ServiceHandler sh;

    WebService(){
        apiPath = "http://webservicecommande-85865.euw1.nitrousbox.com/";
        sh = new ServiceHandler();
    }

    public List<Category> getCategoriesAndArticles(){
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

                res.add(new Category(idCat, nomCat));
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
                String description = prod.getString("description");
                Double price = prod.getDouble("price");
                Bitmap urlImg = null;
                int catId = prod.getInt("category_id");
                Article ar = new Article(idProduct,urlImg,nameProduct,description,price,catId);
                res.add(ar);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res;
    }

    public Bitmap getImageUrl(int idProduct){
        Bitmap res = null;

        String apiRes = sh.makeServiceCall(apiPath+ "products/" + idProduct + ".json" , ServiceHandler.GET);
        if(apiRes == null || apiRes == "") return res;

        try {
            JSONObject objectImg = new JSONObject (apiRes);
            res = BitmapFactory.decodeStream((InputStream)new URL(objectImg.getString("url_image")).getContent());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }


        public class RetreiveArticleTask extends AsyncTask<WebService, Void, List<Article>> {


            @Override
            protected List<Article> doInBackground(WebService... webServices) {
                int count = webServices.length;
                ArrayList<Article> res = new ArrayList<Article>();

                for (int i = 0; i < count; i++) {
                    res.addAll(webServices[i].getProducts());
                }
                return res;
            }

            protected void onPostExecute(List<Article> res) {

            }
        }
}
