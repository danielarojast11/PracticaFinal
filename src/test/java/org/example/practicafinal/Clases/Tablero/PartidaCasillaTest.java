package org.example.practicafinal.Clases.Tablero;

import org.example.practicafinal.Clases.Partida.Partida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartidaCasillaTest {

    @Test
    void testGetCasilla(){
        Partida partida = new Partida();
        Casilla casilla = new Casilla();
        PartidaCasilla partidaCasilla = new PartidaCasilla(casilla, partida);
        assertEquals(casilla, partidaCasilla.getCasilla());
    }

    @Test
    void testSetCasilla(){
        Casilla casilla = new Casilla();
        PartidaCasilla partidaCasilla = new PartidaCasilla();
        partidaCasilla.setCasilla(casilla);
        assertEquals(casilla, partidaCasilla.getCasilla());
    }

    @Test
    void testGetPartida(){
        Partida partida = new Partida();
        Casilla casilla = new Casilla();
        PartidaCasilla partidaCasilla = new PartidaCasilla(casilla, partida);
        assertEquals(partida, partidaCasilla.getPartida());
    }

    @Test
    void testSetPartida(){
        Partida partida = new Partida();
        PartidaCasilla partidaCasilla = new PartidaCasilla();
        partidaCasilla.setPartida(partida);
        assertEquals(partida, partidaCasilla.getPartida());
    }
}