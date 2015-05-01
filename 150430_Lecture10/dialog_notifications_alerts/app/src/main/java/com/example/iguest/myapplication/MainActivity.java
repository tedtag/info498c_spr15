package com.example.iguest.myapplication;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              // Toasts are useful for simple notifications, warnings, etc.
              Toast toast = Toast.makeText(MainActivity.this, "This is toast", Toast.LENGTH_SHORT);
              toast.setGravity(Gravity.LEFT & Gravity.TOP, 10, 10);
              toast.show();

              // Toast.makeText(MainActivity.this, "This is toast 2", Toast.LENGTH_SHORT).show();
              // Toast.makeText(MainActivity.this, "This is toast 3", Toast.LENGTH_SHORT).show();
              // Toast.makeText(MainActivity.this, "This is toast 4", Toast.LENGTH_SHORT).show();

              Notification.Builder builder = new Notification.Builder(MainActivity.this)
                      .setContentTitle("Notification!")
                      .setContentText("This is a notification")
                      .setSmallIcon(R.drawable.ic_launcher);
              //Large icon is the icon to the left; small is to the right

                   // .setSound(URI)
                   // .setPriority(Notification.PRIORITY_HIGH);
              Notification note = builder.build();
              // Notification note = builder.getNotification();

              // An android system service
              // We pass in a string because they don't have to change the context base class
              // when they add new system services. FBC -- fragile base class problem.

              NotificationManager mgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
              mgr.notify(1, note);

              AlertDialog.Builder dlgBuilder = new AlertDialog.Builder(MainActivity.this);
           /* dlgBuilder.setMessage("Launch nukes?");
              dlgBuilder.setTitle("Confirm");
              dlgBuilder.setPositiveButton("LAUNCH", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     Toast.makeText(MainActivity.this, "Lancuning...", Toast.LENGTH_SHORT).show();
                 }
              });
          */

              dlgBuilder.setTitle("Login");
              dlgBuilder.setView(R.layout.login_dialog);
              dlgBuilder.create().show();
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
