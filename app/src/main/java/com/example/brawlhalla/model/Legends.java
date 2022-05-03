package com.example.brawlhalla.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Legends {

    String name;
    String nickNames;
    String Weapon1;
    String Weapon2;


    public Legends(JSONObject jsonObject) throws JSONException {
        name = jsonObject.getString("bio_name");
        nickNames = jsonObject.getString("bio_aka");
        Weapon1 = jsonObject.getString("weapon_one");
        Weapon2 = jsonObject.getString("weapon_two");
    }

    public String getName() {
        return name;
    }

    public String getNickNames() {
        return nickNames;
    }

    public String getWeapon1() {
        return Weapon1;
    }

    public String getWeapon2() {
        return Weapon2;
    }

    public static List<Legends> fromJsonArray(JSONArray movieJsonArray) throws JSONException
    {
        List<Legends> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Legends(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

}
