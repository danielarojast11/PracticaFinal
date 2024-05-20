package org.example.practicafinal.Clases.BuclesDeControl;

import org.example.practicafinal.Clases.Entorno.Elementos;
import org.example.practicafinal.Clases.Individuo.Individuo;
import org.example.practicafinal.Clases.Individuo.IndividuoAvanzado;
import org.example.practicafinal.Clases.Individuo.IndividuoBasico;
import org.example.practicafinal.Clases.Individuo.IndividuoNormal;
import org.example.practicafinal.Clases.Partida.Partida;
import org.example.practicafinal.Clases.Tablero.Casilla;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BuclesTest {

    @Test
    void testSetPartida(){
        Bucles bucles = new Bucles();
        Partida partida = new Partida();
        bucles.setPartida(partida);
        assertEquals(partida, partida);
    }

    @Test
    void testEliminarIndividuo(){
        Individuo ind = new Individuo(1, 2, 5, 50, 60);
        Individuo ind2 = new Individuo(2, 3, 0, 50, 60);
        Individuo ind3 = new Individuo(3, 4, 7, 0, 60);
        List<Individuo> individuos = new ArrayList<>();
        individuos.add(ind);
        individuos.add(ind2);
        individuos.add(ind3);
        Bucles bucles = new Bucles();
        bucles.eliminarIndividuo(individuos);
        bucles.eliminarIndividuo(individuos);
        assertEquals(false, individuos.contains(ind2));
        assertEquals(true, individuos.contains(ind3));
    }

    @Test
    void testActualizarIndividuo(){
        Individuo ind1 = new Individuo(1, 2, 5, 50, 60);
        Individuo ind2 = new Individuo(2, 3, 0, 50, 60);
        Individuo ind3 = new Individuo(3, 4, 7, 0, 60);
        ArrayList<Individuo> individuos = new ArrayList<>();
        individuos.add(ind1);
        individuos.add(ind2);
        individuos.add(ind3);
        Bucles bucles = new Bucles();
        bucles.actualizarIndividuos();
        assertEquals(4, ind1.getTurnosVida());
        assertEquals(54, ind1.getProbClonacion());
        assertEquals(45, ind1.getProbReproduccion());
        assertEquals(false, individuos.contains(ind2));
        assertEquals(true, individuos.contains(ind3));
    }

    @Test
    void testModificarElementos(){
        Elementos elementos = new Elementos(4, 0);
        Bucles bucles = new Bucles();
        //bucles.modificarElemento(elementos);
        assertEquals(3, elementos.getTiempoActividad());
    }

    @Test
    void testEliminarElementos(){
        Elementos elemento1 = new Elementos(0, 1);
        Elementos elemento2 = new Elementos(1, 2);
        ArrayList<Elementos> listaElementos = new ArrayList<>();
        listaElementos.add(elemento1);
        listaElementos.add(elemento2);
        Bucles bucles = new Bucles();
        //bucles.eliminarElemento(elemento1, listaElementos);
        assertEquals(false, listaElementos.contains(elemento1));
        assertEquals(true, listaElementos.contains(elemento2));
    }

    @Test
    void testActualizarElementos(){
        Elementos elemento1 = new Elementos(0, 3);
        Elementos elemento2 = new Elementos(1, 4);
        Elementos elemento3 = new Elementos(2, 5);
        ArrayList<Elementos> listaElementos = new ArrayList<>();
        listaElementos.add(elemento1);
        listaElementos.add(elemento2);
        listaElementos.add(elemento3);
        Bucles bucles = new Bucles();
        bucles.actualizarElementos();
        assertEquals(0, elemento2.getTiempoActividad());
        assertEquals(true, listaElementos.contains(elemento1));
        assertEquals(true, listaElementos.contains(elemento3));
    }

    @Test
    void testMoverIndividuos(){

    }

    @Test
    void testIndividuoMejorado(){
        Casilla casilla1 = new Casilla();
        Casilla casilla2 = new Casilla();
        Casilla casilla3 = new Casilla();
        ArrayList<Casilla> listaCasillas = new ArrayList<>();
        listaCasillas.add(casilla1);
        listaCasillas.add(casilla2);
        listaCasillas.add(casilla3);
        Individuo ind1 = new Individuo(1, 2, 5, 50, 60);
        Individuo ind2 = new Individuo(2, 3, 0, 50, 60);
        Individuo ind3 = new Individuo(3, 4, 7, 0, 60);
        ArrayList<Individuo> individuos = new ArrayList<>();
        individuos.add(ind1);
        individuos.add(ind2);
        individuos.add(ind3);
        Elementos elemento1 = new Elementos(4, 0);
        Elementos elementos2 = new Elementos(5, 1);
        Elementos elementos3 = new Elementos(6, 2);
        ArrayList<Elementos> listaElementos = new ArrayList<>();
        listaElementos.add(elemento1);
        listaElementos.add(elementos2);
        listaElementos.add(elementos3);
        Partida partida = new Partida();
        Bucles bucle = new Bucles();
        bucle.individuoMejorado(listaCasillas, individuos, listaElementos, partida);
        assertEquals(41, ind1.getTurnosVida());
        assertEquals(36, ind2.getTurnosVida());
        assertEquals(43, ind3.getTurnosVida());
    }

    @Test
    void testIndividuoConRecurso(){
        Individuo ind1 = new Individuo(1, 2, 5, 50, 60, 2);
        Individuo ind2 = new Individuo(1, 2, 5, 50, 60, 3);
        Elementos elemento0 = new Elementos(4, 0);
        Elementos elemento1 = new Elementos(5, 1);
        Elementos elemento2 = new Elementos(6, 2);
        Elementos elemento3 = new Elementos(7, 3);
        Elementos elemento4 = new Elementos(8, 4);
        Elementos elemento5 = new Elementos(9, 5);
        Partida partida = new Partida();
        Bucles bucles = new Bucles();
        bucles.individuoConRecurso(ind1, elemento0, partida);
        assertEquals(7, ind1.getTurnosVida());
        bucles.individuoConRecurso(ind1, elemento1, partida);
        assertEquals(17, ind1.getTurnosVida());
        bucles.individuoConRecurso(ind1, elemento2, partida);
        assertEquals(60, ind1.getProbClonacion());
        assertEquals(3, ind1.getRango());
        assertEquals(3, ind2.getRango());
        bucles.individuoConRecurso(ind1, elemento3, partida);
        assertEquals(15, ind1.getTurnosVida());
        bucles.individuoConRecurso(ind1, elemento4, partida);
        assertEquals(50, ind1.getProbReproduccion());
        bucles.individuoConRecurso(ind1, elemento5, partida);
        ind1.setProbabilidadMuerte(100);
        assertEquals(50, ind1.getProbReproduccion());
    }

    @Test
    void testReproducir(){
        IndividuoNormal ind2 = new IndividuoNormal(1, 2, 5, 50, 60);
        IndividuoAvanzado ind3 = new IndividuoAvanzado(1, 2, 5, 50, 60);
        IndividuoBasico ind1 = new IndividuoBasico(1, 3, 8, 40, 50);
        IndividuoBasico hijo1 = new IndividuoBasico(1, 3, 8, 40, 50);
        IndividuoNormal hijo2 = new IndividuoNormal(1, 2, 5, 50, 60);
        IndividuoAvanzado hijo3 = new IndividuoAvanzado(1, 2, 5, 50, 60);
        ind1.addHijo(hijo1);
        ind2.addHijo(hijo2);
        ind3.addHijo(hijo3);
        List<Individuo> listaIndividuos = new ArrayList<>();
        listaIndividuos.add(ind1);
        listaIndividuos.add(ind2);
        listaIndividuos.add(ind3);
        Bucles bucles = new Bucles();
        bucles.reproducir(ind3, ind3, listaIndividuos);
        bucles.reproducir(ind2, ind2, listaIndividuos);
        bucles.reproducir(ind1, ind1, listaIndividuos);
        assertEquals(ind1.getHijos(), ind1.getHijos());
        assertEquals(ind2.getHijos(), ind2.getHijos());
        assertEquals(ind3.getHijos(), ind3.getHijos());
    }

    @Test
    void testClonar(){
        Individuo ind1 = new Individuo(1, 2, 5, 50, 60);
        Partida partida = new Partida();
        Bucles bucles = new Bucles();
        bucles.clonar(ind1, partida);
        assertEquals(60, ind1.getProbClonacion());
    }

    @Test
    void testEvaluarCapacidadCasilla(){
        Individuo ind1 = new Individuo(1, 2, 5, 50, 60);
        Individuo ind2 = new Individuo(1, 3, 8, 60, 30);
        Casilla casilla1 = new Casilla();
        casilla1.addIndividuoCasilla(ind1);
        casilla1.addIndividuoCasilla(ind2);
        Bucles bucle = new Bucles();
        bucle.evaluarCapacidadCasilla(casilla1);
        assertEquals(2, casilla1.getIndividuosTotales());
        Individuo ind11 = new Individuo(1, 2, 5, 50, 60);
        Individuo ind21 = new Individuo(1, 3, 8, 60, 30);
        Individuo ind31 = new Individuo(1, 2, 5, 50, 60);
        Individuo ind41 = new Individuo(1, 3, 8, 60, 30);
        Casilla casilla2 = new Casilla();
        casilla2.addIndividuoCasilla(ind11);
        casilla2.addIndividuoCasilla(ind21);
        casilla2.addIndividuoCasilla(ind31);
        casilla2.addIndividuoCasilla(ind41);
        Bucles bucle2 = new Bucles();
        bucle2.evaluarCapacidadCasilla(casilla2);
        assertEquals(4, casilla2.getIndividuosTotales());
    }

    @Test
    void testEvaluarIndividuosCasilla(){
        Individuo ind1 = new Individuo(1, 2, 5, 50, 60);
        Individuo ind2 = new Individuo(1, 3, 8, 60, 30);
        Casilla casilla1 = new Casilla();
        casilla1.addIndividuoCasilla(ind1);
        casilla1.addIndividuoCasilla(ind2);
        Bucles bucle = new Bucles();
        bucle.evaluarIndividuosCasilla(casilla1);
        assertEquals(ind1, casilla1.getIndividuosCasilla().getFirst());
    }

    @Test
    void testReordenar(){
        Individuo ind1 = new Individuo(1, 2, 5, 50, 60);
        Individuo ind2 = new Individuo(3, 3, 8, 60, 30);
        Individuo ind3 = new Individuo(4, 2, 5, 50, 60);
        Individuo ind4 = new Individuo(2, 3, 8, 60, 30);
        Casilla casilla1 = new Casilla();
        casilla1.addIndividuoCasilla(ind1);
        casilla1.addIndividuoCasilla(ind2);
        casilla1.addIndividuoCasilla(ind3);
        casilla1.addIndividuoCasilla(ind4);
        Bucles bucles = new Bucles();
        bucles.reordenar(casilla1);
    }

    @Test
    void testEvaluacionFinal(){
        Individuo ind1 = new Individuo(1, 2, 5, 50, 60);
        Individuo ind2 = new Individuo(3, 3, 8, 60, 30);
        Individuo ind3 = new Individuo(4, 2, 5, 50, 60);
        Individuo ind4 = new Individuo(2, 3, 8, 60, 30);
        List<Individuo> listaIndividuos = new ArrayList<>();
        listaIndividuos.add(ind1);
        listaIndividuos.add(ind2);
        listaIndividuos.add(ind3);
        listaIndividuos.add(ind4);
        Casilla casilla1 = new Casilla();
        casilla1.addIndividuoCasilla(ind1);
        casilla1.addIndividuoCasilla(ind2);
        casilla1.addIndividuoCasilla(ind3);
        casilla1.addIndividuoCasilla(ind4);
        Bucles bucles = new Bucles();
        bucles.evaluacionFinal();
    }

    @Test
    void testAparicionRecursos(){
        List<Casilla> listaCasillas = new ArrayList<>();
        Elementos elemento0 = new Elementos(4, 0);
        Elementos elemento1 = new Elementos(5, 1);
        Elementos elemento2 = new Elementos(6, 2);
        Elementos elemento3 = new Elementos(7, 3);
        Elementos elemento4 = new Elementos(8, 4);
        Elementos elemento5 = new Elementos(9, 5);
        List<Elementos> listaElementos1 = new ArrayList<>();
        listaElementos1.add(elemento0);
        listaElementos1.add(elemento1);
        listaElementos1.add(elemento2);
        listaElementos1.add(elemento3);
        listaElementos1.add(elemento4);
        listaElementos1.add(elemento5);
        List<Elementos> listaElementos2 = new ArrayList<>();
        listaElementos2.add(elemento0);
        listaElementos2.add(elemento1);
        Bucles bucle1 = new Bucles();
        bucle1.aparicionRecursos(listaCasillas, listaElementos1);
        Bucles bucle2 = new Bucles();
        bucle2.aparicionRecursos(listaCasillas, listaElementos2);
    }
}