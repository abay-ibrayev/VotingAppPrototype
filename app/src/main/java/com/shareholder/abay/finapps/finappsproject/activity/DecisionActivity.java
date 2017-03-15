package com.shareholder.abay.finapps.finappsproject.activity;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.shareholder.abay.finapps.finappsproject.DividerItemDecoration;
import com.shareholder.abay.finapps.finappsproject.MainActivity;
import com.shareholder.abay.finapps.finappsproject.R;
import com.shareholder.abay.finapps.finappsproject.adapter.QuestionAdapter;
import com.shareholder.abay.finapps.finappsproject.fragment.DialogAnswer;
import com.shareholder.abay.finapps.finappsproject.model.Decision;
import com.shareholder.abay.finapps.finappsproject.model.QuestionVote;
import com.shareholder.abay.finapps.finappsproject.utils.RecyclerViewItemClick;

import java.util.ArrayList;
import java.util.Date;

public class DecisionActivity extends MainActivity implements View.OnClickListener, RecyclerViewItemClick.OnItemClickListener{
    QuestionAdapter adapter;
    ArrayList<QuestionVote> questionVotes = new ArrayList<>();
    ArrayList<Decision> decision = new ArrayList<>();
    RecyclerView rvQuestion;
    LinearLayout ll;
    int id;
    String question_name;
    String company_name;
    Date date;
    RadioGroup rgAnswers;
    TextView questionText;
    TextView tvAnswer1;
    TextView tvAnswer2;
    TextView tvAnswer3;
    TextView tvAnswer4;
    TextView etAnswer1;
    TextView etAnswer2;
    TextView etAnswer3;
    TextView etAnswer4;
    Button btnEnter;
    String activityResult;
    int my_id;
    DialogFragment dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_decision,frameContent);
        Bundle extras = getIntent().getExtras();
        id = extras.getInt("id");
        my_id = extras.getInt("id_second");
        question_name= extras.getString("question_name");
        company_name= extras.getString("company_name");
        date = (Date) extras.get("date");
        Log.d("myLogs",id+ " "+ question_name+" "+company_name+" ");
        setTitle("Голосование № " +my_id);
        dialog = new DialogAnswer();
        bindViews();
        setAdapter();
        setData();
        getCumulative();

    }

    @Override
    protected void bindViews() {
        questionText = (TextView) findViewById(R.id.cumulativeText1);
        tvAnswer1 = (TextView) findViewById(R.id.answerText1);
        tvAnswer2= (TextView) findViewById(R.id.answerText2);
        tvAnswer3 = (TextView) findViewById(R.id.answerText3);
        tvAnswer4 = (TextView) findViewById(R.id.answerText4);
        etAnswer1 = (TextView) findViewById(R.id.answerEdit1);
        etAnswer2 = (TextView) findViewById(R.id.answerEdit2);
        etAnswer3 = (TextView) findViewById(R.id.answerEdit3);
        etAnswer4 = (TextView) findViewById(R.id.answerEdit4);
        rvQuestion = (RecyclerView) findViewById(R.id.my_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvQuestion.setLayoutManager(layoutManager);
        rvQuestion.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        rvQuestion.setItemAnimator( new DefaultItemAnimator());
        rgAnswers = (RadioGroup) findViewById(R.id.rgAnswers);
        ll = (LinearLayout)findViewById(R.id.llMain);
        btnEnter = (Button) findViewById(R.id.btnEnter);
        btnEnter.setOnClickListener(this);
        etAnswer1.setOnClickListener(this);
        etAnswer2.setOnClickListener(this);
        etAnswer3.setOnClickListener(this);
        etAnswer4.setOnClickListener(this);
    }

    @Override
    protected void setAdapter() {
        adapter = new QuestionAdapter(questionVotes,this);
        rvQuestion.setAdapter(adapter);
    }

    @Override
    protected void setData() {
        questionVotes.add(new QuestionVote(id,question_name,company_name,date));
        for(int i =0;i<4;i++){
            decision.add(new Decision("Person"+i,new String[]{"Мустафин Б.А.","Жанов Ж.Ж.","Ахметов К.К.","Иванов И.И."}));
        }
        adapter.notifyDataSetChanged();
    }


    public void getCumulative(){
        if(id%2==0){
            rgAnswers.setVisibility(View.GONE);
            //some methods to get extra data from text maybe for cumulative
            ll.setVisibility(View.VISIBLE);
            for (int i=0;i<decision.size();i++){
                questionText.setText(decision.get(i).getQuestion());
                tvAnswer1.setText(decision.get(i).getAnswerVariants()[0]);
                tvAnswer2.setText(decision.get(i).getAnswerVariants()[1]);
                tvAnswer3.setText(decision.get(i).getAnswerVariants()[2]);
                tvAnswer4.setText(decision.get(i).getAnswerVariants()[3]);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Bundle args;
        switch (v.getId()) {
            case R.id.btnEnter:
                if (activityResult==null) {
                    switch (rgAnswers.getCheckedRadioButtonId()){
                        case R.id.rbNo:
                            activityResult="Нет";
                            break;
                        case R.id.rbYes:
                            activityResult="Да";
                            break;
                        case R.id.rbMaybe:
                            activityResult="Воздержусь";
                            break;
                        }
                    }
                Intent intent = new Intent();
                intent.putExtra("my_id",my_id);
                intent.putExtra("answer",activityResult);
                setResult(RESULT_OK,intent);
                finish();
                break;
            case R.id.answerEdit1: {
                Log.d("Focus_check", "dialog 1");
                args = new Bundle();
                args.putString("text", "Голос за: \n" + decision.get(0).getAnswerVariants()[0]);
                args.putInt("int", 1);
                if (dialog != new DialogAnswer()) {
                    dialog = new DialogAnswer();
                }
                dialog.setArguments(args);
                dialog.show(getFragmentManager(), "dialog");
                break;
            }
            case R.id.answerEdit2: {
                Log.d("Focus_check", "dialog 2");
                args = new Bundle();
                args.putString("text", "Голос за: \n" + decision.get(0).getAnswerVariants()[1]);
                args.putInt("int", 2);
                if (dialog != new DialogAnswer()) {
                    dialog = new DialogAnswer();
                }
                dialog.setArguments(args);
                dialog.show(getFragmentManager(), "dialog");
                break;
            }
            case R.id.answerEdit3: {
                Log.d("Focus_check", "dialog 3");
                args = new Bundle();
                args.putString("text", "Голос за: \n" + decision.get(0).getAnswerVariants()[2]);
                args.putInt("int", 3);
                if (dialog != new DialogAnswer()) {
                    dialog = new DialogAnswer();
                }

                dialog.setArguments(args);
                dialog.show(getFragmentManager(), "dialog");
                break;
            }
            case R.id.answerEdit4: {
                Log.d("Focus_check", "dialog 4");
                args = new Bundle();
                args.putString("text", "Голос за: \n" + decision.get(0).getAnswerVariants()[3]);
                args.putInt("int", 4);
                if (dialog != new DialogAnswer()) {
                    dialog = new DialogAnswer();
                }
                dialog.setArguments(args);
                dialog.show(getFragmentManager(), "dialog");
                break;
            }
            default: {
                Log.d("Focus_check", "no dialog");
                break;
            }

        }

    }

    public void getDialogResult(String result,int id){
        switch (id){
            case 1:
                etAnswer1.setText(result);
                activityResult = result;
                break;
            case 2:
                etAnswer2.setText(result);
                activityResult = result;
                break;
            case 3:
                etAnswer3.setText(result);
                activityResult = result;
                break;
            case 4:
                etAnswer4.setText(result);
                activityResult = result;
                break;

        }


    }

    @Override
    public void onItemClick(View v, int position) {

    }
}

