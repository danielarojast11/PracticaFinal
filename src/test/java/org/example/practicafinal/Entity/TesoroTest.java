package org.example.practicafinal.Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TesoroTest {

    @Test
    void testGetProbabilidad(){
        Casilla casilla = new Casilla(1, 2);
        Tesoro tesoro = new Tesoro(1, casilla);
        assertEquals(10, tesoro.getProbabilidad());
    }

    @Test
    void testSetProbabilidad(){
        Casilla casilla = new Casilla(1, 2);
        Tesoro tesoro = new Tesoro(1, casilla);
        tesoro.setProbabilidad(2);
        assertEquals(2, tesoro.getProbabilidad());
    }
}