package org.example.practicafinal.Clases.Entorno;

public class Agua extends Elementos{
    private int alteracion = 2;
    public Agua(int tiempoActividad) {
        super(tiempoActividad);
    }

    public Agua() {
    }
    public int getAlteracion(){
        return alteracion;
    }
}
