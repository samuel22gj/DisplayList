package com.seasual.displaylist;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView display_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        findViews();

        setupDisplayRecycler();
    }

    private void findViews() {
        display_recycler = (RecyclerView) findViewById(R.id.display_recycler);
    }

    private void setupDisplayRecycler() {
        display_recycler.setHasFixedSize(true);
        display_recycler.setLayoutManager(new LinearLayoutManager(this));
        display_recycler.setAdapter(new DisplayAdapter(getDisplayList()));
    }

    private ArrayList<Display> getDisplayList() {
        DisplayManager mDisplayManager = (DisplayManager) getSystemService(Context.DISPLAY_SERVICE);
        Display[] displays = mDisplayManager.getDisplays();
        return new ArrayList<>(Arrays.asList(displays));
    }
}
