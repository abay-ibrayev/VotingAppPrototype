package com.shareholder.abay.finapps.finappsproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shareholder.abay.finapps.finappsproject.MainActivity;
import com.shareholder.abay.finapps.finappsproject.R;

import java.util.Calendar;

public class MessagesActivity extends MainActivity implements View.OnClickListener{
    Button btnMessage;
    Button btnArchive;
    EditText etReceiver;
    EditText etTheme;
    EditText etContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_messages,frameContent);
        setTitle("Сообщения");
        bindViews();
    }

    @Override
    protected void bindViews() {
        btnMessage = (Button) findViewById(R.id.btnMessage);
        btnArchive = (Button) findViewById(R.id.btnArchive);
        etReceiver = (EditText) findViewById(R.id.etReceiver);
        etTheme = (EditText)findViewById(R.id.etTheme);
        etContent = (EditText)findViewById(R.id.etContent);
        btnArchive.setOnClickListener(this);
        btnMessage.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigationView.getMenu().getItem(2).setChecked(true);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.btnMessage:
                if(etReceiver.getText().toString()!="" && etTheme.getText().toString()!="" && etContent.getText().toString()!=""){
                    Toast.makeText(getApplicationContext(),"Sending Email",Toast.LENGTH_LONG).show();
                    intent= new Intent(getApplicationContext(),ArchiveMessagesActivity.class);
                    intent.putExtra("receiver", etReceiver.getText().toString());
                    intent.putExtra("theme",etTheme.getText().toString());
                    intent.putExtra("content",etContent.getText().toString());
                    intent.putExtra("date", Calendar.getInstance().getTime());
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Fill all fields",Toast.LENGTH_LONG).show();
                }


                break;
            case R.id.btnArchive:
                intent = new Intent(getApplicationContext(),ArchiveMessagesActivity.class);
                startActivity(intent);
                break;

        }
    }
}
