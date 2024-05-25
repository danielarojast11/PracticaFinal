package org.example.practicafinal.EstructurasDeDatos;

import org.example.practicafinal.Entity.*;
import org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada.ElementoLE;

public class EstructurasDeDatos {

    private Partida partida;

    public void EstructurasDeDatos() {
        System.out.println("Estructuras de datos partida");
        System.out.println("¿Qué individuo ha sido el más longevo?: " + individuoMasLongevo());
        System.out.println("¿Cuántas mutaciones ha habido?: "+ cantidadMutaciones());
        System.out.println("¿Cuántas reproducciones ha habido?: " +cantidadReproducciones());
        System.out.println("¿Qué individuo ha tenido más reproducciones?: " + individuoConMasReproducciones());
        System.out.println("¿Qué individuo ha tenido más mutaciones?: " + individuoConMasMutaciones());
        System.out.println("¿Qué individuo ha bebido más agua?: " + individuoMasAgua());
        System.out.println("Qué individuo ha conseguido llegar a un momento de vida máximo?: " + individuoMasTiempoDeVida());
        System.out.println("¿Cuánto ha sido?: " + duracionIndividuoMasTiempoDeVida());
        System.out.println("¿Coincide con el más longevo?: " + comparaIndividuo());
    }

    private Individuo individuoMasLongevo(){
        int longevidad = 0;
        Individuo ind = null;
        ElementoLE elementoLE = partida.getListaIndividuos().getPrimero();
        while (elementoLE != null){
            Individuo individuo = (Individuo) elementoLE.getData();
            if (individuo.getLongevidad() > longevidad){
                longevidad = individuo.getLongevidad();
                ind = individuo;
            }

            elementoLE = elementoLE.getSiguiente();
        }
        return ind;
    }

    private int cantidadMutaciones(){
        int mutaciones = 0;
        ElementoLE elementoLE = partida.getListaIndividuos().getPrimero();
        while (elementoLE != null){
            Individuo individuo = (Individuo) elementoLE.getData();
            ElementoLE elementoLE1 = individuo.getOperaciones().getPrimero();
            while (elementoLE1 != null){
                Operacion operacion = (Operacion) elementoLE1.getData();
                if (operacion.getTipo() == 9){
                    mutaciones++;
                }
                elementoLE1 = elementoLE1.getSiguiente();
            }
            elementoLE = elementoLE.getSiguiente();
        }
        return mutaciones;
    }

    private int cantidadReproducciones(){
        int reproducciones = 0;
        ElementoLE elementoLE = partida.getListaIndividuos().getPrimero();
        while (elementoLE != null){
            Individuo individuo = (Individuo) elementoLE.getData();
            ElementoLE elementoLE1 = individuo.getOperaciones().getPrimero();
            while (elementoLE1 != null){
                Operacion operacion = (Operacion) elementoLE1.getData();
                if (operacion.getTipo() == 10){
                    reproducciones++;
                }
                elementoLE1 = elementoLE1.getSiguiente();
            }
            elementoLE = elementoLE.getSiguiente();
        }
        return reproducciones;
    }

    private Individuo individuoConMasReproducciones(){
        int reproducciones = 0;
        Individuo ind = null;
        ElementoLE elementoLE = partida.getListaIndividuos().getPrimero();
        while (elementoLE != null){
            Individuo individuo = (Individuo) elementoLE.getData();
            ElementoLE elementoLE1 = individuo.getOperaciones().getPrimero();
            while (elementoLE1 != null){
                Operacion operacion = (Operacion) elementoLE1.getData();
                if (operacion.getTipo() == 10){
                    reproducciones++;
                    ind = individuo;
                }
                elementoLE = elementoLE1.getSiguiente();
            }
            elementoLE = elementoLE.getSiguiente();
        }
        return ind;
    }

    private Individuo individuoConMasMutaciones(){
        int mutaciones = 0;
        Individuo ind = null;
        ElementoLE elementoLE = partida.getListaIndividuos().getPrimero();
        while (elementoLE != null){
            Individuo individuo = (Individuo) elementoLE.getData();
            ElementoLE elementoLE1 = individuo.getOperaciones().getPrimero();
            while (elementoLE1 != null){
                Operacion operacion = (Operacion) elementoLE1.getData();
                if (operacion.getTipo() == 9){
                    mutaciones++;
                    ind = individuo;
                }
                elementoLE = elementoLE1.getSiguiente();
            }
            elementoLE = elementoLE.getSiguiente();
        }
        return ind;
    }

    private Individuo individuoMasAgua(){
        int agua = 0;
        Individuo ind = null;
        ElementoLE elementoLE = partida.getListaIndividuos().getPrimero();
        while (elementoLE != null){
            Individuo individuo = (Individuo) elementoLE.getData();
            ElementoLE elementoLE1 = individuo.getOperaciones().getPrimero();
            while (elementoLE1 != null){
                Operacion operacion = (Operacion) elementoLE1.getData();
                if (operacion.getTipo() == 3){
                    agua++;
                    ind = individuo;
                }
                elementoLE = elementoLE1.getSiguiente();
            }
            elementoLE = elementoLE.getSiguiente();
        }
        return ind;
    }

    private void turnosVida (Casilla casilla){
        ElementoLE elemento = casilla.getIndividuos().getPrimero();
        while (elemento != null) {
            Individuo individuo = (Individuo) elemento.getData();
            if (individuo.getTurnosVida() > 0) {
                individuo.getOperaciones().add(new Operacion("Turnos Vida", individuo.getTurnosVida(), 12));
            }
        }
    }

    private Individuo individuoMasTiempoDeVida(){
        int turnosVida = 0;
        Individuo ind = null;
        ElementoLE elementoLE = partida.getListaIndividuos().getPrimero();
        while (elementoLE != null){
            Individuo individuo = (Individuo) elementoLE.getData();
            ElementoLE elementoLE1 = individuo.getOperaciones().getPrimero();
            while (elementoLE1 != null){
                Operacion operacion = (Operacion) elementoLE1.getData();
                if (operacion.getTipo() == 12){
                    turnosVida++;
                    ind = individuo;
                }
                elementoLE = elementoLE1.getSiguiente();
            }
            elementoLE = elementoLE.getSiguiente();
        }
        return ind;
    }

    private int duracionIndividuoMasTiempoDeVida(){
        int turnosVida = 0;
        ElementoLE elementoLE = partida.getListaIndividuos().getPrimero();
        while (elementoLE != null){
            Individuo individuo = (Individuo) elementoLE.getData();
            ElementoLE elementoLE1 = individuo.getOperaciones().getPrimero();
            while (elementoLE1 != null){
                Operacion operacion = (Operacion) elementoLE1.getData();
                if (operacion.getTipo() == 12){
                    turnosVida++;
                }
                elementoLE = elementoLE1.getSiguiente();
            }
            elementoLE = elementoLE.getSiguiente();
        }
        return turnosVida;
    }

    private boolean comparaIndividuo(){
        if (individuoMasLongevo() == individuoMasTiempoDeVida()){
            return true;
        }
        return false;
    }
}
