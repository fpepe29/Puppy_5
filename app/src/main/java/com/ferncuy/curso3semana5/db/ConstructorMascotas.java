package com.ferncuy.curso3semana5.db;

import android.content.ContentValues;
import android.content.Context;

import com.ferncuy.curso3semana5.R;
import com.ferncuy.curso3semana5.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private Context context;
    private static final int Hueso = 1;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

       BaseDatos db = new BaseDatos(context);
       insertarMisMascotas(db);
       return db.obtenerTodasLasMascotas();
    }

    public void insertarMisMascotas (BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Vaca");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.vaca);

        db.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Caballo");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.caballo);

        db.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Cabra");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.cabra);

        db.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Cerdo");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.cerdo);

        db.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Oveja");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.oveja);

        db.insertarMascota(contentValues);
    }

    public void darHuesoMascota(Mascota mascota) {

        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_HUESOS_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLA_HUESOS_MASCOTA_QTY_HUESOS, Hueso);
        db.insertarHuesosMascota(contentValues);
    }

    public int obtenerHuesosMascota (Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerHuesosMascota(mascota);
    }

}
