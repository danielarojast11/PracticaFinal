package org.example.practicafinal.Clases.Entorno;

import org.example.practicafinal.Entity.Agua;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AguaTest {

    @Test
    void getAlteracion(){
        Agua agua = new Agua();
        assertEquals(2, agua.getAlteracion());
    }

    @Test
    void setAlteracion(){
        Agua agua = new Agua();
        agua.setAlteracion(2);
        assertEquals(2, agua.getAlteracion());
    }

    @Test
    void getType(){
        Agua agua = new Agua(5, 0);
        assertEquals(0, agua.getType());
    }
}