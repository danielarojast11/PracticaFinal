package org.example.practicafinal.EstructurasDeDatos.Lista.Simple;

public class ElementoLS<TipoDato> {
    private TipoDato data;

    public TipoDato getData() {
        return data;
    }

    public TipoDato setData(TipoDato data) {
        this.data = data;
        return data;
    }
}
