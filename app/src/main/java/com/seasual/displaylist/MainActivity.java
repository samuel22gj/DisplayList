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

    private ArrayList<Display> mDisplayList;
    private RecyclerView.Adapter mDisplayAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private RecyclerView display_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        findViews();

        Display[] displays;

        DisplayManager mDisplayManager = (DisplayManager) getSystemService(Context.DISPLAY_SERVICE);
        displays = mDisplayManager.getDisplays();

        mDisplayList = new ArrayList<>(Arrays.asList(displays));

        setupDisplayRecycler();
    }

    private void findViews() {
        display_recycler = (RecyclerView) findViewById(R.id.display_recycler);
    }

    private void setupDisplayRecycler() {
        display_recycler.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        display_recycler.setLayoutManager(mLayoutManager);

        mDisplayAdapter = new DisplayAdapter(mDisplayList);
        display_recycler.setAdapter(mDisplayAdapter);
    }
}
