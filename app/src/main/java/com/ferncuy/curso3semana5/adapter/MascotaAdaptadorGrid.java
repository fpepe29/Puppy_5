package com.ferncuy.curso3semana5.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ferncuy.curso3semana5.R;
import com.ferncuy.curso3semana5.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptadorGrid extends RecyclerView.Adapter<MascotaAdaptadorGrid.MascotaViewHolderGrid>{


    ArrayList<Mascota> mascotas;
    Activity activitygrid;

    public static  class MascotaViewHolderGrid extends RecyclerView.ViewHolder {
        private ImageView imgFotoCVgrid;
        private TextView tvQtyHuesosCVgrid;


        public MascotaViewHolderGrid(@NonNull View itemView) {
            super(itemView);
            imgFotoCVgrid = (ImageView) itemView.findViewById(R.id.imgFotoCVgrid);
            tvQtyHuesosCVgrid = (TextView) itemView.findViewById(R.id.tvQtyHuesosCV);

        }



    }


    public MascotaAdaptadorGrid(ArrayList<Mascota> mascotas, Activity activitygrid) {
        this.mascotas = mascotas;
        this.activitygrid = activitygrid;

    }

    @NonNull
    @Override
    public MascotaViewHolderGrid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_app_pets_perfilgrid,parent,false);
        return new MascotaViewHolderGrid(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolderGrid mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFotoCVgrid.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvQtyHuesosCVgrid.setText(String.valueOf(mascota.getHuesos()));

    }

    @Override
    public int getItemCount() {//cantidad de elementos que contine mi lista
        return mascotas.size(); // mascotas .size es la cantidad de elementos que contiene la lista de mascotas
    }


}
