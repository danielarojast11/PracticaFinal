package org.example.practicafinal.Entity;

public class Montaña extends Elemento {
    private int alteracion = -2;

    public Montaña(int tiempoActividad, Casilla casilla) {
        super(tiempoActividad, casilla);
    }

    public int getAlteracion(){
        return this.alteracion;
    }

    public void setAlteracion(int alteracion){
        this.alteracion = alteracion;
    }
}
