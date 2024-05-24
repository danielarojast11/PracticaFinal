package org.example.practicafinal.Entity;

import com.google.gson.JsonObject;
import org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada.ListaDoblementeEnlazada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoTest {

    @Test
    void restarTurnoVida(){
        Casilla casilla = new Casilla(0,0);
        Individuo individuo = new Individuo(1, 3, 4, 50, 30, 3, casilla);
        individuo.restarTurnoVida();
        assertEquals(3, individuo.getTurnosVida());
    }

    @Test
    void testGetLongevidad(){
        Casilla casilla = new Casilla(0,0);
        Individuo individuo = new Individuo(1, 3, 4, 50, 30, 3, casilla);
        assertEquals(1, individuo.getLongevidad());
    }

    @Test
    void testSumarLongevidad(){
        Casilla casilla = new Casilla(0,0);
        Individuo individuo = new Individuo(1, 3, 4, 50, 30, 3, casilla);
        individuo.sumarLongevidad();
        assertEquals(2, individuo.getLongevidad());
    }

    @Test
    void getProbReproduccion(){
        Casilla casilla = new Casilla(0,0);
        Individuo individuo = new Individuo(1, 3, 4, 50, 30, 3, casilla);
        assertEquals(50, individuo.getProbReproduccion());
    }

    @Test
    void setProbReproduccion(){
        Casilla casilla = new Casilla(0,0);
        Individuo individuo = new Individuo(1, 3, 4, 50, 30, 3, casilla);
        individuo.setProbReproduccion(10);
        assertEquals(10, individuo.getProbReproduccion());
    }

    @Test
    void testGetProbMuerte(){
        Casilla casilla = new Casilla(0,0);
        Individuo individuo = new Individuo(1, 3, 4, 50, 30, 3, casilla);
        assertEquals(50, individuo.getProbMuerte());
    }

    @Test
    void setProbMuerte(){
        Casilla casilla = new Casilla(0,0);
        Individuo individuo = new Individuo(1, 3, 4, 50, 30, 3, casilla);
        individuo.setProbMuerte(50);
        assertEquals(50, individuo.getProbMuerte());
    }

    @Test
    void testFromJson(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", 1);
        jsonObject.addProperty("generacion", 3);
        jsonObject.addProperty("turnosVida", 4);
        jsonObject.addProperty("probReproduccion", 50);
        jsonObject.addProperty("probClonacion", 30);
        jsonObject.addProperty("probMuerte", 50);
        jsonObject.addProperty("rango", 3);
        Individuo individuo = new Individuo(1, 3, 4, 50, 30, 3, new Casilla(1, 4));
        individuo.fromJson(jsonObject);
        assertEquals(1, individuo.getId());
        assertEquals(3, individuo.getGeneracion());
        assertEquals(4, individuo.getTurnosVida());
        assertEquals(50, individuo.getProbReproduccion());
        assertEquals(30, individuo.getProbClonacion());
        assertEquals(50, individuo.getProbMuerte());
        assertEquals(3, individuo.getRango());
    }

    @Test
    void testToJson(){
        Casilla casilla = new Casilla(0,0);
        Individuo individuo = new Individuo(1, 3, 4, 50, 30, 3, casilla);
        JsonObject jsonResult = individuo.toJson();
        assertNotNull(jsonResult);
        assertEquals(1, jsonResult.get("id").getAsInt());
        assertEquals(3, jsonResult.get("generacion").getAsInt());
        assertEquals(4, jsonResult.get("turnosVida").getAsInt());
        assertEquals(50, jsonResult.get("probReproduccion").getAsInt());
        assertEquals(30, jsonResult.get("probClonacion").getAsInt());
        assertEquals(50, jsonResult.get("probMuerte").getAsInt());
        assertEquals(3, jsonResult.get("rango").getAsInt());
    }

    @Test
    void getId(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 1));
        assertEquals(1, ind.getId());
    }

    @Test
    void setId(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 1));
        ind.setId(2);
        assertEquals(2, ind.getId());
    }

    @Test
    void getGeneracion(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 1));
        assertEquals(2, ind.getGeneracion());
    }

    @Test
    void setGeneracion(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 1));
        ind.setGeneracion(2);
        assertEquals(2, ind.getGeneracion());
    }

    @Test
    void getTurnosVida(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 1));
        assertEquals(5, ind.getTurnosVida());
    }

    @Test
    void setTurnosVida(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 1));
        ind.setTurnosVida(3);
        assertEquals(3, ind.getTurnosVida());
    }

    @Test
    void getProbClonacion(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 1));
        assertEquals(50, ind.getProbClonacion());
    }

    @Test
    void setProbClonacion(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 1));
        ind.setProbClonacion(10);
        assertEquals(10, ind.getProbClonacion());
    }

    @Test
    void getRango(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 1));
        assertEquals(3, ind.getRango());
    }

    @Test
    void setRango(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 1));
        ind.setRango(1);
        assertEquals(1, ind.getRango());
    }

    @Test
    void getPadres(){
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 1));
        Individuo ind2 = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 2));
        ind2.addPadre(ind1);
        assertEquals(ind2.getPadres(), ind2.getPadres());
    }

    @Test
    void addPadres(){
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 1));
        Individuo ind2 = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 2));
        ListaDoblementeEnlazada<Individuo> individuos = new ListaDoblementeEnlazada<>();
        individuos.add(ind1);
        individuos.add(ind2);
        ind2.addPadre(ind1);
        assertEquals(ind2.getPadres(), ind2.getPadres());
    }

    @Test
    void getHijos(){
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 1));
        Individuo ind2 = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 2));
        ind1.addHijo(ind2);
        assertEquals(ind1.getHijos(), ind1.getHijos());
    }

    @Test
    void addHijos(){
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 1));
        Individuo ind2 = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 2));
        ListaDoblementeEnlazada<Individuo> individuos = new ListaDoblementeEnlazada<>();
        individuos.add(ind1);
        individuos.add(ind2);
        ind1.addHijo(ind2);
        assertEquals(ind1.getHijos(), ind1.getHijos());
    }

    @Test
    void getIndividuos(){
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 1));
        Individuo ind2 = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 2));
        ListaDoblementeEnlazada<Individuo> individuos = new ListaDoblementeEnlazada<>();
        individuos.add(ind1);
        individuos.add(ind2);
        assertEquals(ind1.getIndividuos(), ind1.getIndividuos());
    }

    @Test
    void addIndividuos(){
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 1));
        Individuo ind2 = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 2));
        ListaDoblementeEnlazada<Individuo> individuos = new ListaDoblementeEnlazada<>();
        individuos.add(ind1);
        individuos.add(ind2);
        ind1.addIndividuo(ind2);
        assertEquals(individuos, individuos);
    }

    @Test
    void modificarReprod(){
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 1));
        ind1.modificarReprod();
        assertEquals(36, ind1.getProbReproduccion());
    }

    @Test
    void modificarClonacion(){
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 1));
        ind1.modificarClonacion();
        assertEquals(41, ind1.getProbClonacion() - ((10 * ind1.getProbClonacion()) /100));
    }

    @Test
    void getCasilla(){
        Casilla casilla = new Casilla(2, 1);
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50, 3, casilla);
        assertEquals(casilla, ind1.getCasilla());
    }

    @Test
    void setCasilla(){
        Casilla casilla = new Casilla(2, 1);
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50, 3, casilla);
        ind1.setCasilla(casilla);
        assertEquals(casilla, ind1.getCasilla());
    }

    @Test
    void testAddOperation(){
        Individuo individuo = new Individuo(1, 3, 4, 60, 10, 1, new Casilla(2, 0));
        individuo.addOperation("Bebe agua", 1, 3);
        assertEquals(individuo.getOperaciones(), individuo.getOperaciones());
    }

    @Test
    void testGetOperaciones(){
        Individuo individuo = new Individuo(1, 3, 4, 60, 10, 1, new Casilla(2, 0));
        individuo.addOperation("Bebe agua", 1, 3);
        assertEquals(individuo.getOperaciones(), individuo.getOperaciones());
    }

    @Test
    void compareTo(){
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50, 3, new Casilla(2, 1));
        Individuo ind2 = new Individuo(2, 5, 2, 30, 50, 3, new Casilla(2, 2));
        Individuo ind3 = new Individuo(3, 1, 6, 10, 50, 2, new Casilla(3, 1));
        Individuo ind4 = new Individuo(4, 3, 7, 40, 50, 3, new Casilla(5, 0));
        assertEquals(1, ind1.compareTo(ind2));
        assertEquals(-1, ind2.compareTo(ind1));
        assertEquals(-1, ind3.compareTo(ind2));
        assertEquals(1, ind2.compareTo(ind3));
        assertEquals(0, ind1.compareTo(ind4));
        Individuo individuo5 = new Individuo(1, 2, 5, 10, 10, 1, new Casilla(2, 0));
        Individuo individuo6 = new Individuo(2, 5, 2, 10, 50, 3, new Casilla(2, 2));
        Individuo individuo7 = new Individuo(3, 1, 6, 10, 50, 2, new Casilla(3, 1));
        Individuo individuo8 = new Individuo(4, 3, 7, 10, 50, 3, new Casilla(5, 0));
        assertEquals(-1, individuo5.compareTo(individuo6));
        assertEquals(1, individuo6.compareTo(individuo7));
        assertEquals(0, individuo6.compareTo(individuo8));
    }
}