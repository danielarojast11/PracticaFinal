package org.example.practicafinal.Entity;

public class Tesoro extends Elemento {
    private int probabilidad = 10;

    public Tesoro(int tiempoActividad, Casilla casilla) {
        super(tiempoActividad, casilla);
    }

    @Override
    public int getProbabilidad() {
        return probabilidad;
    }

    @Override
    public void setProbabilidad(int probabilidad) {
        this.probabilidad = probabilidad;
    }
}
