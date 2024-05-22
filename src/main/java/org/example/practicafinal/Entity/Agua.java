package org.example.practicafinal.Entity;

public class Agua extends Elemento {

    private int alteracion = 2;

    public Agua(int tiempoActividad, Casilla casilla) {
        super(tiempoActividad, casilla);
    }

    public int getAlteracion(){
        return alteracion;
    }

    public void setAlteracion(int alteracion) {
        this.alteracion = alteracion;
    }

}
