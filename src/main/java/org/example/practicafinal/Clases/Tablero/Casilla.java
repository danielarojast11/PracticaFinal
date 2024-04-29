package org.example.practicafinal.Clases.Tablero;

import javafx.scene.layout.Pane;

public class Casilla extends Pane {
    int columna;
    int fila;
    public Casilla(){

    }
    public Casilla(int columna, int fila){
        this.columna=columna;
        this.fila=fila;
        this.setId("casilla("+columna+","+fila+")");
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void generarAleatoria(int columna, int fila){

    }
}
