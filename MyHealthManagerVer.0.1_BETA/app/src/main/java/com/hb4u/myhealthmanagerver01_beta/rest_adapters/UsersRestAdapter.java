package com.hb4u.myhealthmanagerver01_beta.rest_adapters;


import android.os.AsyncTask;

import com.hb4u.myhealthmanagerver01_beta.api_repository.UsersApi;
import com.hb4u.myhealthmanagerver01_beta.classes.Users;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.lang.Object;

public class UsersRestAdapter extends AsyncTask<String, Void, Users>{
    protected final String TAG = getClass().getSimpleName();
    protected Retrofit mRestAdapter;
    protected UsersApi mUserApi;
    static final String USERS_URL="http://192.168.1.74:53494/CalculatorWebService.asmx/";

    public UsersRestAdapter(){
        try {
            mRestAdapter = new Retrofit.Builder()
                    .baseUrl(USERS_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mUserApi = mRestAdapter.create(UsersApi.class);
        }catch(Exception ex){
        ex.printStackTrace();
        }
    }

    @Override
    protected Users doInBackground(String... strings) {
        Call<Users> call = mUserApi.getUser();
        Users result = null;
        try{
            result = call.execute().body();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onPostExecute(Users user){

    }

}
