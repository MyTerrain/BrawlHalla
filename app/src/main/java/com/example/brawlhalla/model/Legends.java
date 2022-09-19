package com.example.brawlhalla.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Legends {

    String name;
    String legendsTitle;
    String Weapon1;
    String Weapon2;
    String botName;
    int legendsID;
    int strength;
    int dexterity;
    int speed;
    int defense;



    public Legends(JSONObject jsonObject) throws JSONException {
        legendsID = jsonObject.getInt("legend_id");
        name = jsonObject.getString("legend_name_key");
        legendsTitle = jsonObject.getString("bio_aka");
        Weapon1 = jsonObject.getString("weapon_one");
        Weapon2 = jsonObject.getString("weapon_two");
        botName = jsonObject.getString("bio_name");
        strength = jsonObject.getInt("strength");
        dexterity = jsonObject.getInt("dexterity");
        speed = jsonObject.getInt("speed");
        defense = jsonObject.getInt("defense");

    }

    public int getLegendsID() {
        return legendsID;
    }

    public String getName() {
        return name;
    }

    public String getLegendsTitle() {
        return legendsTitle;
    }

    public String getWeapon1() {
        return Weapon1;
    }

    public String getWeapon2() {
        return Weapon2;
    }

    public String getBotName() {
        return botName;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDefense() {
        return defense;
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
