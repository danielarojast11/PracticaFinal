package org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada;

public class ElementoLE {
    private ElementoLE siguiente;
    private Object data;

    public ElementoLE(Object valor){
        this.data = valor;
    }

    protected void insertarmeEn(ElementoLE el){
        this.siguiente = el;
    }

    protected ElementoLE getSiguiente(){
        return siguiente;
    }

    public Object getData(){
        return data;
    }

    public Object setData(Object o){
        data = o;
        return data;
    }
}
