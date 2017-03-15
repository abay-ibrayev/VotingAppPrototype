package com.shareholder.abay.finapps.finappsproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.shareholder.abay.finapps.finappsproject.DividerItemDecoration;
import com.shareholder.abay.finapps.finappsproject.MainActivity;
import com.shareholder.abay.finapps.finappsproject.R;
import com.shareholder.abay.finapps.finappsproject.adapter.HistoryAdapter;
import com.shareholder.abay.finapps.finappsproject.adapter.QuestionAdapter;
import com.shareholder.abay.finapps.finappsproject.model.QuestionVote;
import com.shareholder.abay.finapps.finappsproject.utils.RecyclerViewItemClick;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class VoteActivity extends MainActivity implements RecyclerViewItemClick.OnItemClickListener, View.OnClickListener  {
    ArrayList<QuestionVote> questionVotes = new ArrayList<>();
    QuestionAdapter adapter;
    RecyclerView rvQuestion;
    Button btnVote;
    int my_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_vote,frameContent);
        Bundle extras = getIntent().getExtras();
        my_id= extras.getInt("id");
        String company_name = extras.getString("company_name");
        Date date = (Date) extras.get("date");
        setTitle("Голосование № " + my_id);
        bindViews();
        setAdapter();
        setData();

    }

    @Override
    protected void setData() {
        for(int i=1; i<=5;i++){
            questionVotes.add(new QuestionVote(i,"Вопрос № "+i,"Компания: №"+i,Calendar.getInstance().getTime()));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void bindViews() {
        rvQuestion= (RecyclerView) findViewById(R.id.my_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvQuestion.setLayoutManager(layoutManager);
        rvQuestion.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        rvQuestion.setItemAnimator( new DefaultItemAnimator());
        btnVote = (Button) findViewById(R.id.btnVote);
        btnVote.setOnClickListener(this);
    }

    @Override
    protected void setAdapter() {
        adapter = new QuestionAdapter(questionVotes,this);
        rvQuestion.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data==null){
            return;
        }
        if(resultCode ==RESULT_OK){
            String answer = data.getStringExtra("answer");
            int id = data.getIntExtra("my_id",0);
            //questionVotes.add(new QuestionVote(id,answer,answer));
            //adapter.notifyDataSetChanged();
            //questions.add(Integer.valueOf(position),new QuestionVote(Integer.valueOf(position),"вопрос"+position,answer,null));
            //adapter.notifyDataSetChanged();
            //lvQuestion.setAdapter(adapter);
        }


    }



    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnVote:
                Intent intent = new Intent();
                intent.putExtra("answer","answer");
                setResult(RESULT_OK,intent);
                finish();
                break;
        }


    }

    @Override
    public void onItemClick(View v, int position) {
        Toast.makeText(v.getContext(), questionVotes.get(position).getQuestion_name(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,DecisionActivity.class);
        intent.putExtra("id",position);
        intent.putExtra("id_second",my_id);
        intent.putExtra("question_name",questionVotes.get(position).getQuestion_name());
        intent.putExtra("company_name",questionVotes.get(position).getCompany_name());
        intent.putExtra("date",questionVotes.get(position).getDate());
        startActivityForResult(intent,1);
    }
}
