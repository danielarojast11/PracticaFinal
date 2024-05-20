package org.example.practicafinal.Clases.Entorno;

import com.google.gson.JsonObject;
import org.example.practicafinal.Clases.Tablero.Casilla;
import org.jetbrains.annotations.NotNull;

public class Elementos implements Comparable<Elementos>{

    private int tiempoActividad;
    private Casilla casilla = new Casilla();
    protected int type;

    public Elementos(int tiempoActividad, int type) {
        this.tiempoActividad = tiempoActividad;
        this.type = type;
    }

    public Elementos() {
    }

    public void fromJson(JsonObject jsonObject) {
        this.tiempoActividad = jsonObject.get("tiempoActividad").getAsInt();
        this.type = jsonObject.get("type").getAsInt();
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("tiempoActividad", this.tiempoActividad);
        jsonObject.addProperty("type", this.type);
        return jsonObject;
    }

    public int getTiempoActividad() {
        return tiempoActividad;
    }

    public void setTiempoActividad(int tiempoActividad) {
        this.tiempoActividad = tiempoActividad;
    }

    public Casilla getCasilla(){
        return casilla;
    }

    public void setCasilla(int columna, int fila){
        this.casilla = new Casilla(columna,fila);
    }

    public void setCasilla(Casilla casilla){
        this.casilla = casilla;
    }

    public int getType(){
        return type;
    }

    @Override
    public int compareTo(@NotNull Elementos o) {
        return 0;
    }
}
