package org.example.practicafinal.Entity;

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
