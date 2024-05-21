package org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada;

public class ElementoLDE {
    private ElementoLDE anterior;
    private ElementoLDE siguiente;
    private Object data;

    protected void insertarmeEn (ElementoLDE el){
        el.siguiente = this.siguiente;
        this.siguiente = el;
        el.anterior = this;
    }

    protected ElementoLDE getSiguiente(){
        return this.siguiente;
    }

    protected ElementoLDE getAnterior(){
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
