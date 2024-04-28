package org.example.practicafinal.Clases.Entorno;

public class Tesoro extends Elementos{
    private int alteracion;
    public Tesoro(int tiempoActividad) {
        super(tiempoActividad);
    }

    public Tesoro() {
    }
    public int getAlteracion(){
        return alteracion;
    }
    public void setAlteracion(int valor){
        this.alteracion=valor;
    }
}
