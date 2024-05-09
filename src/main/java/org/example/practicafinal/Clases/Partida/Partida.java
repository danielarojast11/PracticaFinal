package org.example.practicafinal.Clases.Partida;
import org.example.practicafinal.Clases.BuclesDeControl.Bucles;
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
    int MaximosIndividuos = 3;
    int turno;
    int probReproduccion;
    int probClonacion;
    int id = 1;
    int turnosVida;
    int numeroIndividuosBasicos;
    int numeroIndividuosNormal;
    int numeroIndividuosAvanzados;
    int agua;
    int comida;
    int montana;
    int cofre;
    int biblioteca;
    int pozo;
    int columnas;
    int filas;

    List<Individuo> listaIndividuos = new ArrayList<>();
    List<Casilla> listaCasillas = new ArrayList<>();
    List <Elementos> listaElementos = new ArrayList<>();

        //CONSTRUCTORS
    public Partida(int probReproduccion,
                   int probClonacion,
                   int turnosVida
                   ) {
        this.probReproduccion = probReproduccion;
        this.probClonacion = probClonacion;
        this.turnosVida = turnosVida;
    }

    public Partida(int probReproduccion,
                   int probClonacion,
                   int turnosVida,
                   int numeroIndividuosBasicos,
                   int numeroIndividuosNormal,
                   int numeroIndividuosAvanzados, int filas, int columnas) {
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
        this.columnas = columnas;
        this.filas = filas;
    }

    public Partida() {
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
        return this.MaximosIndividuos;
    }

    public int getProbReproduccion() {
        return probReproduccion;
    }

    public void setProbReproduccion(int probReproduccion) {
        this.probReproduccion = probReproduccion;
    }

    public int getProbClonacion() {
        return probClonacion;
    }

    public void setProbClonacion(int probClonacion) {
        this.probClonacion = probClonacion;
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

    public void setTurnosVida(int turnosVida) {
        this.turnosVida = turnosVida;
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
    public void setListaElementos(List<Elementos> listaElementos){this.listaElementos=listaElementos;}

        //GETTERS AND SETTERS PLACEHOLDERS
    public void setColumnas(int columnas){
            this.columnas = columnas;
        }

    public void setFilas(int filas){
        this.filas = filas;
    }
    public void setListaCasillas(List<Casilla> listaCasillas){
        this.listaCasillas = listaCasillas;
    }
    public List<Casilla> getListaCasillas(){return this.listaCasillas;}

        //CREATE INDIVIDUALS
    public IndividuoBasico crearBasico(){
        IndividuoBasico basico = new IndividuoBasico(id, turno, turnosVida, probReproduccion, probClonacion);
        modificarId();
        listaIndividuos.add(basico);
        Casilla casilla = new Casilla(columnaAleatoria(), filaAleatoria());
        basico.setCasilla(casilla);
        for (Casilla casilla1 : listaCasillas){
            if (Objects.equals(casilla1.getId(), casilla.getId())){
                casilla1.addIndividuoCasilla(basico);
            }
        }
        return basico;
    }
    public IndividuoNormal crearNormal(){
        IndividuoNormal normal = new IndividuoNormal(id, turno, turnosVida, probReproduccion, probClonacion);
        modificarId();
        listaIndividuos.add(normal);
        Casilla casilla = new Casilla(columnaAleatoria(), filaAleatoria());
        normal.setCasilla(casilla);
        for (Casilla casilla1 : listaCasillas){
            if (Objects.equals(casilla1.getId(), casilla.getId())){
                casilla1.addIndividuoCasilla(normal);
            }
        }
        return normal;
    }

    public IndividuoAvanzado crearAvanzado(){
        IndividuoAvanzado avanzado = new IndividuoAvanzado(id, turno, turnosVida, probReproduccion, probClonacion);
        modificarId();
        listaIndividuos.add(avanzado);
        Casilla casilla = new Casilla(columnaAleatoria(), filaAleatoria());
        avanzado.setCasilla(casilla);
        for (Casilla casilla1 : listaCasillas){
            if (Objects.equals(casilla1.getId(), casilla.getId())){
                casilla1.addIndividuoCasilla(avanzado);
            }
        }
        return avanzado;
    }

    public void individuosInicio(){
        for (int i = 0; i < numeroIndividuosBasicos; i++){
            crearBasico();
        }
        for (int i = 0; i < numeroIndividuosNormal; i++){
            crearNormal();
        }
        for (int i = 0; i < numeroIndividuosAvanzados; i++){
            crearAvanzado();
        }
    }

        //CREATE ELEMENTS
    public Agua crearAgua(){
        Agua agua = new Agua();
        Casilla casilla = new Casilla(columnaAleatoria(),filaAleatoria());
        agua.setCasilla(casilla);
        for (Casilla casilla1 : listaCasillas){
            if (Objects.equals(casilla1.getId(), casilla.getId())&&casilla1.getElementosCasilla().size()<3){
                casilla1.addElementoCasilla(agua);
                listaElementos.add(agua);
            }
        }
        return agua;
    }

    public Comida crearComida(){
        Comida comida = new Comida();
        Casilla casilla = new Casilla(columnaAleatoria(),filaAleatoria());
        comida.setCasilla(casilla);
        for (Casilla casilla1 : listaCasillas){
            if (Objects.equals(casilla1.getId(), casilla.getId())&&casilla1.getElementosCasilla().size()<3){
                casilla1.addElementoCasilla(comida);
                listaElementos.add(comida);
            }
        }
        return comida;
    }
    public Biblioteca crearBiblioteca(){
        Biblioteca biblioteca = new Biblioteca();
        Casilla casilla =new Casilla(columnaAleatoria(),filaAleatoria());
        biblioteca.setCasilla(casilla);
        for (Casilla casilla1 : listaCasillas){
            if (Objects.equals(casilla1.getId(), casilla.getId())&&casilla1.getElementosCasilla().size()<3){
                casilla1.addElementoCasilla(biblioteca);
                listaElementos.add(biblioteca);
            }
        }
        return biblioteca;
    }

    public Montaña crearMontaña(){
        Montaña montaña = new Montaña();
        Casilla casilla =new Casilla(columnaAleatoria(),filaAleatoria());
        montaña.setCasilla(casilla);
        for (Casilla casilla1 : listaCasillas){
            if (Objects.equals(casilla1.getId(), casilla.getId())&&casilla1.getElementosCasilla().size()<3){
                casilla1.addElementoCasilla(montaña);
                listaElementos.add(montaña);
            }
        }
        return montaña;
    }

    public Tesoro crearTesoro(){
        Tesoro tesoro = new Tesoro();
        Casilla casilla = new Casilla(columnaAleatoria(),filaAleatoria());
        tesoro.setCasilla(casilla);
        for (Casilla casilla1 : listaCasillas){
            if (Objects.equals(casilla1.getId(), casilla.getId())&&casilla1.getElementosCasilla().size()<3){
                casilla1.addElementoCasilla(tesoro);
                listaElementos.add(tesoro);
            }
        }
        return tesoro;
    }
    public Pozo crearPozo(){
        Pozo pozo = new Pozo();
        Casilla casilla = new Casilla(columnaAleatoria(),filaAleatoria());
        pozo.setCasilla(casilla);
        for (Casilla casilla1 : listaCasillas){
            if (Objects.equals(casilla1.getId(), casilla.getId())&&casilla1.getElementosCasilla().size()<3){
                casilla1.addElementoCasilla(pozo);
                listaElementos.add(pozo);
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

        //MODIFY PARAMETERS
    public void modificarId(){
         this.setId(id+1);
        }
    public void modificarTurno(){
            this.setTurno(turno+1);
        }

    public int filaAleatoria(){
        int fila = (int) (Math.random()*filas);
        return fila;
    }

    public int columnaAleatoria(){
        int columna = (int) (Math.random()*columnas);
        return columna;
    }
}
