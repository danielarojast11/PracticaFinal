package org.example.practicafinal.EstructurasDeDatos.Lista.Simple;

public class ElementoLS {
    private Object data;
    private ElementoLS siguiente;

    public Object getData() {
        return data;
    }

    public Object setData(Object o) {
        this.data = o;
        return data;
    }
}
