package org.example.practicafinal.Clases.Entorno;

public class Montaña extends Elementos{
    private int alteracion = -2;

    public Montaña(int tiempoActividad) {
        super(tiempoActividad);
    }

    public Montaña() {
    }
    public int getAlteracion(){
        return this.alteracion;
    }
}
