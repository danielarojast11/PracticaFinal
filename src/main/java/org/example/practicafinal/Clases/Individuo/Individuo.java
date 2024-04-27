package org.example.practicafinal.Clases.Individuo;

public class Individuo {
    private int id;
    private int generacion;
    private int turnosVida;
    private int probReproduccion;
    private int probClonacion;
    private int probMuerte = 1-probReproduccion;

    public Individuo() {
    }

    public Individuo(int id, int generacion, int turnosVida, int probReproduccion, int probClonacion) {
        this.id = id;
        this.generacion = generacion;
        this.turnosVida = turnosVida;
        this.probReproduccion = probReproduccion;
        this.probClonacion = probClonacion;
    }

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

    public void setProbMuerte(int probMuerte) {
        this.probMuerte = probMuerte;
    }
}
