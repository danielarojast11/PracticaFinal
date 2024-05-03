package org.example.practicafinal.Clases.Individuo;

public class IndividuoAvanzado extends Individuo {

    private int rango = 3;

    public IndividuoAvanzado(int id, int generacion, int turnosVida, int probReproduccion, int probClonacion) {
        super(id, generacion, turnosVida, probReproduccion, probClonacion);
    }

    public IndividuoAvanzado() {

    }

    public int getRango(){
        return rango;
    }

    public void mover(){

    }
    public IndividuoAvanzado reproducir(){
        IndividuoAvanzado hijo = new IndividuoAvanzado();
        return hijo;
    }
}
