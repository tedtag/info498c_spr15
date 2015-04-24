package com.example.iguest.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

// Import controls
import android.widget.*;
import android.view.*;
import java.util.*;

public class MainActivity extends ActionBarActivity {

    TextView text;
    Button coolButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // I would like you to load this resource, and use that as its view.
        setContentView(R.layout.activity_main);

        // Final says that this reference will live beyond length of this message
        // It allows us to access it inside of the event handler
     // final TextView text = (TextView) findViewByID(R.id.txtMessage);
        // OR we can put it outside of the method
        text = (TextView) findViewById(R.id.txtMessage);

        coolButton = (Button) findViewById(R.id.btnDisplayMessage);
        coolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("Today's date and time is " + new Date().toString());
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
