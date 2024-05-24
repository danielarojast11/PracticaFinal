package org.example.practicafinal.Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComidaTest {

    @Test
    void getAlteracion(){
        Casilla casilla = new Casilla(2, 1);
        Comida comida = new Comida(1, casilla);
        assertEquals(10, comida.getAlteracion());
    }

    @Test
    void setAlteracion(){
        Casilla casilla = new Casilla(2, 1);
        Comida comida = new Comida(1, casilla);
        comida.setAlteracion(10);
        assertEquals(10, comida.getAlteracion());
    }
}