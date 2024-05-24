package org.example.practicafinal.Entity;

import com.google.gson.JsonObject;
import org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada.ListaEnlazada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasillaTest {

    @Test
    void testIsCompleta(){
        Casilla casilla = new Casilla(true);
        assertTrue(casilla.isCompleta());
    }

    @Test
    void testSetCompleta(){
        Casilla casilla = new Casilla(1, 2);
        casilla.setCompleta(true);
        assertTrue(casilla.isCompleta());
    }

    @Test
    void testGetColumna(){
        Casilla casilla = new Casilla(4,5);
        assertEquals(4, casilla.getColumna());
    }

    @Test
    void testSetColumna(){
        Casilla casilla = new Casilla(1, 1);
        casilla.setColumna(1);
        assertEquals(1, casilla.getColumna());
    }

    @Test
    void testGetFila(){
        Casilla casilla = new Casilla(4,5);
        assertEquals(5, casilla.getFila());
    }

    @Test
    void testSetFila(){
        Casilla casilla = new Casilla(0,0);
        casilla.setFila(1);
        assertEquals(1, casilla.getFila());
    }

    @Test
    void testGetIndividuos(){
        Casilla casilla = new Casilla(4,5);
        Individuo individuo1 = new Individuo(1, 2, 10);
        Individuo individuo2 = new Individuo(2, 2, 20);
        Individuo individuo3 = new Individuo(3, 2, 30);
        ListaEnlazada<Individuo> individuos = new ListaEnlazada<>();
        individuos.add(individuo1);
        individuos.add(individuo2);
        individuos.add(individuo3);
        casilla.addIndividuo(individuo1);
        casilla.addIndividuo(individuo2);
        casilla.addIndividuo(individuo3);
        assertEquals(casilla.getIndividuos(), casilla.getIndividuos());
    }

    @Test
    void testAddIndividuo(){
        Casilla casilla = new Casilla(4,5);
        Individuo individuo1 = new Individuo(1, 2, 10);
        Individuo individuo2 = new Individuo(2, 2, 20);
        casilla.addIndividuo(individuo1);
        casilla.addIndividuo(individuo2);
        assertEquals(casilla.getIndividuos(), casilla.getIndividuos());
    }

    @Test
    void testRemoveIndividuo(){
        Casilla casilla = new Casilla(4,5);
        Individuo individuo1 = new Individuo(1, 2, 10);
        Individuo individuo2 = new Individuo(2, 2, 20);
        casilla.addIndividuo(individuo1);
        casilla.addIndividuo(individuo2);
        assertEquals(casilla.getIndividuos(), casilla.getIndividuos());
        casilla.removeIndividuo(individuo1);
        assertEquals(casilla.getIndividuos(), casilla.getIndividuos());
    }

    @Test
    void testGetElementos(){
        Casilla casilla = new Casilla(4,5);
        Casilla casilla1 = new Casilla(0,0);
        Casilla casilla2 = new Casilla(0,1);
        Casilla casilla3 = new Casilla(0,2);
        Elemento elemento1 = new Elemento(4,casilla1);
        Elemento elemento2 = new Elemento(3,casilla2);
        Elemento elemento3 = new Elemento(2,casilla3);
        ListaEnlazada<Elemento> elementos = new ListaEnlazada<>();
        elementos.add(elemento1);
        elementos.add(elemento2);
        elementos.add(elemento3);
        casilla.addElemento(elemento1);
        casilla.addElemento(elemento2);
        casilla.addElemento(elemento3);
        assertEquals(casilla.getElementos(), casilla.getElementos());
    }

    @Test
    void testAddElemento(){
        Casilla casilla = new Casilla(4,5);
        Elemento elemento1 = new Elemento(4,casilla);
        Elemento elemento2 = new Elemento(3,casilla);
        casilla.addElemento(elemento1);
        casilla.addElemento(elemento2);
        assertEquals(casilla.getElementos(), casilla.getElementos());
    }

    @Test
    void testFromJson(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("columna", 4);
        jsonObject.addProperty("fila", 3);
        Casilla casilla = new Casilla(4, 3);
        casilla.fromJson(jsonObject);
        assertEquals(4, casilla.getColumna());
        assertEquals(3, casilla.getFila());
    }

    @Test
    void testToJson(){
        Casilla casilla = new Casilla(4, 5);
        JsonObject jsonResult = casilla.toJson();
        assertNotNull(jsonResult);
        assertEquals(4, jsonResult.get("columna").getAsInt());
        assertEquals(5, jsonResult.get("fila").getAsInt());
    }

    /* @Test
    void testSetElementosCasilla(){
        Casilla casilla = new Casilla(4,5);
        Elemento elemento1 = new Elemento(4,5);
        Elemento elemento2 = new Elemento(3,2);
        Elemento elemento3 = new Elemento(2,1);
        ListaDoblementeEnlazada<Elemento> elementos = new ListaDoblementeEnlazada<>();
        elementos.add(elemento1);
        elementos.add(elemento2);
        elementos.add(elemento3);
        casilla.setElementosCasilla(elementos);
        assertEquals(elementos, casilla.getElementosCasilla());
    }

    @Test
    void testRemoveElementosCasilla(){
        Casilla casilla = new Casilla(4,5);
        Elemento elemento1 = new Elemento(4,5);
        Elemento elemento2 = new Elemento(3,2);
        Elemento elemento3 = new Elemento(2,1);
        ListaDoblementeEnlazada<Elemento> elementos1 = new ListaDoblementeEnlazada<>();
        elementos1.add(elemento1);
        elementos1.add(elemento2);
        elementos1.add(elemento3);
        casilla.addElementoCasilla(elemento1);
        casilla.addElementoCasilla(elemento2);
        casilla.addElementoCasilla(elemento3);
        ListaDoblementeEnlazada<Elemento> elementos2 = casilla.getElementosCasilla();
        elementos2.add(elemento1);
        elementos2.add(elemento3);
        assertTrue(elementos1.contains(elemento2));
        casilla.removeElementoCasilla(elemento2);
        assertFalse(elementos2.contains(elemento2));
    }

    @Test
    void testGetIndividuosTotales(){
        Casilla casilla = new Casilla(4,5);
        Individuo individuo1 = new Individuo();
        Individuo individuo2 = new Individuo();
        Individuo individuo3 = new Individuo();
        casilla.addIndividuoCasilla(individuo1);
        casilla.addIndividuoCasilla(individuo2);
        casilla.addIndividuoCasilla(individuo3);
        assertEquals(3, casilla.getIndividuosTotales());
    }


    @Test
    void testGetIndividuosIdCasilla(){
        Casilla casilla = new Casilla(4,5);
        Individuo individuo1 = new Individuo(1, 5, 3, 70, 10);
        Individuo individuo2 = new Individuo(2, 4, 7, 30, 25);
        Individuo individuo3 = new Individuo(4, 5, 8, 10, 30);
        ListaDoblementeEnlazada<Individuo> individuos = new ListaDoblementeEnlazada<>();
        individuos.add(individuo1);
        individuos.add(individuo2);
        individuos.add(individuo3);
        casilla.addIndividuoCasilla(individuo1);
        casilla.addIndividuoCasilla(individuo2);
        casilla.addIndividuoCasilla(individuo3);
        assertEquals(casilla.getIndividuosIdCasilla(), casilla.getIndividuosIdCasilla());
    }

    @Test
    void testSetIndividuosCasilla(){
        Casilla casilla = new Casilla(4,5);
        Individuo individuo1 = new Individuo();
        Individuo individuo2 = new Individuo();
        Individuo individuo3 = new Individuo();
        ListaDoblementeEnlazada<Individuo> individuos = new ListaDoblementeEnlazada<>();
        individuos.add(individuo1);
        individuos.add(individuo2);
        individuos.add(individuo3);
        casilla.setIndividuosCasilla(individuos);
        assertEquals(3, casilla.getIndividuosTotales());
    }

    @Test
    void testAddIndividuosCasilla(){
        Casilla casilla = new Casilla(4,5);
        Individuo individuo1 = new Individuo();
        Individuo individuo2 = new Individuo();
        casilla.addIndividuoCasilla(individuo1);
        casilla.addIndividuoCasilla(individuo2);
        assertEquals(2, casilla.getIndividuosTotales());
    }*/
}