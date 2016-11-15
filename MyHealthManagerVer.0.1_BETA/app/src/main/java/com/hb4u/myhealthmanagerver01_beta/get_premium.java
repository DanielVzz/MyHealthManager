package com.hb4u.myhealthmanagerver01_beta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class get_premium extends AppCompatActivity {

    //region variables
    //endregion

    //region PageMethods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_premium);
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
            Intent myIntent = new Intent(get_premium.this, scanning_screen.class);
            get_premium.this.startActivity(myIntent);
            onPause();
        }else if(selectedMenuIdString.equals("item_check_statistics")){
            Intent myIntent = new Intent(get_premium.this, activity_statistics_home.class);
            get_premium.this.startActivity(myIntent);
            onPause();
        }
        else if(selectedMenuIdString.equals("item_settings")){
            Intent myIntent = new Intent(get_premium.this, settings.class);
            get_premium.this.startActivity(myIntent);
            onPause();
        }
        else if (selectedMenuIdString.equals("itemabout")) {
            Intent myIntent = new Intent(get_premium.this, about.class);
            get_premium.this.startActivity(myIntent);
            onPause();
        } else if(selectedMenuIdString.equals("item_getpremium")){
//            Intent myIntent = new Intent(scanning_screen.this, get_premium.class);
//            scanning_screen.this.startActivity(myIntent);
//            onPause();
        }
        return super.onOptionsItemSelected(item);
    }
    //endregion

    //region ButtonEvents
    //endregion

}
