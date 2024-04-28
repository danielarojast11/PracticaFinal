package org.example.practicafinal.Clases.Individuo;

public class IndividuoNormal extends Individuo {
    public IndividuoNormal(){

    }
    public IndividuoNormal(int id, int generacion, int turnosVida, int probReproduccion, int probClonacion) {
        super(id, generacion, turnosVida, probReproduccion, probClonacion);
    }

    public IndividuoNormal reproducir(){
        IndividuoNormal hijo = new IndividuoNormal();
        return hijo;
    }
}
