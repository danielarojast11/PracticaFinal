package org.example.practicafinal.Clases.ArbolGenealogico;

import org.example.practicafinal.Clases.Individuo.Individuo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Grafo {

    //Parameters
    private List<Individuo> individuos;
    private HashMap<Individuo, List<Individuo>> individuosGrafo;

    //Constructores
    public Grafo(List<Individuo> individuos) {
        this.individuos = individuos;
        individuosGrafo = new HashMap<>();
    }


    //Methods
    public HashMap<Individuo, List<Individuo>> getIndividuosGrafo(){
        for(Individuo individuo: this.individuos){
            this.individuosGrafo.put(individuo, this.getArbolIndividuo(individuo));
        }
        return individuosGrafo;
    }

    private List<Individuo> getArbolIndividuo(Individuo individuo){
        return null;
    }


}
