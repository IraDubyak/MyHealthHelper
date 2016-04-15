package com.example.ira.healthhelper;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SystemActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_systems);
        initViews();

        final Button selectSystemsButton = (Button) findViewById(R.id.select_systems_button);

        selectSystemsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SystemActivity.this, SymptomActivity.class);
                startActivity(intent);
            }
        });

    }

    private ArrayList<String> systems;
    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        systems = new ArrayList<>();
        systems.add("Покривна");
        systems.add("М'язова");
        systems.add("Кісткова");
        systems.add("Нервова");
        systems.add("Кровоносна");
        systems.add("Дихальна");
        systems.add("Видільна");
        systems.add("Травна");

        mAdapter = new MyAdapter(systems);
        mRecyclerView.setAdapter(mAdapter);
    }

}

