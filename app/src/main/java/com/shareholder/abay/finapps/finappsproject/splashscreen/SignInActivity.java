package com.shareholder.abay.finapps.finappsproject.splashscreen;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.shareholder.abay.finapps.finappsproject.MainActivity;
import com.shareholder.abay.finapps.finappsproject.R;
import com.shareholder.abay.finapps.finappsproject.activity.ProfileActivity;
import com.shareholder.abay.finapps.finappsproject.rest.RestClient;
import com.shareholder.abay.finapps.finappsproject.rest.RestInterface;
import com.shareholder.abay.finapps.finappsproject.rest.SimpleResponse;
import com.shareholder.abay.finapps.finappsproject.rest.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignInActivity extends AppCompatActivity {
    EditText etLogin;
    EditText etPassword;
    User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        etLogin = (EditText) findViewById(R.id.etLogin);
        etPassword= (EditText) findViewById(R.id.etPassword);



    }
    public void onClick(View v){
        //here we need to check login and password for valid
        //some code......and if true from REST we go....
        user.setIin(etLogin.getText().toString());
        user.setPassword(etPassword.getText().toString());
        new PrefetchDataVotes().execute();



    }
    public boolean checkedUser=true;
    private class PrefetchDataVotes extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... params) {
            // here we need get some data from REST and convert it in Pojo objects
            RestInterface restService = RestClient.getClient().create(RestInterface.class);
            Call<SimpleResponse> call = restService.checkUser("Basic YnNiLnVzZXIxOjE=", user);
            call.enqueue(new Callback<SimpleResponse>() {
                @Override
                public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
                    Log.d("myLogs",response.body().isSuccess()+"");
                    if(response.isSuccessful()){
                        checkedUser = true;
                        Log.d("myLogs", "successful "+checkedUser);
                    }else {
                        Log.d("myLogs", "not successful "+checkedUser);
                    }
                    //checkedUser = response.body().isSuccess();

                }

                @Override
                public void onFailure(Call<SimpleResponse> call, Throwable t) {
                    Log.d("myLogs", "Not successful"+t.toString());
                }
            });

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(checkedUser){
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                //putExtra method with Logins
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(getApplicationContext(),"Неправильный ИИН или пароль",Toast.LENGTH_LONG).show();
            }


        }
    }
}
