package org.example.practicafinal.Clases.Entorno;

public class Pozo extends Elementos {

    int type = 5;

    public Pozo(int tiempoActividad, int type) {
        super(tiempoActividad, type);
    }

    public Pozo() {
    }

    public int getType(){
        return this.type;
    }

}
