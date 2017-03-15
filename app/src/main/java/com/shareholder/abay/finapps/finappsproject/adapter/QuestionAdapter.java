package com.shareholder.abay.finapps.finappsproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.shareholder.abay.finapps.finappsproject.R;
import com.shareholder.abay.finapps.finappsproject.model.QuestionVote;
import com.shareholder.abay.finapps.finappsproject.model.Vote;
import com.shareholder.abay.finapps.finappsproject.utils.RecyclerViewItemClick;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by abay on 10/23/16.
 */
public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {
    ArrayList<QuestionVote> questionVoteList;
    private RecyclerViewItemClick.OnItemClickListener listener;

    public QuestionAdapter(ArrayList<QuestionVote> questionVoteList, RecyclerViewItemClick.OnItemClickListener listener) {
        this.questionVoteList = questionVoteList;
        this.listener = listener;
    }

    @Override
    public QuestionAdapter.QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vote_item,parent,false);
        return  new QuestionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(QuestionAdapter.QuestionViewHolder holder, int position) {
        QuestionVote questionVote = questionVoteList.get(position);
        holder.questionName.setText(position+")"+questionVote.getQuestion_name());
        holder.companyName.setText("Компания: "+ questionVote.getCompany_name());
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        holder.endDate.setText("Конец голосования: "+df.format(questionVote.getDate()));

    }

    @Override
    public int getItemCount() {
        return questionVoteList.size();
    }
    public class QuestionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView questionName;
        public TextView companyName;
        public TextView endDate;
        public QuestionViewHolder(View itemView) {
            super(itemView);
            questionName = (TextView) itemView.findViewById(R.id.vote_id);
            companyName = (TextView) itemView.findViewById(R.id.company_name);
            endDate=(TextView) itemView.findViewById(R.id.end_date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onItemClick(v, getAdapterPosition());
            }
        }
    }

    /*
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view==null){
            view = inflater.inflate(R.layout.vote_item,parent,false);
        }
        QuestionVote vote = getQuestion(position);
        ((TextView) view.findViewById(R.id.vote_id)).setText(vote.getId()+") "+vote.getQuestion_name());

        //возможнo нужno будет конвертировать тип данных в тип String
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        if (vote.getDate()!=null){
            ((TextView) view.findViewById(R.id.company_name)).setText("Компания: "+vote.getCompany_name());
            ((TextView) view.findViewById(R.id.end_date)).setText("Конец голосования: "+df.format(vote.getDate()));
        }
        else{
            ((TextView) view.findViewById(R.id.company_name)).setText(vote.getCompany_name());
            ((TextView) view.findViewById(R.id.end_date)).setText("");
        }
        return view;*/

}
