package com.example.android_ui_webservice.app;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CategoryChoice extends Activity {

    public String[] catItems = new String[] { "TEUB1" , "TEUB2", "TEUB3", "TEUB4", "TEUB5", "TEUB6", "TEUB7", "TEUB8", "TEUB9", "TEUB10"  };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_choice);

         ArrayAdapter<String> CatAdapter ;
        CatAdapter = new ArrayAdapter<String>(this, R.id.listViewCat, catItems);
        ListView listview = (ListView ) findViewById(R.id.listViewCat);
        listview.setAdapter(CatAdapter);
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

}
