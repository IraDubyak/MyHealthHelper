package com.example.ira.healthhelper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class SymptomAdapter extends RecyclerView.Adapter<SymptomAdapter.ViewHolder> {
    private ArrayList<String> symptoms;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView symptom;
        public ViewHolder(View v) {
            super(v);
            //system = v;
            symptom = (TextView) v.findViewById(R.id.symptom);
        }
    }

    public SymptomAdapter(ArrayList<String> symptom) {
        this.symptoms = symptom;
    }

    @Override
    public SymptomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.symptom, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.symptom.setText(symptoms.get(position));

    }

    @Override
    public int getItemCount() {
        return symptoms.size();
    }
}