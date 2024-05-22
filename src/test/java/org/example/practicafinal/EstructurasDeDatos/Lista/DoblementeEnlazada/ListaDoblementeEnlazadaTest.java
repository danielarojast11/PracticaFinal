package org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaDoblementeEnlazadaTest {

    @Test
    void isVacia() {
        ListaDoblementeEnlazada l1 = new ListaDoblementeEnlazada();
        assertTrue(l1.isVacia());
    }

    @Test
    void vaciar() {
        ListaDoblementeEnlazada l1 = new ListaDoblementeEnlazada();
        l1.vaciar();
    }

    @Test
    void add() {
        ElementoLDE e1 = new ElementoLDE();
        ListaDoblementeEnlazada l1 = new ListaDoblementeEnlazada();
        l1.add(e1);
    }

    @Test
    void testAdd() {
        String s = new String();
        ListaDoblementeEnlazada l1 = new ListaDoblementeEnlazada();
        l1.add(s);
    }

    @Test
    void testAdd1() {
        Object o = new Object();
        ListaDoblementeEnlazada l1 = new ListaDoblementeEnlazada();
        l1.add(o);
    }

    @Test
    void insert() {
        String s = new String();
        ListaDoblementeEnlazada l1 = new ListaDoblementeEnlazada();
        l1.insert(s, 1);
    }

    @Test
    void testInsert() {
        Object o = new Object();
        ListaDoblementeEnlazada l1 = new ListaDoblementeEnlazada();
        l1.insert(o, 0);
    }

    @Test
    void del() {
        ListaDoblementeEnlazada l1 = new ListaDoblementeEnlazada();
        l1.del(4);
    }

    @Test
    void getNumeroElementos() {
        ListaDoblementeEnlazada l1 = new ListaDoblementeEnlazada();
        l1.getNumeroElementos();
    }

    @Test
    void getPosicion() {
        ElementoLDE elementoLDE = new ElementoLDE();
        ListaDoblementeEnlazada l1 = new ListaDoblementeEnlazada();
        l1.getPosicion(elementoLDE);
    }

    @Test
    void getPrimero() {
        ListaDoblementeEnlazada l1 = new ListaDoblementeEnlazada();
        l1.getPrimero();
    }

    @Test
    void getUltimo() {
        ListaDoblementeEnlazada l1 = new ListaDoblementeEnlazada();
        l1.getUltimo();
    }

    @Test
    void getSiguiente() {
        ElementoLDE elementoLDE = new ElementoLDE();
        ListaDoblementeEnlazada l1 = new ListaDoblementeEnlazada();
        l1.getSiguiente(elementoLDE);
    }

    @Test
    void getAnterior() {
        ElementoLDE elementoLDE = new ElementoLDE();
        ListaDoblementeEnlazada l1 = new ListaDoblementeEnlazada();
        l1.getAnterior(elementoLDE);
    }

    @Test
    void getElemento() {
        ListaDoblementeEnlazada l1 = new ListaDoblementeEnlazada();
        l1.getElemento(2);
    }
}