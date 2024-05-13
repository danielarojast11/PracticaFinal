package org.example.practicafinal.Clases.Entorno;

import org.example.practicafinal.Clases.Tablero.Casilla;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementosTest {

    @Test
    void getTiempoActividad(){
        Elementos elementos = new Elementos(4, 0);
        assertEquals(4, elementos.getTiempoActividad());
    }

    @Test
    void setTiempoActividad(){
        Elementos elementos = new Elementos(4, 1);
        elementos.setTiempoActividad(5);
        assertEquals(5, elementos.getTiempoActividad());
    }

    @Test
    void getCasilla(){
        Elementos elementos = new Elementos();
        Casilla casilla = new Casilla();
        assertEquals(elementos.getCasilla(), elementos.getCasilla());
    }

    @Test
    public void setCasillas(){
        Elementos elementos = new Elementos();
        elementos.setCasilla(4, 3);
        assertEquals(elementos.getCasilla(), elementos.getCasilla());
    }

    @Test
    void setCasilla(){
        Elementos elementos = new Elementos(4, 2);
        Casilla casilla = new Casilla();
        elementos.setCasilla(casilla);
        assertEquals(casilla, elementos.getCasilla());
    }

    @Test
    void getType(){
        Elementos elementos = new Elementos();
        assertEquals(0, elementos.getType());
    }

    @Test
    void compareTo(){
        Elementos elemento1 = new Elementos();
        Elementos elemento2 = new Elementos();
        assertEquals(0, elemento1.compareTo(elemento2));
    }
}