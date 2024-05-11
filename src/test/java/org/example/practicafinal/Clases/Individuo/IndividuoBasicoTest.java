package org.example.practicafinal.Clases.Individuo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoBasicoTest {

    @Test
    void testMover(){

    }

    @Test
    void testGetRango(){
        IndividuoBasico basico = new IndividuoBasico(1, 2, 5, 40, 60);
        assertEquals(1, basico.getRango());
    }

    @Test
    void testReproducir(){
        IndividuoBasico basico = new IndividuoBasico();
        IndividuoBasico hijo = new IndividuoBasico();
        List<IndividuoBasico> hijos = new ArrayList<>();
        hijos.add(hijo);
        basico.reproducir();
        basico.addHijo(hijo);
        assertEquals(hijos, basico.getHijos());
    }
}