package org.example.practicafinal.Clases.Partida;
import org.example.practicafinal.Clases.Individuo.Individuo;
import org.example.practicafinal.Clases.Individuo.IndividuoAvanzado;
import org.example.practicafinal.Clases.Individuo.IndividuoBasico;
import org.example.practicafinal.Clases.Individuo.IndividuoNormal;
import org.example.practicafinal.Clases.Tablero.Casilla;

import java.util.ArrayList;
import java.util.List;

public class Partida {
    int turno;
    int probReproduccion;
    int probClonacion;
    int id;
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

    ArrayList<Individuo> listaIndividuos = new ArrayList<>();

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
                   int numeroIndividuosAvanzados) {
        this.probReproduccion = probReproduccion;
        this.probClonacion = probClonacion;
        this.turnosVida = turnosVida;
        this.numeroIndividuosBasicos = numeroIndividuosBasicos;
        this.numeroIndividuosNormal = numeroIndividuosNormal;
        this.numeroIndividuosAvanzados = numeroIndividuosAvanzados;
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

    public void setColumnas(int columnas){
        this.columnas = columnas;
    }

    public void setFilas(int filas){
        this.filas = filas;
    }

    public ArrayList<Individuo> getListaIndividuos(){
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

    //CREATE INDIVIDUALS
    public IndividuoBasico crearBasico(){
            IndividuoBasico basico = new IndividuoBasico(id, turno, turnosVida, probReproduccion, probClonacion);
            modificarId();
            listaIndividuos.add(basico);
            Casilla casilla = basico.getCasilla();
            basico.setCasilla(casilla.columnaAleatoria(columnas), casilla.filaAleatoria(filas));
            return basico;
        }

        public IndividuoNormal crearNormal(){
            IndividuoNormal normal = new IndividuoNormal(id, turno, turnosVida, probReproduccion, probClonacion);
            modificarId();
            listaIndividuos.add(normal);
            Casilla casilla = normal.getCasilla();
            normal.setCasilla(casilla.columnaAleatoria(columnas), casilla.filaAleatoria(filas));
            return normal;
        }

        public IndividuoAvanzado crearAvanzado(){
            IndividuoAvanzado avanzado = new IndividuoAvanzado(id, turno, turnosVida, probReproduccion, probClonacion);
            modificarId();
            listaIndividuos.add(avanzado);
            Casilla casilla = avanzado.getCasilla();
            avanzado.setCasilla(casilla.columnaAleatoria(columnas), casilla.filaAleatoria(filas));
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

        public Individuo reproducir(Individuo a, Individuo b){
            Individuo hijo = null;
            if (a.getClass()== IndividuoAvanzado.class||b.getClass()== IndividuoAvanzado.class){
                hijo = this.crearAvanzado();
            } else if (a.getClass()==IndividuoNormal.class||b.getClass()== IndividuoNormal.class) {
                hijo = this.crearNormal();
            } else {
                hijo = this.crearBasico();
            }
            Casilla casilla = hijo.getCasilla();
            casilla.setColumna(a.getCasilla().getColumna());
            casilla.setFila(a.getCasilla().getFila());
            return hijo;
        }

            //MODIFY PARAMETERS
        public void modificarId(){
         this.setId(id+1);
        }

        public void modificarTurno(){
            this.setTurno(turno+1);
        }
}
