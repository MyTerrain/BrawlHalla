package com.example.brawlhalla;

import android.content.Context;
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
        TextView Weapons1;
        TextView Weapons2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvLegendsName);
            nickNames = itemView.findViewById(R.id.tvLegendsNN);
            Weapons1 = itemView.findViewById(R.id.tvWeapon1);
            Weapons2 = itemView.findViewById(R.id.tvWeapon2);
        }

        public void bind(Legends legendList) {
            name.setText(legendList.getName());
            nickNames.setText(legendList.getNickNames());
            Weapons1.setText(legendList.getWeapon1());
            Weapons2.setText(legendList.getWeapon2());
        }
    }
}
