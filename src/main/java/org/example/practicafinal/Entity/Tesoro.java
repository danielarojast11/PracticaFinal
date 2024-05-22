package org.example.practicafinal.Entity;

public class Tesoro extends Elemento {
    private int alteracion;

    public Tesoro(int tiempoActividad, Casilla casilla) {
        super(tiempoActividad, casilla);
    }

    public int getAlteracion(){
        return alteracion;
    }

    public void setAlteracion(int valor){
        this.alteracion=valor;
    }
}
