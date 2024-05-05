package org.example.practicafinal.Clases.Tablero;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import org.example.practicafinal.EscenarioJugarController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Casilla extends BorderPane implements MouseListener {
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

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
