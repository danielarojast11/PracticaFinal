package org.example.practicafinal.Clases.Entorno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    @Test
    void getAlteracion(){
        Biblioteca b = new Biblioteca(4, 2);
        assertEquals(0, b.getAlteracion());
    }

    @Test
    void setAlteracion(){
        Biblioteca b = new Biblioteca(4, 2);
        b.setAlteracion(2);
        assertEquals(2, b.getAlteracion());
    }

    @Test
    void getType(){
        Biblioteca b = new Biblioteca();
        assertEquals(2, b.getType());
    }
}