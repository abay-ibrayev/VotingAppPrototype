package com.shareholder.abay.finapps.finappsproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.shareholder.abay.finapps.finappsproject.DividerItemDecoration;
import com.shareholder.abay.finapps.finappsproject.MainActivity;
import com.shareholder.abay.finapps.finappsproject.R;
import com.shareholder.abay.finapps.finappsproject.adapter.VoteAdapter;
import com.shareholder.abay.finapps.finappsproject.model.Vote;
import com.shareholder.abay.finapps.finappsproject.utils.RecyclerViewItemClick;

import java.util.ArrayList;
import java.util.Calendar;

public class RecentVotesActivity extends MainActivity implements View.OnClickListener,RecyclerViewItemClick.OnItemClickListener {
    ArrayList<Vote> votes = new ArrayList<>();
    VoteAdapter adapter;
    RecyclerView rvVotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_recent_votes,frameContent);
        setTitle("Текущие голосования");
        bindViews();
        setAdapter();
        setData();
    }

    @Override
    protected void setAdapter() {
        adapter = new VoteAdapter(votes,this);
        rvVotes.setAdapter(adapter);
    }

    @Override
    protected void setData() {
        for(int i=1; i<=10;i++){
            votes.add(new Vote(i,"Компания: №"+i, Calendar.getInstance().getTime()));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void bindViews() {
        rvVotes= (RecyclerView) findViewById(R.id.my_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvVotes.setLayoutManager(layoutManager);
        rvVotes.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        rvVotes.setItemAnimator( new DefaultItemAnimator());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data==null){
            return;
        }
        if(resultCode ==RESULT_OK) {
            String answer = data.getStringExtra("answer");
            Log.d("myLogs", answer);


        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(View v, int position) {
        Intent intent = new Intent(getApplicationContext(),VoteActivity.class);
        intent.putExtra("id", votes.get(position).getId());
        intent.putExtra("company_name", votes.get(position).getCompany_name());
        intent.putExtra("date", votes.get(position).getDate());
        startActivityForResult(intent,1);
    }
}
