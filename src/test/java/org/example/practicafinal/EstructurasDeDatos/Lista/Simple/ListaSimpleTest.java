package org.example.practicafinal.EstructurasDeDatos.Lista.Simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaSimpleTest {

    @Test
    void isVacia() {
        ListaSimple ls = new ListaSimple();
        ls.isVacia();
    }

    @Test
    void vaciar() {
        ListaSimple ls = new ListaSimple();
        ls.vaciar();
    }

    @Test
    void add() {
        ElementoLS elementoLS = new ElementoLS();
        ListaSimple ls = new ListaSimple();
        ls.add(elementoLS);
    }

    @Test
    void testAdd() {
        String s = new String();
        ListaSimple ls = new ListaSimple();
        ls.add(s);
    }

    @Test
    void testAdd1() {
        Object o = new Object();
        ListaSimple ls = new ListaSimple();
        ls.add(o);
    }

    @Test
    void insert() {
        String s = new String();
        ListaSimple ls = new ListaSimple();
        ls.insert(s, 1);
    }

    @Test
    void testInsert() {
        Object o = new Object();
        ListaSimple ls = new ListaSimple();
        ls.insert(o, 2);
    }

    @Test
    void del() {
        ListaSimple ls = new ListaSimple();
        ls.del(2);
    }

    @Test
    void getNumeroElementos() {
        ListaSimple ls = new ListaSimple();
        ls.getNumeroElementos();
    }

    @Test
    void getPosicion() {
        ElementoLS elementoLS = new ElementoLS();
        ListaSimple ls = new ListaSimple();
        ls.getPosicion(elementoLS);
    }

    @Test
    void getPrimero() {
        ListaSimple ls = new ListaSimple();
        ls.getPrimero();
    }

    @Test
    void getUltimo() {
        ListaSimple ls = new ListaSimple();
        ls.getUltimo();
    }

    @Test
    void getElemento() {
        ListaSimple ls = new ListaSimple();
        ls.getElemento(2);
    }
}