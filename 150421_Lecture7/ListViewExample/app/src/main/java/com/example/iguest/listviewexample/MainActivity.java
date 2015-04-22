package com.example.iguest.listviewexample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    public String[] heroes = {"Iron Man", "Batman", "Superman", "Thor", "Condorman"};

    private ListView theList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theList = (ListView) findViewById(R.id.lstSummerHeroes);

        // ArrayAdaptor will implements all the appropriate data for a given String

        // @ First parameter is a context. It's the hook back to the Android environment.
        // The context will 99.9% of the time be the activity where it will be taking place.
        // @ Second parameter will be a resource.
        ArrayAdapter<String> items = new ArrayAdapter<String>(this, R.layout.simple_list_item, heroes);
        // ArrayAdapter<String> items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, heroes);
        theList.setAdapter(items);

        // The point is that if the user clicks the list for any amount of time, we will...
        theList.setOnItemClickListener(new ListView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Go bring some other activity around the item selected
                Toast.makeText(MainActivity.this, "You selected position " + position + " which is " + heroes[position], Toast.LENGTH_SHORT).show();
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
