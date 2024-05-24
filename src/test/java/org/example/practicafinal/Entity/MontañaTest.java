package org.example.practicafinal.Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MontañaTest {

    @Test
    void getAlteracion(){
        Casilla casilla = new Casilla(1, 2);
        Montaña montaña = new Montaña(4, casilla);
        assertEquals(-2, montaña.getAlteracion());
    }

    @Test
    void setAlteracion(){
        Casilla casilla = new Casilla(1, 2);
        Montaña montaña = new Montaña(4, casilla);
        montaña.setAlteracion(-2);
        assertEquals(-2, montaña.getAlteracion());
    }
}