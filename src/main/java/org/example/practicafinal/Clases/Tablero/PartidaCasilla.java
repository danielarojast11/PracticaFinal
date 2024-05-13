package org.example.practicafinal.Clases.Tablero;

import org.example.practicafinal.Clases.Partida.Partida;

public class PartidaCasilla {
    Casilla casilla;
    Partida partida;


    public PartidaCasilla(){ }

    public PartidaCasilla(Casilla casilla, Partida partida){
        this.casilla = casilla;
        this.partida = partida;
    }

    public Casilla getCasilla() {
        return casilla;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
}
