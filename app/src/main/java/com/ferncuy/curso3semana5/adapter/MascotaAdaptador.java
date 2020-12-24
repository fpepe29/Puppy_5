package com.ferncuy.curso3semana5.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ferncuy.curso3semana5.R;
import com.ferncuy.curso3semana5.db.ConstructorMascotas;
import com.ferncuy.curso3semana5.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;
    public static  class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFotoCV;
        private TextView tvNombreCV;
        private TextView tvQtyHuesosCV;
        private ImageButton bntDarHueso;



        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoCV    = (ImageView) itemView.findViewById(R.id.imgFotoCVgrid);
            tvNombreCV   = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvQtyHuesosCV = (TextView) itemView.findViewById(R.id.tvQtyHuesosCV);
            bntDarHueso = (ImageButton) itemView.findViewById(R.id.btnDarHueso);


        }
    }


    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;

    }

    @Override
    public MascotaViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_app_pets,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder( final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvQtyHuesosCV.setText(String.valueOf(mascota.getHuesos()));

        mascotaViewHolder.bntDarHueso.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(activity ,"Diste like a "+ mascota.getNombre(),Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darHuesoMascota(mascota);
                mascotaViewHolder.tvQtyHuesosCV.setText(String.valueOf(constructorMascotas.obtenerHuesosMascota(mascota)));


            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


}
