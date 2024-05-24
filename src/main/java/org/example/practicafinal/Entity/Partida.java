package org.example.practicafinal.Entity;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada.ListaDoblementeEnlazada;
import org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada.ElementoLE;
import org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada.ListaEnlazada;

import java.util.Objects;

public class Partida {
    private int probabilidadZ = 40;
    private int probanilidadEjecucionReproduccion = 75;
    private int probanilidadEjecucionClonacion = 75;
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

    public void addIndividuo(Individuo individuo) {
        this.listaIndividuos.add(individuo);
    }

    public void aumentarTurno(){
        this.turno++;
    }

    public Casilla moverBasico(){
        int posicion = (int) (Math.random() * listaCasillas.getNumeroElementos());
        return listaCasillas.getElemento(posicion).getData();
    }

    public Casilla moverNormal(Casilla casilla){
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

        Casilla nuevaCasilla;
        int posicion = (int)(Math.random() * casillasSeleccionables.getNumeroElementos());
        return casillasSeleccionables.getElemento(posicion).getData();
    }

    public Casilla moverAvanzado(Casilla casilla){
        int distancia = 1000;
        Casilla casillaDestino = null;
        ElementoLE<Casilla> posicionActual = this.listaCasillas.getPrimero();
        while (posicionActual != null) {
            // Distancia de Chebyshov
            int d2 = Math.max(
                    Math.abs(casilla.getFila() - posicionActual.getData().getFila()),
                    Math.abs(casilla.getColumna() - posicionActual.getData().getColumna())
            );
            if (distancia > d2) {
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

    public int getProbanilidadEjecucionReproduccion() {
        return probanilidadEjecucionReproduccion;
    }

    public void setProbanilidadEjecucionReproduccion(int probanilidadEjecucionReproduccion) {
        this.probanilidadEjecucionReproduccion = probanilidadEjecucionReproduccion;
    }

    public int getProbanilidadEjecucionClonacion() {
        return probanilidadEjecucionClonacion;
    }

    public void setProbanilidadEjecucionClonacion(int probanilidadEjecucionClonacion) {
        this.probanilidadEjecucionClonacion = probanilidadEjecucionClonacion;
    }




    public void fromJson(JsonObject jsonObject) {
        this.turno = jsonObject.get("turno").getAsInt();
        this.probReproduccion = jsonObject.get("probReproduccion").getAsInt();
        this.probClonacion = jsonObject.get("probClonacion").getAsInt();
        this.id = jsonObject.get("id").getAsInt();
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
        /*this.maximosIndividuos = jsonObject.get("maximosIndividuos").getAsInt();

        JsonArray datos = jsonObject.getAsJsonArray("listaIndividuos");
        this.listaIndividuos.clear();
        for (int i = 0; i < datos.size(); i++) {
            Individuo individuo = new Individuo();
            individuo.fromJson(datos.get(i).getAsJsonObject());
            this.listaIndividuos.add(individuo);
        }

        datos = jsonObject.getAsJsonArray("listaCasillas");
        this.listaCasillas.clear();
        for (int i = 0; i < datos.size(); i++) {
            Casilla casilla = new Casilla();
            casilla.fromJson(datos.get(i).getAsJsonObject());
            this.listaCasillas.add(casilla);
        }

        datos = jsonObject.getAsJsonArray("listaElementos");
        this.listaElementos.clear();
        for (int i = 0; i < datos.size(); i++) {
            Elemento elemento = new Elemento();
            elemento.fromJson(datos.get(i).getAsJsonObject());
            this.listaElementos.add(elemento);
        }*/
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("turno", this.turno);
        jsonObject.addProperty("probReproduccion", this.probReproduccion);
        jsonObject.addProperty("probClonacion", this.probClonacion);
        jsonObject.addProperty("id", this.id);
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
        /*jsonObject.addProperty("maximosIndividuos", this.maximosIndividuos);

        JsonArray jsonArrayIndividuos = new JsonArray();
        for (Individuo i: this.listaIndividuos) {
            jsonArrayIndividuos.add(i.toJson());
        }
        jsonObject.add("listaIndividuos", jsonArrayIndividuos);

        JsonArray jsonArrayCasillas = new JsonArray();
        for (Casilla c: this.listaCasillas) {
            jsonArrayCasillas.add(c.toJson());
        }
        jsonObject.add("listaCasillas", jsonArrayCasillas);


        JsonArray jsonArrayElementos = new JsonArray();
        for (Elemento e: this.listaElementos) {
            jsonArrayElementos.add(e.toJson());
        }
        jsonObject.add("listaElementos", jsonArrayElementos);*/

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

    public void removeIndividuo(Individuo individuo) {
        //this.listaIndividuos.remove(individuo);
    }

    public void removeIndividuo(int index) {
        //this.listaIndividuos.remove(index);
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

        //GETTERS AND SETTERS PLACEHOLDERS


    //public void setListaCasillas(ListaDoblementeEnlazada<Casilla> listaCasillas){
        //this.listaCasillas = listaCasillas;
    //}



        //CREATE INDIVIDUALS
    /*public IndividuoBasico crearBasico(ListaDoblementeEnlazada<Individuo> listaIndividuos){
        IndividuoBasico basico = new IndividuoBasico(id, turno, turnosVida, probReproduccion, probClonacion);
        modificarId();
        listaIndividuos.add(basico);
        Casilla casilla = casillaAleatoria();
        basico.setCasilla(casilla);
        for (Casilla casilla1 : listaCasillas){
            if (Objects.equals(casilla1.getId(), casilla.getId())){
                casilla1.addIndividuoCasilla(basico);
            }
        }
        return basico;
    }

    public IndividuoNormal crearNormal(ListaDoblementeEnlazada<Individuo> listaIndividuos){
        IndividuoNormal normal = new IndividuoNormal(id, turno, turnosVida, probReproduccion, probClonacion);
        modificarId();
        listaIndividuos.add(normal);
        Casilla casilla = casillaAleatoria();
        normal.setCasilla(casilla);
        for (Casilla casilla1 : listaCasillas){
            if (Objects.equals(casilla1.getId(), casilla.getId())){
                casilla1.addIndividuoCasilla(normal);
            }
        }
        return normal;
    }

    public IndividuoAvanzado crearAvanzado(ListaDoblementeEnlazada<Individuo> listaIndividuos){
        IndividuoAvanzado avanzado = new IndividuoAvanzado(id, turno, turnosVida, probReproduccion, probClonacion);
        modificarId();
        listaIndividuos.add(avanzado);
        Casilla casilla = casillaAleatoria();
        avanzado.setCasilla(casilla);
        for (Casilla casilla1 : listaCasillas){
            if (Objects.equals(casilla1.getId(), casilla.getId())){
                casilla1.addIndividuoCasilla(avanzado);
            }
        }
        return avanzado;
    }

        //CREATE ELEMENTS
    public Agua crearAgua(){
        Agua agua = new Agua();
        Casilla casilla = casillaAleatoria();
        for (Casilla casilla1 : listaCasillas){
            if (Objects.equals(casilla1.getId(), casilla.getId())&&casilla1.getElementosCasilla().size()<3){
                casilla1.addElementoCasilla(agua);
                listaElementos.add(agua);
                agua.setCasilla(casilla);
            }
        }
        return agua;
    }

    public Comida crearComida(){
        Comida comida = new Comida();
        Casilla casilla = casillaAleatoria();
        for (Casilla casilla1 : listaCasillas){
            if (Objects.equals(casilla1.getId(), casilla.getId())&&casilla1.getElementosCasilla().size()<3){
                casilla1.addElementoCasilla(comida);
                listaElementos.add(comida);
                comida.setCasilla(casilla);
            }
        }
        return comida;
    }
    public Biblioteca crearBiblioteca(){
        Biblioteca biblioteca = new Biblioteca();
        Casilla casilla =casillaAleatoria();
        for (Casilla casilla1 : listaCasillas){
            if (Objects.equals(casilla1.getId(), casilla.getId())&&casilla1.getElementosCasilla().size()<3){
                casilla1.addElementoCasilla(biblioteca);
                listaElementos.add(biblioteca);
                biblioteca.setCasilla(casilla);
            }
        }
        return biblioteca;
    }

    public Montaña crearMontaña(){
        Montaña montaña = new Montaña();
        Casilla casilla =casillaAleatoria();
        for (Casilla casilla1 : listaCasillas){
            if (Objects.equals(casilla1.getId(), casilla.getId())&&casilla1.getElementosCasilla().size()<3){
                casilla1.addElementoCasilla(montaña);
                listaElementos.add(montaña);
                montaña.setCasilla(casilla);
            }
        }
        return montaña;
    }

    public Tesoro crearTesoro(){
        Tesoro tesoro = new Tesoro();
        Casilla casilla = casillaAleatoria();
        for (Casilla casilla1 : listaCasillas){
            if (Objects.equals(casilla1.getId(), casilla.getId())&&casilla1.getElementosCasilla().size()<3){
                casilla1.addElementoCasilla(tesoro);
                listaElementos.add(tesoro);
                tesoro.setCasilla(casilla);
            }
        }
        return tesoro;
    }
    public Pozo crearPozo(){
        Pozo pozo = new Pozo();
        Casilla casilla = casillaAleatoria();
        for (Casilla casilla1 : listaCasillas){
            if (Objects.equals(casilla1.getId(), casilla.getId())&&casilla1.getElementosCasilla().size()<3){
                casilla1.addElementoCasilla(pozo);
                listaElementos.add(pozo);
                pozo.setCasilla(casilla);
            }
        }
        return pozo;
    }*/

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
