package com.hb4u.myhealthmanagerver01_beta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class activity_statistics_home extends AppCompatActivity {

    //region variables
    //endregion

    //region PageMethods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_home);
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

        } else if (selectedMenuIdString.equals("itemabout")) {
            Intent myIntent = new Intent(activity_statistics_home.this, about.class);
            activity_statistics_home.this.startActivity(myIntent);
            onPause();
        } else if(selectedMenuIdString.equals("itemSettings")){

        }else if(selectedMenuIdString.equals("itemCheckStatistics")){

        }
        return super.onOptionsItemSelected(item);
    }
    //endregion

    //region ButtonEvents
    //endregion

}
