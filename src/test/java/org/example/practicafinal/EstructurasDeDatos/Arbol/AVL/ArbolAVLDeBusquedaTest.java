package org.example.practicafinal.EstructurasDeDatos.Arbol.AVL;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArbolAVLDeBusquedaTest {

    @Test
    void getGrado() {
        ArbolAVLDeBusqueda a = new ArbolAVLDeBusqueda();
        assertEquals(0, a.getGrado());
    }

    @Test
    void getAlturaTotal() {
        ArbolAVLDeBusqueda a = new ArbolAVLDeBusqueda();
        assertEquals(-1, a.getAlturaTotal());
    }

    @Test
    void getAlturaIzquierdo(){
        ArbolAVLDeBusqueda a = new ArbolAVLDeBusqueda();
        assertEquals(-1, a.getAlturaIzquierdo());
    }

    @Test
    void getAlturaDerecho(){
        ArbolAVLDeBusqueda a = new ArbolAVLDeBusqueda();
        assertEquals(-1, a.getAlturaDerecho());
    }

    @Test
    void add() {
        ArbolAVLDeBusqueda a1 = new ArbolAVLDeBusqueda();
        a1.add(new Nodo(3));
        assertEquals(3, a1.getRaiz().getContenido());
        a1.add(new Nodo(1));
        assertEquals(1, a1.getRaiz().getIzquierdo().getContenido());
        a1.add(new Nodo(5));
        assertEquals(5, a1.getRaiz().getDerecho().getContenido());
        a1.add(new Nodo(2));
        assertEquals(2, a1.getRaiz().getIzquierdo().getDerecho().getContenido());
        a1.add(new Nodo(8));
        assertEquals(8, a1.getRaiz().getDerecho().getDerecho().getContenido());
    }

    @Test
    void borrar(){
        ArbolAVLDeBusqueda a1 = new ArbolAVLDeBusqueda();
        a1.add(new Nodo(3));
        a1.add(new Nodo(1));
        a1.add(new Nodo(5));
        a1.add(new Nodo(2));
        Nodo nodoEliminar = new Nodo(5);
        a1.borrar(nodoEliminar);
    }

    @Test
    void isEquilibrado(){
        ArbolAVLDeBusqueda a1 = new ArbolAVLDeBusqueda();
        a1.add(new Nodo(4));
        a1.add(new Nodo(1));
        a1.add(new Nodo(6));
        a1.add(new Nodo(3));
        a1.add(new Nodo(5));
        a1.add(new Nodo(7));
        assertEquals(true, a1.isEquilibrado());
    }

    @Test
    void equilibrar(){
        ArbolAVLDeBusqueda a1 = new ArbolAVLDeBusqueda();
        a1.add(new Nodo(57));
        a1.add(new Nodo(35));
        a1.add(new Nodo(92));
        a1.add(new Nodo(13));
        a1.add(new Nodo(44));
        a1.add(new Nodo(64));
        a1.add(new Nodo(23));
        a1.add(new Nodo(77));
        a1.add(new Nodo(14));
        a1.add(new Nodo(24));
        a1.add(new Nodo(68));
        a1.add(new Nodo(87));
        a1.add(new Nodo(88));
        a1.add(new Nodo(90));
        a1.equilibrar();
    }

    @Test
    void getRaiz(){
        ArbolAVLDeBusqueda a1 = new ArbolAVLDeBusqueda();
        a1.add(new Nodo(3));
        assertEquals(3, a1.getRaiz().getContenido());
    }

    @Test
    void setRaiz() {
        ArbolAVLDeBusqueda a1 = new ArbolAVLDeBusqueda();
        a1.add(new Nodo(3));
        a1.setRaiz(new Nodo(7));
        assertEquals(7, a1.getRaiz().getContenido());
    }

    @Test
    void getListaDatosNivel() {
        ArbolAVLDeBusqueda a1 = new ArbolAVLDeBusqueda();
        Nodo raiz = new Nodo(1);
        a1.setRaiz(raiz);
        Nodo n11 = new Nodo(1);
        Nodo n12 = new Nodo(5);
        List<Nodo> l1 = new ArrayList<>();
        l1.add(raiz);
        List<Nodo> l2 = new ArrayList<>();
        l2.add(n11);
        l2.add(n12);
        List<Nodo> nodos1 = a1.getListaDatosNivel(0);
        List<Nodo> nodos2 = a1.getListaDatosNivel(1);
        assertEquals(nodos1, a1.getListaDatosNivel(0));
        assertEquals(nodos2, a1.getListaDatosNivel(1));
    }

    @Test
    void isArbolHomogeneo() {
        ArbolAVLDeBusqueda a1 = new ArbolAVLDeBusqueda();
        int[] nodos;
        nodos = new int[]{5, 3, 4, 2, 7, 6, 8};
        for (int indice = 0; indice < nodos.length; indice++){
            int i = nodos[indice];
            a1.add(new Nodo(i));
        }
        assertTrue(a1.isArbolHomogeneo());
    }

    @Test
    void isArbolCompleto() {
        ArbolAVLDeBusqueda a1 = new ArbolAVLDeBusqueda();
        int[] nodos;
        nodos = new int[]{5, 3, 4, 2, 7, 6, 8};
        for (int indice = 0; indice < nodos.length; indice++){
            int i = nodos[indice];
            a1.add(new Nodo(i));
        }
        assertTrue(a1.isArbolCompleto());
    }

    @Test
    void isArbolCasiCompleto() {
        ArbolAVLDeBusqueda a1 = new ArbolAVLDeBusqueda();
        int[] nodos;
        nodos = new int[]{5, 3, 4, 2, 7, 6};
        for (int indice = 0; indice < nodos.length; indice++){
            int i = nodos[indice];
            a1.add(new Nodo(i));
        }
        assertTrue(a1.isArbolCasiCompleto());
    }

    @Test
    void getCamino() {
        ArbolAVLDeBusqueda a1 = new ArbolAVLDeBusqueda();
        Nodo raiz = new Nodo(1);
        a1.setRaiz(raiz);
        Nodo n11 = new Nodo(1);
        Nodo n12 = new Nodo(5);
        List<Nodo> l1 = new ArrayList<>();
        l1.add(raiz);
        List<Nodo> l2 = new ArrayList<>();
        l2.add(n11);
        l2.add(n12);
        List<Nodo> nodos1 = a1.getCamino(0);
        List<Nodo> nodos2 = a1.getCamino(1);
        assertEquals(nodos1, a1.getCamino(0));
        assertEquals(nodos2, a1.getCamino(1));
    }

    @Test
    void getSubArbol() {
        ArbolAVLDeBusqueda a1 = new ArbolAVLDeBusqueda();
        int[] nodos;
        nodos = new int[]{5, 3, 4, 2, 7, 6, 8};
        for (int indice = 0; indice < nodos.length; indice++){
            int i = nodos[indice];
            a1.add(new Nodo(i));
        }
        ArbolAVLDeBusqueda a2 = a1.getSubArbol(a1.getRaiz(), "izquierdo");
        assertEquals(3, a2.getRaiz().getContenido());
        assertEquals(2, a2.getRaiz().getIzquierdo().getContenido());
        assertEquals(4, a2.getRaiz().getDerecho().getContenido());
        ArbolAVLDeBusqueda a3 = a1.getSubArbol(a1.getRaiz(), "derecho");
        assertEquals(7, a3.getRaiz().getContenido());
        assertEquals(6, a3.getRaiz().getIzquierdo().getContenido());
        assertEquals(8, a3.getRaiz().getDerecho().getContenido());
    }

    @Test
    void getListaPreOrden() {
        ArbolAVLDeBusqueda a1 = new ArbolAVLDeBusqueda();
        int[] nodos;
        nodos = new int[]{5, 3, 7};
        for (int indice = 0; indice < nodos.length; indice++){
            int i = nodos[indice];
            a1.add(new Nodo(i));
        }
        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> listaa = new ArrayList<>();
        listaa.add(5);
        listaa.add(3);
        listaa.add(7);
        a1.getListaPreOrden();
        for (Nodo nodo: a1.getListaPreOrden()){
            int i = nodo.getContenido();
            lista.add(i);
        }
        assertEquals(listaa, lista);
    }

    @Test
    void getListaPostOrden() {
        ArbolAVLDeBusqueda a1 = new ArbolAVLDeBusqueda();
        int[] nodos;
        nodos = new int[]{5, 3, 7};
        for (int indice = 0; indice < nodos.length; indice++){
            int i = nodos[indice];
            a1.add(new Nodo(i));
        }
        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> listaa = new ArrayList<>();
        listaa.add(3);
        listaa.add(7);
        listaa.add(5);
        a1.getListaPreOrden();
        for (Nodo nodo: a1.getListaPostOrden()){
            int i = nodo.getContenido();
            lista.add(i);
        }
        assertEquals(listaa, lista);
    }

    @Test
    void getListaOrdenCentral() {
        ArbolAVLDeBusqueda a1 = new ArbolAVLDeBusqueda();
        int[] nodos;
        nodos = new int[]{5, 3, 7};
        for (int indice = 0; indice < nodos.length; indice++){
            int i = nodos[indice];
            a1.add(new Nodo(i));
        }
        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> listaa = new ArrayList<>();
        listaa.add(3);
        listaa.add(5);
        listaa.add(7);
        a1.getListaPreOrden();
        for (Nodo nodo: a1.getListaOrdenCentral()){
            int i = nodo.getContenido();
            lista.add(i);
        }
        assertEquals(listaa, lista);
    }
}