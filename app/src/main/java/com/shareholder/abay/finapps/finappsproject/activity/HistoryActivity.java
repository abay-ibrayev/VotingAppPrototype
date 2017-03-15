package com.shareholder.abay.finapps.finappsproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.shareholder.abay.finapps.finappsproject.DividerItemDecoration;
import com.shareholder.abay.finapps.finappsproject.MainActivity;
import com.shareholder.abay.finapps.finappsproject.R;
import com.shareholder.abay.finapps.finappsproject.adapter.HistoryAdapter;
import com.shareholder.abay.finapps.finappsproject.adapter.MessageAdapter;
import com.shareholder.abay.finapps.finappsproject.model.HistoryVote;
import com.shareholder.abay.finapps.finappsproject.utils.RecyclerViewItemClick;

import java.util.ArrayList;


public class HistoryActivity extends MainActivity implements RecyclerViewItemClick.OnItemClickListener {
    ArrayList<HistoryVote> historyVotes = new ArrayList<>();
    HistoryAdapter adapter;
    RecyclerView rvHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_history,frameContent);
        setTitle("История голосований");
        bindViews();
        setAdapter();
        setData();

    }
    @Override
    protected void setAdapter() {
        adapter= new HistoryAdapter(historyVotes, this);
        rvHistory.setAdapter(adapter);
    }

    @Override
    protected void bindViews() {
        rvHistory= (RecyclerView) findViewById(R.id.my_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvHistory.setLayoutManager(layoutManager);
        rvHistory.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        rvHistory.setItemAnimator( new DefaultItemAnimator());
    }

    @Override
    protected void setData() {
        for(int i=0;i<5;i++){
            historyVotes.add(new HistoryVote("Выборы Заместителя Департамента","Мустафин Б.А."+i));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigationView.getMenu().getItem(1).setChecked(true);
    }

    @Override
    public void onItemClick(View v, int position) {
        Toast.makeText(v.getContext(), historyVotes.get(position).getDescription(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,HistoryDescActivity.class);
        intent.putExtra("name",historyVotes.get(position).getName());
        intent.putExtra("desc", historyVotes.get(position).getDescription());
        startActivity(intent);
    }
}