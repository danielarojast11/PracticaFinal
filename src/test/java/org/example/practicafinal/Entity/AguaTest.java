package org.example.practicafinal.Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AguaTest {

    @Test
    void getAlteracion(){
        Casilla casilla = new Casilla(2, 1);
        Agua agua = new Agua(1, casilla);
        assertEquals(2, agua.getAlteracion());
    }

    @Test
    void setAlteracion(){
        Casilla casilla = new Casilla(2, 1);
        Agua agua = new Agua(1, casilla);
        agua.setAlteracion(2);
        assertEquals(2, agua.getAlteracion());
    }
}