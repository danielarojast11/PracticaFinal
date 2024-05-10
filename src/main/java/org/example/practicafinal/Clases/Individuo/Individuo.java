package org.example.practicafinal.Clases.Individuo;

import org.example.practicafinal.Clases.Tablero.Casilla;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Individuo implements Comparable<Individuo>{

        //PARAMETERS
    protected int id;
    protected int generacion;
    private int turnosVida;
    private int probReproduccion;
    private int probClonacion;
    private int probMuerte;
    protected int rango;
    private List<Individuo> padres = new ArrayList<>();
    private List<Individuo> hijos = new ArrayList<>();
    private List<Individuo> individuos = new ArrayList<>();

    private Casilla casilla = new Casilla();


        //CONSTRUCTORS
    public Individuo() {
    }

    public Individuo(int id,
                     int generacion,
                     int turnosVida,
                     int probReproduccion,
                     int probClonacion) {
        this.id = id;
        this.generacion = generacion;
        this.turnosVida = turnosVida;
        this.probReproduccion = probReproduccion;
        this.probClonacion = probClonacion;
        this.probMuerte = 100 - probReproduccion;
    }

    public Individuo(int id,
                     int generacion,
                     int turnosVida,
                     int probReproduccion,
                     int probClonacion,
                     int rango) {
        this.id = id;
        this.generacion = generacion;
        this.turnosVida = turnosVida;
        this.probReproduccion = probReproduccion;
        this.probClonacion = probClonacion;
        this.rango = rango;
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
    }

    public int getProbClonacion() {
        return probClonacion;
    }

    public void setProbClonacion(int probClonacion) {
        this.probClonacion = probClonacion;
    }

    protected void setProbMuerte(int probReproduccion) {
        this.probMuerte = 100 - probReproduccion;
    }

    public void setProbabilidadMuerte(int probMuerte) {
        this.probMuerte = probMuerte;
    }

    public int getRango(){
        return rango;
    }

    public void setRango(int rango){
        this.rango = rango;
    }

        //FAMILY TREE
    public List<Individuo> getPadres() {
        return padres;
    }

    public void addPadre(Individuo padre){
        this.padres.add(padre);
    }

    public List<Individuo> getHijos() {
        return hijos;
    }

    public void addHijo(Individuo hijo){
        this.hijos.add(hijo);
    }

    public List<Individuo> getIndividuos() {
        return individuos;
    }

    public void addIndividuo(Individuo individuo){
        this.individuos.add(individuo);
    }

        //METHODS MODIFY EACH TURN
    public void modificarReprod(){
        this.setProbReproduccion(probReproduccion - (10* probReproduccion /100));
    }

    public void modificarClonacion(){
        this.setProbClonacion(probClonacion - (10* probClonacion /100));
    }

    public void modificarTurnosVida(){
        this.setTurnosVida(turnosVida-1);
    }

        //METHODS PLACEHOLDERS
    public void setCasilla (Casilla casilla){this.casilla = casilla;}

    public Casilla getCasilla(){
        return casilla;
    }


    @Override
    public int compareTo(@NotNull Individuo o) {
        if (this.getProbReproduccion()!=o.getProbReproduccion()){
            if (this.getProbReproduccion() < o.getProbReproduccion()){
                return -1;
            } else if (this.getProbReproduccion()>o.getProbReproduccion()){
                return 1;
            }
        }
        if (this.getRango() > o.getRango()) {
            return 1;
        } else if (this.getRango() < o.getRango()) {
            return -1;
        }
        return 0;
    }
}
