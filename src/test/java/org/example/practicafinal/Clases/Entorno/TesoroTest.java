package org.example.practicafinal.Clases.Entorno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TesoroTest {

    @Test
    void getAlteracion(){
        Tesoro t = new Tesoro();
        assertEquals(t.getAlteracion(),0);
    }

    @Test
    void setAlteracion(){
        Tesoro t = new Tesoro(4, 4);
        t.setAlteracion(2);
        assertEquals(t.getAlteracion(),2);
    }

    @Test
    void getType(){
        Tesoro t = new Tesoro();
        assertEquals(t.getType(),4);
    }
}