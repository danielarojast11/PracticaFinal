package org.example.practicafinal.Entity;

public class Biblioteca extends Elemento {
    private int alteracion;

    public Biblioteca(int tiempoActividad, Casilla casilla) {
        super(tiempoActividad, casilla);
    }

    public int getAlteracion(){
        return alteracion;
    }

    public void setAlteracion(int valor){
        this.alteracion=valor;
    }
}
