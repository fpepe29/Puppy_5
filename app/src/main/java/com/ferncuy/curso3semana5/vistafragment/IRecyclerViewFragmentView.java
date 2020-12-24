package com.ferncuy.curso3semana5.vistafragment;

import com.ferncuy.curso3semana5.adapter.MascotaAdaptador;
import com.ferncuy.curso3semana5.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador mascotaAdaptador);

}
