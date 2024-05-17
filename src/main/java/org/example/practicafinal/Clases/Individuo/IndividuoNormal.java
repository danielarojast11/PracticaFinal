package org.example.practicafinal.Clases.Individuo;

public class IndividuoNormal extends Individuo {

    private final int rango = 2;

    public IndividuoNormal(){
    }

    public IndividuoNormal(int id,
                           int turnosVida,
                           int probReproduccion,
                           int probClonacion) {
        super(id, turnosVida, probReproduccion, probClonacion);
    }

    public IndividuoNormal(int id,
                           int generacion,
                           int turnosVida,
                           int probReproduccion,
                           int probClonacion) {
        super(id, generacion, turnosVida, probReproduccion, probClonacion);
    }

    public int getRango(){
        return rango;
    }

    public IndividuoNormal reproducir(){
        IndividuoNormal hijo = new IndividuoNormal();
        return hijo;
    }
}
