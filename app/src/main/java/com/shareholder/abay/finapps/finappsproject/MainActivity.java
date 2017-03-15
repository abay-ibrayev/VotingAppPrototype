package com.shareholder.abay.finapps.finappsproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;

import com.shareholder.abay.finapps.finappsproject.activity.HistoryActivity;
import com.shareholder.abay.finapps.finappsproject.activity.MessagesActivity;
import com.shareholder.abay.finapps.finappsproject.activity.ProfileActivity;
import com.shareholder.abay.finapps.finappsproject.activity.RecentVotesActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    protected DrawerLayout drawer;
    protected FrameLayout frameContent;
    protected NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         drawer= (DrawerLayout) findViewById(R.id.drawer_layout);
        frameContent = (FrameLayout) findViewById(R.id.frameContent);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView= (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    protected void bindViews() {

    }

    protected void setAdapter() {

    }

    protected void setData() {

    }

    protected void hideKeyboard(){
        InputMethodManager inputManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
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



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent;
        if (id == R.id.recent_votes) {
            // Handle the camera action
            intent = new Intent(getApplicationContext(), RecentVotesActivity.class);
            startActivity(intent);
        } else if (id == R.id.history) {
            intent = new Intent(getApplicationContext(), HistoryActivity.class);
            startActivity(intent);
        } else if (id == R.id.messages) {
            intent = new Intent(getApplicationContext(), MessagesActivity.class);
            startActivity(intent);
        } else if (id == R.id.profile) {
            intent = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(intent);
        } else if (id == R.id.settings) {

        } else if (id == R.id.exit) {
            Intent intentExit = new Intent(Intent.ACTION_MAIN);
            intentExit.addCategory(Intent.CATEGORY_HOME);
            intentExit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intentExit);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
