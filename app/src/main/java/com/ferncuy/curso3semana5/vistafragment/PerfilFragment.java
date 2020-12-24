package com.ferncuy.curso3semana5.vistafragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ferncuy.curso3semana5.R;
import com.ferncuy.curso3semana5.adapter.MascotaAdaptadorGrid;
import com.ferncuy.curso3semana5.pojo.Mascota;

import java.util.ArrayList;


public class PerfilFragment extends Fragment {
    ArrayList <Mascota> mascotas;
    ArrayList <Mascota> mascotasMain;
    public RecyclerView rvMascotasGrid;
    public RecyclerView rvMascotasGridMain;

    /*// TODO: Rename parameter arguments, choose names that match
    // the vista.vistafragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PerfilFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment vista.vistafragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        vista.vistafragment.setArguments(args);
        return vista.vistafragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this vista.vistafragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvMascotasGrid = (RecyclerView) v.findViewById(R.id.rvMascotasGrid);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);

        rvMascotasGrid.setLayoutManager(gridLayoutManager);
        inicializarListaMascotasGrid();
        inicializarAdaptadorGrid();

        return v;
    }
    public void inicializarAdaptadorGrid (){
        MascotaAdaptadorGrid mascotaAdaptadorGrid = new MascotaAdaptadorGrid(mascotas,getActivity());
        rvMascotasGrid.setAdapter(mascotaAdaptadorGrid);
    }


    public void inicializarListaMascotasGrid() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.vaca, 1));
        mascotas.add(new Mascota(R.drawable.vaca, 2));
        mascotas.add(new Mascota(R.drawable.vaca, 3));
        mascotas.add(new Mascota(R.drawable.vaca, 4));
        mascotas.add(new Mascota(R.drawable.vaca, 5));
        mascotas.add(new Mascota(R.drawable.vaca, 6));
        mascotas.add(new Mascota(R.drawable.vaca, 7));
        mascotas.add(new Mascota(R.drawable.vaca, 8));
        mascotas.add(new Mascota(R.drawable.vaca, 9));

    }

}