package com.example.android_ui_webservice.app;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class ArticleDetails extends Activity {

    public static final String ARTICLE_ITEM = "article_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);

        Article art = (Article)getIntent().getSerializableExtra(ARTICLE_ITEM);
        TextView name = (TextView)findViewById(R.id.name);
        name.setText(art.getName());
        TextView desc = (TextView)findViewById(R.id.description);
        desc.setText(art.getDescription());
        TextView price = (TextView)findViewById(R.id.price);
        price.setText(art.getPrice().toString() + " €");
        ImageView img = (ImageView)findViewById(R.id.art_img);
        img.setImageBitmap(art.getImg());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.article_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
