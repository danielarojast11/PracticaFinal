package org.example.practicafinal.Clases.Entorno;

public class Comida extends Elementos{
    private int alteracion = 1;

    public Comida(int tiempoActividad) {
        super(tiempoActividad);
    }

    public Comida() {
    }

    public int getAlteracion() {
        return alteracion;
    }
}