package org.example.practicafinal.Clases.Individuo;

public class IndividuoAvanzado extends Individuo {
    public IndividuoAvanzado(int id, int generacion, int turnosVida, int probReproduccion, int probClonacion) {
        super(id, generacion, turnosVida, probReproduccion, probClonacion);
    }

    public IndividuoAvanzado() {

    }

    public void mover(){

    }
    public IndividuoAvanzado reproducir(){
        IndividuoAvanzado hijo = new IndividuoAvanzado();
        return hijo;
    }
}
