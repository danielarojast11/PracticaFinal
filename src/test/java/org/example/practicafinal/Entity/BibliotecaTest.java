package org.example.practicafinal.Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    @Test
    void testGetProbabilidad(){
        Casilla casilla = new Casilla(1, 2);
        Biblioteca biblioteca = new Biblioteca(1, casilla);
        assertEquals(10, biblioteca.getProbabilidad());
    }

    @Test
    void testSetProbabilidad(){
        Casilla casilla = new Casilla(1, 2);
        Biblioteca biblioteca = new Biblioteca(1, casilla);
        biblioteca.setProbabilidad(3);
        assertEquals(3, biblioteca.getProbabilidad());
    }
}