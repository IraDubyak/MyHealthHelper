package com.example.ira.healthhelper;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.ArrayList;

public class SymptomActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_symptoms);
        mLocalDataBase = new LocalDataBase(this);
        initViews();

    }

    private ArrayList<String> symptoms;
    LocalDataBase mLocalDataBase;
    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view_symptoms);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        symptoms = new ArrayList<>();
        symptoms.addAll(mLocalDataBase.getItems());

        mAdapter = new SymptomAdapter(symptoms);
        mRecyclerView.setAdapter(mAdapter);
    }


}