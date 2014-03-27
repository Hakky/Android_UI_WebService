package com.example.android_ui_webservice.app;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CategoryChoice extends Activity {

    public List<String> catItems = new ArrayList<String>() {{ add("Catégorie 1"); add("Catégorie 2"); add("Catégorie 3");  }};
    private List<Category> catList = new ArrayList<Category>();
    ArrayAdapter<String> CatAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_choice);

        TextView title = (TextView)findViewById(R.id.title);
        title.setText("Catégories");



        CatAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, catItems);

        ListView listview = (ListView ) findViewById(R.id.listViewCat);
        listview.setAdapter(CatAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String catName = (String)parent.getItemAtPosition(position);
                Category c = getCategoryByName(catName);

                Intent intent = new Intent(parent.getContext(), ArticlesOverview.class);
                intent.putExtra(ArticlesOverview.CATEGORY_PARENT, c);
                startActivity(intent);
            }
        });
        WebService ws = new WebService();
        new RetreiveCategoriesTask().execute(ws);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.category_choice, menu);
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

    private Category getCategoryByName(String catName){
        for (Category c : catList){
            if (c.getName() == catName)
                return c;
        }
        return /*new Category(2, "Catégorie 2");*/null;
    }

    public class RetreiveCategoriesTask extends AsyncTask<WebService, Void, List<Category>> {


        @Override
        protected List<Category> doInBackground(WebService... webServices) {
            int count = webServices.length;
            ArrayList<Category> res = new ArrayList<Category>();

            for (int i = 0; i < count; i++) {
                res.addAll(webServices[i].getCategoriesAndArticles());
            }
            return res;
        }

        protected void onPostExecute(List<Category> res) {
            for(Category c : res ){
                catItems.add(c.getName());
            }
            CatAdapter.notifyDataSetChanged();
        }
    }
}
