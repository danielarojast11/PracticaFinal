package org.example.practicafinal.Entity;

public class Operacion {
    private int turno;
    private String tipo;
    public Operacion(String tipo, int turno){
        this.tipo = tipo;
        this.turno = turno;
    }

    public int getTurno(){
        return turno;
    }
    public String getTipo(){
        return tipo;
    }
}
