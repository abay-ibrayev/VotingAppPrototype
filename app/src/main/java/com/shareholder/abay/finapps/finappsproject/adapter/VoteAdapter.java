package com.shareholder.abay.finapps.finappsproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shareholder.abay.finapps.finappsproject.R;
import com.shareholder.abay.finapps.finappsproject.model.Vote;
import com.shareholder.abay.finapps.finappsproject.utils.RecyclerViewItemClick;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by abay on 10/22/16.
 */
public class VoteAdapter extends RecyclerView.Adapter<VoteAdapter.VoteViewHolder> {


    private ArrayList<Vote> voteList;
    private RecyclerViewItemClick.OnItemClickListener listener;

    public VoteAdapter(ArrayList<Vote> voteList, RecyclerViewItemClick.OnItemClickListener listener) {
        this.voteList = voteList;
        this.listener = listener;
    }
    @Override
    public VoteAdapter.VoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vote_item,parent,false);
        return new VoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VoteAdapter.VoteViewHolder holder, int position) {
            Vote vote = voteList.get(position);
            holder.voteId.setText("Голосование "+vote.getId());
            holder.companyName.setText("Компания: "+vote.getCompany_name());
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            holder.endDate.setText("Конец голосования: " +df.format(vote.getDate()));
    }

    @Override
    public int getItemCount() {
        return voteList.size();
    }

    public class VoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView voteId;
        public TextView companyName;
        public TextView endDate;
        public VoteViewHolder(View itemView) {
            super(itemView);
            voteId = (TextView) itemView.findViewById(R.id.vote_id);
            companyName = (TextView) itemView.findViewById(R.id.company_name);
            endDate = (TextView)itemView.findViewById(R.id.end_date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(listener!=null){
                listener.onItemClick(v,getAdapterPosition());
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
        Vote vote = getVote(position);
        ((TextView) view.findViewById(R.id.vote_id)).setText("Голосование "+vote.getId());
        ((TextView) view.findViewById(R.id.company_name)).setText("Компания: "+vote.getCompany_name());
        //возможнo нужno будет конвертировать тип данных в тип String
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        ((TextView) view.findViewById(R.id.end_date)).setText("Конец голосования: " +df.format(vote.getDate()));
        return view;*/
}
