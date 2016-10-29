package com.hb4u.myhealthmanagerver01_beta;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class scanning_screen extends AppCompatActivity {

    //region variables
    //endregion

    //region PageMethods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanning_screen);
        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setHomeButtonEnabled(true);
        myActionBar.setDisplayHomeAsUpEnabled(true);
        myActionBar.setDisplayShowHomeEnabled(true);
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

//        int itemId = item.getItemId();
//        R.id.item_scan_code
//        if(itemId == "itemScanCode"){
//        }
//        else if(itemId == "itemCheckStatistics"){
//        }
//        else if(itemId == "itemSettings"){
//
//        }
//        else if(itemId == "itemAbout"){
//            Intent myIntent = new Intent(scanning_screen.this, about.class);
//            scanning_screen.this.startActivity(myIntent);
//            onPause();
//        }
//        else if(itemId == "itemPremium"){
//
//        }
        String selectedMenuIdString = (String) item.getTitleCondensed();
        if (selectedMenuIdString.equals("item_scan_code")) {

        } else if (selectedMenuIdString.equals("itemabout")) {
            Intent myIntent = new Intent(scanning_screen.this, about.class);
            scanning_screen.this.startActivity(myIntent);
            onPause();
        } else if(selectedMenuIdString.equals("itemSettings")){

        }
        return super.onOptionsItemSelected(item);
    }

    //endregion

    //region ButtonEvents
    //endregion

}
