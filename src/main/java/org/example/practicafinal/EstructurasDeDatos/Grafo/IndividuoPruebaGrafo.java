package org.example.practicafinal.EstructurasDeDatos.Grafo;

import org.example.practicafinal.Entity.Operacion;

import java.util.ArrayList;
import java.util.Deque;

public class IndividuoPruebaGrafo {
    private int id;
    private int generation;
    private int lifeTurns;
    private double reproductionProb;
    private double cloneProb;
    private ArrayList<Operacion> operaciones;
    public IndividuoPruebaGrafo(int id, int generation, int lifeTurns, double reproductionProb, double cloneProb) {
        this.id = id;
        this.generation = generation;
        this.lifeTurns = lifeTurns;
        this.reproductionProb = reproductionProb;
        this.cloneProb = cloneProb;
        this.operaciones = new ArrayList<>();
    }
    public void addOperaciones(String description, int turn, int type) {
        operaciones.add(new Operacion(description, turn, type));
    }

    public int getId() {
        return id;
    }

    public ArrayList<Operacion> getOperaciones() {
        return operaciones;
    }
}
