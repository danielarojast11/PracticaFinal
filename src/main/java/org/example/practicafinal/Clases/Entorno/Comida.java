package org.example.practicafinal.Clases.Entorno;

public class Comida extends Elementos{

    int type = 1;
    private int alteracion = 1;

    public Comida(int tiempoActividad, int type) {
        super(tiempoActividad, type);
    }

    public Comida() {
    }

    public int getAlteracion() {
        return alteracion;
    }

    public void setAlteracion(int alteracion) {
        this.alteracion = alteracion;
    }

    public int getType(){
        return this.type;
    }
}
