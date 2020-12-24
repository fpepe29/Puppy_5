package com.ferncuy.curso3semana5.pojo;

public class Mascota {
    private int id;
    private String nombre;
    private int huesos = 0;
    private int foto;


    public Mascota(int foto, String nombre, int huesos) {
        this.foto = foto;
        this.nombre = nombre;
        this.huesos = huesos;
    }
    public Mascota(int foto, int huesos) {
        this.foto = foto;
        this.huesos = huesos;
    }

    public Mascota(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
    }

    public Mascota() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHuesos() {        return huesos;    }

    public void setHuesos(int huesos) { this.huesos = huesos; }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getId() {        return id;    }

    public void setId(int id) {        this.id = id;    }
}
