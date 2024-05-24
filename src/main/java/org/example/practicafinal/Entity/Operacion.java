package org.example.practicafinal.Entity;

public class Operacion {
    private int turno;
    private String descripcion;
    /**
     * 0 - Nacimiento
     * 1 - Cambio casilla
     * 2 - Muerte
     * 3 - Agua
     * 4 - Comida
     * 5 - Montaña
     * 6 - Tesoro
     * 7 - Biblioteca
     * 8 - Pozo
     * 9 - Mutación
     * 10 - Reproducción
     */
    private int tipo;

    public Operacion(String descripcion, int turno, int tipo){
        this.descripcion = descripcion;
        this.turno = turno;
        this.tipo = tipo;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public int getTurno(){
        return turno;
    }

    public int getTipo(){
        return tipo;
    }
}
