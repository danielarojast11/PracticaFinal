package org.example.practicafinal.Clases.Individuo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoNormalTest {

    @Test
    void testMover(){

    }

    @Test
    void testGetRango(){
        IndividuoNormal normal = new IndividuoNormal(1, 2, 5, 40, 60);
        assertEquals(2, normal.getRango());
    }

    @Test
    void testReproducir(){
        IndividuoNormal normal = new IndividuoNormal();
        IndividuoNormal hijo = new IndividuoNormal();
        List<IndividuoNormal> hijos = new ArrayList<>();
        hijos.add(hijo);
        normal.reproducir();
        normal.addHijo(hijo);
        assertEquals(hijos, normal.getHijos());
    }
}