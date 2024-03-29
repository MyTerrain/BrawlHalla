package com.example.brawlhalla.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LegendsBio {

    String name;
    String bioBotName;
    String legendsNickNames;
    String story;
    String bioWeapon1;
    String bioWeapon2;
    int strength;
    int dexterity;
    int speed;
    int defense;

    public LegendsBio(JSONObject jsonObject) throws JSONException{
        name = jsonObject.getString("legend_name_key");
        bioBotName = jsonObject.getString("bot_name");
        legendsNickNames = jsonObject.getString("bio_aka");
        story = jsonObject.getString("bio_text");
        bioWeapon1 = jsonObject.getString("weapon_one");
        bioWeapon2 = jsonObject.getString("weapon_two");
        strength = jsonObject.getInt("strength");
        dexterity = jsonObject.getInt("dexterity");
        speed = jsonObject.getInt("speed");
        defense = jsonObject.getInt("defense");
    }

    public String getName() {
        return name;
    }

    public String getBioBotName() {
        return bioBotName;
    }

    public String getLegendsNickNames() {
        return legendsNickNames;
    }

    public String getBioStory() {
        return story;
    }

    public String getBioWeapon1() {
        return bioWeapon1;
    }

    public String getBioWeapon2() {
        return bioWeapon2;
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

    public static List<LegendsBio> fromJsonObject(JSONArray jsonArrayBio) throws JSONException{

        List<LegendsBio> legendsBios = new ArrayList<>();
        for (int i = 0; i < jsonArrayBio.length(); i++) {
            legendsBios.add(new LegendsBio(jsonArrayBio.getJSONObject(i)));
        }
        return legendsBios;
    }
}
