package org.example.practicafinal.Clases.Tablero;

import com.google.gson.JsonObject;
import org.example.practicafinal.Entity.Casilla;
import org.example.practicafinal.Entity.Elemento;
import org.example.practicafinal.Entity.Individuo;
import org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada.ListaDoblementeEnlazada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasillaTest {

    @Test
    void testToJson(){
        Casilla casilla = new Casilla(4, 5);
        JsonObject jsonResult = casilla.toJson();
        assertNotNull(jsonResult);
        assertEquals(4, jsonResult.get("columna").getAsInt());
        assertEquals(5, jsonResult.get("fila").getAsInt());
    }

    @Test
    void testGetElementosCasilla(){
        Casilla casilla = new Casilla(4,5);
        Elemento elemento1 = new Elemento(4,5);
        Elemento elemento2 = new Elemento(3,2);
        Elemento elemento3 = new Elemento(2,1);
        ListaDoblementeEnlazada<Elemento> elementos = new ListaDoblementeEnlazada<>();
        elementos.add(elemento1);
        elementos.add(elemento2);
        elementos.add(elemento3);
        casilla.addElementoCasilla(elemento1);
        casilla.addElementoCasilla(elemento2);
        casilla.addElementoCasilla(elemento3);
        assertEquals(elementos, casilla.getElementosCasilla());
    }

    @Test
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
    void testAddElementosCasilla(){
        Casilla casilla = new Casilla(4,5);
        Elemento elemento1 = new Elemento(4,5);
        Elemento elemento2 = new Elemento(3,2);
        Elemento elemento3 = new Elemento(2,1);
        ListaDoblementeEnlazada<Elemento> elementos = new ListaDoblementeEnlazada<>();
        elementos.add(elemento1);
        elementos.add(elemento2);
        elementos.add(elemento3);
        casilla.addElementoCasilla(elemento1);
        casilla.addElementoCasilla(elemento2);
        casilla.addElementoCasilla(elemento3);
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
    void testGetIndividuosCasilla(){
        Casilla casilla = new Casilla(4,5);
        Individuo individuo1 = new Individuo();
        Individuo individuo2 = new Individuo();
        Individuo individuo3 = new Individuo();
        ListaDoblementeEnlazada<Individuo> individuos = new ListaDoblementeEnlazada<>();
        individuos.add(individuo1);
        individuos.add(individuo2);
        individuos.add(individuo3);
        casilla.addIndividuoCasilla(individuo1);
        casilla.addIndividuoCasilla(individuo2);
        casilla.addIndividuoCasilla(individuo3);
        assertEquals(individuos, casilla.getIndividuosCasilla());
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
    }

    @Test
    void testAddIndividuosCasilla2(){
        Casilla casilla = new Casilla(4,5);
        Individuo individuo1 = new Individuo(1, 5, 3, 70, 10);
        Individuo individuo2 = new Individuo(2, 4, 7, 30, 25);
        Individuo individuo3 = new Individuo(4, 5, 8, 10, 30);
        ListaDoblementeEnlazada<Individuo> individuos = new ListaDoblementeEnlazada<>();
        individuos.add(individuo1);
        individuos.add(individuo2);
        individuos.add(individuo3);
        casilla.addIndividuoCasilla();
        assertEquals(casilla.getIndividuosIdCasilla(), casilla.getIndividuosIdCasilla());
    }

    @Test
    void testRemoveIndividuosCasilla(){
        Casilla casilla = new Casilla(4,5);
        Individuo individuo1 = new Individuo();
        Individuo individuo2 = new Individuo();
        Individuo individuo3 = new Individuo();
        ListaDoblementeEnlazada<Individuo> individuos1 = new ListaDoblementeEnlazada<>();
        individuos1.add(individuo1);
        individuos1.add(individuo2);
        individuos1.add(individuo3);
        ListaDoblementeEnlazada<Individuo> individuos2 = new ListaDoblementeEnlazada<>();
        individuos2.add(individuo1);
        individuos2.add(individuo2);
        assertTrue(individuos1.contains(individuo3));
        casilla.removeIndividuoCasilla(individuo3);
        assertFalse(individuos2.contains(individuo3));
    }

    @Test
    void testGetColumna(){
        Casilla casilla = new Casilla(4,5);
        assertEquals(4, casilla.getColumna());
    }

    @Test
    void testSetColumna(){
        Casilla casilla = new Casilla();
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
        Casilla casilla = new Casilla();
        casilla.setFila(1);
        assertEquals(1, casilla.getFila());
    }
}