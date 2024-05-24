package org.example.practicafinal.Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperacionTest {

    @Test
    void testGetDescripcion(){
        Operacion operacion = new Operacion("Bebe agua", 2, 3);
        assertEquals("Bebe agua", operacion.getDescripcion());
    }

    @Test
    void testGetTurno(){
        Operacion operacion = new Operacion("Bebe agua", 2, 3);
        assertEquals(2, operacion.getTurno());
    }

    @Test
    void testGetTipo(){
        Operacion operacion = new Operacion("Bebe agua", 2, 3);
        assertEquals(3, operacion.getTipo());
    }
}