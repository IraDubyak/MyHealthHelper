package com.example.ira.healthhelper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<String> systems;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView system;
        public ViewHolder(View v) {
            super(v);
            //system = v;
            system = (TextView) v.findViewById(R.id.system);
        }
    }

    public MyAdapter(ArrayList<String> system) {
        this.systems = system;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.system, parent, false);

       ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.system.setText(systems.get(position));

    }

    @Override
    public int getItemCount() {
        return systems.size();
    }
}
