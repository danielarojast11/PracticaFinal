package org.example.practicafinal.Entity;

import com.google.gson.JsonObject;
import org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada.ListaDoblementeEnlazada;
import org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada.ListaEnlazada;
import org.example.practicafinal.EstructurasDeDatos.Lista.Simple.ListaSimple;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Individuo implements Comparable<Individuo>{
    protected int id;
    protected int generacion;
    private int turnosVida;
    private int probReproduccion;
    private int probClonacion;
    private int probMuerte;
    protected int rango;
    protected int longevidad;
    private Casilla casilla;
    private ListaEnlazada<Operacion> operaciones = new ListaEnlazada<>();
    private ListaEnlazada<Individuo> padres = new ListaEnlazada<>();
    private ListaEnlazada<Individuo> hijos = new ListaEnlazada<>();

    public Individuo(
            int id,
            int generacion,
            int turnosVida,
            int probReproduccion,
            int probClonacion,
            int rango,
            Casilla casilla
    ) {
        this.id = id;
        this.generacion = generacion;
        this.turnosVida = turnosVida;
        this.probReproduccion = probReproduccion;
        this.probClonacion = probClonacion;
        this.probMuerte = 100 - probReproduccion;
        this.rango = rango;
        this.casilla = casilla;
        this.operaciones.add(new Operacion("Nacimiento", generacion, 0));
        this.longevidad = 1;
    }

    public void restarTurnoVida(){
        if (this.getTurnosVida() > 0){
            this.setTurnosVida(turnosVida - 1);
        }
    }

    public int getLongevidad() {
        return longevidad;
    }

    public void sumarLongevidad() {
        this.longevidad++;
    }

    public int getProbReproduccion() {
        return probReproduccion;
    }

    public void setProbReproduccion(int probReproduccion) {
        this.probReproduccion = probReproduccion;
        this.probMuerte = 100 - probReproduccion;
    }

    public int getProbMuerte() {
        return this.probMuerte;
    }

    public void setProbMuerte(int probMuerte) {
        this.probMuerte = probMuerte;
    }

    public ListaEnlazada<Individuo> getPadres() {
        return padres;
    }

    public void addPadre(Individuo padre){
        this.padres.add(padre);
    }

    public ListaEnlazada<Individuo> getHijos() {
        return hijos;
    }

    public void addHijo(Individuo hijo){
        this.hijos.add(hijo);
    }






    private final ListaDoblementeEnlazada<Individuo> individuos = new ListaDoblementeEnlazada<>();

    public Individuo (int id, int probclonacion, int probreproduc){
        this.id=id;
        this.probClonacion=probclonacion;
        this.probReproduccion=probreproduc;
    }


    public void fromJson(JsonObject jsonObject) {
        this.id = jsonObject.get("id").getAsInt();
        this.generacion = jsonObject.get("generacion").getAsInt();
        this.turnosVida = jsonObject.get("turnosVida").getAsInt();
        this.probReproduccion = jsonObject.get("probReproduccion").getAsInt();
        this.probClonacion = jsonObject.get("probClonacion").getAsInt();
        this.probMuerte = jsonObject.get("probMuerte").getAsInt();
        this.rango = jsonObject.get("rango").getAsInt();
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", this.id);
        jsonObject.addProperty("generacion", this.generacion);
        jsonObject.addProperty("turnosVida", this.turnosVida);
        jsonObject.addProperty("probReproduccion", this.probReproduccion);
        jsonObject.addProperty("probClonacion", this.probClonacion);
        jsonObject.addProperty("probMuerte", this.probMuerte);
        jsonObject.addProperty("rango", this.rango);
        return jsonObject;
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

    public int getProbClonacion() {
        return probClonacion;
    }

    public void setProbClonacion(int probClonacion) {
        this.probClonacion = probClonacion;
    }


    public int getRango(){
        return rango;
    }

    public void setRango(int rango){
        this.rango = rango;
    }

    public ListaDoblementeEnlazada<Individuo> getIndividuos() {
        return individuos;
    }

    public void addIndividuo(Individuo individuo){
        this.individuos.add(individuo);
    }

        //METHODS MODIFY EACH TURN
    public void modificarReprod(){
        if (this.getProbReproduccion() > 0){
            this.setProbReproduccion(probReproduccion - (10 * probReproduccion /100));
        }
    }

    public void modificarClonacion(){
        if(this.getProbClonacion() > 0){
            this.setProbClonacion(probClonacion - ((10 * probClonacion) /100));
        }
    }



        //METHODS PLACEHOLDERS
    public void setCasilla (Casilla casilla){this.casilla = casilla;}

    public Casilla getCasilla(){
        return casilla;
    }

    public void addOperation(String descripcion, int turno, int tipo){
        operaciones.add(new Operacion(descripcion, turno, tipo));
    }

    public ListaEnlazada<Operacion> getOperaciones(){
        return operaciones;
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
