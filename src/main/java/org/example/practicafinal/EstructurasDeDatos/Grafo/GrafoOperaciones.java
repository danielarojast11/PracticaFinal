package org.example.practicafinal.EstructurasDeDatos.Grafo;
import org.example.practicafinal.Entity.Individuo;
import org.example.practicafinal.Entity.Operacion;
import org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada.ListaDoblementeEnlazada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrafoOperaciones {
    private Map<String, String> grafo;
    public GrafoOperaciones(){
        this.grafo= new HashMap<>();
    }
    public void addOperacionesIndividuo (IndividuoPruebaGrafo individuo){
        String nodoAnterior = null;
        for (Operacion op : individuo.getOperaciones()){
            String nodo = "Individuo: " + individuo.getId() + " Turno: " + op.getTurno();
            if (nodoAnterior!=null){
                grafo.put(nodoAnterior,nodo);
            }
            nodoAnterior = nodo;
        }
    }

    /*public void construirGrafo(ListaDoblementeEnlazada<Individuo> individuos){
        for (int i =0; i<individuos.getNumeroElementos(); i++){
            Individuo individuo = individuos.getElemento(i).getData();
            addOperacionesIndividuo(individuo);
        }
    }*/
    public void construirGrafo(ArrayList<IndividuoPruebaGrafo> individuos){
        for (IndividuoPruebaGrafo ind:individuos){
            addOperacionesIndividuo(ind);
        }
    }

    public Map<String, String> getGrafo(){
        return grafo;
    }
}
