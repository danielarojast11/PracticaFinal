package org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoLDETest {

    @Test
    void insertarmeEn() {
        ElementoLDE e1 = new ElementoLDE();
        ElementoLDE e2 = new ElementoLDE();
        e1.insertarmeEn(e2);
    }

    @Test
    void getSiguiente() {
        ElementoLDE e1 = new ElementoLDE();
        e1.getSiguiente();
    }

    @Test
    void getAnterior() {
        ElementoLDE e1 = new ElementoLDE();
        e1.getAnterior();
    }

    @Test
    void getData() {
        ElementoLDE e1 = new ElementoLDE();
        e1.getData();
    }

    @Test
    void setData() {
        ElementoLDE e1 = new ElementoLDE();
        e1.setData("mundo");
        assertEquals("mundo", e1.getData());
    }
}