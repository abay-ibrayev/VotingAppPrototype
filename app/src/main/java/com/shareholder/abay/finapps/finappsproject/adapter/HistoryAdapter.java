package com.shareholder.abay.finapps.finappsproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shareholder.abay.finapps.finappsproject.R;
import com.shareholder.abay.finapps.finappsproject.model.HistoryVote;
import com.shareholder.abay.finapps.finappsproject.utils.RecyclerViewItemClick;

import java.util.ArrayList;

/**
 * Created by abay on 10/23/16.
 */
public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    private ArrayList<HistoryVote> historyVoteList;
     private RecyclerViewItemClick.OnItemClickListener listener;

    public HistoryAdapter(ArrayList<HistoryVote> historyVoteList, RecyclerViewItemClick.OnItemClickListener listener) {
        this.historyVoteList = historyVoteList;
        this.listener = listener;
    }

    @Override
    public HistoryAdapter.HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_item,parent,false);
        return new HistoryViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {
        HistoryVote historyVote = historyVoteList.get(position);
        holder.historyName.setText(historyVote.getName());
        holder.historyDesc.setText(historyVote.getDescription());
    }


    @Override
    public int getItemCount() {
        return historyVoteList.size();
    }
    public class HistoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView historyName;
        public TextView historyDesc;


        public HistoryViewHolder(View view) {
            super(view);
            historyName = (TextView) view.findViewById(R.id.historyName);
            historyDesc = (TextView) view.findViewById(R.id.historyDesc);
            view.setOnClickListener(this);
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
            view = inflater.inflate(R.layout.history_item,parent,false);
        }
        HistoryVote historyVote = getHistory(position);
        ((TextView) view.findViewById(R.id.historyName)).setText(historyVote.getName());
        ((TextView) view.findViewById(R.id.historyDesc)).setText(historyVote.getDescription());
        return view;
    }

    private HistoryVote getHistory(int position) {
        return (HistoryVote) getItem(position);
    }*/
}
