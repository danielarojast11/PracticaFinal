package org.example.practicafinal.EstructurasDeDatos.Arbol.AVL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodoTest {
    @Test
    void getIzquierdo() {
        Nodo n = new Nodo(3);
        n.setIzquierdo(new Nodo(3));
        assertEquals(3,n.getIzquierdo().getContenido());
    }

    @Test
    void setIzquierdo() {
        Nodo n = new Nodo(3);
        n.setIzquierdo(new Nodo(4));
        assertEquals(4, n.getIzquierdo().getContenido());
    }

    @Test
    void getDerecho() {
        Nodo n = new Nodo(3);
        n.setDerecho(new Nodo(5));
        assertEquals(5, n.getDerecho().getContenido());
    }

    @Test
    void setDerecho() {
        Nodo n = new Nodo(3);
        n.setDerecho(new Nodo(6));
        assertEquals(6, n.getDerecho().getContenido());
    }

    @Test
    void getContenido() {
        Nodo n = new Nodo(3);
        assertEquals(3, n.getContenido());
    }

    @Test
    void setContenido() {
        Nodo n = new Nodo(3);
        n.setContenido(7);
        assertEquals(7, n.getContenido());
    }

    @Test
    void getEquilibrio(){
        Nodo n = new Nodo(0);
        assertEquals(0, n.getEquilibrio());
    }

    @Test
    void setEquilibrio() {
        Nodo n = new Nodo(3);
        n.setEquilibrio(7);
        assertEquals(7, n.getEquilibrio());
    }

    @Test
    void compareTo() {
        Nodo n = new Nodo(3);
        Nodo m = new Nodo(7);
        Nodo p = new Nodo(2);
        Nodo w = new Nodo(3);
        assertEquals(-1, n.compareTo(m));
        assertEquals(1, n.compareTo(p));
        assertEquals(0, n.compareTo(w));
    }
}