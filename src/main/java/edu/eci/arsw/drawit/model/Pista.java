package edu.eci.arsw.drawit.model;

public class Pista {

    private String contenido;
    private boolean tomada;

    public Pista(){}

    public Pista(String contenido, boolean tomada){
        this.contenido = contenido;
        this.tomada = tomada;
    }

    public boolean getTomada(){
        return tomada;
    }

    public void setTomada(boolean ganadorPista){
        this.tomada = ganadorPista;
    }

    public String getContenido(){
        return contenido;
    }

    public void setContenido(String contenido){
        this.contenido = contenido;
    }
}
