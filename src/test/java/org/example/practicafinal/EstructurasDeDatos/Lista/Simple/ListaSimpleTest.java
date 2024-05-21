package org.example.practicafinal.EstructurasDeDatos.Lista.Simple;

import org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada.ElementoLE;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaSimpleTest {

    @Test
    void getMaximo(){
        ListaSimple<Integer> lista = new ListaSimple<>();
        assertEquals(3000, lista.getMaximo());
    }

    @Test
    void setMaximo(){
        ListaSimple<Integer> lista = new ListaSimple<>();
        lista.setMaximo(3000);
        assertEquals(3000, lista.getMaximo());
    }

    @Test
    void isVacia() {
        ListaSimple<ElementoLS> ls = new ListaSimple<>();
        ls.isVacia();
        assertTrue(ls.isVacia());
    }

    @Test
    void vaciar() {
        ListaSimple<ElementoLS> ls = new ListaSimple<>();
        ls.vaciar();
        assertTrue(ls.isVacia());
    }

    @Test
    void add() {
        ElementoLS<Object> elementoLS = new ElementoLS<>();
        ListaSimple<Object> ls = new ListaSimple<>();
        ls.add(elementoLS);
        assertEquals(ls.getPosicion(elementoLS), ls.getPosicion(elementoLS));
    }

    @Test
    void testAdd() {
        String s = new String();
        ListaSimple<String> ls = new ListaSimple<>();
        ls.add(s);
    }

    @Test
    void del() {
        ListaSimple<Integer> ls = new ListaSimple<>();
        ls.del(2);
    }

    @Test
    void getNumeroElementos() {
        ListaSimple<Integer> ls = new ListaSimple<>();
        ElementoLS<Integer> elementoLS = new ElementoLS<>();
        ls.add(elementoLS);
        assertEquals(3000, ls.getNumeroElementos());
    }

    @Test
    void getPosicion() {
        ElementoLS<Object> elementoLS = new ElementoLS<>();
        ListaSimple<Object> ls = new ListaSimple<>();
        ls.getPosicion(elementoLS);
    }

    @Test
    void getPrimero() {
        ElementoLS<Integer> elementoLS = new ElementoLS<>();
        ListaSimple<Integer> ls = new ListaSimple<>();
        ls.add(elementoLS);
        assertEquals(elementoLS, ls.getPrimero());
    }

    @Test
    void getUltimo() {
        ElementoLS<Integer> elementoLS1 = new ElementoLS<>();
        ElementoLS<Integer> elementoLS2 = new ElementoLS<>();
        ListaSimple<Integer> ls = new ListaSimple<>();
        ls.add(elementoLS1);
        ls.add(elementoLS2);
        assertEquals(elementoLS2, ls.getUltimo());
    }

    @Test
    void getElemento() {
        ElementoLS<Integer> elementoLS1 = new ElementoLS<>();
        ElementoLS<Integer> elementoLS2 = new ElementoLS<>();
        ElementoLS<Integer> elementoLS3 = new ElementoLS<>();
        ListaSimple ls = new ListaSimple();
        ls.add(elementoLS1);
        ls.add(elementoLS2);
        ls.add(elementoLS3);
        assertEquals(elementoLS2, ls.getElemento(1));
    }
}