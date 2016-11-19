package com.hb4u.myhealthmanagerver01_beta.rest_adapters;


import android.icu.text.DecimalFormat;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.hb4u.myhealthmanagerver01_beta.R;
import com.hb4u.myhealthmanagerver01_beta.api_repository.UsersApi;
import com.hb4u.myhealthmanagerver01_beta.classes.UserHealthInfo;
import com.hb4u.myhealthmanagerver01_beta.classes.Users;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.lang.Object;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class UsersRestAdapter extends AsyncTask<List<ProgressBar>, Void, List<String>>{
    protected final String TAG = getClass().getSimpleName();
    protected Retrofit mRestAdapter;
    protected UsersApi mUserApi;
    private List<ProgressBar> MyprogressBar;
    static final String USERS_URL="http://192.168.1.74:53494/";


    public UsersRestAdapter(List<ProgressBar> myProgressBar){
        try {
            this.MyprogressBar = myProgressBar;
            Gson gson = new GsonBuilder().setLenient().create();
            mRestAdapter = new Retrofit.Builder()
                    .baseUrl(USERS_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            mUserApi = mRestAdapter.create(UsersApi.class);
        }catch(Exception ex){
        ex.printStackTrace();
        }
    }

    @Override
    protected List<String> doInBackground(List<ProgressBar>... strings) {
//        Call<Users> call = mUserApi.getUser();
//        Users result = null;
//        try{
//            result = call.execute().body();
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//
//        return result;

        Call<ResponseBody> call = mUserApi.getUser();
        List<String> healthInfoStrings = new ArrayList<String>();
        ResponseBody myHelathInfo = null;
        try{
            myHelathInfo = call.execute().body();
            String healthInfoInString = getJSONString(myHelathInfo);
            JSONObject healthObject = new JSONObject(healthInfoInString);
            healthInfoStrings.add(healthObject.get("totalSugar").toString());
            healthInfoStrings.add(healthObject.get("totalFat").toString());
            healthInfoStrings.add(healthObject.get("totalSaturatedFat").toString());
            healthInfoStrings.add(healthObject.get("totalSodium").toString());
        }catch(IOException e){
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return healthInfoStrings;
    }

    @Override
    protected void onPostExecute(final List<String> UserHealthInfo){
        Handler mHandler = new Handler();
        mHandler.post(new Runnable() {
            public void run() {
                for(int i= 0; i < MyprogressBar.size(); i++ ) {
                    MyprogressBar.get(i).setProgress((int) Double.parseDouble(UserHealthInfo.get(i)));
                }
            }
        });

    }

    public String getJSONString(ResponseBody response) {

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new ByteArrayInputStream(response.string().getBytes("utf-8"))));
            NodeList nl = doc.getElementsByTagName("string");
            Node n = nl.item(0);
            String str = n.getFirstChild().getNodeValue();
            System.out.println("Node value : " + str);
            return str;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
