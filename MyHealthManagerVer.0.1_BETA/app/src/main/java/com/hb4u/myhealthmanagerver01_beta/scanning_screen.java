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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class scanning_screen extends AppCompatActivity implements OnClickListener {

    //region variables
    private Button scanBtn;
    private TextView formatTxt, contentTxt;
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
        scanBtn = (Button)findViewById(R.id.scan_button);
        formatTxt = (TextView)findViewById(R.id.scan_format);
        contentTxt = (TextView)findViewById(R.id.scan_content);
        scanBtn.setOnClickListener(this);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            formatTxt.setText("FORMAT: " + scanFormat);
            contentTxt.setText("CONTENT: " + scanContent);
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
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
//            Intent myIntent = new Intent(scanning_screen.this, scanning_screen.class);
//            scanning_screen.this.startActivity(myIntent);
//            onPause();
        }else if(selectedMenuIdString.equals("item_check_statistics")){
            Intent myIntent = new Intent(scanning_screen.this, activity_statistics_home.class);
            scanning_screen.this.startActivity(myIntent);
            onPause();
        }
        else if(selectedMenuIdString.equals("item_settings")){
            Intent myIntent = new Intent(scanning_screen.this, settings.class);
            scanning_screen.this.startActivity(myIntent);
            onPause();
        }
        else if (selectedMenuIdString.equals("itemabout")) {
            Intent myIntent = new Intent(scanning_screen.this, about.class);
            scanning_screen.this.startActivity(myIntent);
            onPause();
        } else if(selectedMenuIdString.equals("item_getpremium")){
            Intent myIntent = new Intent(scanning_screen.this, get_premium.class);
            scanning_screen.this.startActivity(myIntent);
            onPause();
        }
        return super.onOptionsItemSelected(item);
    }



    //endregion

    //region ButtonEvents
    public void onClick(View v){
        if(v.getId()== R.id.scan_button){
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }
    //endregion



}
