package org.example.practicafinal.Clases.Entorno;

public class Montaña extends Elementos{

    int type = 3;
    private int alteracion = -2;

    public Montaña(int tiempoActividad) {
        super(tiempoActividad);
    }

    public Montaña() {
    }

    public int getAlteracion(){
        return this.alteracion;
    }

    public void setAlteracion(int alteracion){
        this.alteracion = alteracion;
    }

    public int getType(){
        return this.type;
    }

}
