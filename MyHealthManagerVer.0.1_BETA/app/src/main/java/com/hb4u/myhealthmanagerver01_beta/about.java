package com.hb4u.myhealthmanagerver01_beta;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class about extends AppCompatActivity {

    //region variables
    //endregion

    //region PageMethods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setHomeButtonEnabled(true);
        myActionBar.setDisplayHomeAsUpEnabled(true);
        myActionBar.setDisplayShowHomeEnabled(true);
    }
    //endregion

    //region MenuMethods
    //endregion

    //region buttonEvents
    //endregion
}
