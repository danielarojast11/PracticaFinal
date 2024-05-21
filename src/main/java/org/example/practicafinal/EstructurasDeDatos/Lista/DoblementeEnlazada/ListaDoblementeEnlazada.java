package org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada;

public class ListaDoblementeEnlazada {
    private ElementoLDE primero;
    private ElementoLDE ultimo;

    public boolean isVacia(){
        if (primero == null){
            return true;
        }
        return false;
    }

    public void vaciar(){
        primero = null;
    }

    protected int add (ElementoLDE el){
        if (primero == null){
            primero = el;
        }
        else{
            ultimo.insertarmeEn(el);
        }
        ultimo = el;
        ElementoLDE posicion = primero;
        int contador = 0;
        while (posicion.getSiguiente() != null){
            contador ++;
            posicion = posicion.getSiguiente();
        }
        return contador;
    }

    public void add (String s){
        ElementoLDE elementoLDE = new ElementoLDE();
        elementoLDE.setData(s);
        this.add(elementoLDE);
    }

    public void add (Object o){
        ElementoLDE elementoLDE = new ElementoLDE();
        elementoLDE.setData(o);
        this.add(elementoLDE);
    }

    public void insert (String s, int posicion){
        ElementoLDE elementoLDE = new ElementoLDE();
        elementoLDE.setData(s);
        int contador = 0;
        ElementoLDE actual = primero;
        if (actual == null){
            primero = elementoLDE;
            ultimo = elementoLDE;
        }
        else {
            while (contador < posicion){

                actual = actual.getSiguiente();
                contador ++;
            }
            actual.insertarmeEn(elementoLDE);
        }
    }

    public void insert(Object o, int posicion){
        ElementoLDE elementoLDE = new ElementoLDE();
        elementoLDE.setData(o);
        int contador = 0;
        ElementoLDE actual = primero;
        if (actual == null){
            primero = elementoLDE;
            ultimo = elementoLDE;
        }
        else{
            while (contador < posicion){
                actual = actual.getSiguiente();
                contador ++;
            }
            actual.insertarmeEn(elementoLDE);
        }
    }

    public int del (int posicion){
        ElementoLDE actual = primero;
        int contador = 0;
        if (actual == null){
            primero = actual;
            ultimo = actual;
        }
        else{
            while (contador < posicion){
                actual = actual.getSiguiente();
                contador ++;
            }
            ElementoLDE p = primero;
            contador = 0;
            if (actual == p){
                primero = p.getSiguiente();
                contador ++;
            }
            while (p.getSiguiente() != null){
                if (p.getSiguiente() != actual){
                    p.insertarmeEn(p);
                    contador ++;
                }
            }
        }
        return contador;
    }

    public int getNumeroElementos(){
        ElementoLDE posicion = primero;
        int contador = 0 ;
        if (primero != null){
            while (posicion.getSiguiente() != ultimo){
                contador ++;
            }
        }
        return contador;
    }

    public int getPosicion(ElementoLDE el){
        ElementoLDE posicion = primero;
        int contador = 1;
        while (posicion != null){
            if (posicion == el){
                return contador;
            }
            contador ++;
            posicion = posicion.getSiguiente();
        }
        return 0;
    }

    public ElementoLDE getPrimero(){
        return this.primero;

    }

    public ElementoLDE getUltimo(){
        return this.ultimo;

    }

    public ElementoLDE getSiguiente(ElementoLDE el){
        return el.getSiguiente();
    }

    public ElementoLDE getAnterior(ElementoLDE el){
        return el.getAnterior();
    }

    public ElementoLDE getElemento(int posicion){
        ElementoLDE actual = primero;
        int contador = 0;
        if (actual == null){
            primero = actual;
            ultimo = actual;
        }
        else{
            while (contador < posicion){
                actual = actual.getSiguiente();
                contador ++;
            }
        }
        return actual;
    }
}
