package org.example.practicafinal.Clases.Partida;
import org.example.practicafinal.Clases.Individuo.Individuo;
import org.example.practicafinal.Clases.Individuo.IndividuoAvanzado;
import org.example.practicafinal.Clases.Individuo.IndividuoBasico;
import org.example.practicafinal.Clases.Individuo.IndividuoNormal;

public class Partida {
    int turno;
    int probReproduccion;
    int probClonacion;
    int id;
    int turnosVida;

        //CONSTRUCTORS
    public Partida(int turno, int probReproduccion, int probClonacion, int id, int turnosVida) {
        this.turno = turno;
        this.probReproduccion = probReproduccion;
        this.probClonacion = probClonacion;
        this.id = id;
        this.turnosVida = turnosVida;
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

        //CREATE INDIVIDUALS
    public IndividuoBasico crearBasico(){
            IndividuoBasico basico = new IndividuoBasico(id, turno, turnosVida, probReproduccion, probClonacion);
            modificarId();
            return basico;
        }
        public IndividuoNormal crearNormal(){
            IndividuoNormal normal = new IndividuoNormal(id, turno, turnosVida, probReproduccion, probClonacion);
            modificarId();
            return normal;
        }

        public IndividuoAvanzado crearAvanzado(){
            IndividuoAvanzado avanzado = new IndividuoAvanzado(id, turno, turnosVida, probReproduccion, probClonacion);
            modificarId();
            return avanzado;
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
}
