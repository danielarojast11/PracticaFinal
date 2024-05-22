package org.example.practicafinal.Clases.Tablero;

import com.google.gson.JsonObject;
import javafx.scene.layout.Pane;
import org.example.practicafinal.Clases.Entorno.Elementos;
import org.example.practicafinal.Entity.Individuo;
import org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada.ListaDoblementeEnlazada;
import org.example.practicafinal.EstructurasDeDatos.Lista.Simple.ListaSimple;

public class Casilla extends Pane {
    private int columna;
    private int fila;
    private ListaSimple<Individuo> individuos = new ListaSimple<>();

    public Casilla(int columna, int fila){
        this.columna=columna;
        this.fila=fila;
        this.setId("casilla("+columna+","+fila+")");
    }

    public void addIndividuo(Individuo individuo) {
        this.individuos.add(individuo);
        addIndividuoCasilla();
    }




    private final ListaDoblementeEnlazada<Integer> individuosIdCasilla = new ListaDoblementeEnlazada<>();
    private ListaDoblementeEnlazada<Elementos> elementosCasilla = new ListaDoblementeEnlazada<>();

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


        //Elementos en la Casilla
    public ListaDoblementeEnlazada<Elementos> getElementosCasilla() {
        return elementosCasilla;
    }

    public void setElementosCasilla(ListaDoblementeEnlazada<Elementos> elementosCasilla) {
        this.elementosCasilla = elementosCasilla;
    }

    public void addElementoCasilla(Elementos elemento) {
        this.elementosCasilla.add(elemento);
    }

    public void removeElementoCasilla(Elementos elemento) {
        this.elementosCasilla.remove(elemento);
    }

        //Individuos en la Casilla
    public ListaDoblementeEnlazada<Individuo> getIndividuosCasilla() {
        return this.individuosCasilla;
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

    public void removeIndividuoCasilla(Individuo individuo) {
        this.individuosCasilla.remove(individuo);
        addIndividuoCasilla();
    }


        //Componentes Casilla
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


}
