package org.example.practicafinal.Entity;

import org.jetbrains.annotations.NotNull;

public class Elemento implements Comparable<Elemento>
{
    private int tiempoActividad;
    private Casilla casilla;

    public Elemento(int tiempoActividad, Casilla casilla) {
        this.tiempoActividad = tiempoActividad;
        this.casilla = casilla;
    }

    public int getTiempoActividad() {
        return tiempoActividad;
    }

    public void setTiempoActividad(int tiempoActividad) {
        this.tiempoActividad = tiempoActividad;
    }

    public Casilla getCasilla(){
        return casilla;
    }

    public void setCasilla(Casilla casilla){
        this.casilla = casilla;
    }

    @Override
    public int compareTo(@NotNull Elemento o) {
        return 0;
    }
}
