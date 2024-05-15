package org.example.practicafinal.Clases.Partida;

import com.google.gson.JsonObject;
import org.example.practicafinal.Clases.Entorno.*;
import org.example.practicafinal.Clases.Individuo.Individuo;
import org.example.practicafinal.Clases.Individuo.IndividuoAvanzado;
import org.example.practicafinal.Clases.Individuo.IndividuoBasico;
import org.example.practicafinal.Clases.Individuo.IndividuoNormal;
import org.example.practicafinal.Clases.Tablero.Casilla;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PartidaTest {

    @Test
    void testToJson(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        JsonObject jsonResult = partida.toJson();
        assertNotNull(jsonResult);
        assertEquals(5, jsonResult.get("probReproduccion").getAsInt());
        assertEquals(10, jsonResult.get("probClonacion").getAsInt());
        assertEquals(3, jsonResult.get("turnosVida").getAsInt());
        assertEquals(4, jsonResult.get("numeroIndividuosBasicos").getAsInt());
        assertEquals(5, jsonResult.get("numeroIndividuosNormal").getAsInt());
        assertEquals(1, jsonResult.get("numeroIndividuosAvanzados").getAsInt());
        assertEquals(3, jsonResult.get("agua").getAsInt());
        assertEquals(2, jsonResult.get("comida").getAsInt());
        assertEquals(1, jsonResult.get("montana").getAsInt());
        assertEquals(4, jsonResult.get("cofre").getAsInt());
        assertEquals(2, jsonResult.get("biblioteca").getAsInt());
        assertEquals(1, jsonResult.get("pozo").getAsInt());
        assertEquals(4, jsonResult.get("tiempoActividad").getAsInt());
        assertEquals(4, jsonResult.get("columnas").getAsInt());
        assertEquals(5, jsonResult.get("filas").getAsInt());
    }

    @Test
    void testGetTurno(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(0, partida.getTurno());
    }

    @Test
    void testSetTurno(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        partida.setTurno(2);
        assertEquals(2, partida.getTurno());
    }

    @Test
    void testGetMaximosIndividuos(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(3, partida.getMaximosIndividuos());
    }

    @Test
    void testGetProbReproduccion(){
        Partida partida = new Partida(1, 5, 10, 3);
        assertEquals(5, partida.getProbReproduccion());
    }

    @Test
    void testGetProbClonacion(){
        Partida partida = new Partida(1, 5, 10, 3);
        assertEquals(10, partida.getProbClonacion());
    }

    @Test
    void testGetId(){
        Partida partida = new Partida(1, 5, 10, 3);
        assertEquals(1, partida.getId());
    }

    @Test
    void testSetId(){
        Partida partida = new Partida();
        partida.setId(2);
        assertEquals(2, partida.getId());
    }

    @Test
    void testGetTurnosVida(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 4, 5);
        assertEquals(3, partida.getTurnosVida());
    }

    @Test
    void testGetListaIndividuos(){
        Partida partida = new Partida();
        Individuo ind1 = new Individuo();
        Individuo ind2 = new Individuo();
        Individuo ind3 = new Individuo();
        List<Individuo> listaIndividuos = new ArrayList<>();
        listaIndividuos.add(ind1);
        listaIndividuos.add(ind2);
        listaIndividuos.add(ind3);
        assertEquals(partida.getListaIndividuos(), partida.getListaIndividuos());
    }

    @Test
    void testGetNumeroIndividuosBasicos(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 4, 5);
        assertEquals(4, partida.getNumeroIndividuosBasicos());
    }

    @Test
    void testSetNumeroIndividuosBasicos(){
        Partida partida = new Partida();
        partida.setNumeroIndividuosBasicos(2);
        assertEquals(2, partida.getNumeroIndividuosBasicos());
    }

    @Test
    void testGetNumeroIndividuosNormal(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 4, 5);
        assertEquals(5, partida.getNumeroIndividuosNormal());
    }

    @Test
    void testSetNumeroIndividuosNormal(){
        Partida partida = new Partida();
        partida.setNumeroIndividuosNormal(2);
        assertEquals(2, partida.getNumeroIndividuosNormal());
    }

    @Test
    void testGetNumeroIndividuosAvanzados(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 4, 5);
        assertEquals(1, partida.getNumeroIndividuosAvanzados());
    }

    @Test
    void testSetNumeroIndividuosAvanzados(){
        Partida partida = new Partida();
        partida.setNumeroIndividuosAvanzados(2);
        assertEquals(2, partida.getNumeroIndividuosAvanzados());
    }

    @Test
    void testGetAgua(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(3, partida.getAgua());
    }

    @Test
    void testSetAgua(){
        Partida partida = new Partida();
        partida.setAgua(2);
        assertEquals(2, partida.getAgua());
    }

    @Test
    void testGetComida(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(2, partida.getComida());
    }

    @Test
    void testSetComida(){
        Partida partida = new Partida();
        partida.setComida(1);
        assertEquals(1, partida.getComida());
    }

    @Test
    void testGetMontana(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(1, partida.getMontana());
    }

    @Test
    void testSetMontana(){
        Partida partida = new Partida();
        partida.setMontana(4);
        assertEquals(4, partida.getMontana());
    }

    @Test
    void testGetCofre(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(4, partida.getCofre());
    }

    @Test
    void testSetCofre(){
        Partida partida = new Partida();
        partida.setCofre(2);
        assertEquals(2, partida.getCofre());
    }

    @Test
    void testGetBiblioteca(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(2, partida.getBiblioteca());
    }

    @Test
    void testSetBiblioteca(){
        Partida partida = new Partida();
        partida.setBiblioteca(2);
        assertEquals(2, partida.getBiblioteca());
    }

    @Test
    void testGetPozo(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(1, partida.getPozo());
    }

    @Test
    void testSetPozo(){
        Partida partida = new Partida();
        partida.setPozo(2);
        assertEquals(2, partida.getPozo());
    }

    @Test
    void testGetListaElementos(){
        Partida partida = new Partida();
        Elementos elemento1 = new Elementos();
        Elementos elemento2 = new Elementos();
        Elementos elemento3 = new Elementos();
        List<Elementos> listaElementos = new ArrayList<>();
        listaElementos.add(elemento1);
        listaElementos.add(elemento2);
        listaElementos.add(elemento3);
        assertEquals(partida.getListaElementos(), partida.getListaElementos());
    }

    @Test
    void testGetTiempoActividad(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(4, partida.getTiempoActividad());
    }

    @Test
    void testSetColumnas(){
        Partida partida = new Partida();
        partida.setColumnas(2);
        assertEquals(2, partida.getColumnas());
    }

    @Test
    void testGetColumnas(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(4, partida.getColumnas());
    }

    @Test
    void testSetFilas(){
        Partida partida = new Partida();
        partida.setFilas(2);
        assertEquals(2, partida.getFilas());
    }

    @Test
    void testGetFilas(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(5, partida.getFilas());
    }

    @Test
    void testSetListaCasillas(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        Casilla casilla1 = new Casilla(1, 2);
        Casilla casilla2 = new Casilla(2, 1);
        Casilla casilla3 = new Casilla(3, 1);
        List<Casilla> listaCasillas = new ArrayList<>();
        listaCasillas.add(casilla1);
        listaCasillas.add(casilla2);
        listaCasillas.add(casilla3);
        partida.setListaCasillas(listaCasillas);
        assertEquals(listaCasillas, partida.getListaCasillas());
    }

    @Test
    void testGetListaCasillas(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        Casilla casilla1 = new Casilla(1, 2);
        Casilla casilla2 = new Casilla(2, 1);
        Casilla casilla3 = new Casilla(3, 1);
        List<Casilla> listaCasillas = new ArrayList<>();
        listaCasillas.add(casilla1);
        listaCasillas.add(casilla2);
        listaCasillas.add(casilla3);
        assertEquals(partida.getListaCasillas(), partida.getListaCasillas());
    }

    @Test
    void testCrearBasico(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        Casilla casilla1 = new Casilla(1, 2);
        Casilla casilla2 = new Casilla(2, 1);
        Casilla casilla3 = new Casilla(3, 1);
        List<Casilla> listaCasillas = new ArrayList<>();
        listaCasillas.add(casilla1);
        listaCasillas.add(casilla2);
        listaCasillas.add(casilla3);
        IndividuoBasico basico = partida.crearBasico();
        assertNotNull(basico);
        assertEquals(1, partida.getId());
        assertEquals(0, partida.getTurno());
        assertEquals(3, partida.getTurnosVida());
        assertEquals(5, partida.getProbReproduccion());
        assertEquals(10, partida.getProbClonacion());
    }

    @Test
    void testCrearNormal(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        Casilla casilla1 = new Casilla(1, 2);
        Casilla casilla2 = new Casilla(2, 1);
        Casilla casilla3 = new Casilla(3, 1);
        List<Casilla> listaCasillas = new ArrayList<>();
        listaCasillas.add(casilla1);
        listaCasillas.add(casilla2);
        listaCasillas.add(casilla3);
        IndividuoNormal normal = partida.crearNormal();
        assertNotNull(normal);
        assertEquals(1, partida.getId());
        assertEquals(0, partida.getTurno());
        assertEquals(3, partida.getTurnosVida());
        assertEquals(5, partida.getProbReproduccion());
        assertEquals(10, partida.getProbClonacion());
    }

    @Test
    void testCrearAvanzado(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        Casilla casilla1 = new Casilla(1, 2);
        Casilla casilla2 = new Casilla(2, 1);
        Casilla casilla3 = new Casilla(3, 1);
        List<Casilla> listaCasillas = new ArrayList<>();
        listaCasillas.add(casilla1);
        listaCasillas.add(casilla2);
        listaCasillas.add(casilla3);
        IndividuoAvanzado avanzado = partida.crearAvanzado();
        assertNotNull(avanzado);
        assertEquals(1, partida.getId());
        assertEquals(0, partida.getTurno());
        assertEquals(3, partida.getTurnosVida());
        assertEquals(5, partida.getProbReproduccion());
        assertEquals(10, partida.getProbClonacion());
    }

    @Test
    void testIndividuosInicio(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);

    }

    @Test
    void testCrearAgua(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        Casilla casilla1 = new Casilla(1, 2);
        Casilla casilla2 = new Casilla(2, 1);
        Casilla casilla3 = new Casilla(3, 1);
        List<Casilla> listaCasillas = new ArrayList<>();
        listaCasillas.add(casilla1);
        listaCasillas.add(casilla2);
        listaCasillas.add(casilla3);
        Agua agua = partida.crearAgua();
        assertNotNull(agua);
        assertEquals(4, partida.getTiempoActividad());
    }

    @Test
    void testCrearComida(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        Casilla casilla1 = new Casilla(1, 2);
        Casilla casilla2 = new Casilla(2, 1);
        Casilla casilla3 = new Casilla(3, 1);
        List<Casilla> listaCasillas = new ArrayList<>();
        listaCasillas.add(casilla1);
        listaCasillas.add(casilla2);
        listaCasillas.add(casilla3);
        Comida comida = partida.crearComida();
        assertNotNull(comida);
        assertEquals(4, partida.getTiempoActividad());
    }

    @Test
    void testCrearBiblioteca(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        Casilla casilla1 = new Casilla(1, 2);
        Casilla casilla2 = new Casilla(2, 1);
        Casilla casilla3 = new Casilla(3, 1);
        List<Casilla> listaCasillas = new ArrayList<>();
        listaCasillas.add(casilla1);
        listaCasillas.add(casilla2);
        listaCasillas.add(casilla3);
        Biblioteca biblioteca = partida.crearBiblioteca();
        assertNotNull(biblioteca);
        assertEquals(4, partida.getTiempoActividad());
    }

    @Test
    void testCrearMontaña(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        Casilla casilla1 = new Casilla(1, 2);
        Casilla casilla2 = new Casilla(2, 1);
        Casilla casilla3 = new Casilla(3, 1);
        List<Casilla> listaCasillas = new ArrayList<>();
        listaCasillas.add(casilla1);
        listaCasillas.add(casilla2);
        listaCasillas.add(casilla3);
        Montaña montana = partida.crearMontaña();
        assertNotNull(montana);
        assertEquals(4, partida.getTiempoActividad());
    }

    @Test
    void testCrearTesoro(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        Casilla casilla1 = new Casilla(1, 2);
        Casilla casilla2 = new Casilla(2, 1);
        Casilla casilla3 = new Casilla(3, 1);
        List<Casilla> listaCasillas = new ArrayList<>();
        listaCasillas.add(casilla1);
        listaCasillas.add(casilla2);
        listaCasillas.add(casilla3);
        Tesoro tesoro = partida.crearTesoro();
        assertNotNull(tesoro);
        assertEquals(4, partida.getTiempoActividad());
    }

    @Test
    void testCrearPozo(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        Casilla casilla1 = new Casilla(1, 2);
        Casilla casilla2 = new Casilla(2, 1);
        Casilla casilla3 = new Casilla(3, 1);
        List<Casilla> listaCasillas = new ArrayList<>();
        listaCasillas.add(casilla1);
        listaCasillas.add(casilla2);
        listaCasillas.add(casilla3);
        Pozo pozo = partida.crearPozo();
        assertNotNull(pozo);
        assertEquals(4, partida.getTiempoActividad());
    }

    @Test
    void testElementosPrincipio(){

    }

    @Test
    void testMoverBasico(){

    }

    @Test
    void testMoverNormal(){

    }

    @Test
    void testMoverIndividuo(){

    }

    @Test
    void testModificarId(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        partida.modificarId();
        assertEquals(1, partida.getId());
    }

    @Test
    void testModificarTurno(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        partida.modificarTurno();
        assertEquals(1, partida.getTurno());
    }

    @Test
    void testFilaAleatoria(){
        Partida partida = new Partida();
        int fila = partida.filaAleatoria();
        assertTrue(fila >= 0 && fila < 10, "El valor de fila debe estar entre 0 y " + (10 - 1));
    }

    @Test
    void testColumnaAleatoria(){
        Partida partida = new Partida();
        int columna = partida.filaAleatoria();
        assertTrue(columna >= 0 && columna < 10, "El valor de columna debe estar entre 0 y " + (10 - 1));
    }

    @Test
    void testCasillaAleatoria(){
        Partida partida = new Partida();
        Casilla casilla = partida.casillaAleatoria();
        assertNotNull(casilla);
        assertEquals(casilla, casilla);
    }

    @Test
    void testGetIndividuosTotales(){
        Partida partida = new Partida();
        assertEquals(0, partida.getIndividuosTotales());
    }
}