package org.example.practicafinal.Clases.Entorno;

import org.example.practicafinal.Clases.Tablero.Casilla;

public class Elementos {

    private int tiempoActividad;
    private Casilla casilla = new Casilla();

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
    public void setCasilla (Casilla casilla){this.casilla = casilla;}

    public Casilla getCasilla(){
        return casilla;
    }
}
