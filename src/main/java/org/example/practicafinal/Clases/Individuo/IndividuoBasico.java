package org.example.practicafinal.Clases.Individuo;

public class IndividuoBasico extends Individuo {

    private int rango = 1;

    public IndividuoBasico (){

    }

    public IndividuoBasico(int id, int generacion, int turnosVida, int probReproduccion, int probClonacion) {
        super(id, generacion, turnosVida, probReproduccion, probClonacion);
    }

    public void mover(){

    }

    public int getRango(){
        return rango;
    }

    public IndividuoBasico reproducir(){
        IndividuoBasico hijo = new IndividuoBasico();
        return hijo;
    }
}
