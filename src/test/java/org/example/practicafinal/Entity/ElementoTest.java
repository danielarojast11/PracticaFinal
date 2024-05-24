package org.example.practicafinal.Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoTest {

    @Test
    void getTiempoActividad(){
        Casilla casilla = new Casilla(2, 1);
        Elemento elemento = new Elemento(4, casilla);
        assertEquals(4, elemento.getTiempoActividad());
    }

    @Test
    void setTiempoActividad(){
        Casilla casilla = new Casilla(2, 1);
        Elemento elemento = new Elemento(4, casilla);
        elemento.setTiempoActividad(5);
        assertEquals(5, elemento.getTiempoActividad());
    }

    @Test
    void testReducirTiempoActividad(){
        Casilla casilla = new Casilla(2, 1);
        Elemento elemento = new Elemento(4, casilla);
        elemento.reducirTiempoActividad();
        assertEquals(3, elemento.getTiempoActividad());
    }

    @Test
    void getCasilla(){
        Casilla casilla = new Casilla(0, 0);
        Elemento elemento = new Elemento(1, casilla);
        assertEquals(casilla, elemento.getCasilla());
    }

    @Test
    public void setCasillas(){
        Casilla casilla = new Casilla(0, 0);
        Elemento elemento = new Elemento(1, casilla);
        elemento.setCasilla(casilla);
        assertEquals(casilla, elemento.getCasilla());
    }

    @Test
    void testGetAlteracion(){
        Casilla casilla = new Casilla(0, 0);
        Elemento elemento = new Elemento(1, casilla);
        assertEquals(0, elemento.getAlteracion());
    }

    @Test
    void testSetAlteracion(){
        Casilla casilla = new Casilla(0, 0);
        Elemento elemento = new Elemento(1, casilla);
        elemento.setAlteracion(2);
        assertEquals(2, elemento.getAlteracion());
    }

    @Test
    void testGetProbabilidad(){
        Casilla casilla = new Casilla(0, 0);
        Elemento elemento = new Elemento(1, casilla);
        assertEquals(0, elemento.getProbabilidad());
    }

    @Test
    void testSetProbabilidad(){
        Casilla casilla = new Casilla(0, 0);
        Elemento elemento = new Elemento(1, casilla);
        elemento.setProbabilidad(2);
        assertEquals(2, elemento.getProbabilidad());
    }

    @Test
    void compareTo(){
        Casilla casilla1 = new Casilla(1,2);
        Casilla casilla2 = new Casilla(2,3);
        Elemento elemento1 = new Elemento(2, casilla1);
        Elemento elemento2 = new Elemento(3, casilla2);
        assertEquals(0, elemento1.compareTo(elemento2));
    }
}