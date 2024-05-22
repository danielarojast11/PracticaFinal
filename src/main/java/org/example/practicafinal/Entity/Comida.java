package org.example.practicafinal.Entity;

public class Comida extends Elemento {
    private int alteracion = 1;

    public Comida(int tiempoActividad, Casilla casilla) {
        super(tiempoActividad, casilla);
    }

    public int getAlteracion() {
        return alteracion;
    }

    public void setAlteracion(int alteracion) {
        this.alteracion = alteracion;
    }
}
