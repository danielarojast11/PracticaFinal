package org.example.practicafinal.EstructurasDeDatos.Arbol;

import org.example.practicafinal.EstructurasDeDatos.Arbol.Binario.ArbolBinarioDeBusqueda;
import org.example.practicafinal.EstructurasDeDatos.Arbol.Binario.NodoBinario;
import org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada.ListaDoblementeEnlazada;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArbolBinarioDeBusquedaTest {
    @Test
    void getGrado() {
        ArbolBinarioDeBusqueda a = new ArbolBinarioDeBusqueda();
        assertEquals(0, a.getGrado());
    }

    @Test
    void getAltura() {
        ArbolBinarioDeBusqueda a = new ArbolBinarioDeBusqueda();
        assertEquals(0, a.getAltura());
    }

    @Test
    void getRaiz(){
        ArbolBinarioDeBusqueda a = new ArbolBinarioDeBusqueda();
        assertEquals(0, a.getRaiz());
    }

    @Test
    void getListaDatosNivel() {
        ArbolBinarioDeBusqueda a1 = new ArbolBinarioDeBusqueda();
        NodoBinario raiz = new NodoBinario(1);
        a1.setRaiz(raiz);
        NodoBinario n11 = new NodoBinario(1);
        NodoBinario n12 = new NodoBinario(5);
        List<NodoBinario> l1 = new ArrayList<>();
        l1.add(raiz);
        List<NodoBinario> l2 = new ArrayList<>();
        l2.add(n11);
        l2.add(n12);
        ListaDoblementeEnlazada<NodoBinario> nodos1 = a1.getListaDatosNivel(0);
        ListaDoblementeEnlazada<NodoBinario> nodos2 = a1.getListaDatosNivel(1);
        assertEquals(nodos1, a1.getListaDatosNivel(0));
        assertEquals(nodos2, a1.getListaDatosNivel(1));
    }

    @Test
    void isArbolHomogeneo() {
        ArbolBinarioDeBusqueda a1 = new ArbolBinarioDeBusqueda();
        int[] nodos;
        nodos = new int[]{5, 3, 4, 2, 7, 6, 8};
        for (int indice = 0; indice < nodos.length; indice++){
            int i = nodos[indice];
            a1.add(new NodoBinario(i));
        }
    }

    @Test
    void isArbolCompleto() {
        ArbolBinarioDeBusqueda a1 = new ArbolBinarioDeBusqueda();
        int[] nodos;
        nodos = new int[]{5, 3, 4, 2, 7, 6, 8};
        for (int indice = 0; indice < nodos.length; indice++){
            int i = nodos[indice];
            a1.add(new NodoBinario(i));
        }
        assertTrue(a1.isArbolCompleto());
    }

    @Test
    void isArbolCasiCompleto() {
        ArbolBinarioDeBusqueda a1 = new ArbolBinarioDeBusqueda();
        int[] nodos;
        nodos = new int[]{5, 3, 4, 2, 7, 6};
        for (int indice = 0; indice < nodos.length; indice++){
            int i = nodos[indice];
            a1.add(new NodoBinario(i));
        }
        assertTrue(a1.isArbolCasiCompleto());
    }

    @Test
    void getCamino() {
        ArbolBinarioDeBusqueda a1 = new ArbolBinarioDeBusqueda();
        NodoBinario raiz = new NodoBinario(1);
        a1.setRaiz(raiz);
        NodoBinario n11 = new NodoBinario(1);
        NodoBinario n12 = new NodoBinario(5);
        List<NodoBinario> l1 = new ArrayList<>();
        l1.add(raiz);
        List<NodoBinario> l2 = new ArrayList<>();
        l2.add(n11);
        l2.add(n12);
        ListaDoblementeEnlazada<NodoBinario> nodos1 = a1.getCamino(0);
        ListaDoblementeEnlazada<NodoBinario> nodos2 = a1.getCamino(1);
        assertEquals(nodos1, a1.getCamino(0));
        assertEquals(nodos2, a1.getCamino(1));
    }

    @Test
    void add() {
        ArbolBinarioDeBusqueda a1 = new ArbolBinarioDeBusqueda();
        a1.add(new NodoBinario(3));
        assertEquals(3, a1.getRaiz().getContenido());
        a1.add(new NodoBinario(1));
        assertEquals(1, a1.getRaiz().getIzquierdo().getContenido());
        a1.add(new NodoBinario(5));
        assertEquals(5, a1.getRaiz().getDerecho().getContenido());
        a1.add(new NodoBinario(2));
        assertEquals(2, a1.getRaiz().getIzquierdo().getDerecho().getContenido());
        a1.add(new NodoBinario(8));
        assertEquals(8, a1.getRaiz().getDerecho().getDerecho().getContenido());
    }

    @Test
    void getSubArbol() {
        ArbolBinarioDeBusqueda a1 = new ArbolBinarioDeBusqueda();
        int[] nodos;
        nodos = new int[]{5, 3, 4, 2, 7, 6, 8};
        for (int indice = 0; indice < nodos.length; indice++){
            int i = nodos[indice];
            a1.add(new NodoBinario(i));
        }
        ArbolBinarioDeBusqueda a2 = a1.getSubArbol(a1.getRaiz(), "izquierdo");
        assertEquals(3, a2.getRaiz().getContenido());
        assertEquals(2, a2.getRaiz().getIzquierdo().getContenido());
        assertEquals(4, a2.getRaiz().getDerecho().getContenido());
        ArbolBinarioDeBusqueda a3 = a1.getSubArbol(a1.getRaiz(), "derecho");
        assertEquals(7, a3.getRaiz().getContenido());
        assertEquals(6, a3.getRaiz().getIzquierdo().getContenido());
        assertEquals(8, a3.getRaiz().getDerecho().getContenido());
    }

    @Test
    void setRaiz() {
        ArbolBinarioDeBusqueda a1 = new ArbolBinarioDeBusqueda();
        a1.add(new NodoBinario(3));
        a1.setRaiz(new NodoBinario(7));
        assertEquals(7, a1.getRaiz().getContenido());
    }

    @Test
    void getListaPreOrden() {
        ArbolBinarioDeBusqueda a1 = new ArbolBinarioDeBusqueda();
        int[] nodos;
        nodos = new int[]{5, 3, 7};
        for (int indice = 0; indice < nodos.length; indice++){
            int i = nodos[indice];
            a1.add(new NodoBinario(i));
        }
        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> listaa = new ArrayList<>();
        listaa.add(5);
        listaa.add(3);
        listaa.add(7);
        a1.getListaPreOrden();
        assertEquals(listaa, lista);
    }

    @Test
    void getListaPostOrden() {
        ArbolBinarioDeBusqueda a1 = new ArbolBinarioDeBusqueda();
        int[] nodos;
        nodos = new int[]{5, 3, 7};
        for (int indice = 0; indice < nodos.length; indice++){
            int i = nodos[indice];
            a1.add(new NodoBinario(i));
        }
        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> listaa = new ArrayList<>();
        listaa.add(3);
        listaa.add(7);
        listaa.add(5);
        a1.getListaPreOrden();
        assertEquals(listaa, lista);
    }

    @Test
    void getListaOrdenCentral() {
        ArbolBinarioDeBusqueda a1 = new ArbolBinarioDeBusqueda();
        int[] nodos;
        nodos = new int[]{5, 3, 7};
        for (int indice = 0; indice < nodos.length; indice++){
            int i = nodos[indice];
            a1.add(new NodoBinario(i));
        }
        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> listaa = new ArrayList<>();
        listaa.add(3);
        listaa.add(5);
        listaa.add(7);
        a1.getListaPreOrden();
        assertEquals(listaa, lista);
    }
}