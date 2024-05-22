package org.example.practicafinal.EstructurasDeDatos.Arbol.Binario;

public class NodoBinario implements Comparable<NodoBinario>{
    private NodoBinario izquierdo;
    private NodoBinario derecho;
    private int contenido;

    public NodoBinario (int valor){
        this.contenido = valor;
    }

    public NodoBinario getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoBinario izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoBinario getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoBinario derecho) {
        this.derecho = derecho;
    }

    public int getContenido() {
        return contenido;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    @Override
    public int compareTo(NodoBinario o) {
        if (this.contenido < o.getContenido()){
            return -1;
        }
        if (this.contenido > o.getContenido()){
            return 1;
        }
        return 0;
    }
}
