package com.example.brawlhalla;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brawlhalla.model.Legends;

import java.util.List;

public class LegendsAdapter extends RecyclerView.Adapter<LegendsAdapter.ViewHolder> {

    Context context;
    List<Legends> legends;

    public LegendsAdapter(Context context, List<Legends> legends) {
        this.context = context;
        this.legends = legends;
    }

    @NonNull
    @Override
    public LegendsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View legendsView = LayoutInflater.from(context).inflate(R.layout.legends_activity, parent, false);
        return new ViewHolder(legendsView);
    }

    @Override
    public void onBindViewHolder(@NonNull LegendsAdapter.ViewHolder holder, int position) {
        Legends legendList = legends.get(position);
        holder.bind(legendList);
    }

    @Override
    public int getItemCount() { return legends.size();}

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView nickNames;
        TextView weapons1;
        TextView weapons2;
        TextView legends_ID;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvLegendsName);
            nickNames = itemView.findViewById(R.id.tvLegendsNN);
            weapons1 = itemView.findViewById(R.id.tvWeapon1);
            weapons2 = itemView.findViewById(R.id.tvWeapon2);
            legends_ID = itemView.findViewById(R.id.tvLegends_ID);

        }

        public void bind(Legends legendList) {
            name.setText(legendList.getName());
            nickNames.setText(legendList.getLegendsTitle());
            weapons1.setText(legendList.getWeapon1());
            weapons2.setText(legendList.getWeapon2());
            legends_ID.setText("" + legendList.getLegendsID());

            nickNames.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, LegendsBioActivity.class);
                    String legendsName = name.getText().toString();
                    String legendsNickNames = nickNames.getText().toString();
                    String legendsWeapon1 = weapons1.getText().toString();
                    String legendsWeapon2 = weapons2.getText().toString();
                    String botName = legendList.getBotName().toString();
                    CharSequence legend_ID = legends_ID.getText();
                   // int legendID = legends_ID.getText();
                    int speed = legendList.getSpeed();
                    int defense = legendList.getDefense();
                    int dexterity = legendList.getDexterity();
                    int strength = legendList.getStrength();
                   // int legendID = legendList.getLegendsID();

                    intent.putExtra("speed_id", speed);
                    intent.putExtra("defense_id", defense);
                    intent.putExtra("dexterity_id", dexterity);
                    intent.putExtra("strength_id", strength);

                    intent.putExtra("legendID",legends_ID);
                  //  intent.putExtra("name_id", legendsName);
                    intent.putExtra("nickNames_id", legendsNickNames);
                    intent.putExtra("weapon1_id", legendsWeapon1);
                    intent.putExtra("weapon2_id", legendsWeapon2);
                    intent.putExtra("botName_id", botName);
                    context.startActivity(intent);
                }
            });
        }
    }
}
