package org.example.practicafinal.EstructurasDeDatos.Grafo;
import org.example.practicafinal.Entity.Individuo;
import org.example.practicafinal.Entity.Operacion;
import org.example.practicafinal.Entity.Partida;
import org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada.ElementoLE;
import org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada.ListaEnlazada;

import java.util.HashMap;
import java.util.Map;

public class GrafoOperaciones {
    private Map<String, String> grafo;
    private Partida partida;

    public GrafoOperaciones(){
        this.grafo= new HashMap<>();
    }

    public void addOperacionesIndividuo (IndividuoPruebaGrafo individuo){
        String nodoAnterior = null;
        ElementoLE elementoLE = individuo.getOperaciones().getPrimero();
        while (elementoLE != null){
            String nodo = "Individuo: " + individuo.getId() + " Turno: " + individuo.getOperaciones().getPrimero().getData().getTurno();
            if (nodoAnterior!=null){
                grafo.put(nodoAnterior,nodo);
            }
            nodoAnterior = nodo;
            elementoLE = elementoLE.getSiguiente();
        }
    }

    public void construirGrafo(ListaEnlazada<Individuo> individuos){
        for (int i =0; i<individuos.getNumeroElementos(); i++){
            ElementoLE elementoLE = partida.getListaIndividuos().getPrimero();
            while (elementoLE != null){
                IndividuoPruebaGrafo individuo = (IndividuoPruebaGrafo) elementoLE.getData();
                addOperacionesIndividuo(individuo);
            }
        }
    }

    public Map<String, String> getGrafo(){
        return grafo;
    }
}
