package com.example.android_ui_webservice.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ArticlesOverview extends Activity {

    private List<Article> artList = new ArrayList<Article>();
    public static final String CATEGORY_PARENT = "category_parent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles_overview);

        Category category = (Category)getIntent().getSerializableExtra(CATEGORY_PARENT);
        TextView title = (TextView)findViewById(R.id.title);
        title.setText(category.getName());
        //artList = category.getArticles();

        artList.add(new Article("sjd", "Super produit", "j'ai dit super produit", 2345.0));
        artList.add(new Article("sjd", "Super produit", "j'ai dit super produit", 2345.0));
        artList.add(new Article("sjd", "Super produit", "j'ai dit super produit", 2345.0));
        artList.add(new Article("sjd", "Super produit", "j'ai dit super produit", 2345.0));
        artList.add(new Article("sjd", "Super produit", "j'ai dit super produit", 2345.0));
        artList.add(new Article("sjd", "Super produit", "j'ai dit super produit", 2345.0));
        artList.add(new Article("sjd", "Super produit", "j'ai dit super produit", 2345.0));
        artList.add(new Article("sjd", "Super produit", "j'ai dit super produit", 2345.0));

        ArticleAdapter artAdapter = new ArticleAdapter(this, artList);
        ListView articlesListView = (ListView)findViewById(R.id.articlesListView);
        articlesListView.setAdapter(artAdapter);
        artAdapter.notifyDataSetChanged();
        articlesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Article a = (Article)parent.getItemAtPosition(position);

                Intent intent = new Intent(parent.getContext(), ArticleDetails.class);
                intent.putExtra(ArticleDetails.ARTICLE_ITEM, a);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.articles_overview, menu);
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
