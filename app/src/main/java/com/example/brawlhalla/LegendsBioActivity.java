package com.example.brawlhalla;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.brawlhalla.model.LegendsBio;

import org.json.JSONArray;

import okhttp3.Headers;

public class LegendsBioActivity extends AppCompatActivity{
   // public static final String LEGENDS_API_KEY = "https://api.brawlhalla.com/legend/3/?api_key=BKC1AQQUZC2B3IRJ1B8H";
    public static final String TAG = "LegendsBioActivity";
    //List<LegendsBio> legendsBio;
    Intent myIntent = getIntent();
    int legendsID = myIntent.getIntExtra("legendID", 0);
//    String legendsID = myIntent.getStringExtra("legendID");
    String id_legends = String.valueOf(legendsID);
    //String legendsID = getIntent().getStringExtra("legends_ID");
    //String getWeapon2 = getIntent().getStringExtra("weapon2_id");
    String api_key = "/?api_key=BKC1AQQUZC2B3IRJ1B8H";
    public final String LEGENDS_API_KEY = "https://api.brawlhalla.com/legend/"+id_legends+api_key;

    TextView infoName;
    TextView legendsNickNames;
    TextView weapon1;
    TextView weapon2;
    Button backButton;
    TextView botName;
    TextView story;
//    RatingBar strength;
//    RatingBar dexterity;
//    RatingBar defense;
//    RatingBar speed;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.legends_info_activity);

        infoName = findViewById(R.id.tvInfoName);
        legendsNickNames = findViewById(R.id.tvBioNN);
        weapon1 = findViewById(R.id.tvBioWeapon1);
        weapon2 = findViewById(R.id.tvBioWeapon2);
        backButton = findViewById(R.id.btBackButton);
        botName = findViewById(R.id.tvBotName);
        story = findViewById(R.id.tvBioStory);
//        strength = findViewById(R.id.rbStength);
//        speed = findViewById(R.id.rbSpeed);
//        dexterity = findViewById(R.id.rbDexterity);
//        defense = findViewById(R.id.rbDefense);

        LegendsBio legendsBio = getIntent().getParcelableExtra("legends");
                //Parcels.unwrap(getIntent().getParcelableExtra("movie"));
        

         infoName.setText(legendsBio.getName().toString());
         weapon1.setText(legendsBio.getBioWeapon1().toString());
         weapon2.setText(legendsBio.getBioWeapon2().toString());
         botName.setText(legendsBio.getBioBotName().toString());
         story.setText(legendsBio.getBioStory().toString());
         legendsNickNames.setText(legendsBio.getLegendsNickNames().toString());
         

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(LEGENDS_API_KEY, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG, "OnSuccess");
                JSONArray brawlLegends = json.jsonArray;

                try{
                    LegendsBio.fromJsonObject(brawlLegends);
                   // adapter.notifyDataSetChanged();

                } catch (Exception e) {
                    Log.e(TAG, "Hit Json Exception");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {

            }
        });


    }
}

/*
  @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.legends_info_activity);

        RecyclerView rvBio = findViewById(R.id.rvInfo);
        legendsBio = new ArrayList<>();
        LegendsBioAdapter adapter = new LegendsBioAdapter(this, legendsBio);
        rvBio.setAdapter(adapter);
        rvBio.setLayoutManager(new LinearLayoutManager(this));

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(LEGENDS_API_KEY, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG, "OnSuccess");
                JSONArray brawlLegends = json.jsonArray;

                try{
                    LegendsBio.fromJsonObject(brawlLegends);
                    adapter.notifyDataSetChanged();

                } catch (Exception e) {
                    Log.e(TAG, "Hit Json Exception");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {

            }
        });




    }
}




 */
