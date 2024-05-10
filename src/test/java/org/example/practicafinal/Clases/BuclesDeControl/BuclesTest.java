package org.example.practicafinal.Clases.BuclesDeControl;

import org.example.practicafinal.Clases.Entorno.Elementos;
import org.example.practicafinal.Clases.Individuo.Individuo;
import org.example.practicafinal.Clases.Partida.Partida;
import org.example.practicafinal.Clases.Tablero.Casilla;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BuclesTest {

    @Test
    void testModificarIndividuo(){
        Individuo ind = new Individuo(1, 2, 5, 50, 60);
        Individuo ind2 = new Individuo(2, 3, 0, 50, 60);
        Individuo ind3 = new Individuo(3, 4, 7, 0, 60);
        Bucles bucles = new Bucles();
        List<Individuo> individuos = new ArrayList<>();
        individuos.add(ind);
        individuos.add(ind2);
        individuos.add(ind3);
        bucles.modificarIndividuo(ind, individuos);
        assertEquals(4, ind.getTurnosVida());
        assertEquals(54, ind.getProbClonacion());
        assertEquals(45, ind.getProbReproduccion());
        assertEquals(0, ind2.getTurnosVida());
        assertEquals(0, ind3.getProbReproduccion());
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
        bucles.eliminarIndividuo(ind2, individuos);
        bucles.eliminarIndividuo(ind3, individuos);
        assertEquals(false, individuos.contains(ind2));
        assertEquals(false, individuos.contains(ind3));
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
        bucles.actualizarIndividuos(individuos);
        assertEquals(4, ind1.getTurnosVida());
        assertEquals(54, ind1.getProbClonacion());
        assertEquals(45, ind1.getProbReproduccion());
        assertEquals(false, individuos.contains(ind2));
        assertEquals(false, individuos.contains(ind3));
    }

    @Test
    void testModificarElementos(){
        Elementos elementos = new Elementos(4, 0);
        Bucles bucles = new Bucles();
        bucles.modificarElemento(elementos);
        assertEquals(3, elementos.getTiempoActividad());
    }

    @Test
    void testEliminarElementos(){
        Elementos elemento1 = new Elementos(0, 1);
        Elementos elemento2 = new Elementos(1, 2);
        ArrayList<Elementos> listaElementos = new ArrayList<>();
        listaElementos.add(elemento1);
        listaElementos.add(elemento2);
        Bucles bucles = new Bucles(listaElementos);
        bucles.eliminarElemento(elemento1, listaElementos);
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
        Bucles bucles = new Bucles(listaElementos);
        bucles.actualizarElementos(listaElementos);
        assertEquals(0, elemento2.getTiempoActividad());
        assertEquals(true, listaElementos.contains(elemento1));
        assertEquals(true, listaElementos.contains(elemento3));
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
        bucles.individuoConRecurso(ind1, elemento3, partida);
        assertEquals(15, ind1.getTurnosVida());
        bucles.individuoConRecurso(ind1, elemento4, partida);
        assertEquals(50, ind1.getProbReproduccion());
        bucles.individuoConRecurso(ind1, elemento5, partida);
        ind1.setProbabilidadMuerte(100);
        assertEquals(50, ind1.getProbReproduccion());
    }
}