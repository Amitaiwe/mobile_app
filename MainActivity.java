package com.example.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.*;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<cardView> mExampleList;

    private RecyclerView mRecyclerView;
    private pAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();

    }


    public void changeItem(int position, String text) {
        mExampleList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);
    }

    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new cardView(R.drawable.charmander, "charmander", "fire"));
        mExampleList.add(new cardView(R.drawable.squirtle, "squirtle", "water"));
        mExampleList.add(new cardView(R.drawable.bulbasaur, "bulbasaur", "grass"));
        mExampleList.add(new cardView(R.drawable.abra, "abra", "psychic"));
        mExampleList.add(new cardView(R.drawable.pidgey, "pidgey", "flying"));
        mExampleList.add(new cardView(R.drawable.pikachu, "pikachu", "electric"));
        mExampleList.add(new cardView(R.drawable.ponyta, "ponyta", "fire"));
        mExampleList.add(new cardView(R.drawable.psyduck, "psyduck", "water"));
        mExampleList.add(new cardView(R.drawable.vulfix, "vulfix", "fire"));
        mExampleList.add(new cardView(R.drawable.mewtwo, "mewtwo", "psychic"));

    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.myrecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new pAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new pAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked");
            }

            @Override
            public void onDeleteClick(int position) {

            }
        });
    }

}