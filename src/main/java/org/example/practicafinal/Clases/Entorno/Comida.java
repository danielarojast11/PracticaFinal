package org.example.practicafinal.Clases.Entorno;

public class Comida extends Elementos{

    int type = 1;
    private int alteracion = 1;

    public Comida(int tiempoActividad) {
        super(tiempoActividad);
    }

    public Comida() {
    }

    public int getAlteracion() {
        return alteracion;
    }

    public void setAlteracion(int alteracion) {
        this.alteracion = alteracion;
    }

}
