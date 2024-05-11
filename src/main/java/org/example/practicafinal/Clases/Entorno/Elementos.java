package org.example.practicafinal.Clases.Entorno;

import org.example.practicafinal.Clases.Tablero.Casilla;
import org.jetbrains.annotations.NotNull;

public class Elementos implements Comparable<Elementos>{

    private int tiempoActividad;
    private int aparicionRecurso;
    private Casilla casilla = new Casilla();
    protected int type;

    public Elementos(int tiempoActividad, int type) {
        this.tiempoActividad = tiempoActividad;
        this.type = type;
    }

    public Elementos() {
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

    public void setCasilla(int columna, int fila){
        this.casilla = new Casilla(columna,fila);
    }

    public void setCasilla2(Casilla casilla){
        this.casilla = casilla;
    }

    public int getType(){
        return type;
    }

    public int getAparicionRecurso() {
        return aparicionRecurso;
    }

    public void setAparicionRecurso(int aparicionRecurso) {
        this.aparicionRecurso = aparicionRecurso;
    }

    @Override
    public int compareTo(@NotNull Elementos o) {
        return 0;
    }
}
