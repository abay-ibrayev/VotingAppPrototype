package com.shareholder.abay.finapps.finappsproject.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.shareholder.abay.finapps.finappsproject.DividerItemDecoration;
import com.shareholder.abay.finapps.finappsproject.MainActivity;
import com.shareholder.abay.finapps.finappsproject.R;
import com.shareholder.abay.finapps.finappsproject.adapter.MessageAdapter;
import com.shareholder.abay.finapps.finappsproject.model.Message;
import com.shareholder.abay.finapps.finappsproject.utils.RecyclerViewItemClick;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ArchiveMessagesActivity extends MainActivity implements RecyclerViewItemClick.OnItemClickListener {
    String content;
    String receiver;
    String theme;
    Date date;
    RecyclerView recyclerView;
    MessageAdapter adapter;
    ArrayList<Message> messages = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_archive_messages,frameContent);
        Bundle extras = getIntent().getExtras();
        setTitle("Архив сообщений");
        receiver= extras.getString("receiver");
        theme = extras.getString("theme");
        content = extras.getString("content");
        date = (Date) extras.get("date");
        bindViews();
        setAdapter();
        setData();


    }

    @Override
    protected void bindViews() {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator( new DefaultItemAnimator());
    }

    @Override
    protected void setAdapter() {
        adapter= new MessageAdapter(messages, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void setData() {
        messages.add(new Message(receiver,theme,date));
        messages.add(new Message("Company","Tema", Calendar.getInstance().getTime()));
        messages.add(new Message("Company","Tema", Calendar.getInstance().getTime()));
        messages.add(new Message("Company","Tema", Calendar.getInstance().getTime()));
        messages.add(new Message("Company","Tema", Calendar.getInstance().getTime()));
        messages.add(new Message("Company","Tema", Calendar.getInstance().getTime()));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(View v, int position) {
        Toast.makeText(v.getContext(), messages.get(position).getTheme(), Toast.LENGTH_SHORT).show();
    }
}
