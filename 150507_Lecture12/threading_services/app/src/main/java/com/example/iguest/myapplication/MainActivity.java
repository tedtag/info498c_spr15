package com.example.iguest.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.apache.http.client.HttpClient;

//class MyReceiver extends BroadcastReceiver
//{
//    @Override
//    public void onReceive(final Context c, Intent i) {
//        Log.v("MyReceiver", "Received Intent: " + i.toString());
//
//        Thread networkThread = new Thread(new Runnable() {
//            @Override public void run() {
//                HttpClient client = null;
//                //imagine network stuff goes here
//                String result = "Yay! It worked";
//
//                c.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(c, "We got results: " + reslt, Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });
//    }
//}

public class MainActivity extends ActionBarActivity {

    PendingIntent alarmIntent = null;
    BroadcastReceiver alarmReceiver = new BroadcastReceiver() {
        @Override public void onReceive(final Context c, Intent i) {
            Toast.makeText(MainActivity.this, "Received alarm!", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MyReceiver r = new MyReceiver();
//        registerReceiver(r, IntentFilter.create(Intent.ACTION_AIRPLANE_MODE_CHANGED, null));

        /* Always setup the receiver first so you don't miss the message */
        registerReceiver(alarmReceiver, new IntentFilter("com.tedneward.dosomethingreallycool"));

        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent();
        i.setAction("com.tedneward.dosomethingreallycool");
        alarmIntent = PendingIntent.getBroadcast(this, 0, i, 0);

        am.setRepeating(AlarmManager.RTC, System.currentTimeMillis() + 5000, 5 * 1000, alarmIntent);


        // To cancel:
        // am.cancel(alarmIntent);
        // alarmIntent.cancel();
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
