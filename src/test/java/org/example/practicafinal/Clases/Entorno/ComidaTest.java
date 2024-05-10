package org.example.practicafinal.Clases.Entorno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComidaTest {

    @Test
    void getAlteracion(){
        Comida comida = new Comida();
        assertEquals(comida.getAlteracion(),1);
    }

    @Test
    void setAlteracion(){
        Comida comida = new Comida(4);
        comida.setAlteracion(1);
        assertEquals(comida.getAlteracion(),1);
    }

    @Test
    void getType(){
        Comida comida = new Comida();
        assertEquals(comida.getType(),1);
    }
}