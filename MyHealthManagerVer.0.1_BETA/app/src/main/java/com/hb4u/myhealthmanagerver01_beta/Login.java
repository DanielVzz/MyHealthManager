package com.hb4u.myhealthmanagerver01_beta;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class Login extends AppCompatActivity {

    //region Variables
    private Toolbar toolbar;
    //endregion

    //region PageMethods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    //endregion

    //region MenuMethods
    //endregion

    //region ButtonEvents
    public void btnLogIn_Click(View view)
    {
        Intent myIntent = new Intent(Login.this, scanning_screen.class);
        Login.this.startActivity(myIntent);
        finish();
    }
    //endregion
}
