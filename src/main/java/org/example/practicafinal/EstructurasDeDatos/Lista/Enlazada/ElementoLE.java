package org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada;

public class ElementoLE<TipoDato> {
    private ElementoLE<TipoDato> siguiente;
    private TipoDato data;

    public ElementoLE(TipoDato valor){
        this.data = valor;
    }

    protected void insertarmeEn(ElementoLE<TipoDato> el){
        this.siguiente = el;
    }

    protected ElementoLE<TipoDato> getSiguiente(){
        return siguiente;
    }

    public TipoDato getData(){
        return data;
    }

    public TipoDato setData(TipoDato o){
        data = o;
        return data;
    }
}
