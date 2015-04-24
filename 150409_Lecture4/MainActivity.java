package com.example.iguest.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.util.Log;
// Or import static android.util.Log.*;

public class MainActivity extends Activity {

    // Specify the TAG for debugging
    public static final String TAG = "MainActivity";

    // We will not create constructors.
    // All constructor methods will be deferred to onCreate
    // There are internal and external events.
    // "on"____ events are all internal events.

    // From a compiler perspective, @Override hints to the compiler
    // that the method should exist as a parent method

    // Bundle lets us save the state just in case the android
    // system wants to destroy the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This is the tag; it's typically derived fro the Activity name
        Log.i(TAG, "onCreate called");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
