package org.example.practicafinal.Clases.Entorno;

public class Agua extends Elementos{

    private final int type = 0;
    private int alteracion = 2;

    public Agua(int tiempoActividad, int type) {
        super(tiempoActividad, type);
    }

    public Agua() {
    }

    public int getAlteracion(){
        return alteracion;
    }

    public void setAlteracion(int alteracion) {
        this.alteracion = alteracion;
    }

    public int getType(){
        return this.type;
    }

}
