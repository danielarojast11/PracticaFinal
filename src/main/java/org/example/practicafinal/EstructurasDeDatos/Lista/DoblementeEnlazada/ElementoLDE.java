package org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada;

public class ElementoLDE<TipoDato> {
    private ElementoLDE<TipoDato> anterior;
    private ElementoLDE<TipoDato> siguiente;
    private Object data;

    protected void insertarmeEn (ElementoLDE<TipoDato> el){
        el.siguiente = this.siguiente;
        this.siguiente = el;
        el.anterior = this;
    }

    protected ElementoLDE<TipoDato> getSiguiente(){
        return this.siguiente;
    }

    protected ElementoLDE<TipoDato> getAnterior(){
        return this.anterior;
    }

    public Object getData(){
        return data;
    }

    public Object setData(Object o){
        this.data = o;
        return data;
    }
}
