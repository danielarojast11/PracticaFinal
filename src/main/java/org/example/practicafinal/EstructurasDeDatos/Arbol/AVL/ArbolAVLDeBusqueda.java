package org.example.practicafinal.EstructurasDeDatos.Arbol.AVL;

import org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada.ListaDoblementeEnlazada;


public class ArbolAVLDeBusqueda {
    private int grado = 0;
    private int altura = 0;
    private Nodo raiz;
    private ListaDoblementeEnlazada<Nodo> nodos;
    public int getGrado(){
        return grado;
    }

    public int getAlturaTotal(){
        if (this.raiz != null){
            return this.calcularAltura(raiz);
        }
        return -1;
    }

    private int calcularAltura(Nodo nodoActual) {
        if (nodoActual != null){
            int alturaIzquierdo = this.calcularAltura(nodoActual.getIzquierdo());
            int alturaDerecho = this.calcularAltura(nodoActual.getDerecho());
            return Math.max(alturaIzquierdo, alturaDerecho) + 1;
        }
        return -1;
    }

    public int getAlturaIzquierdo(){
        if (this.raiz != null){
            return this.calcularAlturaIzquierdo(this.raiz.getIzquierdo());
        }
        return -1;
    }

    private int calcularAlturaIzquierdo(Nodo nodoActual) {
        if (nodoActual != null){
            int alturaIzquierdo = this.calcularAlturaIzquierdo(nodoActual.getIzquierdo());
            return alturaIzquierdo +1;
        }
        return -1;
    }

    public int getAlturaDerecho(){
        if (this.raiz != null){
            return this.calcularAlturaDerecho(this.raiz.getDerecho());
        }
        return -1;
    }

    private int calcularAlturaDerecho(Nodo nodoActual) {
        if (nodoActual != null){
            int alturaDerecho = this.calcularAlturaDerecho(nodoActual.getDerecho());
            return alturaDerecho +1;
        }
        return -1;
    }

    public void add(Nodo nodo){
        if(this.raiz == null){
            this.raiz = nodo;
        } else {
            addNodo(raiz, nodo);
        }
    }

    private void addNodo(Nodo nodoActual, Nodo nodoAñadir){
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

    public void borrar (Nodo nodoBuscar){
        if (this.raiz != null) {
            borrarNodo(raiz, nodoBuscar);
        }
        if (!isEquilibrado()){
            equilibrar();
        }
    }

    private void borrarNodo(Nodo nodoActual, Nodo nodoBorrar){
        if (raiz.getContenido() == nodoBorrar.getContenido()) {
            if (this.raiz.getIzquierdo() != null) {
                raiz = nodoMax(nodoActual);
                raiz.setDerecho(raiz.getDerecho());
            } else {
                raiz = nodoMin(nodoActual);
                raiz.setIzquierdo(raiz.getIzquierdo());
            }
        } else {
            if (nodoActual.getContenido() < nodoBorrar.getContenido()) {
                if (nodoActual.getDerecho() != null) {
                    if (nodoActual.getDerecho().getContenido() == nodoBorrar.getContenido()) {
                        Nodo n = nodoMin(nodoActual.getDerecho());
                        n.setDerecho(nodoActual.getDerecho().getDerecho());
                        if (nodoActual.getDerecho().getIzquierdo() != null && n.getContenido() != nodoActual.getDerecho().getIzquierdo().getContenido()) {
                            n.setIzquierdo(nodoActual.getDerecho().getIzquierdo());
                        }
                        nodoActual.setDerecho(n);
                    } else {
                        borrarNodo(nodoActual.getDerecho(), nodoBorrar);
                    }
                }
            } else {
                if (nodoActual.getIzquierdo() != null) {
                    if (nodoActual.getIzquierdo().getContenido() == nodoBorrar.getContenido()) {
                        Nodo n = nodoMax(nodoActual.getIzquierdo());
                        n.setIzquierdo(nodoActual.getIzquierdo().getIzquierdo());
                        if (nodoActual.getIzquierdo().getDerecho() != null && n.getContenido() != nodoActual.getIzquierdo().getDerecho().getContenido()) {
                            n.setDerecho(nodoActual.getIzquierdo().getDerecho());
                        }
                        nodoActual.setIzquierdo(n);
                    } else {
                        borrarNodo(nodoActual.getIzquierdo(), nodoBorrar);
                    }
                }
            }
        }
    }

    private Nodo nodoMin (Nodo nodoActual){
        if (nodoActual.getIzquierdo() != null){
            return nodoMin(nodoActual.getIzquierdo());
        }
        return nodoActual;
    }

    private Nodo nodoMax (Nodo nodoActual){
        if (nodoActual.getDerecho() != null){
            return nodoMax(nodoActual.getDerecho());
        }
        return nodoActual;
    }

    public boolean isEquilibrado(){
        if (raiz != null){
            return this.comprobarEquilibrado(raiz);
        }
        return false;
    }

    private boolean comprobarEquilibrado(Nodo nodoActual){
        if (getAlturaDerecho() == getAlturaIzquierdo() || getAlturaDerecho() == (getAlturaIzquierdo() -1) || getAlturaIzquierdo() == (getAlturaDerecho() -1)){
            return true;
        }
        return false;
    }

    public void equilibrar(){
        if (!isEquilibrado()){
            ListaDoblementeEnlazada<Nodo> nodos = new ListaDoblementeEnlazada<>();
            calcularEquilibrioNodos(raiz);
            equilibrarArbol(raiz, nodos);
        }
    }

    private void equilibrarArbol(Nodo nodoActual, ListaDoblementeEnlazada<Nodo> nodos){
        nodos.add(nodoActual);
        if (nodoActual.getDerecho() != null){
            equilibrarArbol(nodoActual.getDerecho(), nodos);
        } else {
            if (nodoActual.getIzquierdo() != null){
                equilibrarArbol(nodoActual.getIzquierdo(), nodos);
            }
        }
        if (nodoActual.getEquilibrio() > 1){
            if (nodoActual.getDerecho() != null && nodoActual.getIzquierdo() != null){
                rotacionCompuestaIzquierda(nodos);
            } else {
                if (nodoActual.getIzquierdo() != null && nodoActual.getDerecho() == null){
                    rotacionDerecha(nodos);
                } else if (nodoActual.getDerecho() != null && nodoActual.getIzquierdo() == null) {
                    rotacionIzquierda(nodos);
                }
            }
        } else if (nodoActual.getEquilibrio() < -1){
            if (nodoActual.getDerecho() != null && nodoActual.getIzquierdo() != null){
                rotacionCompuestaDerecha(nodos);
            } else {
                if (nodoActual.getIzquierdo() != null && nodoActual.getDerecho() == null){
                    rotacionDerecha(nodos);
                } else if (nodoActual.getDerecho() != null && nodoActual.getIzquierdo() == null) {
                    rotacionIzquierda(nodos);
                }
            }
        }
    }

    private void calcularEquilibrioNodos(Nodo nodoActual){
        nodoActual.setEquilibrio(getAlturaDerecho() - getAlturaIzquierdo());
        if (nodoActual.getIzquierdo() != null){
            calcularEquilibrioNodos(nodoActual.getIzquierdo());
        }
        if (nodoActual.getDerecho() != null) {
            calcularEquilibrioNodos(nodoActual.getDerecho());
        }
    }

    private void rotacionIzquierda(ListaDoblementeEnlazada<Nodo> nodos){
        /*Nodo nodoActual = nodos.get(nodos.getNumeroElementos() -1);
        Nodo n = nodoActual.getDerecho();
        nodoActual.setDerecho(n.getDerecho());
        n.getDerecho().setIzquierdo(n);
        n.setDerecho(null);

        if (nodoActual == raiz){
            raiz = n;
        }*/
    }

    private void rotacionDerecha(ListaDoblementeEnlazada<Nodo> nodos){
        /*Nodo nodoActual = nodos.get(nodos.getNumeroElementos() -1);
        Nodo n = nodoActual.getIzquierdo();
        nodoActual.setIzquierdo(n.getIzquierdo());
        n.getIzquierdo().setDerecho(n);
        n.setIzquierdo(null);

        if (nodoActual == raiz){
            raiz = n;
        }*/
    }

    private void rotacionCompuestaIzquierda(ListaDoblementeEnlazada<Nodo> nodos){
        /*Nodo nodoActual = nodos.get(nodos.getNumeroElementos() -2);
        Nodo n = nodoActual.getIzquierdo().getDerecho().getIzquierdo();
        n.setDerecho(nodoActual.getIzquierdo().getDerecho());
        nodoActual.getIzquierdo().setDerecho(null);
        n.setIzquierdo(nodoActual.getIzquierdo());
        nodoActual.setIzquierdo(n);*/
    }

    private void rotacionCompuestaDerecha(ListaDoblementeEnlazada<Nodo> nodos){
        /*Nodo nodoActual = nodos.get(nodos.getNumeroElementos() -2);
        Nodo n = nodoActual.getDerecho().getIzquierdo().getDerecho();
        n.setIzquierdo(nodoActual.getDerecho().getIzquierdo());
        nodoActual.getDerecho().setIzquierdo(null);
        n.setDerecho(nodoActual.getDerecho());
        nodoActual.setDerecho(n);*/
    }

    public Nodo getRaiz(){ return raiz;}

    public void setRaiz(Nodo raiz){
        this.raiz = raiz;
    }

    public ListaDoblementeEnlazada<Nodo> getListaDatosNivel(int nivel){
        this.nodos = new ListaDoblementeEnlazada<>();

        if (this.raiz != null){
            this.getNodosNivel(nivel, this.raiz, 0);
        }

        return this.nodos;
    }

    private void getNodosNivel(int nivel, Nodo nodoActual, int nivelActual){

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

    private boolean comprobarHomogeneo(Nodo nodoActual){
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

    private boolean comprobarCompleto(Nodo nodoActual, int nivel){
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

    private boolean comprobarCasiCompleto(Nodo nodoActual, int nivel){
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

    public ListaDoblementeEnlazada<Nodo> getCamino(int valorBuscar){
        /*this.nodos = new ListaDoblementeEnlazada<>();
        if (this.raiz != null){
            this.getNodosCamino(valorBuscar, raiz);
            int ultimoValor = this.nodos.get(this.nodos.getNumeroElementos() -1).getContenido();
            if (valorBuscar != ultimoValor){
                this.nodos = new ListaDoblementeEnlazada<>();
            }
        }
        return this.nodos;*/
        return null;
    }

    private void getNodosCamino(int valorBuscar, Nodo nodoActual){
        this.nodos.add(nodoActual);
        Nodo nodoBuscar = new Nodo(valorBuscar);

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

    public ArbolAVLDeBusqueda getSubArbol(Nodo nodoBuscar, String lado){
        if(raiz != null){
            Nodo nodoEncontrado = this.buscarNodo(nodoBuscar, this.raiz);
            if(nodoEncontrado != null){
                ArbolAVLDeBusqueda abb = new ArbolAVLDeBusqueda();
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

    private Nodo buscarNodo(Nodo nodoBuscar, Nodo nodoActual){
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

    public ListaDoblementeEnlazada<Nodo> getListaPreOrden(){
        this.nodos = new ListaDoblementeEnlazada<>();
        if (this.raiz != null) {
            this.getNodosPreOrden(raiz);
        }
        return this.nodos;
    }

    private void getNodosPreOrden(Nodo nodoActual){
        this.nodos.add(nodoActual);

        if (nodoActual.getIzquierdo() != null){
            this.getNodosPreOrden(nodoActual.getIzquierdo());
        }

        if (nodoActual.getDerecho() != null){
            this.getNodosPreOrden(nodoActual.getDerecho());
        }
    }

    public ListaDoblementeEnlazada<Nodo> getListaPostOrden(){
        this.nodos = new ListaDoblementeEnlazada<>();
        if (this.raiz != null) {
            this.getNodosPostOrden(raiz);
        }
        return this.nodos;
    }

    private void getNodosPostOrden(Nodo nodoActual){
        if (nodoActual.getIzquierdo() != null){
            this.getNodosPostOrden(nodoActual.getIzquierdo());
        }
        if (nodoActual.getDerecho() != null){
            this.getNodosPostOrden(nodoActual.getDerecho());
        }

        this.nodos.add(nodoActual);
    }

    public ListaDoblementeEnlazada<Nodo> getListaOrdenCentral(){
        this.nodos = new ListaDoblementeEnlazada<>();
        if (this.raiz != null) {
            this.getNodosOrdenCentral(raiz);
        }
        return this.nodos;
    }

    private void getNodosOrdenCentral(Nodo nodoActual){
        if (nodoActual.getIzquierdo() != null){
            this.getNodosPreOrden(nodoActual.getIzquierdo());
        }
        this.nodos.add(nodoActual);

        if (nodoActual.getDerecho() != null){
            this.getNodosPreOrden(nodoActual.getDerecho());
        }
    }
}
