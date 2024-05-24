package org.example.practicafinal.Entity;

import com.google.gson.JsonObject;
import org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada.ListaDoblementeEnlazada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartidaTest {

    @Test
    void testAumentarId(){
        Partida partida = new Partida(2, 10, 30, 2, 1, 3, 1, 2, 4, 0, 3, 2, 5, 4, 1);
        partida.aumentarid();
        assertEquals(1, partida.getId());
    }

    @Test
    void testGetId(){
        Partida partida = new Partida(2, 10, 30, 2, 1, 3, 1, 2, 4, 0, 3, 2, 5, 4, 1);
        assertEquals(0, partida.getId());
    }

    @Test
    void testSetId(){
        Partida partida = new Partida(2, 10, 30, 2, 1, 3, 1, 2, 4, 0, 3, 2, 5, 4, 1);
        partida.setId(2);
        assertEquals(2, partida.getId());
    }

    @Test
    void testGetMaxIndividuos(){
        Partida partida = new Partida(2, 10, 30, 2, 1, 3, 1, 2, 4, 0, 3, 2, 5, 4, 1);
        assertEquals(3, partida.getMaxIndividuos());
    }

    @Test
    void testSetMaxIndividuos(){
        Partida partida = new Partida(2, 10, 30, 2, 1, 3, 1, 2, 4, 0, 3, 2, 5, 4, 1);
        partida.setMaxIndividuos(3);
        assertEquals(3, partida.getMaxIndividuos());
    }

    @Test
    void testGetMaxElementos(){
        Partida partida = new Partida(2, 10, 30, 2, 1, 3, 1, 2, 4, 0, 3, 2, 5, 4, 1);
        assertEquals(3, partida.getMaxElementos());
    }

    @Test
    void testSetMaxElementos(){
        Partida partida = new Partida(2, 10, 30, 2, 1, 3, 1, 2, 4, 0, 3, 2, 5, 4, 1);
        partida.setMaxElementos(3);
        assertEquals(3, partida.getMaxElementos());
    }

    @Test
    void testGetColumnas(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(4, partida.getColumnas());
    }

    @Test
    void testSetColumnas(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        partida.setColumnas(2);
        assertEquals(2, partida.getColumnas());
    }

    @Test
    void testGetFilas(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(5, partida.getFilas());
    }

    @Test
    void testSetFilas(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        partida.setFilas(2);
        assertEquals(2, partida.getFilas());
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
    void testGetTurnosVida(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(5, partida.getTurnosVida());
    }

    @Test
    void testSetTurnosVida(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        partida.setTurnosVida(2);
        assertEquals(2, partida.getTurnosVida());
    }

    @Test
    void testGetProbClonacion(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(10, partida.getProbClonacion());
    }

    @Test
    void testSetProbClonacion(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        partida.setProbClonacion(2);
        assertEquals(2, partida.getProbClonacion());
    }

    @Test
    void testGetProbReproduccion(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(3, partida.getProbReproduccion());
    }

    @Test
    void testSetProbReproduccion(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        partida.setProbReproduccion(2);
        assertEquals(2, partida.getProbReproduccion());
    }

    @Test
    void testGetListaCasillas(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        Casilla casilla1 = new Casilla(1, 2);
        Casilla casilla2 = new Casilla(2, 1);
        Casilla casilla3 = new Casilla(3, 1);
        ListaDoblementeEnlazada<Casilla> listaCasillas = new ListaDoblementeEnlazada<>();
        listaCasillas.add(casilla1);
        listaCasillas.add(casilla2);
        listaCasillas.add(casilla3);
        assertEquals(partida.getListaCasillas(), partida.getListaCasillas());
    }

    @Test
    void testAddIndividuo(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        Individuo individuo1 = new Individuo(1, 3, 50);
        Individuo individuo2 = new Individuo(1, 4, 50);
        partida.addIndividuo(individuo1);
        partida.addIndividuo(individuo2);
        assertEquals(partida.getListaCasillas(), partida.getListaCasillas());
    }

    @Test
    void testAumentarTurno(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        partida.aumentarTurno();
        assertEquals(1, partida.getTurno());
    }

    @Test
    void testMoverBasico(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        Casilla casilla = partida.moverBasico();
        assertNotNull(casilla);
        assertEquals(casilla, casilla);
    }

    @Test
    void testMoverNormal(){
    }

    @Test
    void testMoverAvanzado(){

    }

    @Test
    void testGetProbabilidadZ(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(40, partida.getProbabilidadZ());
    }

    @Test
    void testSetProbabilidadZ(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        partida.setProbabilidadZ(2);
        assertEquals(2, partida.getProbabilidadZ());
    }

    @Test
    void testColocarIndividuo(){
        Casilla casilla = new Casilla(1, 2);
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        partida.colocarIndividuo(casilla, 2);
        assertEquals(partida.getListaCasillas(), partida.getListaCasillas());
    }

    @Test
    void testFromJson(){
        Partida partida = new Partida(1, 2, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("turno", 2);
        jsonObject.addProperty("probReproduccion", 50);
        jsonObject.addProperty("probClonacion", 30);
        jsonObject.addProperty("id", 1);
        jsonObject.addProperty("turnosVida", 4);
        jsonObject.addProperty("numeroIndividuosBasicos", 1);
        jsonObject.addProperty("numeroIndividuosNormal", 1);
        jsonObject.addProperty("numeroIndividuosAvanzados", 1);
        jsonObject.addProperty("agua", 1);
        jsonObject.addProperty("comida", 3);
        jsonObject.addProperty("montana", 2);
        jsonObject.addProperty("cofre", 0);
        jsonObject.addProperty("biblioteca", 1);
        jsonObject.addProperty("pozo", 3);
        jsonObject.addProperty("tiempoActividad", 4);
        jsonObject.addProperty("columnas", 1);
        jsonObject.addProperty("filas", 0);
        partida.fromJson(jsonObject);
        assertEquals(2, partida.getTurno());
        assertEquals(50, partida.getProbReproduccion());
        assertEquals(30, partida.getProbClonacion());
        assertEquals(1,partida.getId());
        assertEquals(4, partida.getTurnosVida());
        assertEquals(1, partida.getNumeroIndividuosBasicos());
        assertEquals(1, partida.getNumeroIndividuosNormal());
        assertEquals(1, partida.getNumeroIndividuosAvanzados());
        assertEquals(1, partida.getAgua());
        assertEquals(3, partida.getComida());
        assertEquals(2, partida.getMontana());
        assertEquals(0, partida.getCofre());
        assertEquals(1, partida.getBiblioteca());
        assertEquals(3, partida.getPozo());
        assertEquals(4, partida.getTiempoActividad());
        assertEquals(1, partida.getColumnas());
        assertEquals(0, partida.getFilas());
    }

    @Test
    void testToJson() {
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        JsonObject jsonResult = partida.toJson();
        assertNotNull(jsonResult);
        assertEquals(0,jsonResult.get("turno").getAsInt());
        assertEquals(3, jsonResult.get("probReproduccion").getAsInt());
        assertEquals(10, jsonResult.get("probClonacion").getAsInt());
        assertEquals(0, jsonResult.get("id").getAsInt());
        assertEquals(5, jsonResult.get("turnosVida").getAsInt());
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
    void testGetNumeroIndividuosBasicos(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(4, partida.getNumeroIndividuosBasicos());
    }

    @Test
    void testSetNumeroIndividuosBasicos(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        partida.setNumeroIndividuosBasicos(2);
        assertEquals(2, partida.getNumeroIndividuosBasicos());
    }

    @Test
    void testGetNumeroIndividuosNormal(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(5, partida.getNumeroIndividuosNormal());
    }

    @Test
    void testSetNumeroIndividuosNormal(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        partida.setNumeroIndividuosNormal(2);
        assertEquals(2, partida.getNumeroIndividuosNormal());
    }

    @Test
    void testGetNumeroIndividuosAvanzados(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(1, partida.getNumeroIndividuosAvanzados());
    }

    @Test
    void testSetNumeroIndividuosAvanzados(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        partida.setNumeroIndividuosAvanzados(2);
        assertEquals(2, partida.getNumeroIndividuosAvanzados());
    }

    @Test
    void testRemoveIndividuo(){
        /*Partida partida = new Partida();
        Individuo ind1 = new Individuo();
        Individuo ind2 = new Individuo();
        List<Individuo> listaIndividuos = new ArrayList<>();
        listaIndividuos.add(ind1);
        listaIndividuos.add(ind2);
        partida.removeIndividuo(ind1);
        assertEquals(2, listaIndividuos.size());*/
    }

    @Test
    void testRemoveIndividuoIndex(){
        /*Partida partida = new Partida();
        Individuo ind1 = new Individuo(1, 2, 3, 4);
        Individuo ind2 = new Individuo(2, 5, 40, 30);
        ListaDoblementeEnlazada<Individuo> listaIndividuos = new ListaDoblementeEnlazada<>();
        listaIndividuos.add(ind1);
        listaIndividuos.add(ind2);
        partida.removeIndividuo(1);
        assertEquals(1, partida.getListaIndividuos().size());*/
    }

    @Test
    void testGetAgua(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(3, partida.getAgua());
    }

    @Test
    void testSetAgua(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
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
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
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
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
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
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
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
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
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
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        partida.setPozo(2);
        assertEquals(2, partida.getPozo());
    }

    @Test
    void testGetTiempoActividad(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        assertEquals(4, partida.getTiempoActividad());
    }


    @Test
    void testModificarId(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        partida.modificarId();
        assertEquals(1, partida.getId());
    }

    @Test
    void testFilaAleatoria(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        int fila = partida.filaAleatoria();
        assertTrue(fila >= 0 && fila < 10, "El valor de fila debe estar entre 0 y " + (10 - 1));
    }

    @Test
    void testColumnaAleatoria(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        int columna = partida.filaAleatoria();
        assertTrue(columna >= 0 && columna < 10, "El valor de columna debe estar entre 0 y " + (10 - 1));
    }

    @Test
    void testCasillaAleatoria(){
        Partida partida = new Partida(5, 10, 3, 4, 5, 1, 3, 2, 1, 4, 2, 1, 4, 4, 5);
        Casilla casilla = partida.casillaAleatoria();
        assertNotNull(casilla);
        assertEquals(casilla, casilla);
    }
}