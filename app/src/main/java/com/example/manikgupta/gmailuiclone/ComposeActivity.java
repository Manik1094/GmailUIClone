package com.example.manikgupta.gmailuiclone;

import android.app.ActionBar;
import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NavUtils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

public class ComposeActivity extends AppCompatActivity {

    private android.support.v7.app.ActionBar actionBar;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);
//        Toolbar toolbar = findViewById(R.id.toolbar);
        //      toolbar.setTitle(getString(R.string.compose_activity_title));


        Intent intent = getIntent();
        actionBar = this.getSupportActionBar();

        actionBar.setTitle(getString(R.string.compose_activity_title));
        if(actionBar!=null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.comp_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home)
        {
            NavUtils.navigateUpFromSameTask(this);
        }
        switch (id)
        {
            case R.id.first_menu_item:
                Toast.makeText(this, "First menu Item clicked", Toast.LENGTH_SHORT).show();
                return true;


            case R.id.second_menu_item:
                Toast.makeText(this, "Second menu Item clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.third_menu_item:
                Toast.makeText(this, "Third menu item clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.fourth_menu_item:
                Toast.makeText(this, "Fourth Menu Item Clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.fifth_menu_item:
                Toast.makeText(this, "Fifth Menu Item Clicked", Toast.LENGTH_SHORT).show();
                return true;



        }
        return super.onOptionsItemSelected(item);
    }
}
