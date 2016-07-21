package com.seasual.displaylist;

import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.ViewHolder> {
    private static final String TAG = DisplayAdapter.class.getSimpleName();

    private ArrayList<Display> mDisplayList;

    public DisplayAdapter(ArrayList<Display> displays) {
        mDisplayList = displays;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView info;

        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.display_name);
            info = (TextView) v.findViewById(R.id.display_info);
        }
    }

    @Override
    public DisplayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.display_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DisplayAdapter.ViewHolder holder, int position) {
        Display display = mDisplayList.get(position);

        holder.name.setText(display.getName());
        holder.info.setText(getDisplayInfo(display));
    }

    @Override
    public int getItemCount() {
        return mDisplayList.size();
    }

    private String getDisplayInfo(Display display) {
        StringBuilder sb = new StringBuilder();
        sb.append("Display ID: ").append(display.getDisplayId()).append("\n");

        DisplayMetrics dm = new DisplayMetrics();
        display.getMetrics(dm);
        sb.append("Height: ").append(dm.heightPixels).append("\n");
        sb.append("Width: ").append(dm.widthPixels).append("\n");
        sb.append("Density: ").append(dm.density).append("\n");
        sb.append("Density DPI: ").append(dm.densityDpi);

        return sb.toString();
    }
}
