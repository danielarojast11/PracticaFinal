package org.example.practicafinal.Clases.Entorno;

import org.example.practicafinal.Clases.Tablero.Casilla;
import org.jetbrains.annotations.NotNull;

public class Elementos implements Comparable<Elementos>{

    private int tiempoActividad;
    private Casilla casilla = new Casilla();
    protected String type;

    public Elementos(int tiempoActividad) {
        this.tiempoActividad = tiempoActividad;
    }

    public Elementos() {
    }

    public int getTiempoActividad() {
        return tiempoActividad;
    }

    public void setTiempoActividad(int tiempoActividad) {
        this.tiempoActividad = tiempoActividad;
    }

    public void setCasilla(int columna, int fila){
        this.casilla = new Casilla(columna,fila);
    }

    public void setCasilla (Casilla casilla){
        this.casilla = casilla;
    }

    public String getType(){
        return type;
    }

    public Casilla getCasilla(){
        return casilla;
    }

    @Override
    public int compareTo(@NotNull Elementos o) {
        return 0;
    }
}
