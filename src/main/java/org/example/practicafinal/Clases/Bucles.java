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
                    individuoActual = individuoActual.getSiguiente();
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
                    individuo.getOperaciones().add(new Operacion("Se mueve a la casilla", partida.getTurno(), 11));
                    evaluarIndividuoRecursos(individuo);
                    if (individuo.getProbMuerte() >= 100 || individuo.getTurnosVida() == 0) {
                        individuo.getOperaciones().add(new Operacion("Muerte", partida.getTurno(), 2));
                        individuoActual = individuoActual.getSiguiente();
                        continue; // Continuo el bucle porque el individuo ha muerto fijo
                    }

                    casillaDestino.addIndividuo(individuo);
                }

                individuoActual = individuoActual.getSiguiente();
            }

            relacionesIndividuos(casilla);

            casillaActual = casillaActual.getSiguiente();
        }
    }

    public void evaluarCasillas() {
        ElementoLE casillaActual = partida.getListaCasillas().getPrimero();
        while (casillaActual != null) {
            Casilla casilla = (Casilla) casillaActual.getData();
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
            if (individuo.getProbClonacion() > partida.getProbabilidadEjecucionClonacion()) {
                Individuo in = partida.colocarIndividuo(casilla, individuo.getRango());
                in.addPadre(individuo);
                individuo.addHijo(in);
                individuo.getOperaciones().add(new Operacion("Clonacion", partida.getTurno(), 9));
            }

            elementoLE = elementoLE.getSiguiente();
        }
    }

    private boolean reproduccion(Individuo individuo1, Individuo individuo2, Casilla casilla) {
        int probabilidadReproduccion = (individuo1.getProbReproduccion() + individuo2.getProbReproduccion()) / 2;
        if (probabilidadReproduccion > partida.getProbabilidadEjecucionReproduccion()) {
            Individuo individuo = partida.colocarIndividuo(
                    casilla,
                    Math.max(individuo1.getRango(), individuo2.getRango())
            );
            individuo1.addHijo(individuo);
            individuo1.getOperaciones().add(new Operacion("Reproducción", partida.getTurno(), 10));
            individuo2.addHijo(individuo);
            individuo2.getOperaciones().add(new Operacion("Reproducción", partida.getTurno(), 10));
            individuo.addPadre(individuo1);
            individuo.addPadre(individuo2);
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
                individuo.getOperaciones().add(new Operacion("Cae en Pozo", partida.getTurno(), 8));
            }

            elementoLe = elementoLe.getSiguiente();
        }
    }

        //8-Aparición recursos
    public ListaDoblementeEnlazada<Elemento> aparicionRecursos(ListaDoblementeEnlazada<Casilla> listaCasillas,
                                                               ListaDoblementeEnlazada<Elemento> listaElementos){

        for (int i =0; i<listaCasillas.getNumeroElementos(); i++){
            Casilla casilla = listaCasillas.getElemento(i).getData();
            if (casilla.getElementos().getNumeroElementos()<3){
                Elemento elemento = new Elemento();
                int j = (int) (Math.random()*6);
                if (j==0){
                    elemento=new Agua(partida.getTiempoActividad(), casilla);
                } else if (j==1){
                    elemento=new Comida(partida.getTiempoActividad(), casilla);
                } else if (j==2){
                    elemento = new Biblioteca(partida.getTiempoActividad(), casilla);
                } else if (j==3){
                    elemento = new Tesoro(partida.getTiempoActividad(), casilla);
                } else if (j==4){
                    elemento = new Montaña(partida.getTiempoActividad(), casilla);
                } else {
                    elemento=new Pozo(partida.getTiempoActividad(), casilla);
                }
                listaElementos.add(elemento);
            }
        }
        return listaElementos;
    }
}
