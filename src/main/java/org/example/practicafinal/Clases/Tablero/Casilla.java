package org.example.practicafinal.Clases.Tablero;

import com.google.gson.JsonObject;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import org.example.practicafinal.Clases.Entorno.Elementos;
import org.example.practicafinal.Clases.Individuo.Individuo;
import org.example.practicafinal.EscenarioJugarController;

import java.util.ArrayList;
import java.util.List;


public class Casilla extends Pane {
    private int columna;
    private int fila;
    private List<Individuo> individuosCasilla = new ArrayList<>();
    private final List<Integer> individuosIdCasilla = new ArrayList<>();
    private List<Elementos> elementosCasilla = new ArrayList<>();

    //EscenarioJugarController escenario;

    public Casilla(){ }

    public Casilla(int columna, int fila){
        this.columna=columna;
        this.fila=fila;
        this.setId("casilla("+columna+","+fila+")");
    }

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
    public List<Elementos> getElementosCasilla() {
        return elementosCasilla;
    }

    public void setElementosCasilla(List<Elementos> elementosCasilla) {
        this.elementosCasilla = elementosCasilla;
    }

    public void addElementoCasilla(Elementos elemento) {
        this.elementosCasilla.add(elemento);
    }

    public void removeElementoCasilla(Elementos elemento) {
        this.elementosCasilla.remove(elemento);
    }

        //Individuos en la Casilla
    public List<Individuo> getIndividuosCasilla() {
        return this.individuosCasilla;
    }

    public List<Integer> getIndividuosIdCasilla(){return this.individuosIdCasilla;}

    public int getIndividuosTotales(){
        return individuosCasilla.size();
    }

    public void setIndividuosCasilla(List<Individuo> listaIndividuos) {
        this.individuosCasilla = listaIndividuos;
    }

    public void addIndividuoCasilla(Individuo individuo) {
        this.individuosCasilla.add(individuo);
        addIndividuoCasilla();
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
