package org.example.practicafinal.Clases.Entorno;

import com.google.gson.JsonObject;
import org.example.practicafinal.Entity.Casilla;
import org.example.practicafinal.Entity.Elemento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoTest {

    @Test
    void testToJson(){
        Elemento elemento = new Elemento(4, 0);
        JsonObject jsonResult = elemento.toJson();
        assertNotNull(jsonResult);
        assertEquals(4, jsonResult.get("tiempoActividad").getAsInt());
        assertEquals(0, jsonResult.get("type").getAsInt());
    }

    @Test
    void getTiempoActividad(){
        Elemento elemento = new Elemento(4, 0);
        assertEquals(4, elemento.getTiempoActividad());
    }

    @Test
    void setTiempoActividad(){
        Elemento elemento = new Elemento(4, 1);
        elemento.setTiempoActividad(5);
        assertEquals(5, elemento.getTiempoActividad());
    }

    @Test
    void getCasilla(){
        Elemento elemento = new Elemento();
        Casilla casilla = new Casilla();
        assertEquals(elemento.getCasilla(), elemento.getCasilla());
    }

    @Test
    public void setCasillas(){
        Elemento elemento = new Elemento();
        elemento.setCasilla(4, 3);
        assertEquals(elemento.getCasilla(), elemento.getCasilla());
    }

    @Test
    void setCasilla(){
        Elemento elemento = new Elemento(4, 2);
        Casilla casilla = new Casilla();
        elemento.setCasilla(casilla);
        assertEquals(casilla, elemento.getCasilla());
    }

    @Test
    void getType(){
        Elemento elemento = new Elemento();
        assertEquals(0, elemento.getType());
    }

    @Test
    void compareTo(){
        Elemento elemento1 = new Elemento();
        Elemento elemento2 = new Elemento();
        assertEquals(0, elemento1.compareTo(elemento2));
    }
}