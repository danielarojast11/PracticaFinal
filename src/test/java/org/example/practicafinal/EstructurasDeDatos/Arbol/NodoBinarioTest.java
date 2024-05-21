package org.example.practicafinal.EstructurasDeDatos.Arbol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodoBinarioTest {

    @Test
    void getIzquierdo() {
        NodoBinario n = new NodoBinario(3);
        n.setIzquierdo(new NodoBinario(3));
        assertEquals(3,n.getIzquierdo().getContenido());
    }

    @Test
    void setIzquierdo() {
        NodoBinario n = new NodoBinario(3);
        n.setIzquierdo(new NodoBinario(4));
        assertEquals(4, n.getIzquierdo().getContenido());
    }

    @Test
    void getDerecho() {
        NodoBinario n = new NodoBinario(3);
        n.setDerecho(new NodoBinario(5));
        assertEquals(5, n.getDerecho().getContenido());
    }

    @Test
    void setDerecho() {
        NodoBinario n = new NodoBinario(3);
        n.setDerecho(new NodoBinario(6));
        assertEquals(6, n.getDerecho().getContenido());
    }

    @Test
    void getContenido() {
        NodoBinario n = new NodoBinario(3);
        assertEquals(3, n.getContenido());
    }

    @Test
    void setContenido() {
        NodoBinario n = new NodoBinario(3);
        n.setContenido(7);
        assertEquals(7, n.getContenido());
    }

    @Test
    void compareTo() {
        NodoBinario n = new NodoBinario(3);
        NodoBinario m = new NodoBinario(7);
        NodoBinario p = new NodoBinario(2);
        NodoBinario w = new NodoBinario(3);
        assertEquals(-1, n.compareTo(m));
        assertEquals(1, n.compareTo(p));
        assertEquals(0, n.compareTo(w));
    }
}