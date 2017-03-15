package com.shareholder.abay.finapps.finappsproject.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.shareholder.abay.finapps.finappsproject.MainActivity;
import com.shareholder.abay.finapps.finappsproject.R;

public class HistoryDescActivity extends MainActivity {
    TextView tvInfo;
    TextView tvTableDesc;
    TextView tvDesc;
    TextView tvName;
    TextView tableRow1textView1;
    TextView tableRow1textView2;
    TextView tableRow1textView3;
    TextView tableRow2textView1;
    TextView tableRow2textView2;
    TextView tableRow2textView3;
    TextView tableRow3textView1;
    TextView tableRow3textView2;
    TextView tableRow3textView3;
    String extraName;
    String extraDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_history_desc,frameContent);
        setTitle("История голосований");
        Bundle extras = getIntent().getExtras();
        extraName= extras.getString("name");
        extraDesc = extras.getString("desc");
        bindViews();
        receiveData();
    }

    @Override
    protected void bindViews() {
        tvName= (TextView) findViewById(R.id.hdName);
        tvDesc = (TextView) findViewById(R.id.hdDesc);
        tvInfo = (TextView) findViewById(R.id.hdInfo);
        tvTableDesc = (TextView) findViewById(R.id.hdTableDesc);
        tableRow1textView1 = (TextView) findViewById(R.id.tr1tv1);
        tableRow1textView2 = (TextView) findViewById(R.id.tr1tv2);
        tableRow1textView3 = (TextView) findViewById(R.id.tr1tv3);
        tableRow2textView1 = (TextView) findViewById(R.id.tr2tv1);
        tableRow2textView2 = (TextView) findViewById(R.id.tr2tv2);
        tableRow2textView3 = (TextView) findViewById(R.id.tr2tv3);
        tableRow3textView1 = (TextView) findViewById(R.id.tr3tv1);
        tableRow3textView2 = (TextView) findViewById(R.id.tr3tv2);
        tableRow3textView3 = (TextView) findViewById(R.id.tr3tv3);
        tvName.setText(extraName);
        tvDesc.setText(extraDesc);
    }

    private void receiveData(){
        tvInfo.setText("По итогам голосования, Проведеннного в период с 15 Марта по 20 Марта 2016 года, среди держателей " +
                    "акций компании ААА Заместителем Директора департамента назначен Мустафин Б.А. и вступил в должность " +
                    "25 Марта 2016 года.");
        tvTableDesc.setText("Распределение голосов:");
        tableRow1textView2.setText("В общем");
        tableRow1textView3.setText("Ваш голос");
        tableRow2textView1.setText("Мустафин Б.А.");
        tableRow2textView2.setText("47%");
        tableRow2textView3.setText("(70% акций)");
        tableRow3textView1.setText("Иванов А.А.");
        tableRow3textView2.setText("15%");
        tableRow3textView3.setText("");
    }
}
