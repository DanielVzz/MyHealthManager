package com.hb4u.myhealthmanagerver01_beta;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;

public class activity_demo_mode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ViewPager viewPager;
        activity_custom_swipe  customSwip;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_mode);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        customSwip=new activity_custom_swipe(this);
        viewPager.setAdapter(customSwip);

        final Handler mHandler = new Handler();
        int delay = 1000;
        int period = 6500;

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(viewPager.getCurrentItem() == 5){
                            viewPager.setCurrentItem(0,true);
                        }
                        else{
                            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                        }

                    }
                });
            }
        }, delay, period);
    }

    public void mUpdateResults(){

    }

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
//            Intent myIntent = new Intent(scanning_screen.this, scanning_screen.class);
//            scanning_screen.this.startActivity(myIntent);
//            onPause();
        }else if(selectedMenuIdString.equals("item_check_statistics")){
            Intent myIntent = new Intent(activity_demo_mode.this, activity_statistics_home.class);
            activity_demo_mode.this.startActivity(myIntent);
            onPause();
        }
        else if(selectedMenuIdString.equals("item_settings")){
            Intent myIntent = new Intent(activity_demo_mode.this, settings.class);
            activity_demo_mode.this.startActivity(myIntent);
            onPause();
        }
        else if (selectedMenuIdString.equals("itemabout")) {
            Intent myIntent = new Intent(activity_demo_mode.this, activity_about_demo_mode.class);
            activity_demo_mode.this.startActivity(myIntent);
            onPause();
        } else if(selectedMenuIdString.equals("item_getpremium")){
            Intent myIntent = new Intent(activity_demo_mode.this, get_premium.class);
            activity_demo_mode.this.startActivity(myIntent);
            onPause();
        }
        return super.onOptionsItemSelected(item);
    }



    //endregion
}
