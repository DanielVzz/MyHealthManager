package com.hb4u.myhealthmanagerver01_beta;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.hb4u.myhealthmanagerver01_beta.classes.Users;
import com.hb4u.myhealthmanagerver01_beta.rest_adapters.UsersRestAdapter;

import java.util.ArrayList;
import java.util.List;

public class activity_statistics_home extends AppCompatActivity {

    //region variables
    //endregion

    //region PageMethods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_home);
        //UsersRestAdapter userRepo = new UsersRestAdapter();

        final ProgressBar pBarSugar = (ProgressBar) findViewById(R.id.ProgressBarSugar);
        final ProgressBar pBarFat = (ProgressBar) findViewById(R.id.ProgressBarFat);
        final ProgressBar pBarSatFat = (ProgressBar) findViewById(R.id.ProgressBarSaturatedFat);
        final ProgressBar pBarSodium = (ProgressBar) findViewById(R.id.ProgressBarSodium);
        List<ProgressBar> myHealthProgressBars = new ArrayList<ProgressBar>();
        myHealthProgressBars.add(pBarSugar);
        myHealthProgressBars.add(pBarFat);
        myHealthProgressBars.add(pBarSatFat);
        myHealthProgressBars.add(pBarSodium);

        new UsersRestAdapter(myHealthProgressBars).execute();

//        Handler mHandler = new Handler();
//        mHandler.post(new Runnable() {
//            public void run() {
//                //pBarSugar.setProgress(50);
//                pBarSodium.setProgress(50);
//                pBarFat.setProgress(50);
//                pBarSatFat.setProgress(50);
//            }
//        });
    }
    //endregion

    //region MenuMethods
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.refresh, menu);
//        inflater.inflate(R.menu.stop, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String selectedMenuIdString = (String) item.getTitleCondensed();
        if (selectedMenuIdString.equals("item_scan_code")) {
            Intent myIntent = new Intent(activity_statistics_home.this, scanning_screen.class);
            activity_statistics_home.this.startActivity(myIntent);
            onPause();
        }else if(selectedMenuIdString.equals("item_check_statistics")){
//            Intent myIntent = new Intent(scanning_screen.this, activity_statistics_home.class);
//            scanning_screen.this.startActivity(myIntent);
//            onPause();
        }
        else if(selectedMenuIdString.equals("item_settings")){
            Intent myIntent = new Intent(activity_statistics_home.this, settings.class);
            activity_statistics_home.this.startActivity(myIntent);
            onPause();
        }
        else if (selectedMenuIdString.equals("itemabout")) {
            Intent myIntent = new Intent(activity_statistics_home.this, about.class);
            activity_statistics_home.this.startActivity(myIntent);
            onPause();
        } else if(selectedMenuIdString.equals("item_getpremium")){
            Intent myIntent = new Intent(activity_statistics_home.this, get_premium.class);
            activity_statistics_home.this.startActivity(myIntent);
            onPause();
        }
        return super.onOptionsItemSelected(item);
    }
    //endregion

    //region Metodos

    //endregion

    //region ButtonEvents
    //endregion

}
