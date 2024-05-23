package org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada;

public class ListaDoblementeEnlazada<TipoDato> {
    private ElementoLDE<TipoDato> primero;
    private ElementoLDE<TipoDato> ultimo;

    public boolean isVacia(){
        if (primero == null){
            return true;
        }
        return false;
    }

    public void vaciar(){
        primero = null;
    }

    protected int add (ElementoLDE<TipoDato> el){
        if (primero == null){
            primero = el;
        }
        else{
            ultimo.insertarmeEn(el);
        }
        ultimo = el;
        ElementoLDE<TipoDato> posicion = primero;
        int contador = 0;
        while (posicion.getSiguiente() != null){
            contador ++;
            posicion = posicion.getSiguiente();
        }
        return contador;
    }

    public void add (String s){
        ElementoLDE<TipoDato> elementoLDE = new ElementoLDE<>();
        /*elementoLDE.setData(s);
        this.add(elementoLDE);*/
    }

    public void add (Object o){
        /*ElementoLDE<TipoDato> elementoLDE = new ElementoLDE<>();
        elementoLDE.setData(o);
        this.add(elementoLDE);*/
    }

    public void insert (String s, int posicion){
        /*ElementoLDE<TipoDato> elementoLDE = new ElementoLDE<>();
        elementoLDE.setData(s);
        int contador = 0;
        ElementoLDE<TipoDato> actual = primero;
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
        }*/
    }

    public void insert(Object o, int posicion){
        ElementoLDE<TipoDato> elementoLDE = new ElementoLDE<>();
        /*elementoLDE.setData(o);
        int contador = 0;
        ElementoLDE<TipoDato> actual = primero;
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
        }*/
    }

    public int del (int posicion){
        ElementoLDE<TipoDato> actual = primero;
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
            ElementoLDE<TipoDato> p = primero;
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
        ElementoLDE<TipoDato> posicion = primero;
        int contador = 0 ;
        if (primero != null){
            while (posicion.getSiguiente() != ultimo){
                contador ++;
            }
        }
        return contador;
    }

    public int getPosicion(ElementoLDE<TipoDato> el){
        ElementoLDE<TipoDato> posicion = primero;
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

    public ElementoLDE<TipoDato> getPrimero(){
        return this.primero;

    }

    public ElementoLDE<TipoDato> getUltimo(){
        return this.ultimo;

    }

    public ElementoLDE<TipoDato> getSiguiente(ElementoLDE<TipoDato> el){
        return el.getSiguiente();
    }

    public ElementoLDE<TipoDato> getAnterior(ElementoLDE<TipoDato> el){
        return el.getAnterior();
    }

    public ElementoLDE<TipoDato> getElemento(int posicion){
        ElementoLDE<TipoDato> actual = primero;
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
