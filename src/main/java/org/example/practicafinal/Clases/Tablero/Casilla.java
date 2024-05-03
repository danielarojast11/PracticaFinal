package org.example.practicafinal.Clases.Tablero;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import org.example.practicafinal.EscenarioJugarController;

public class Casilla extends BorderPane {
    int columna;
    int fila;

    EscenarioJugarController escenario;
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


    public int filaAleatoria(int top){
        int fila = (int) (Math.random()*top);
        return fila;
    }

    public int columnaAleatoria(int top){
        int columna = (int) (Math.random()*top);
        return columna;
    }
}
