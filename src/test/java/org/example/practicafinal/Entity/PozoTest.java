package org.example.practicafinal.Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PozoTest {

    @Test
    void testPozo(){
        Casilla casilla = new Casilla(0,0);
        Pozo pozo = new Pozo(1, casilla);
    }
}