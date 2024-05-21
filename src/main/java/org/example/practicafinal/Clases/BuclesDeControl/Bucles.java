package org.example.practicafinal.Clases.BuclesDeControl;

import org.example.practicafinal.Clases.Entorno.Elementos;
import org.example.practicafinal.Clases.Individuo.Individuo;
import org.example.practicafinal.Clases.Individuo.IndividuoAvanzado;
import org.example.practicafinal.Clases.Individuo.IndividuoNormal;
import org.example.practicafinal.Clases.Partida.Partida;
import org.example.practicafinal.Clases.Tablero.Casilla;
import org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada.ListaDoblementeEnlazada;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Objects;

public class Bucles {

        //Parameters
    private ListaDoblementeEnlazada<Individuo> listaIndividuos;
    private ListaDoblementeEnlazada<Casilla> tablero;
    private Individuo individuo;
    private Partida partida;

        //Constructor
    public Bucles(){
    }

    public void setPartida(Partida partida){this.partida=partida;}


    public void eliminarIndividuo(ListaDoblementeEnlazada<Individuo> listaIndividuos){
        ListaDoblementeEnlazada<Individuo> individuoscopia = new ListaDoblementeEnlazada<>();
        individuoscopia.add(listaIndividuos);
        listaIndividuos.vaciar();
        for (Individuo individuo: individuoscopia){
            if (individuo.getTurnosVida()>0){
                listaIndividuos.add(individuo);
            }
        }
    }

    public void actualizarIndividuos(){
        ListaDoblementeEnlazada<Individuo> listadoIndividuos = new ListaDoblementeEnlazada<>();
        if (partida.getListaIndividuos() != null){
            for (Individuo individuo : partida.getListaIndividuos()){
                //Actualizar y Eliminar Individuos
                if (individuo.getTurnosVida()==0){
                    individuo.getCasilla().removeIndividuoCasilla(individuo);
                } else {
                    individuo.modificarTurnosVida();
                    individuo.modificarReprod();
                    individuo.modificarClonacion();
                    listadoIndividuos.add(individuo);
                }
            }
        }
        partida.setListaIndividuos(listaIndividuos);
    }

    public void actualizarElementos(){
        ListaDoblementeEnlazada<Elementos> listaElementos = new ListaDoblementeEnlazada<>();
        for (Elementos elemento : partida.getListaElementos()){
            elemento.setTiempoActividad(elemento.getTiempoActividad()-1);
            if (elemento.getTiempoActividad() > 0){
                listaElementos.add(elemento);
            } else {
                elemento.getCasilla().removeElementoCasilla(elemento);
            }
        }
        partida.setListaElementos(listaElementos);
    }

        //3-Mover Individuos

    public void moverIndividuos(){
        for (Individuo individuo : listaIndividuos) {
            Casilla casillaVieja = individuo.getCasilla();
            Casilla casillaNueva = new Casilla();
            switch (individuo.getRango()) {
                case 1:
                    casillaNueva = partida.moverBasico();
                    break;
                case 2:
                    casillaNueva = partida.moverNormal(casillaVieja);
                    break;
                case 3:
                    casillaNueva = partida.moverAvanzado(casillaVieja);
                    break;
            }

            individuo.setCasilla(casillaNueva);
            for (Casilla casilla : partida.getListaCasillas()) {
                if (Objects.equals(casilla.getId(), casillaVieja.getId())) {
                    casilla.removeIndividuoCasilla(individuo);
                }
                if (Objects.equals(casilla.getId(), casillaNueva.getId())) {
                    casilla.addIndividuoCasilla(individuo);
                }
            }
        }
    }

        //4-Evaluar las mejoras obtenidas por los recursos
    public Individuo individuoMejorado(ListaDoblementeEnlazada<Casilla> listaCasillas,
                                       ListaDoblementeEnlazada<Individuo> listaIndividuos,
                                       ListaDoblementeEnlazada<Elementos> listaElementos,
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
    public Individuo reproducir(@NotNull Individuo a, @NotNull Individuo b, ListaDoblementeEnlazada<Individuo> listaIndividuos){
        Individuo hijo = null;
        if (a.getClass()== IndividuoAvanzado.class || b.getClass()== IndividuoAvanzado.class){
            hijo = partida.crearAvanzado(listaIndividuos);

        } else if (a.getClass()== IndividuoNormal.class || b.getClass()== IndividuoNormal.class) {
            hijo = partida.crearNormal(listaIndividuos);

        } else {
            hijo = partida.crearBasico(listaIndividuos);
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
        if (casilla.getIndividuosTotales() < partida.getMaximosIndividuos()) {
            int a = 1;
            for (int i = 0; i < partida.getMaximosIndividuos(); i++) {
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
        return casilla.getIndividuosCasilla().getPrimero().getData();
    }

    public ListaDoblementeEnlazada<Integer> reordenar(Casilla casilla){
        ListaDoblementeEnlazada<Integer> id = new ListaDoblementeEnlazada<>();
        Collections.sort(casilla.getIndividuosCasilla());
        for (Individuo individuo1 : casilla.getIndividuosCasilla()){
            id.add(individuo1.getId());
        }
        return id;
    }

    public void evaluacionFinal(){
        for (Casilla casilla: partida.getListaCasillas()){
            while (casilla.getIndividuosTotales() > partida.getMaximosIndividuos()){
                Individuo eliminar = evaluarIndividuosCasilla(casilla);
                casilla.removeIndividuoCasilla(eliminar);
                partida.removeIndividuo(eliminar);
            }
        }
    }

        //8-Aparición recursos
    public ListaDoblementeEnlazada<Elementos> aparicionRecursos(ListaDoblementeEnlazada<Casilla> listaCasillas,
                                                                ListaDoblementeEnlazada<Elementos> listaElementos){
        for (Casilla casilla : listaCasillas){
            if (casilla.getElementosCasilla().getNumeroElementos() < 3){
                for (Elementos elemento : listaElementos){
                }
            }
        }
        return listaElementos;
    }
}
