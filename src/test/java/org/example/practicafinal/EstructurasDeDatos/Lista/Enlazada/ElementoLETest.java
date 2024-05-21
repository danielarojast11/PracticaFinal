package org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoLETest {

    @Test
    void insertarmeEn() {
        ElementoLE a = new ElementoLE(9);
        ElementoLE b = new ElementoLE(10);
        b.insertarmeEn(a);
        assertEquals(9, b.getSiguiente().getData());
    }

    @Test
    void getSiguiente() {
        ElementoLE a = new ElementoLE(9);
        ElementoLE b = new ElementoLE(10);
        b.insertarmeEn(a);
        assertEquals(9,b.getSiguiente().getData());
    }

    @Test
    void getData() {
        ElementoLE a = new ElementoLE(9);
        assertEquals(9, a.getData());
    }

    @Test
    void setData() {
        ElementoLE a = new ElementoLE(0);
        a.setData(9);
        assertEquals(9,a.getData());
    }
}