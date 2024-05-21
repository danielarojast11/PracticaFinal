package org.example.practicafinal.EstructurasDeDatos.Arbol;

import java.util.List;

public class ArbolBinarioDeBusquedaDeEnteros extends ArbolBinarioDeBusqueda{
    NodoBinario raiz = this.getRaiz();

    public int getSuma(List<NodoBinario> lista){
        int suma = 0;
        for (int indice = 0; indice < lista.size(); indice++){
            int auxiliar = lista.get(indice).getContenido();
            suma += auxiliar;
        }
        return suma;
    }

    public int getSumaPreOrden(){
        int suma = 0;
        for (NodoBinario nodo: this.getListaPreOrden()){
            suma += nodo.getContenido();
        }
        return suma;
    }

    public int getSumaPostOrden(){
        int suma = 0;
        for (NodoBinario nodo: this.getListaPostOrden()){
            suma += nodo.getContenido();
        }
        return suma;
    }

    public int getSumaOrdenCentral(){
        int suma = 0;
        for (NodoBinario nodo: this.getListaOrdenCentral()){
            suma += nodo.getContenido();
        }
        return suma;
    }

    public int getSumaSubArbol(int n, String lado){
        int suma = 0;
        ArbolBinarioDeBusqueda ab = this.getSubArbol(new NodoBinario(n), lado);
        for (NodoBinario nodo: ab.getListaPostOrden()){
            suma += nodo.getContenido();
        }
        return suma;
    }
}
