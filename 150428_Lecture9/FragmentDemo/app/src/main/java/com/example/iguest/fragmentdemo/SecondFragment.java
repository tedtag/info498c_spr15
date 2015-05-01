package com.example.iguest.fragmentdemo;

/**
 * Created by iguest on 4/28/15.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Ted doesn't like having the Fragment in the same file
 * We should have each one in its own file
 */
public class SecondFragment extends Fragment {

    public SecondFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // BoilerPlate for most fragment code we create
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        return rootView;
    }
}