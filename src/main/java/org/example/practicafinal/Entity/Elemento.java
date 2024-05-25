package org.example.practicafinal.Entity;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;

public class Elemento implements Comparable<Elemento>
{
    private int tiempoActividad;
    private Casilla casilla;
    private int alteracion;
    private int probabilidad;

    public Elemento(){}

    public Elemento(int tiempoActividad, Casilla casilla) {
        this.tiempoActividad = tiempoActividad;
        this.casilla = casilla;
    }

    public void fromJson(JsonObject jsonObject) {
        this.tiempoActividad = jsonObject.get("tiempoActividad").getAsInt();
        this.alteracion = jsonObject.get("alteracion").getAsInt();
        this.probabilidad = jsonObject.get("tipo").getAsInt();
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("tiempoActividad", this.tiempoActividad);
        jsonObject.addProperty("alteracion", this.alteracion);
        jsonObject.addProperty("probabilidad", this.probabilidad);

        return jsonObject;
    }

    public int getTiempoActividad() {
        return tiempoActividad;
    }

    public void setTiempoActividad(int tiempoActividad) {
        this.tiempoActividad = tiempoActividad;
    }

    public void reducirTiempoActividad() {
        tiempoActividad--;
    }

    public Casilla getCasilla(){
        return casilla;
    }

    public void setCasilla(Casilla casilla){
        this.casilla = casilla;
    }

    public int getAlteracion() {
        return alteracion;
    }

    public void setAlteracion(int alteracion) {
        this.alteracion = alteracion;
    }

    public int getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(int probabilidad) {
        this.probabilidad = probabilidad;
    }

    @Override
    public int compareTo(@NotNull Elemento o) {
        return 0;
    }
}
