package org.example.practicafinal.Entity;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.example.practicafinal.Controller.EscenarioJugarController;
import org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada.ListaDoblementeEnlazada;
import org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada.ElementoLE;
import org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada.ListaEnlazada;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Partida {
    private static final Logger log = LogManager.getLogger(Partida.class);
    private int probabilidadZ = 40;
    private int probabilidadEjecucionReproduccion = 75;
    private int probabilidadEjecucionClonacion = 75;
    private int id = 0;
    private int maxIndividuos = 3;
    private int maxElementos = 3;
    private int turno = 0;

    private int turnosVida;
    private int probClonacion;
    private int probReproduccion;
    private int numeroIndividuosBasicos;
    private int numeroIndividuosNormal;
    private int numeroIndividuosAvanzados;
    private int agua;
    private int comida;
    private int montana;
    private int cofre;
    private int biblioteca;
    private int pozo;
    private int tiempoActividad;
    private int columnas;
    private int filas;

    private ListaEnlazada<Casilla> listaCasillas = new ListaEnlazada<>();
    private ListaEnlazada<Individuo> listaIndividuos = new ListaEnlazada<>();

    public Partida(
            int turnosVida,
            int probClonacion,
            int probReproduccion,
            int numeroIndividuosBasicos,
            int numeroIndividuosNormal,
            int numeroIndividuosAvanzados,

            int agua,
            int comida,
            int montana,
            int cofre,
            int biblioteca,
            int pozo,
            int tiempoActividad,
            int columnas,
            int filas
    ) {
        this.turnosVida = turnosVida;
        this.probClonacion = probClonacion;
        this.probReproduccion = probReproduccion;
        this.numeroIndividuosBasicos = numeroIndividuosBasicos;
        this.numeroIndividuosNormal = numeroIndividuosNormal;
        this.numeroIndividuosAvanzados = numeroIndividuosAvanzados;
        this.agua = agua;
        this.comida = comida;
        this.montana = montana;
        this.cofre = cofre;
        this.biblioteca = biblioteca;
        this.pozo = pozo;
        this.tiempoActividad = tiempoActividad;
        this.columnas = columnas;
        this.filas = filas;
        log.info("Partida creada");
    }

    public void aumentarid() {
        this.id++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxIndividuos(){
        return this.maxIndividuos;
    }

    public void setMaxIndividuos(int maxIndividuos) {
        this.maxIndividuos = maxIndividuos;
    }

    public int getMaxElementos() {
        return maxElementos;
    }

    public void setMaxElementos(int maxElementos) {
        this.maxElementos = maxElementos;
    }

    public void setColumnas(int columnas) { this.columnas = columnas; }

    public int getColumnas() { return this.columnas; }

    public void setFilas(int filas) { this.filas = filas; }

    public int getFilas() { return this.filas; }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getTurnosVida() {
        return turnosVida;
    }

    public void setTurnosVida(int turnosVida) {
        this.turnosVida = turnosVida;
    }

    public int getProbClonacion() {
        return probClonacion;
    }

    public void setProbClonacion(int probClonacion) {
        this.probClonacion = probClonacion;
    }

    public int getProbReproduccion() {
        return probReproduccion;
    }

    public void setProbReproduccion(int probReproduccion) {
        this.probReproduccion = probReproduccion;
    }

    public ListaEnlazada<Casilla> getListaCasillas(){
        return this.listaCasillas;
    }

    public ListaEnlazada<Individuo> getListaIndividuos() {
        return listaIndividuos;
    }

    public void setListaIndividuos(ListaEnlazada<Individuo> listaIndividuos) {
        this.listaIndividuos = listaIndividuos;
    }

    public void addIndividuo(Individuo individuo) {
        this.listaIndividuos.add(individuo);
    }

    public void aumentarTurno(){
        this.turno++;
    }

    public Casilla moverBasico(){
        log.info("Ejecutando MoverBasico");
        int posicion = (int) (Math.random() * listaCasillas.getNumeroElementos());
        ElementoLE pos = listaCasillas.getElemento(posicion);
        if (pos == null) {
            return moverBasico();
        } else {
            return (Casilla) pos.getData();
        }
    }

    public Casilla moverNormal(Casilla casilla){
        log.info("Ejecutando MoverNormal");
        ListaEnlazada<Casilla> casillasSeleccionables = new ListaEnlazada<>();
        ElementoLE<Casilla> posicionActual = this.listaCasillas.getPrimero();
        while (posicionActual != null) {
            Casilla casillaActual = posicionActual.getData();
            if (
                    (
                            casillaActual.getFila() == casilla.getFila() ||
                                    casillaActual.getColumna() == casilla.getColumna()
                    ) &&
                    casillaActual.getElementos().getNumeroElementos() > 0
            ) {
                casillasSeleccionables.add(casillaActual);
            }

            posicionActual = posicionActual.getSiguiente();
        }

        int posicion = (int)(Math.random() * casillasSeleccionables.getNumeroElementos());
        Casilla casillaDestino = casilla;
        if (casillasSeleccionables.getElemento(posicion) != null) {
            casillaDestino = casillasSeleccionables.getElemento(posicion).getData();
        }
        return casillaDestino;
    }

    public Casilla moverAvanzado(Casilla casilla){
        log.info("Ejecutando MoverAvanzado");
        int distancia = 1000;
        Casilla casillaDestino = null;
        ElementoLE<Casilla> posicionActual = this.listaCasillas.getPrimero();
        while (posicionActual != null) {
            // Distancia de Chebyshov
            int d2 = Math.max(
                    Math.abs(casilla.getFila() - posicionActual.getData().getFila()),
                    Math.abs(casilla.getColumna() - posicionActual.getData().getColumna())
            );
            if ((distancia > d2) &&  (d2 > 0)) {
                distancia = d2;
                casillaDestino = posicionActual.getData();
            }

            posicionActual = posicionActual.getSiguiente();
        }

        return casillaDestino;
    }

    public int getProbabilidadZ() {
        return probabilidadZ;
    }

    public void setProbabilidadZ(int probabilidadZ) {
        this.probabilidadZ = probabilidadZ;
    }

    public Individuo colocarIndividuo(Casilla casilla, int rango) {
        log.info("Ejecutando ColocarIndividuo");
        aumentarid();
        Individuo in = new Individuo(
                id,
                turno,
                turnosVida,
                probReproduccion,
                probClonacion,
                rango,
                casilla
        );
        casilla.addIndividuo(in);
        addIndividuo(in);
        return in;
    }

    public int getProbabilidadEjecucionReproduccion() {
        return probabilidadEjecucionReproduccion;
    }

    public void setProbabilidadEjecucionReproduccion(int probabilidadEjecucionReproduccion) {
        this.probabilidadEjecucionReproduccion = probabilidadEjecucionReproduccion;
    }

    public int getProbabilidadEjecucionClonacion() {
        return probabilidadEjecucionClonacion;
    }

    public void setProbabilidadEjecucionClonacion(int probabilidadEjecucionClonacion) {
        this.probabilidadEjecucionClonacion = probabilidadEjecucionClonacion;
    }

    public int getNumIndividuos() {
        int numIndividuos = 0;
        ElementoLE casillaActual = listaCasillas.getPrimero();
        while (casillaActual != null) {
            Casilla casilla = (Casilla) casillaActual.getData();
            numIndividuos += casilla.getIndividuos().getNumeroElementos();

            casillaActual = casillaActual.getSiguiente();
        }

        return numIndividuos;
    }

    public void fromJson(JsonObject jsonObject) {
        this.probabilidadZ = jsonObject.get("probabilidadZ").getAsInt();
        this.probabilidadEjecucionReproduccion = jsonObject.get("probabilidadEjecucionReproduccion").getAsInt();
        this.probabilidadEjecucionClonacion = jsonObject.get("probabilidadEjecucionClonacion").getAsInt();
        this.id = jsonObject.get("id").getAsInt();
        this.maxIndividuos = jsonObject.get("maxIndividuos").getAsInt();
        this.maxElementos = jsonObject.get("maxElementos").getAsInt();
        this.turno = jsonObject.get("turno").getAsInt();
        this.probClonacion = jsonObject.get("probClonacion").getAsInt();
        this.probReproduccion = jsonObject.get("probReproduccion").getAsInt();
        this.turnosVida = jsonObject.get("turnosVida").getAsInt();
        this.numeroIndividuosBasicos = jsonObject.get("numeroIndividuosBasicos").getAsInt();
        this.numeroIndividuosNormal = jsonObject.get("numeroIndividuosNormal").getAsInt();
        this.numeroIndividuosAvanzados = jsonObject.get("numeroIndividuosAvanzados").getAsInt();
        this.agua = jsonObject.get("agua").getAsInt();
        this.comida = jsonObject.get("comida").getAsInt();
        this.montana = jsonObject.get("montana").getAsInt();
        this.cofre = jsonObject.get("cofre").getAsInt();
        this.biblioteca = jsonObject.get("biblioteca").getAsInt();
        this.pozo = jsonObject.get("pozo").getAsInt();
        this.tiempoActividad = jsonObject.get("tiempoActividad").getAsInt();
        this.columnas = jsonObject.get("columnas").getAsInt();
        this.filas = jsonObject.get("filas").getAsInt();

        JsonArray datos = jsonObject.getAsJsonArray("listaCasillas");
        this.listaCasillas = new ListaEnlazada<>();
        for (int i = 0; i < datos.size(); i++) {
            Casilla casilla = new Casilla();
            casilla.fromJson(datos.get(i).getAsJsonObject());
            this.listaCasillas.add(casilla);
        }

        datos = jsonObject.getAsJsonArray("listaIndividuos");
        this.listaIndividuos = new ListaEnlazada<>();
        for (int i = 0; i < datos.size(); i++) {
            Individuo individuo = new Individuo();
            individuo.fromJson(datos.get(i).getAsJsonObject());
            this.listaIndividuos.add(individuo);
        }
        log.info("fromJson");
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("probabilidadZ", this.probabilidadZ);
        jsonObject.addProperty("probabilidadEjecucionReproduccion", this.probabilidadEjecucionReproduccion);
        jsonObject.addProperty("probabilidadEjecucionClonacion", this.probabilidadEjecucionClonacion);
        jsonObject.addProperty("id", this.id);
        jsonObject.addProperty("maxIndividuos", this.id);
        jsonObject.addProperty("maxElementos", this.id);
        jsonObject.addProperty("turno", this.turno);
        jsonObject.addProperty("probClonacion", this.probClonacion);
        jsonObject.addProperty("probReproduccion", this.probReproduccion);
        jsonObject.addProperty("turnosVida", this.turnosVida);
        jsonObject.addProperty("numeroIndividuosBasicos", this.numeroIndividuosBasicos);
        jsonObject.addProperty("numeroIndividuosNormal", this.numeroIndividuosNormal);
        jsonObject.addProperty("numeroIndividuosAvanzados", this.numeroIndividuosAvanzados);
        jsonObject.addProperty("agua", this.agua);
        jsonObject.addProperty("comida", this.comida);
        jsonObject.addProperty("montana", this.montana);
        jsonObject.addProperty("cofre", this. cofre);
        jsonObject.addProperty("biblioteca", this.biblioteca);
        jsonObject.addProperty("pozo", this.pozo);
        jsonObject.addProperty("tiempoActividad", this.tiempoActividad);
        jsonObject.addProperty("columnas", this.columnas);
        jsonObject.addProperty("filas", this.filas);

        JsonArray jsonArrayCasillas = new JsonArray();
        ElementoLE elementoLE = this.listaCasillas.getPrimero();
        while (elementoLE != null) {
            Casilla casilla = (Casilla) elementoLE.getData();
            jsonArrayCasillas.add(casilla.toJson());
            elementoLE = elementoLE.getSiguiente();
        }
        jsonObject.add("listaCasillas", jsonArrayCasillas);

        JsonArray jsonArrayIndividuos = new JsonArray();
        elementoLE = this.listaIndividuos.getPrimero();
        while (elementoLE != null) {
            Individuo individuo = (Individuo) elementoLE.getData();
            jsonArrayIndividuos.add(individuo.toJson());
            elementoLE = elementoLE.getSiguiente();
        }
        jsonObject.add("listaIndividuos", jsonArrayIndividuos);
        log.info("toJson");

        return jsonObject;
    }

    public int getNumeroIndividuosBasicos() {
        return numeroIndividuosBasicos;
    }

    public void setNumeroIndividuosBasicos(int numeroIndividuosBasicos) {
        this.numeroIndividuosBasicos = numeroIndividuosBasicos;
    }

    public int getNumeroIndividuosNormal() {
        return numeroIndividuosNormal;
    }

    public void setNumeroIndividuosNormal(int numeroIndividuosNormal) {
        this.numeroIndividuosNormal = numeroIndividuosNormal;
    }

    public int getNumeroIndividuosAvanzados() {
        return numeroIndividuosAvanzados;
    }

    public void setNumeroIndividuosAvanzados(int numeroIndividuosAvanzados) {
        this.numeroIndividuosAvanzados = numeroIndividuosAvanzados;
    }

    //GETTERS AND SETTERS ELEMENTS

    public int getAgua() {
        return agua;
    }

    public void setAgua(int agua) {
        this.agua = agua;
    }

    public int getComida() {
        return comida;
    }

    public void setComida(int comida) {
        this.comida = comida;
    }

    public int getMontana() {
        return montana;
    }

    public void setMontana(int montana) {
        this.montana = montana;
    }

    public int getCofre() {
        return cofre;
    }

    public void setCofre(int cofre) {
        this.cofre = cofre;
    }

    public int getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(int biblioteca) {
        this.biblioteca = biblioteca;
    }

    public int getPozo() {
        return pozo;
    }

    public void setPozo(int pozo) {
        this.pozo = pozo;
    }

    public int getTiempoActividad() {
        return tiempoActividad;
    }

        //MODIFY PARAMETERS
    public void modificarId(){
         this.setId(id+1);
        }

    public int filaAleatoria(){
        int fila = (int) (Math.random()*this.filas);
        return fila;
    }

    public int columnaAleatoria(){
        int columna = (int) (Math.random()*this.columnas);
        return columna;
    }

    public Casilla casillaAleatoria(){
        return new Casilla(columnaAleatoria(),filaAleatoria());
    }
}
