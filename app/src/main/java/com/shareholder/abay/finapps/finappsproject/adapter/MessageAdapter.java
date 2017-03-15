package com.shareholder.abay.finapps.finappsproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.shareholder.abay.finapps.finappsproject.R;
import com.shareholder.abay.finapps.finappsproject.model.Message;
import com.shareholder.abay.finapps.finappsproject.model.Vote;
import com.shareholder.abay.finapps.finappsproject.utils.RecyclerViewItemClick;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by abay on 10/24/16.
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private ArrayList<Message> messageList;

    private RecyclerViewItemClick.OnItemClickListener listener;

    public MessageAdapter(ArrayList<Message> messageList, RecyclerViewItemClick.OnItemClickListener listener) {
        this.messageList = messageList;
        this.listener = listener;
    }

    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vote_item,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MessageAdapter.ViewHolder holder, int position) {
        Message message = messageList.get(position);
        holder.voteId.setText("Тема: "+message.getTheme());
        holder.companyName.setText("Компания: "+message.getReceiver());
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        holder.endDate.setText("Конец голосования: " +df.format(message.getDate()));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView voteId;
        public TextView companyName;
        public TextView endDate;

        public ViewHolder(View view) {
            super(view);
            voteId = (TextView) view.findViewById(R.id.vote_id);
            companyName = (TextView) view.findViewById(R.id.company_name);
            endDate = (TextView) view.findViewById(R.id.end_date);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onItemClick(v, getAdapterPosition());
            }
        }
    }

        /*((TextView) view.findViewById(R.id.vote_id)).setText("Тема: "+message.getTheme());
        ((TextView) view.findViewById(R.id.company_name)).setText("Компания: "+message.getReceiver());
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        ((TextView) view.findViewById(R.id.end_date)).setText("Конец голосования: " +df.format(message.getDate()));
        return view;
        */


    }

