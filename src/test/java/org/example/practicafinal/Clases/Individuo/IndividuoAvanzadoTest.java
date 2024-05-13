package org.example.practicafinal.Clases.Individuo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoAvanzadoTest {

    @Test
    void testMover(){

    }

    @Test
    void testGetRango(){
        IndividuoAvanzado avanzado = new IndividuoAvanzado(1, 2, 5, 40, 60);
        assertEquals(3, avanzado.getRango());
    }

    @Test
    void testReproducir(){
        IndividuoAvanzado avanzado = new IndividuoAvanzado();
        IndividuoAvanzado hijo = new IndividuoAvanzado();
        List<IndividuoAvanzado> hijos = new ArrayList<>();
        hijos.add(hijo);
        avanzado.reproducir();
        avanzado.addHijo(hijo);
        assertEquals(hijos, avanzado.getHijos());
    }
}