package org.example.practicafinal.EstructurasDeDatos.Arbol.AVL;

public class Nodo implements Comparable<Nodo>{
    private Nodo izquierdo;
    private Nodo derecho;
    private int contenido;
    private int equilibrio;

    public Nodo (int valor){
        this.contenido = valor;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

    public int getContenido() {
        return contenido;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    public int getEquilibrio() {
        return equilibrio;
    }

    public void setEquilibrio(int equilibrio) {
        this.equilibrio = equilibrio;
    }

    @Override
    public int compareTo(Nodo o) {
        if (this.contenido < o.getContenido()){
            return -1;
        }
        if (this.contenido > o.getContenido()){
            return 1;
        }
        return 0;
    }
}
