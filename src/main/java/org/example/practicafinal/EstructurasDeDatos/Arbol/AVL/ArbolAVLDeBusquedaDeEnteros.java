package org.example.practicafinal.EstructurasDeDatos.Arbol.AVL;

import java.util.List;

public class ArbolAVLDeBusquedaDeEnteros extends ArbolAVLDeBusqueda{
    Nodo raiz = this.getRaiz();

    public int getSuma(List<Nodo> lista){
        int suma = 0;
        for (int indice = 0; indice < lista.size(); indice++){
            int auxiliar = lista.get(indice).getContenido();
            suma += auxiliar;
        }
        return suma;
    }

    public int getSumaPreOrden(){
        int suma = 0;
        for (Nodo nodo: this.getListaPreOrden()){
            suma += nodo.getContenido();
        }
        return suma;
    }

    public int getSumaPostOrden(){
        int suma = 0;
        for (Nodo nodo: this.getListaPostOrden()){
            suma += nodo.getContenido();
        }
        return suma;
    }

    public int getSumaOrdenCentral(){
        int suma = 0;
        for (Nodo nodo: this.getListaOrdenCentral()){
            suma += nodo.getContenido();
        }
        return suma;
    }

    public int getSumaSubArbol(int n, String lado){
        int suma = 0;
        ArbolAVLDeBusqueda ab = this.getSubArbol(new Nodo(n), lado);
        for (Nodo nodo: ab.getListaPostOrden()){
            suma += nodo.getContenido();
        }
        return suma;
    }
}
