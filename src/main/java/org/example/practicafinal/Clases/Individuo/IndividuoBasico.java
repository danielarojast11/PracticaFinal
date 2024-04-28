package org.example.practicafinal.Clases.Individuo;

public class IndividuoBasico extends Individuo {
    public IndividuoBasico (){

    }
    public IndividuoBasico(int id, int generacion, int turnosVida, int probReproduccion, int probClonacion) {
        super(id, generacion, turnosVida, probReproduccion, probClonacion);
    }
    public void mover(){

    }
    public IndividuoBasico reproducir(){
        IndividuoBasico hijo = new IndividuoBasico();
        return hijo;
    }
}
