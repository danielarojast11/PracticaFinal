package org.example.practicafinal.EstructurasDeDatos.Arbol.Binario;

import org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada.ListaEnlazada;
import org.example.practicafinal.EstructurasDeDatos.Lista.Simple.ListaSimple;

public class ArbolBinarioDeBusqueda {
    private int grado = 0;
    private int altura = 0;
    private NodoBinario raiz;
    private ListaEnlazada<NodoBinario> nodos;

    public int getGrado(){
        return grado;
    }

    public int getAltura(){
        if (this.raiz != null){
            return this.calcularAltura(raiz);
        }

        return 0;
    }

    private int calcularAltura(NodoBinario nodoActual) {
        if (nodoActual != null){
            int alturaIzquierdo = this.calcularAltura(nodoActual.getIzquierdo());
            int alturaDerecho = this.calcularAltura(nodoActual.getDerecho());
            return Math.max(alturaIzquierdo, alturaDerecho) + 1;
        }
        return 0;
    }

    public NodoBinario getRaiz(){ return raiz;}

    public ListaEnlazada<NodoBinario> getListaDatosNivel(int nivel){
        this.nodos = new ListaEnlazada<>();

        if (this.raiz != null){
            this.getNodosNivel(nivel, this.raiz, 0);
        }

        return this.nodos;
    }

    private void getNodosNivel(int nivel, NodoBinario nodoActual, int nivelActual){

        if (nivelActual < nivel){

            if (nodoActual.getIzquierdo() != null){
                this.getNodosNivel(nivel, nodoActual.getIzquierdo(), nivelActual +1);
            }

            if (nodoActual.getDerecho() != null){
                this.getNodosNivel(nivel, nodoActual.getDerecho(), nivelActual +1);
            }
        }
        else {

            this.nodos.add(nodoActual);

        }
    }

    public boolean isArbolHomogeneo(){
        if (raiz != null){
            return this.comprobarHomogeneo(raiz);
        }
        else{
            return true;
        }
    }

    private boolean comprobarHomogeneo(NodoBinario nodoActual){
        if (nodoActual.getIzquierdo() == null && nodoActual.getDerecho() == null){
            return true;
        } else if (nodoActual.getIzquierdo() == null || nodoActual.getDerecho() == null){
            return false;
        } else{
            boolean resI = this.comprobarHomogeneo(nodoActual.getIzquierdo());
            boolean resD = this.comprobarHomogeneo(nodoActual.getDerecho());
            if (resI && resD){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public boolean isArbolCompleto(){
        if (raiz != null){
            return this.comprobarCompleto(this.raiz, 0);
        }
        else{
            return true;
        }
    }

    private boolean comprobarCompleto(NodoBinario nodoActual, int nivel){
        boolean completo = true;
        if (nodoActual.getIzquierdo() != null){
            completo = comprobarCompleto(nodoActual.getIzquierdo(), nivel++);
        } else {
            if (nivel < altura){
                completo = false;
            }
        }
        if (completo) {
            if (nodoActual.getDerecho() != null) {
                completo = comprobarCompleto(nodoActual.getDerecho(), nivel++);
            } else {
                if (nivel < altura) {
                    completo = false;
                }
            }
        }
        return completo;
    }

    public boolean isArbolCasiCompleto(){
        if (raiz != null){
            return this.comprobarCasiCompleto(this.raiz, 0);
        }
        else{
            return true;
        }
    }

    private boolean comprobarCasiCompleto(NodoBinario nodoActual, int nivel){
        boolean casiCompleto = true;
        if (nivel == altura){
            if (nodoActual.getIzquierdo() == null && nodoActual.getDerecho() != null){
                casiCompleto = false;
            }
        } else {
            if (nodoActual.getIzquierdo() != null){
                casiCompleto = this.comprobarCasiCompleto(nodoActual.getIzquierdo(), nivel++);
            }
            if (casiCompleto) {
                if (nodoActual.getDerecho() != null) {
                    casiCompleto = comprobarCasiCompleto(nodoActual.getDerecho(), nivel++);
                }
            }
        }
        return casiCompleto;
    }

    public ListaEnlazada<NodoBinario> getCamino(int valorBuscar){
        this.nodos = new ListaEnlazada<>();
        if (this.raiz != null){
            this.getNodosCamino(valorBuscar, raiz);
            int ultimoValor = this.nodos.getUltimo().getData().getContenido();
            if (valorBuscar != ultimoValor){
                this.nodos = new ListaEnlazada<>();
            }
        }
        return this.nodos;
    }

    private void getNodosCamino(int valorBuscar, NodoBinario nodoActual){
        this.nodos.add(nodoActual);
        NodoBinario nodoBuscar = new NodoBinario(valorBuscar);

        if (nodoActual.compareTo(nodoBuscar) > 0) {
            if (nodoActual.getIzquierdo() != null){
                this.getNodosCamino(valorBuscar, nodoActual.getIzquierdo());
            }
        } else if (nodoActual.compareTo(nodoBuscar) < 0){
            if(nodoActual.getDerecho() != null){
                this.getNodosCamino(valorBuscar, nodoActual.getDerecho());
            }
        }
    }

    public void add(NodoBinario nodo){
        if(this.raiz == null){
            this.raiz = nodo;
        } else {
            addNodo(raiz, nodo);
        }
    }

    private void addNodo(NodoBinario nodoActual, NodoBinario nodoAñadir){
        if (nodoActual.getContenido() < nodoAñadir.getContenido()){
            if (nodoActual.getDerecho() != null){
                addNodo(nodoActual.getDerecho(), nodoAñadir);
            } else{
                nodoActual.setDerecho(nodoAñadir);
            }
        } else {
            if (nodoActual.getIzquierdo() != null){
                addNodo(nodoActual.getIzquierdo(), nodoAñadir);
            } else {
                nodoActual.setIzquierdo(nodoAñadir);
            }
        }
    }

    public ArbolBinarioDeBusqueda getSubArbol(NodoBinario nodoBuscar, String lado){
        if(raiz != null){
            NodoBinario nodoEncontrado = this.buscarNodo(nodoBuscar, this.raiz);
            if(nodoEncontrado != null){
                ArbolBinarioDeBusqueda abb = new ArbolBinarioDeBusqueda();
                abb.setRaiz(nodoEncontrado);
                if (lado.equals("izquierdo")){
                    abb.setRaiz(nodoEncontrado.getIzquierdo());
                }
                if (lado.equals("derecho")){
                    abb.setRaiz(nodoEncontrado.getDerecho());
                }
                return abb;
            }
        }
        return null;
    }

    private NodoBinario buscarNodo(NodoBinario nodoBuscar, NodoBinario nodoActual){
        switch (nodoActual.compareTo(nodoBuscar)){
            case 1:
                if (nodoActual.getIzquierdo() != null){
                    return this.buscarNodo(nodoBuscar, nodoActual.getIzquierdo());
                }
                break;
            case 0:
                return nodoActual;
            case -1:
                if (nodoActual.getDerecho() != null){
                    return this.buscarNodo(nodoBuscar, nodoActual.getDerecho());
                }
                break;
        }
        return null;
    }

    public void setRaiz(NodoBinario raiz){
        this.raiz = raiz;
    }

    public ListaEnlazada<NodoBinario> getListaPreOrden(){
        this.nodos = new ListaEnlazada<>();
        if (this.raiz != null) {
            this.getNodosPreOrden(raiz);
        }
        return this.nodos;
    }

    private void getNodosPreOrden(NodoBinario nodoActual){
        this.nodos.add(nodoActual);

        if (nodoActual.getIzquierdo() != null){
            this.getNodosPreOrden(nodoActual.getIzquierdo());
        }

        if (nodoActual.getDerecho() != null){
            this.getNodosPreOrden(nodoActual.getDerecho());
        }
    }

    public ListaEnlazada<NodoBinario> getListaPostOrden(){
        this.nodos = new ListaEnlazada<>();
        if (this.raiz != null) {
            this.getNodosPostOrden(raiz);
        }
        return this.nodos;
    }

    private void getNodosPostOrden(NodoBinario nodoActual){
        if (nodoActual.getIzquierdo() != null){
            this.getNodosPostOrden(nodoActual.getIzquierdo());
        }
        if (nodoActual.getDerecho() != null){
            this.getNodosPostOrden(nodoActual.getDerecho());
        }

        this.nodos.add(nodoActual);
    }

    public ListaEnlazada<NodoBinario> getListaOrdenCentral(){
        this.nodos = new ListaEnlazada<>();
        if (this.raiz != null) {
            this.getNodosOrdenCentral(raiz);
        }
        return this.nodos;
    }

    private void getNodosOrdenCentral(NodoBinario nodoActual){
        if (nodoActual.getIzquierdo() != null){
            this.getNodosPreOrden(nodoActual.getIzquierdo());
        }
        this.nodos.add(nodoActual);

        if (nodoActual.getDerecho() != null){
            this.getNodosPreOrden(nodoActual.getDerecho());
        }
    }
}
