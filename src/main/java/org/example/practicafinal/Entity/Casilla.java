package org.example.practicafinal.Entity;

import com.google.gson.JsonObject;
import javafx.scene.layout.Pane;
import org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada.ListaDoblementeEnlazada;
import org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada.ListaEnlazada;
import org.example.practicafinal.EstructurasDeDatos.Lista.Simple.ListaSimple;

public class Casilla extends Pane {
    private boolean completa = true;
    private int columna;
    private int fila;
    private ListaEnlazada<Individuo> individuos = new ListaEnlazada<>();
    private ListaEnlazada<Elemento> elementos = new ListaEnlazada<>();

    public Casilla(int columna, int fila){
        this.columna=columna;
        this.fila=fila;
        this.setId("casilla("+columna+","+fila+")");
    }

    public Casilla(boolean completa){
        this.completa = completa;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public ListaEnlazada<Individuo> getIndividuos() {
        return this.individuos;
    }

    public void addIndividuo(Individuo individuo) {
        this.individuos.add(individuo);
    }

    public void removeIndividuo(Individuo individuo) {
        this.individuos.remove(individuo);
    }

    public ListaEnlazada<Elemento> getElementos() {
        return this.elementos;
    }

    public void addElemento(Elemento elemento) {
        this.elementos.add(elemento);
    }

    private final ListaDoblementeEnlazada<Integer> individuosIdCasilla = new ListaDoblementeEnlazada<>();

    public void fromJson(JsonObject jsonObject) {
        this.columna = jsonObject.get("columna").getAsInt();
        this.fila = jsonObject.get("fila").getAsInt();
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("columna", this.columna);
        jsonObject.addProperty("fila", this.fila);
        return jsonObject;
    }


    /* SIN COMPLETAR */
    /*public ListaDoblementeEnlazada<Elemento> getElementosCasilla() {
        return elementosCasilla;
    }

    public void setElementosCasilla(ListaDoblementeEnlazada<Elemento> elementosCasilla) {
        this.elementosCasilla = elementosCasilla;
    }

    public void removeElementoCasilla(Elemento elemento) {
        this.elementosCasilla.remove(elemento);
    }

    public ListaDoblementeEnlazada<Integer> getIndividuosIdCasilla(){return this.individuosIdCasilla;}

    public int getIndividuosTotales(){
        return individuosCasilla.getNumeroElementos();
    }

    public void setIndividuosCasilla(ListaDoblementeEnlazada<Individuo> listaIndividuos) {
        this.individuosCasilla = listaIndividuos;
    }



    public void addIndividuoCasilla(){
        individuosIdCasilla.clear();
        for (Individuo individuo : individuosCasilla){
            individuosIdCasilla.add(individuo.getId());
        }
    }
*/


}
