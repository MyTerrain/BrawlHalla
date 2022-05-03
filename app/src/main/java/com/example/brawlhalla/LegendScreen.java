package com.example.brawlhalla;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.brawlhalla.model.Legends;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class LegendScreen extends AppCompatActivity {

    public static final String LEGENDS_URL = "https://api.brawlhalla.com/legend/all/?api_key=BKC1AQQUZC2B3IRJ1B8H";
    public static final String TAG = "LegendScreen";
    List<Legends> legendsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.legends_rv_activity);

        RecyclerView rvView = findViewById(R.id.rvLegends);
        legendsList = new ArrayList<>();
        LegendsAdapter adapter = new LegendsAdapter(this, legendsList);
        rvView.setAdapter(adapter);
        rvView.setLayoutManager(new LinearLayoutManager(this));

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(LEGENDS_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG, "OnSuccess");
                JSONArray legends =json.jsonArray;

                try {
                    Log.i(TAG, "Legends: " + legends.toString());
                    legendsList.addAll(Legends.fromJsonArray(legends));
                    adapter.notifyDataSetChanged();
                    Log.i(TAG, "Legends: " + legendsList.size());
                } catch (JSONException e) {
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
