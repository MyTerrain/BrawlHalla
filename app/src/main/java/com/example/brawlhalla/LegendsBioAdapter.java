package com.example.brawlhalla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brawlhalla.model.LegendsBio;

import java.util.List;

public class LegendsBioAdapter extends RecyclerView.Adapter<LegendsBioAdapter.ViewHolder> {

    List<LegendsBio> bioAdapterList;
    Context context;

    public LegendsBioAdapter(Context context, List<LegendsBio> bioAdapterList) {
        this.bioAdapterList = bioAdapterList;
        this.context = context;
    }

    @NonNull
    @Override
    public LegendsBioAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.legends_info_activity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LegendsBioAdapter.ViewHolder holder, int position) {
        LegendsBio legendsBioAdapter = bioAdapterList.get(position);
        holder.bind(legendsBioAdapter);
    }

    @Override
    public int getItemCount() {
        return bioAdapterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView bioName;
        TextView botName;
        TextView story;
        TextView nickNames;
        TextView firstWeapon;
        TextView secondWeapon;
        RatingBar speed;
        RatingBar defense;
        RatingBar dexterity;
        RatingBar strength;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bioName = itemView.findViewById(R.id.tvInfoName);
            botName = itemView.findViewById(R.id.tvBotName);
            story = itemView.findViewById(R.id.tvBioStory);
            nickNames = itemView.findViewById(R.id.tvBioNN);
            firstWeapon = itemView.findViewById(R.id.tvBioWeapon1);
            secondWeapon = itemView.findViewById(R.id.tvBioWeapon2);
            speed = itemView.findViewById(R.id.rbSpeed);
            defense = itemView.findViewById(R.id.rbDefense);
            dexterity = itemView.findViewById(R.id.rbDexterity);
            strength = itemView.findViewById(R.id.rbStength);
        }


        public void bind(LegendsBio legendsBioAdapter) {
            bioName.setText(legendsBioAdapter.getName());
            botName.setText(legendsBioAdapter.getName());
            story.setText(legendsBioAdapter.getBioStory());
            nickNames.setText(legendsBioAdapter.getLegendsNickNames());
            firstWeapon.setText(legendsBioAdapter.getBioWeapon1());
            secondWeapon.setText(legendsBioAdapter.getBioWeapon2());
            speed.setRating((float) legendsBioAdapter.getSpeed());
            defense.setRating((float)legendsBioAdapter.getDefense());
            dexterity.setRating((float)legendsBioAdapter.getDexterity());
            strength.setRating((float)legendsBioAdapter.getStrength());
            }
    }

}
