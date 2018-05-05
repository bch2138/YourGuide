package com.example.uhylabr.yourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.uhylabr.yourguide.ParksActivity;
import com.example.uhylabr.yourguide.TouristsActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        // Sets onClick Listener on the Parks TextView to Launch the ParksActivity
        TextView tvParks = (TextView) findViewById(R.id.tv_parks);
        tvParks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startParks();
            }
        });


        // Sets onClick Listener on the Tourist TextView to Launch the TouristsActivity
        TextView tvTourists = (TextView) findViewById(R.id.tv_tourist);
        tvTourists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTourists();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_exit) {
            finish();
        } else if (id == R.id.mn_parks) {
            startParks();
        } else if (id == R.id.mn_tourist) {
            startTourists();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_parks) {
            startParks();

        } else if (id == R.id.nav_tourist) {
            startTourists();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    //Starts the Parks Activity
    public void startParks() {
        Intent intent = new Intent(this, ParksActivity.class);
        startActivity(intent);
    }

    // Starts the Tourist Activity
    public void startTourists() {
        Intent intent = new Intent(this, TouristsActivity.class);
        startActivity(intent);
    }
}
