package com.shareholder.abay.finapps.finappsproject.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.shareholder.abay.finapps.finappsproject.MainActivity;
import com.shareholder.abay.finapps.finappsproject.R;

public class ProfileActivity extends MainActivity {
    TextView profileName;
    TextView tableRow1TextView1;
    TextView tableRow1TextView2;
    TextView tableRow2TextView1;
    TextView tableRow2TextView2;
    TextView tableRow3TextView1;
    TextView tableRow3TextView2;
    TextView lastVote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_profile,frameContent);
        setTitle("Личный Профиль");
        bindViews();
        receiveData();
    }

    @Override
    protected void bindViews() {
        profileName = (TextView) findViewById(R.id.profileName);
        tableRow1TextView1 = (TextView) findViewById(R.id.profiletr1tv1);
        tableRow1TextView2 = (TextView) findViewById(R.id.profiletr1tv2);
        tableRow2TextView1 = (TextView) findViewById(R.id.profiletr2tv1);
        tableRow2TextView2 = (TextView) findViewById(R.id.profiletr2tv2);
        tableRow3TextView1 = (TextView) findViewById(R.id.profiletr3tv1);
        tableRow3TextView2 = (TextView) findViewById(R.id.profiletr3tv2);
        lastVote = (TextView)findViewById(R.id.lastVote);
    }

    private void receiveData() {
        profileName.setText("Асланов"+"\n"+"Аслан Асланович");
        tableRow1TextView1.setText("Компания:");
        tableRow1TextView2.setText("Количество акций:");
        tableRow2TextView1.setText("Алтория");
        tableRow2TextView2.setText("100 акций");
        tableRow3TextView1.setText("Ария");
        tableRow3TextView2.setText("200 акций");
        lastVote.setText("20 Марта 2016 "+"\n"+"Выборы Зам.Директора департамента");

    }

    @Override
    protected void onResume() {
        super.onResume();
        navigationView.getMenu().getItem(3).setChecked(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
