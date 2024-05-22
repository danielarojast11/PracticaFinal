package org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada;

import org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada.ElementoLDE;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaEnlazadaTest {

    ElementoLE<Integer> elementoLE = new ElementoLE<>(4);
    ListaEnlazada l = new ListaEnlazada(elementoLE);

    @Test
    void isVacia() {
        assertTrue(l.isVacia());
    }

    @Test
    void vaciar() {
        l.add(3);
        l.add(4);
        l.vaciar();
        assertTrue(l.isVacia());
    }

    @Test
    void add() {
        l.add(new ElementoLE<>(3));
        l.add(new ElementoLE<>(4));
        assertFalse(l.isVacia());
        assertEquals(2, l.getNumeroElementos());
    }

    @Test
    void testAdd() {
        l.add("Hi");
        l.add("No");
        assertFalse(l.isVacia());
        assertEquals(2, l.getNumeroElementos());
    }

    @Test
    void testAdd1() {
        l.add(2.0);
        l.add("Hi");
        assertFalse(l.isVacia());
        assertEquals(2, l.getNumeroElementos());
    }

    @Test
    void insert() {

    }

    @Test
    void testInsert() {

    }

    @Test
    void del() {
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.del(2);
        assertEquals(3, l.getNumeroElementos());
        assertEquals(3, l.getElemento(2).getData());
        l.del(0);
        assertEquals(2, l.getNumeroElementos());
        assertEquals(5, l.getPrimero().getData());
    }

    @Test
    void getNumeroElementos() {
        assertEquals(0,l.getNumeroElementos());
        l.add(3);
        l.add(4);
        assertEquals(2, l.getNumeroElementos());
    }

    @Test
    void getPosicion() {
        l.add(3);
        l.add(4);
        l.add(5);
        assertEquals(2, l.getPosicion(new ElementoLE(3)));
    }

    @Test
    void getPrimero() {
        l.add("Hi");
        l.add(6);
        l.add(8);
        assertEquals(8, l.getPrimero().getData());
    }

    @Test
    void getSiguiente() {
        l.add(7);
        l.add(8);
        l.add(9);
        assertEquals(7, l.getSiguiente(new ElementoLE(8)).getData());
    }

    @Test
    void getUltimo() {
        l.add(6);
        l.add(2);
        l.add("Hi");
        assertEquals(6, l.getUltimo().getData());
    }

    @Test
    void getElemento() {
        l.add("Hi");
        l.add(7);
        l.add(8);
        assertEquals(7, l.getElemento(1).getData());
        assertEquals(8, l.getElemento(0).getData());
    }
}