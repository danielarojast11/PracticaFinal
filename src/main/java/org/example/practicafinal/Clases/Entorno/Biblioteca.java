package org.example.practicafinal.Clases.Entorno;

public class Biblioteca extends Elementos{

    int type = 2;
    private int alteracion;

    public Biblioteca(int tiempoActividad, int type) {
        super(tiempoActividad, type);
    }

    public Biblioteca() {
    }

    public int getAlteracion(){
        return alteracion;
    }

    public void setAlteracion(int valor){
        this.alteracion=valor;
    }

    public int getType(){
        return this.type;
    }

}
