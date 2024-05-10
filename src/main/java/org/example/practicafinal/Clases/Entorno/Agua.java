package org.example.practicafinal.Clases.Entorno;

public class Agua extends Elementos{

    private int type = 0;
    private int alteracion = 2;

    public Agua(int tiempoActividad) {
        super(tiempoActividad);
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
