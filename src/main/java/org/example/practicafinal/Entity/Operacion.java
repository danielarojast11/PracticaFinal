package org.example.practicafinal.Entity;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada.ElementoLE;
import org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada.ListaEnlazada;

public class Operacion {
    private int turno;
    private String descripcion;
    /**
     * 0 - Nacimiento
     * 1 - Cambio casilla
     * 2 - Muerte
     * 3 - Agua
     * 4 - Comida
     * 5 - Montaña
     * 6 - Tesoro
     * 7 - Biblioteca
     * 8 - Pozo
     * 9 - Mutación
     * 10 - Reproducción
     * 11 - Movimiento
     * 12 - Turnos Vida
     */
    private int tipo;

    public Operacion()
    { }

    public Operacion(String descripcion, int turno, int tipo){
        this.descripcion = descripcion;
        this.turno = turno;
        this.tipo = tipo;
    }

    public void fromJson(JsonObject jsonObject) {
        this.turno = jsonObject.get("turno").getAsInt();
        this.descripcion = jsonObject.get("descripcion").getAsString();
        this.tipo = jsonObject.get("tipo").getAsInt();
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("turno", this.turno);
        jsonObject.addProperty("descripcion", this.descripcion);
        jsonObject.addProperty("tipo", this.tipo);

        return jsonObject;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public int getTurno(){
        return turno;
    }

    public int getTipo(){
        return tipo;
    }
}
