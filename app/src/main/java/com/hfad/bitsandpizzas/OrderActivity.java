package com.hfad.bitsandpizzas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        // get the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // set the toolbar to the activity as an action bar
        setSupportActionBar(toolbar);

        // get the app bar. this returns an ActionBar object, in this case it uses the toolbar that was specified above
        ActionBar actionBar = getSupportActionBar();
        // enable the up button
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}