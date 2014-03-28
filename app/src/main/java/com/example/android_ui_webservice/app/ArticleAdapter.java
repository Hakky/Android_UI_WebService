package com.example.android_ui_webservice.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marc on 06/03/14.
 */
public class ArticleAdapter extends BaseAdapter {

    List<Article> articlesList = new ArrayList<Article>();
    LayoutInflater inflater;

    public ArticleAdapter(Context context, List<Article> articlesList) {
        inflater = LayoutInflater.from(context);
        this.articlesList = articlesList;
    }

    @Override
    public int getCount() {
        return this.articlesList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.articlesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        ImageView img;
        TextView name;
        TextView description;
        TextView price;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_article, null);

            holder.img = (ImageView)convertView.findViewById(R.id.img);
            holder.name = (TextView)convertView.findViewById(R.id.name);
            holder.description = (TextView)convertView.findViewById(R.id.description);
            holder.price = (TextView)convertView.findViewById(R.id.price);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Article art = articlesList.get(position);
        holder.img.setImageBitmap(art.getImg());
        holder.name.setText(art.getName());
        holder.description.setText(art.getDescription());
        holder.price.setText(art.getPrice().toString() + " €");

        return convertView;
    }

}


