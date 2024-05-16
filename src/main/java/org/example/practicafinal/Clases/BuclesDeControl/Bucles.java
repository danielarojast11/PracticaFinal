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
import java.util.Objects;

public class Bucles {

        //Parameters
    private ArrayList<Individuo> listaIndividuos;
    private ArrayList<Casilla> tablero;
    private Individuo individuo;
    private Partida partida;

        //Constructor
    public Bucles(){
    }

    public void setPartida(Partida partida){this.partida=partida;}


        //1-Actualizar y Eliminar Individuos
    public void modificarIndividuo(Individuo individuo, List<Individuo> listaIndividuo){
        if (individuo.getTurnosVida()==0){
            individuo.getCasilla().removeIndividuoCasilla(individuo);
            listaIndividuo.remove(individuo);
        } else {
            individuo.modificarTurnosVida();
            individuo.modificarReprod();
            individuo.modificarClonacion();
        }
    }

    public void eliminarIndividuo(List<Individuo> listaIndividuos){
        List<Individuo> individuoscopia = new ArrayList<>();
        individuoscopia.addAll(listaIndividuos);
        listaIndividuos.clear();
        for (Individuo individuo:individuoscopia){
            if (individuo.getTurnosVida()>0){
                listaIndividuos.add(individuo);
            }
        }
    }

    public List<Individuo> actualizarIndividuos(List<Individuo> listaIndividuos){
        for (Individuo individuo : listaIndividuos){
            modificarIndividuo(individuo, listaIndividuos);
            System.out.println("Id: "+individuo.getId());
            System.out.println("Vida: "+individuo.getTurnosVida());
        }
        return listaIndividuos;
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

        //3-Mover Individuos

    /*public Casilla moverBasico(){
        return casillaAleatoria();
    }

    public Casilla moverNormal(Casilla casillaVieja){
        Casilla nuevaCasilla;
        List<Elementos> elementos = super.getListaElementos();
        int indice = (int)(Math.random()*elementos.size());
        System.out.println("longitud: "+elementos.size());
        System.out.println(indice);
        Elementos elementoAleatorio = elementos.get(indice);
        Casilla casillaElemento = elementoAleatorio.getCasilla();
        int eleccion = (int)(Math.random()*2);
        if (eleccion==0){
            nuevaCasilla = new Casilla(casillaVieja.getColumna(), casillaElemento.getFila());
        } else{
            nuevaCasilla = new Casilla(casillaElemento.getColumna(), casillaVieja.getFila());
        }
        return nuevaCasilla;
    }

    public void moverIndividuo(Individuo individuo){
        Casilla casillaVieja = individuo.getCasilla();
        Casilla casillaNueva = new Casilla();
        if (individuo.getRango()==1){
            casillaNueva=moverBasico();
        } else if (individuo.getRango()==2) {
            casillaNueva=moverNormal(casillaVieja);
        }
        individuo.setCasilla(casillaNueva);
        for (Casilla casilla : getListaCasillas()){
            if (Objects.equals(casilla.getId(), casillaVieja.getId())){
                casilla.removeIndividuoCasilla(individuo);
            }
            if (Objects.equals(casilla.getId(), casillaNueva.getId())){
                casilla.addIndividuoCasilla(individuo);
            }
        }
    }*/

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
    public Individuo reproducir(@NotNull Individuo a, @NotNull Individuo b, List<Individuo> listaIndividuos){
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

    public void evaluacionFinal(Casilla casilla, List<Individuo> listaIndividuos){
        while (casilla.getIndividuosTotales() > partida.getMaximosIndividuos()){
            Individuo eliminar = evaluarIndividuosCasilla(casilla);
            casilla.removeIndividuoCasilla(eliminar);
            listaIndividuos.remove(eliminar);
        }
    }

        //8-Aparición recursos
    public List<Elementos> aparicionRecursos(List<Casilla> listaCasillas, List<Elementos> listaElementos){
        for (Casilla casilla : listaCasillas){
            if (casilla.getElementosCasilla().size() < 3){
                for (Elementos elemento : listaElementos){
                }
            }
        }
        return listaElementos;
    }
}
