package com.example.iguest.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Date;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button)findViewById(R.id.btnNext);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String now = new Date().toString();
                // Date is depricated; Calendar is the recommended option

                Intent next = new Intent(MainActivity.this, NextActivity.class);

                // Extras are how we send objects to the
                // next activity; parcelable/ serializable for objects
                next.putExtra("dateTime", now);

                Log.i("MainActivity", "Firing intent" + next);

                // Nothing happens until...
                startActivity(next);
                // Destroy the current activity and removes it from the activity stack
                finish();
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


/*

// CLASSES vs CLASS OBJECTS
class person {
  public String firstName;
}

person p = new person();
java.lang.reflect.Class pc = p.getClass();
// get me the class  object of whatever p happens to be
Class personClass = person.class;
// resolves the same as the above

// Take a string, and we can see if there are any classes wit that name are loaded, and it
// returns a class object. newInstance() returns a new instance of the class represented by that
// particular class, creating by invoking the default constructor.

*/