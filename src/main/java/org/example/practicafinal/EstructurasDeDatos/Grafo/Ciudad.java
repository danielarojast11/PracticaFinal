package org.example.practicafinal.EstructurasDeDatos.Grafo;

import java.util.ArrayList;

public class Ciudad {
    private ArrayList<Carretera> vecindad;  //Aristas que inciden en el vertice, carreteras que llegan a la ciudad
    private String nombre;

    public Ciudad(){

    }

    public Ciudad(String nombre){
        this.nombre = nombre;
        this.vecindad = new ArrayList<Carretera>();
    }

    public void insertarVecina(Carretera carretera){
        if (!this.vecindad.contains(carretera)){        //Añade la carretera si esta no estaba ya en la lista
            this.vecindad.add(carretera);
        }
    }

    public boolean contieneCiudad(Carretera carretera){
        return this.vecindad.contains(carretera);   //Indica si la carretera llega a la ciudad
    }

    public Carretera getCarretera(int indice){
        return this.vecindad.get(indice);
    }

    public void setVecindad(ArrayList<Carretera> vecindad){
        this.vecindad = vecindad;
    }

    public Carretera eliminarCiudad(int indice){      //Se elimina la carretera que conecta las ciudades
        return this.vecindad.remove(indice);
    }

    public void eliminarCiudadVecina(Carretera carretera){
        this.vecindad.remove(carretera);
    }

    public int getContarVecinos(){
        return this.vecindad.size();        //Devuelve el grado del vertice, las carreteras que llegan a la ciudad
    }

    public String getNombre(){
        return this.nombre;
    }

    public boolean equals(Object ciudad2){
        if (!(ciudad2 instanceof Ciudad)){      //se comprueba si es de tipo Ciudad
            return false;
        }
        Ciudad c = (Ciudad) ciudad2;
        return this.nombre.equals(c.nombre);
    }

    public String toString(){
        return ("Ciudad: "+this.nombre);
    }

    public int hashCode(){
        return this.getNombre().hashCode();
    }

    public ArrayList<Carretera> getVecinos(){
        return new ArrayList<Carretera>(this.vecindad);
    }
}
