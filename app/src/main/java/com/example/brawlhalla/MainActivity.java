package com.example.brawlhalla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image = findViewById(R.id.ivBrawl);
        image.setImageResource(R.drawable.brawlhallascreen);
        Button legends = findViewById(R.id.btLegends);

        legends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), LegendScreen.class);
                startActivity(i);
                finish();
            }
        });
    }
}