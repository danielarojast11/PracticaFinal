package org.example.practicafinal.Clases.Partida;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.example.practicafinal.Clases.Entorno.*;
import org.example.practicafinal.Clases.Individuo.Individuo;
import org.example.practicafinal.Clases.Individuo.IndividuoAvanzado;
import org.example.practicafinal.Clases.Individuo.IndividuoBasico;
import org.example.practicafinal.Clases.Individuo.IndividuoNormal;
import org.example.practicafinal.Clases.Tablero.Casilla;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Partida {
    private int turno;
    private int probReproduccion;
    private int probClonacion;
    private int id = 1;
    private int turnosVida;
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
    private int maximosIndividuos = 3;

    private List<Individuo> listaIndividuos = new ArrayList<>();
    private List<Casilla> listaCasillas = new ArrayList<>();
    private List <Elementos> listaElementos = new ArrayList<>();

        //CONSTRUCTORS
    public Partida(int id,
                   int probReproduccion,
                   int probClonacion,
                   int turnosVida
                   ) {
        this.id = id;
        this.probReproduccion = probReproduccion;
        this.probClonacion = probClonacion;
        this.turnosVida = turnosVida;
    }

    public Partida(int probReproduccion,
                   int probClonacion,
                   int turnosVida,
                   int numeroIndividuosBasicos,
                   int numeroIndividuosNormal,
                   int numeroIndividuosAvanzados,
                   int filas,
                   int columnas) {
        this.probReproduccion = probReproduccion;
        this.probClonacion = probClonacion;
        this.turnosVida = turnosVida;
        this.numeroIndividuosBasicos = numeroIndividuosBasicos;
        this.numeroIndividuosNormal = numeroIndividuosNormal;
        this.numeroIndividuosAvanzados = numeroIndividuosAvanzados;
        this.columnas = columnas;
        this.filas = filas;
    }

    public Partida(
        int probReproduccion,
        int probClonacion,
        int turnosVida,
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
        this.probReproduccion = probReproduccion;
        this.probClonacion = probClonacion;
        this.turnosVida = turnosVida;
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

    public Partida() {
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
        jsonObject.addProperty("maximosIndividuos", this.maximosIndividuos);

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
        for (Elementos e: this.listaElementos) {
            jsonArrayElementos.add(e.toJson());
        }
        jsonObject.add("listaElementos", jsonArrayElementos);

        return jsonObject;
    }

        //GETTERS AND SETTERS

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

        //GETTERS AND SETTERS INDIVIDUALS

    public int getMaximosIndividuos(){
        return this.maximosIndividuos;
    }

    public int getProbReproduccion() {
        return probReproduccion;
    }

    public int getProbClonacion() {
        return probClonacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTurnosVida() {
        return turnosVida;
    }

    public List<Individuo> getListaIndividuos(){
        return listaIndividuos;
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

    public void setListaIndividuos(List<Individuo> listaIndividuos){
        this.listaIndividuos = listaIndividuos;
    }

    public void removeIndividuo(Individuo individuo) {
        this.listaIndividuos.remove(individuo);
    }

    public void removeIndividuo(int index) {
        this.listaIndividuos.remove(index);
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

    public List<Elementos> getListaElementos(){return this.listaElementos;}

    public void setListaElementos(List<Elementos> listaElementos) {
        this.listaElementos = listaElementos;
    }

    public int getTiempoActividad() {
        return tiempoActividad;
    }

        //GETTERS AND SETTERS PLACEHOLDERS
    public void setColumnas(int columnas){
            this.columnas = columnas;
    }

    public int getColumnas() {return this.columnas;}

    public void setFilas(int filas){
        this.filas = filas;
    }

    public int getFilas() {return this.filas;}

    public void setListaCasillas(List<Casilla> listaCasillas){
        this.listaCasillas = listaCasillas;
    }

    public List<Casilla> getListaCasillas(){return this.listaCasillas;}

        //CREATE INDIVIDUALS
    public IndividuoBasico crearBasico(List<Individuo> listaIndividuos){
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

    public IndividuoNormal crearNormal(List<Individuo> listaIndividuos){
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

    public IndividuoAvanzado crearAvanzado(List<Individuo> listaIndividuos){
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

    public void individuosInicio(List<Individuo> listaIndividuos){
        for (int i = 0; i < numeroIndividuosBasicos; i++){
            crearBasico(listaIndividuos);
        }
        for (int i = 0; i < numeroIndividuosNormal; i++){
            crearNormal(listaIndividuos);
        }
        for (int i = 0; i < numeroIndividuosAvanzados; i++){
            crearAvanzado(listaIndividuos);
        }
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
    }

    public void elementosPrincipio(){
        for (int a=0; a<agua;a++){
            crearAgua();
        }for (int c=0; c<comida;c++){
            crearComida();
        }for (int b=0; b<biblioteca; b++){
            crearBiblioteca();
        }for (int m=0; m<montana; m++){
            crearMontaña();
        }for (int t=0; t<cofre; t++){
            crearTesoro();
        }for (int p=0; p<pozo; p++){
            crearPozo();
        }
    }

        //MOVER INDIVIDUOS
    public Casilla moverBasico(){
        return casillaAleatoria();
    }

    public Casilla moverNormal(Casilla casillaVieja){
        Casilla nuevaCasilla;
        int indice = (int)(Math.random()*(listaElementos.size()));
        System.out.println("longitud: "+listaElementos.size());
        System.out.println(indice);
        Elementos elementoAleatorio = getListaElementos().get(indice);
        Casilla casillaElemento = elementoAleatorio.getCasilla();
        int eleccion = (int)(Math.random()*2);
        if (eleccion==0){
            nuevaCasilla = new Casilla(casillaVieja.getColumna(), casillaElemento.getFila());
        } else{
            nuevaCasilla = new Casilla(casillaElemento.getColumna(), casillaVieja.getFila());
        }
        return nuevaCasilla;
    }

    public Casilla moverAvanzado(Casilla casillaActual){
        int distancia = 1000;
        Casilla casillaDestino = null;
        for(Elementos e: listaElementos) {
            // Distancia de Chebyshov
            int d2 = Math.max(
                    Math.abs(e.getCasilla().getFila() - casillaActual.getFila()),
                    Math.abs(e.getCasilla().getColumna() - casillaActual.getColumna())
            );
            if (distancia > d2) {
                distancia = d2;
                casillaDestino = e.getCasilla();
            }
        }

        return casillaDestino;
    }

    public void moverIndividuos(){
        for (Individuo individuo : listaIndividuos) {
            Casilla casillaVieja = individuo.getCasilla();
            Casilla casillaNueva = new Casilla();
            switch (individuo.getRango()) {
                case 1:
                    casillaNueva = moverBasico();
                    break;
                case 2:
                    casillaNueva = moverNormal(casillaVieja);
                    break;
                case 3:
                    casillaNueva = moverAvanzado(casillaVieja);
                    break;
            }

            individuo.setCasilla(casillaNueva);
            for (Casilla casilla : getListaCasillas()) {
                if (Objects.equals(casilla.getId(), casillaVieja.getId())) {
                    casilla.removeIndividuoCasilla(individuo);
                }
                if (Objects.equals(casilla.getId(), casillaNueva.getId())) {
                    casilla.addIndividuoCasilla(individuo);
                }
            }
        }
    }


        //MODIFY PARAMETERS
    public void modificarId(){
         this.setId(id+1);
        }

    public void modificarTurno(){
            this.setTurno(turno+1);
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

    public int getIndividuosTotales(){
        return listaIndividuos.size();
    }
}
