package com.debin.makeupdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.debin.makeupdemo.adapter.MakeUpAdapter;
import com.debin.makeupdemo.model.MakeUp;
import com.debin.makeupdemo.viewmodel.MakeUpViewModel;
import com.debin.makeupdemo.viewmodelFactory.MakeUpViewModelFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private MakeUpViewModel makeUpViewModel;
    private MakeUpAdapter makeUpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        makeUpViewModel = new ViewModelProvider(this, new MakeUpViewModelFactory("powder")).get(MakeUpViewModel.class);
        makeUpViewModel.getMakeUpData().observe(this, new Observer<List<MakeUp>>() {
            @Override
            public void onChanged(List<MakeUp> makeUps) {
             makeUpAdapter = new MakeUpAdapter(makeUps);
             recyclerView.setAdapter(makeUpAdapter);
             makeUpAdapter.notifyDataSetChanged();
             progressBar.setVisibility(View.GONE);
            }
        });

    }

    private void initViews() {
        recyclerView = findViewById(R.id.rv_makeup);
        progressBar = findViewById(R.id.progressBar);
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
