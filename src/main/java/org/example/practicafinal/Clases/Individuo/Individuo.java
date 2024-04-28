package org.example.practicafinal.Clases.Individuo;

public class Individuo {

        //PARAMETERS
    protected int id;
    protected int generacion;
    private int turnosVida;
    private int probReproduccion;
    private int probClonacion;
    private int probMuerte;


        //CONSTRUCTORS
    public Individuo() {
    }

    public Individuo(int id, int generacion, int turnosVida, int probReproduccion, int probClonacion) {
        this.id = id;
        this.generacion = generacion;
        this.turnosVida = turnosVida;
        this.probReproduccion = probReproduccion;
        this.probClonacion = probClonacion;
        this.setProbMuerte();
    }


        //GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    public int getTurnosVida() {
        return turnosVida;
    }

    public void setTurnosVida(int turnosVida) {
        this.turnosVida = turnosVida;
    }

    public int getProbReproduccion() {
        return probReproduccion;
    }

    public void setProbReproduccion(int probReproduccion) {
        this.probReproduccion = probReproduccion;
        this.setProbMuerte();
    }

    public int getProbClonacion() {
        return probClonacion;
    }

    public void setProbClonacion(int probClonacion) {
        this.probClonacion = probClonacion;
    }

    public int getProbMuerte() {
        return probMuerte;
    }

    protected void setProbMuerte() {
        this.probMuerte = 100-probReproduccion;
    }


        //METHODS
    public void modificarReprod(){
        this.setProbReproduccion(probReproduccion-(10*probReproduccion/100));
    }

    public void modificarClonacion(){
        this.setProbClonacion(probClonacion-(10*probClonacion/100));
    }

}
