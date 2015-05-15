package com.example.iguest.tedsponytail;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class MyPhysicalActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Try-with-resources statement; Java 7
        try {
            try (FileOutputStream fos = new FileOutputStream("file.data")) {
                try (BufferedOutputStream bos = new BufferedOutputStream(fos)) {
                  bos.write("Hello, world".getBytes());
                }
            }
        }
        catch (IOException ioEx) {

        }
        // It'll write the finally catch for us

        FileOutputStream fos;
        BufferedOutputStream bos = null;
        try {
            fos = new FileOutputStream("file.data");
            bos = new BufferedOutputStream(fos);
            bos.write("Hello, world".getBytes());
        }
        catch(Exception x) {

        }
        finally {
            try {
                bos.close();
            }
            catch (IOException ioEx) {
                Log.e("MyPhysicalActivity", "weird exception, man" + ioEx);
            }
        }
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
