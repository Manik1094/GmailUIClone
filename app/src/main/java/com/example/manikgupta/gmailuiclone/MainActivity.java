package com.example.manikgupta.gmailuiclone;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MailAdapter mailAdapter;
    private ImageView starImageView;
    private android.support.v7.app.ActionBar actionBar;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private DrawerLayout drawerLayout;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();


    private int NUM_LIST_ITEMS = 100;
    FloatingActionButton floatingActionButton;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        starImageView = (ImageView) findViewById(R.id.star);

        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rec_view);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                layoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        mailAdapter = new MailAdapter(NUM_LIST_ITEMS);

        mRecyclerView.setAdapter(mailAdapter);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(MainActivity.this,ComposeActivity.class);
                startActivity(intent);
            }
        });



        actionBar = this.getSupportActionBar();
        actionBar.setTitle(getString(R.string.app_name));
        if(actionBar!=null)
        {
            try {
                //assert actionBar != null;
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeAsUpIndicator(R.drawable.nav_drawer_icon);
            }catch (Exception e) {
                Log.e(LOG_TAG, "Null pointer exception", e);
            }


        }



        NavigationView navigationView = findViewById(R.id.nav_view);
//        actionBar.hide();
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        switch (menuItem.getItemId())
                        {
                            case R.id.inbox :
                                Toast.makeText(MainActivity.this, "Inbox messages clicked", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.starred:
                                Toast.makeText(MainActivity.this, "Starred messages clicked", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.sent_mail:
                                Toast.makeText(MainActivity.this, "Sent messages clicked", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.drafts:
                                Toast.makeText(MainActivity.this, "Drafts messages clicked", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.allmail:
                                Toast.makeText(MainActivity.this, "Primary messages clicked", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.trash:
                                Toast.makeText(MainActivity.this, "Trash messages clicked", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.spam:
                                Toast.makeText(MainActivity.this, "Spam messages clicked", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.calendar:
                                Toast.makeText(MainActivity.this, "Calendar clicked", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.contacts:
                                Toast.makeText(MainActivity.this, "Contacts  clicked", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.settings:
                                Toast.makeText(MainActivity.this, "Settings  clicked", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.help:
                                Toast.makeText(MainActivity.this, " Help and feedback", Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        // close drawer when item is tapped
                        //    actionBar.show();
                        drawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

