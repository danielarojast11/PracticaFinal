package org.example.practicafinal.Clases;

import org.example.practicafinal.Entity.*;
import org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada.ListaDoblementeEnlazada;
import org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada.ElementoLE;
import org.jetbrains.annotations.NotNull;

public class Bucles {
    private Partida partida;

    public Bucles(Partida partida){
        this.partida = partida;
    }

    public void moverIndividuos(){
        ElementoLE casillaActual = partida.getListaCasillas().getPrimero();
        while (casillaActual != null) {
            Casilla casilla = (Casilla) casillaActual.getData();
            ElementoLE individuoActual = casilla.getIndividuos().getPrimero();
            while (individuoActual != null) {
                Individuo individuo = (Individuo) individuoActual.getData();
                casilla.removeIndividuo(individuo);
                individuo.restarTurnoVida();
                individuo.setProbReproduccion(individuo.getProbReproduccion() - 10);
                individuo.setProbClonacion(individuo.getProbClonacion() - 10);

                if (individuo.getTurnosVida() == 0) {
                    individuo.getOperaciones().add(new Operacion("Muerte", partida.getTurno(), 2));
                    continue;
                } else {
                    individuo.getOperaciones().add(new Operacion("Cambio casilla", partida.getTurno(), 1));
                    individuo.sumarLongevidad();
                    Casilla casillaDestino = null;
                    switch (individuo.getRango()) {
                        case 1:
                            casillaDestino = partida.moverBasico();
                            break;
                        case 2:
                            casillaDestino = partida.moverNormal(casilla);
                            break;
                        case 3:
                            casillaDestino = partida.moverAvanzado(casilla);
                            break;
                    }

                    individuo.setCasilla(casillaDestino);
                    evaluarIndividuoRecursos(individuo);
                    if (individuo.getProbMuerte() >= 100 || individuo.getTurnosVida() == 0) {
                        individuo.getOperaciones().add(new Operacion("Muerte", partida.getTurno(), 2));
                        continue; // Continuo el bucle porque el individuo a muerto fijo
                    }

                    casillaDestino.addIndividuo(individuo);
                }

                individuoActual = individuoActual.getSiguiente();
            }

            relacionesIndividuos(casilla);
            evaluarElementosCasilla(casilla);
            maxCosasCasilla(casilla);

            casillaActual = casillaActual.getSiguiente();
        }
    }

    public void evaluarElementosCasilla(Casilla casilla) {
        ElementoLE elementoLE = casilla.getElementos().getPrimero();
        while (elementoLE != null) {
            Elemento elemento = (Elemento) elementoLE.getData();
            elemento.reducirTiempoActividad();
            if (elemento.getTiempoActividad() <= 0) {
                casilla.getElementos().remove(elemento);
            }

            elementoLE = elementoLE.getSiguiente();
        }

        if (casilla.getElementos().getNumeroElementos() < partida.getMaxElementos()) {
            // Al haber hueco... no tengo claro como va lo de probabilidad "Z" así que lo hago por estadistica...
            // ... un 40% de probabilidad de que se añada un recurso
            int probabilidadZ = (int) Math.random() * 100;
            if (partida.getProbabilidadZ() <= probabilidadZ) {
                // No veo claro como calcular la probabilidad V así que lo pondero...
                int probabilidadV = (int) Math.random() * 100;
                if (probabilidadV < 10) {
                    casilla.addElemento(new Pozo(partida.getTiempoActividad(), casilla));
                } else if (probabilidadV < 20) {
                    casilla.addElemento(new Montaña(partida.getTiempoActividad(), casilla));
                } else if (probabilidadV < 40) {
                    casilla.addElemento(new Biblioteca(partida.getTiempoActividad(), casilla));
                } else if (probabilidadV < 60) {
                    casilla.addElemento(new Tesoro(partida.getTiempoActividad(), casilla));
                } else if (probabilidadV < 80) {
                    casilla.addElemento(new Comida(partida.getTiempoActividad(), casilla));
                } else if (probabilidadV < 100) {
                    casilla.addElemento(new Agua(partida.getTiempoActividad(), casilla));
                }
            }
        }
    }

    public void maxCosasCasilla(Casilla casilla){
        while (casilla.getIndividuos().getNumeroElementos() > partida.getMaxIndividuos()) {
            int posicionEliminar = (int) (Math.random() * casilla.getIndividuos().getNumeroElementos());
            casilla.getIndividuos().del(posicionEliminar);
        }
        while (casilla.getElementos().getNumeroElementos() > partida.getMaxElementos()) {
            int posicionEliminar = (int) (Math.random() * casilla.getElementos().getNumeroElementos());
            casilla.getElementos().del(posicionEliminar);
        }
    }

    private void relacionesIndividuos(Casilla casilla) {
        // Reproducción
        ElementoLE elementoLE = casilla.getIndividuos().getPrimero();
        while (elementoLE != null) {
            Individuo individuo = (Individuo) elementoLE.getData();
            if (elementoLE.getSiguiente() != null) {
                boolean r = reproduccion(individuo, (Individuo) elementoLE.getSiguiente().getData(), casilla);
                if (r) {
                    // Solo una reproducción, no acabemos como los chinos
                    break;
                }
            }
            elementoLE = elementoLE.getSiguiente();
        }

        // Clonación
        elementoLE = casilla.getIndividuos().getPrimero();
        while (elementoLE != null) {
            Individuo individuo = (Individuo) elementoLE.getData();
            if (individuo.getProbClonacion() > partida.getProbanilidadEjecucionClonacion()) {
                partida.colocarIndividuo(casilla, individuo.getRango());
            }

            elementoLE = elementoLE.getSiguiente();
        }
    }

    private boolean reproduccion(Individuo individuo1, Individuo individuo2, Casilla casilla) {
        int probabilidadReproduccion = (individuo1.getProbReproduccion() + individuo2.getProbReproduccion()) / 2;
        if (probabilidadReproduccion > partida.getProbanilidadEjecucionReproduccion()) {
            partida.colocarIndividuo(
                    casilla,
                    Math.max(individuo1.getRango(), individuo2.getRango())
            );
            return true;
        }
        return false;
    }

    private void evaluarIndividuoRecursos(Individuo individuo) {
        ElementoLE elementoLe = individuo.getCasilla().getElementos().getPrimero();
        while (elementoLe != null) {
            Elemento elemento = (Elemento) elementoLe.getData();
            if (elemento instanceof Agua) {
                individuo.setTurnosVida(individuo.getTurnosVida() + elemento.getAlteracion());
                individuo.getOperaciones().add(new Operacion("Bebe agua", partida.getTurno(), 3));
            } else if (elemento instanceof Comida) {
                individuo.setTurnosVida(individuo.getTurnosVida() + elemento.getAlteracion());
                individuo.getOperaciones().add(new Operacion("Come", partida.getTurno(), 4));
            } else if (elemento instanceof Montaña) {
                individuo.setTurnosVida(individuo.getTurnosVida() + elemento.getAlteracion());
                individuo.getOperaciones().add(new Operacion("Montaña", partida.getTurno(), 5));
            } else if (elemento instanceof Tesoro) {
                individuo.setProbReproduccion(individuo.getProbReproduccion() + elemento.getProbabilidad());
                individuo.getOperaciones().add(new Operacion("Montaña", partida.getTurno(), 6));
            } else if (elemento instanceof Biblioteca) {
                individuo.setProbClonacion(individuo.getProbClonacion() + elemento.getProbabilidad());
                individuo.getOperaciones().add(new Operacion("Montaña", partida.getTurno(), 7));
                if (individuo.getRango() < 3) {
                    individuo.setRango(individuo.getRango() + 1);
                }
            } else if (elemento instanceof Pozo) {
                individuo.setProbMuerte(100);
                individuo.getOperaciones().add(new Operacion("Montaña", partida.getTurno(), 8));
            }

            elementoLe = elementoLe.getSiguiente();
        }
    }




    private ListaDoblementeEnlazada<Individuo> listaIndividuos;
    private ListaDoblementeEnlazada<Casilla> tablero;

    public void actualizarElementos(){
        ListaDoblementeEnlazada<Elemento> listaElementos = new ListaDoblementeEnlazada<>();
        /*for (Elemento elemento : partida.getListaElementos()){
            elemento.setTiempoActividad(elemento.getTiempoActividad()-1);
            if (elemento.getTiempoActividad() > 0){
                listaElementos.add(elemento);
            } else {
                elemento.getCasilla().removeElementoCasilla(elemento);
            }
        }
        partida.setListaElementos(listaElementos);*/
    }



        //4-Evaluar las mejoras obtenidas por los recursos
    public Individuo individuoMejorado(ListaDoblementeEnlazada<Casilla> listaCasillas,
                                       ListaDoblementeEnlazada<Individuo> listaIndividuos,
                                       ListaDoblementeEnlazada<Elemento> listaElementos,
                                        Partida partida){
        /*for (Casilla casilla : listaCasillas){
            for (Individuo individuo : listaIndividuos){
                for (Elemento elemento : listaElementos){
                    individuoConRecurso(individuo, elemento, partida);
                }
            }
        }
        return individuo;*/
        return null;
    }

        //5-Reproduccion
    public Individuo reproducir(@NotNull Individuo a, @NotNull Individuo b, ListaDoblementeEnlazada<Individuo> listaIndividuos){
        /*Individuo hijo = null;
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
        return hijo;*/
        return null;
    }

        //6-Clonación
    public Individuo clonar(@NotNull Individuo individuo, Partida partida){
        /*Individuo individuoClonar = null;
        if (individuo.getProbClonacion() >= partida.getProbClonacion()){
            individuoClonar = individuo;
        }
        individuo.addIndividuo(individuoClonar);
        Casilla casilla = individuoClonar.getCasilla();
        casilla.setColumna(individuoClonar.getCasilla().getColumna());
        casilla.setFila(individuoClonar.getCasilla().getFila());
        return individuoClonar;*/
        return null;
    }

        //7-Evaluar Casillas
    public int evaluarCapacidadCasilla(Casilla casilla){
        /*if (casilla.getIndividuosTotales() < partida.getMaximosIndividuos()) {
            int a = 1;
            for (int i = 0; i < partida.getMaximosIndividuos(); i++) {
                if (i < casilla.getIndividuosTotales()) {
                    a += 2;
                }
            }
            return a;
        }*/
        return 0;
    }

    public ListaDoblementeEnlazada<Integer> reordenar(Casilla casilla){
        ListaDoblementeEnlazada<Integer> id = new ListaDoblementeEnlazada<>();
        /*Collections.sort(casilla.getIndividuosCasilla());
        for (Individuo individuo1 : casilla.getIndividuosCasilla()){
            id.add(individuo1.getId());
        }
        return id;*/
        return null;
    }

        //8-Aparición recursos
    public ListaDoblementeEnlazada<Elemento> aparicionRecursos(ListaDoblementeEnlazada<Casilla> listaCasillas,
                                                               ListaDoblementeEnlazada<Elemento> listaElementos){
        /*for (Casilla casilla : listaCasillas){
            if (casilla.getElementosCasilla().getNumeroElementos() < 3){
                for (Elemento elemento : listaElementos){
                }
            }
        }
        return listaElementos;*/
        return null;
    }
}
