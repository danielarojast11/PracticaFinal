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
    private ArrayList<Individuo> listaIndividuos;
    private ArrayList<Elementos> listaElementos;
    private ArrayList<Casilla> tablero;
    private Individuo individuo;

        //Constructor
    public Bucles(){}

    public Bucles (ArrayList<Elementos> listaElementos){
        this.listaElementos = listaElementos;
    }

        //1-Actualizar y Eliminar Individuos
    public void modificarIndividuo(Individuo individuo, List<Individuo> listaIndividuos){
        individuo.modificarTurnosVida();
        individuo.modificarReprod();
        individuo.modificarClonacion();
        eliminarIndividuo(individuo, listaIndividuos);
    }

    public void eliminarIndividuo(Individuo individuo, List<Individuo> listaIndividuos){
        if (individuo.getTurnosVida()==0){
            listaIndividuos.remove(individuo);
        } else if (individuo.getProbReproduccion() == 0) {
            listaIndividuos.remove(individuo);
        }
    }

    public void actualizarIndividuos(List<Individuo> listaIndividuos){
        for (Individuo individuo : listaIndividuos){
            modificarIndividuo(individuo, listaIndividuos);
            eliminarIndividuo(individuo, listaIndividuos);
        }
    }

        //2-Actualizar y Eliminar Recursos
    public void modificarElemento(Elementos elemento){
        elemento.setTiempoActividad(elemento.getTiempoActividad()-1);
    }

    public void eliminarElemento(Elementos elemento, List<Elementos> listaElementos){
        if (elemento.getTiempoActividad() == 0){
            listaElementos.remove(elemento);
        }
    }

    public void actualizarElementos(List<Elementos> listaElementos){
        for (Elementos elemento : listaElementos){
            modificarElemento(elemento);
            eliminarElemento(elemento, listaElementos);
        }
    }

        //4-Evaluar las mejoras obtenidas por los recursos
    public Individuo individuoMejorado(List<Casilla> listaCasillas,
                                       List<Individuo> listaIndividuos,
                                       List<Elementos> listaElementos,
                                        Partida partida){
        for (Casilla casilla : listaCasillas){
            for (Individuo individuo : listaIndividuos){
                for (Elementos elemento : listaElementos){
                    individuoConRecurso(individuo, elemento, partida);
                }
            }
        }
        return individuo;
    }

    protected Individuo individuoConRecurso(Individuo individuo,
                                            Elementos elemento,
                                            Partida partida){

        if (elemento.getType() == 0){
            int individuoAgua = individuo.getTurnosVida() +2;
            individuo.setTurnosVida(individuoAgua);
            return individuo;

        } else if (elemento.getType() == 1) {
            int individuoComida = individuo.getTurnosVida() + 10;
            individuo.setTurnosVida(individuoComida);
            return individuo;

        } else if (elemento.getType() == 2) {
            int sliderClon = partida.getProbClonacion();
            int probClon = (sliderClon * individuo.getProbReproduccion()) / 100;
            int individuoBiblioteca = individuo.getProbClonacion() - probClon;
            individuo.setProbClonacion(individuoBiblioteca);
            if (individuo.getRango() < 3) {
                int individuoRango = individuo.getRango() + 1;
                individuo.setRango(individuoRango);
                return individuo;
            }

        } else if (elemento.getType() == 3) {
            int individuoMontana = individuo.getTurnosVida() -2;
            individuo.setTurnosVida(individuoMontana);
            return individuo;

        } else if (elemento.getType() == 4) {
            int sliderRep = partida.getProbReproduccion();
            int probRep = (sliderRep * individuo.getProbReproduccion()) / 100;
            int individuoCofre = individuo.getProbReproduccion() + probRep;
            individuo.setProbReproduccion(individuoCofre);
            return individuo;

        } else if (elemento.getType() == 5) {
            individuo.setProbabilidadMuerte(100);
        }
        return individuo;
    }

        //5-Reproduccion
    public Individuo reproducir(@NotNull Individuo a, @NotNull Individuo b){
        Individuo hijo = null;
        if (a.getClass()== IndividuoAvanzado.class || b.getClass()== IndividuoAvanzado.class){
            hijo = this.crearAvanzado();

        } else if (a.getClass()== IndividuoNormal.class || b.getClass()== IndividuoNormal.class) {
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

        //6-Clonación
    public Individuo clonar(@NotNull Individuo individuo, Partida partida){
        Individuo individuoClonar = null;
        if (individuo.getProbClonacion() >= partida.getProbClonacion()){
            individuoClonar = individuo;
        }
        individuo.addIndividuo(individuoClonar);
        Casilla casilla = individuoClonar.getCasilla();
        casilla.setColumna(individuoClonar.getCasilla().getColumna());
        casilla.setFila(individuoClonar.getCasilla().getFila());
        return individuoClonar;
    }

        //7-Evaluar Casillas
    public int evaluarCapacidadCasilla(Casilla casilla){
        if (casilla.getIndividuosTotales() < getMaximosIndividuos()) {
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

    public void evaluacionFinal(Casilla casilla){
        while (casilla.getIndividuosTotales() > getMaximosIndividuos()){
            Individuo eliminar = evaluarIndividuosCasilla(casilla);
            casilla.removeIndividuoCasilla(eliminar);
            getListaIndividuos().remove(eliminar);
        }
    }

        //8-Aparición recursos
    public List<Elementos> aparicionRecursos(List<Casilla> listaCasillas, List<Elementos> listaElementos){
        for (Casilla casilla : listaCasillas){
            if (listaElementos.size() < 3){
                for (Elementos elemento : listaElementos){
                    elemento.getAparicionRecurso();
                    casilla.addElementoCasilla(elemento);
                }
            }
        }
        return listaElementos;
    }
}
