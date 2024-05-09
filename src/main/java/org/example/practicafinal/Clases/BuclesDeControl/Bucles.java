package org.example.practicafinal.Clases.BuclesDeControl;

import org.example.practicafinal.Clases.Entorno.Elementos;
import org.example.practicafinal.Clases.Individuo.Individuo;
import org.example.practicafinal.Clases.Individuo.IndividuoAvanzado;
import org.example.practicafinal.Clases.Individuo.IndividuoNormal;
import org.example.practicafinal.Clases.Partida.Partida;
import org.example.practicafinal.Clases.Tablero.Casilla;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bucles extends Partida {

        //Parameters
    private ArrayList<Elementos> listaElementos;
    private ArrayList<Casilla> tablero;
    private Individuo individuo;

        //Constructor
    public Bucles(){}
    public Bucles (ArrayList<Elementos> listaElementos){
        this.listaElementos = listaElementos;
    }

        //1-Actualizar y Eliminar Individuos
    public void modificarIndividuo(Individuo individuo){
        individuo.modificarTurnosVida();
        individuo.modificarReprod();
        individuo.modificarClonacion();
    }

    public void eliminarIndividuo(Individuo individuo){
        if (individuo.getTurnosVida()==0){
            getListaIndividuos().remove(individuo);
        } else if (individuo.getProbReproduccion()==0) {
            getListaIndividuos().remove(individuo);
        }
    }

    public void actualizarIndividuos(List<Individuo> individuos){
        for (Individuo individuo : individuos){
            modificarIndividuo(individuo);
            eliminarIndividuo(individuo);
        }
    }

        //2-Actualizar y Eliminar Recursos
    public void modificarElemento(Elementos elemento){
        elemento.setTiempoActividad(elemento.getTiempoActividad()-1);
    }
    public void eliminarElemento(Elementos elemento){
        if (elemento.getTiempoActividad()==0){
        getListaElementos().remove(elemento);}
    }
    public void actualizarElementos(List<Elementos> elementos){
        for (Elementos elemento : elementos){
            modificarElemento(elemento);
            eliminarElemento(elemento);
        }
    }

    /*public List<Individuo> individuoEnCasilla(List<Casilla> tablero, List<Individuo> listaIndividuos){
        for (Casilla casilla : tablero){
            if (individuo.getIndividuos().size() > 3){
                for (Individuo individuo :  listaIndividuos){
                    individuo.getTurnosVida();
                    //listaIndividuos.sort();
                }
            }
        }
        return listaIndividuos;
    }*/

        //5-Reproduccion
    public Individuo reproducir(@NotNull Individuo a, @NotNull Individuo b){
        Individuo hijo = null;
        if (a.getClass()== IndividuoAvanzado.class||b.getClass()== IndividuoAvanzado.class){
            hijo = this.crearAvanzado();
        } else if (a.getClass()== IndividuoNormal.class||b.getClass()== IndividuoNormal.class) {
            hijo = this.crearNormal();
        } else {
            hijo = this.crearBasico();
        }
        a.addHijo(hijo);
        b.addHijo(hijo);
        Casilla casilla = hijo.getCasilla();
        casilla.setColumna(a.getCasilla().getColumna());
        casilla.setFila(a.getCasilla().getFila());
        return hijo;
    }

        //7-Evaluar Casillas
    public int evaluarCapacidadCasilla(Casilla casilla){
        if (casilla.getIndividuosTotales()<getMaximosIndividuos()) {
            int a = 1;
            for (int i = 0; i < getMaximosIndividuos(); i++) {
                if (i < casilla.getIndividuosTotales()) {
                    a += 2;
                }
            }
            return a;
        }
        return 0;
    }

    public Individuo evaluarIndividuosCasilla(Casilla casilla){
        Collections.sort(casilla.getIndividuosCasilla());
        return casilla.getIndividuosCasilla().getFirst();
    }

    public List<Integer> reordenar(Casilla casilla){
        List<Integer> id = new ArrayList<>();
        Collections.sort(casilla.getIndividuosCasilla());
        for (Individuo individuo1 : casilla.getIndividuosCasilla()){
            id.add(individuo1.getId());
        }
        return id;
    }

    public void evaluarElementosCasilla(Casilla casilla){

    }

    public void evaluacionFinal(Casilla casilla){
        while (casilla.getIndividuosTotales()>getMaximosIndividuos()){
            Individuo eliminar = evaluarIndividuosCasilla(casilla);
            casilla.removeIndividuoCasilla(eliminar);
            getListaIndividuos().remove(eliminar);
        }
    }
}
