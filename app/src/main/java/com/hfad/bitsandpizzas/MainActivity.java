package com.hfad.bitsandpizzas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // set the toolbar to the activity
        setSupportActionBar(toolbar);
    }

    // adds the items in the menu resource file to a Menu Object (inflate)
    // it puts the menu items on the toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // inflate the menu, this adds items to the app bar (resource file -> Menu object)
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // get the action share menu item
        MenuItem menuItem = menu.findItem(R.id.action_share);
        // get the action provider using the menu item and assign it to shareActionProvider
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        // call the method to put set the shareActionProvider intent
        setShareActionIntent("Want to join me for a pizza?");
        // put items on the toolbar (app bar)
        return super.onCreateOptionsMenu(menu);
    }

    // this creates an intent, put the message on it, then use it to set the shareActionProvider intent
    private void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    // this runs when an action in the app's bar is clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_create_order) {
            // this runs when the create order action item is clicked
            Intent intent = new Intent(this, OrderActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}