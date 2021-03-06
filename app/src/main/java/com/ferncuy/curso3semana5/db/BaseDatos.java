package com.ferncuy.curso3semana5.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ferncuy.curso3semana5.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLA_MASCOTAS+ "("+
                ConstantesBaseDatos.TABLA_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLA_MASCOTAS_FOTO + " INTEGER" +
                ")";
        String queryCrearTablaMascotaHuesos = "CREATE TABLE " + ConstantesBaseDatos.TABLA_HUESOS_MASCOTA + "("+
                ConstantesBaseDatos.TABLA_HUESOS_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLA_HUESOS_MASCOTA_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLA_HUESOS_MASCOTA_QTY_HUESOS + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLA_HUESOS_MASCOTA_ID + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLA_MASCOTAS + "(" + ConstantesBaseDatos.TABLA_MASCOTAS_ID +")"+
                ")";
        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaMascotaHuesos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLA_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLA_HUESOS_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLA_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryHuesos = "SELECT COUNT("+ConstantesBaseDatos.TABLA_HUESOS_MASCOTA_QTY_HUESOS+") as huesos " +
                    " FROM " + ConstantesBaseDatos.TABLA_HUESOS_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLA_HUESOS_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();


            Cursor registrosHuesos = db.rawQuery(queryHuesos, null);

            if (registrosHuesos.moveToNext()){
                mascotaActual.setHuesos(registrosHuesos.getInt(0));
            }else{
                mascotaActual.setHuesos(0);
            }

            mascotas.add(mascotaActual);

        }
        db.close();
        return  mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLA_MASCOTAS, null, contentValues);
        db.close();
    }
    public void insertarHuesosMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLA_HUESOS_MASCOTA, null, contentValues);
        db.close();
    }

    public int obtenerHuesosMascota(Mascota mascota){
        int huesos = 0;
        String query = "SELECT COUNT( "+ConstantesBaseDatos.TABLA_HUESOS_MASCOTA_QTY_HUESOS+")" +
                "FROM "+ ConstantesBaseDatos.TABLA_HUESOS_MASCOTA +
                " WHERE "+ ConstantesBaseDatos.TABLA_HUESOS_MASCOTA_ID_MASCOTA + "="+ mascota.getId();
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            huesos = registros.getInt(0);
        }

        db.close();

        return huesos;
    }
}
