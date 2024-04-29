package org.example.practicafinal.Clases.Partida;
import org.example.practicafinal.Clases.Individuo.Individuo;
import org.example.practicafinal.Clases.Individuo.IndividuoAvanzado;
import org.example.practicafinal.Clases.Individuo.IndividuoBasico;
import org.example.practicafinal.Clases.Individuo.IndividuoNormal;

import java.util.ArrayList;

public class Partida {
    int turno;
    int probReproduccion;
    int probClonacion;
    int id;
    int turnosVida;
    int numeroIndividuos;
    int columnas;
    int filas;

    ArrayList<Individuo> listaIndividuos = new ArrayList<>();

        //CONSTRUCTORS
    public Partida(int probReproduccion, int probClonacion, int turnosVida) {
        this.probReproduccion = probReproduccion;
        this.probClonacion = probClonacion;
        this.turnosVida = turnosVida;
    }

    public Partida(int probReproduccion, int probClonacion, int turnosVida, int numeroIndividuos) {
        this.probReproduccion = probReproduccion;
        this.probClonacion = probClonacion;
        this.turnosVida = turnosVida;
        this.numeroIndividuos = numeroIndividuos;
    }

    public Partida(int probReproduccion, int probClonacion, int turnosVida, int numeroIndividuos, int columnas, int filas) {
        this.probReproduccion = probReproduccion;
        this.probClonacion = probClonacion;
        this.turnosVida = turnosVida;
        this.numeroIndividuos = numeroIndividuos;
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

        //CREATE INDIVIDUALS
    public IndividuoBasico crearBasico(){
            IndividuoBasico basico = new IndividuoBasico(id, turno, turnosVida, probReproduccion, probClonacion);
            modificarId();
            listaIndividuos.add(basico);
            return basico;
        }
        public IndividuoNormal crearNormal(){
            IndividuoNormal normal = new IndividuoNormal(id, turno, turnosVida, probReproduccion, probClonacion);
            modificarId();
            listaIndividuos.add(normal);
            return normal;
        }

        public IndividuoAvanzado crearAvanzado(){
            IndividuoAvanzado avanzado = new IndividuoAvanzado(id, turno, turnosVida, probReproduccion, probClonacion);
            modificarId();
            listaIndividuos.add(avanzado);
            return avanzado;
        }

        public void individuosInicio(){
            for (int i = 0; i < numeroIndividuos; i++){
                int a = (int)Math.floor(Math.random()*3+1);
                if (a==3){
                    crearAvanzado();
                } else if (a==2) {
                    crearNormal();
                } else{
                    crearBasico();
                }
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
