package com.example.brawlhalla;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brawlhalla.model.LegendsBio;

import java.util.ArrayList;
import java.util.List;

public class LegendsBioActivity extends AppCompatActivity{
    public static final String API_KEY = "https://api.brawlhalla.com/legend/3/?api_key=BKC1AQQUZC2B3IRJ1B8H";
    List<LegendsBio> legendsBio;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.legends_rv_bio);
        RecyclerView rvBio = findViewById(R.id.rvInfo);
        legendsBio = new ArrayList<>();
        LegendsBioAdapter adapter = new LegendsBioAdapter(this, legendsBio);
        rvBio.setAdapter(adapter);
        rvBio.setLayoutManager(new LinearLayoutManager(this));



    }
}
