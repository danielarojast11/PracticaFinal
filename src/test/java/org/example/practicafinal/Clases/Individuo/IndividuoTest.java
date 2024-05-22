package org.example.practicafinal.Clases.Individuo;

import com.google.gson.JsonObject;
import org.example.practicafinal.Clases.Tablero.Casilla;
import org.example.practicafinal.Entity.Individuo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoTest {

    @Test
    void testToJson(){
        Individuo ind = new Individuo(1, 2, 5, 10);
        JsonObject jsonResult = ind.toJson();
        assertNotNull(jsonResult);
        assertEquals(1, jsonResult.get("id").getAsInt());
        assertEquals(2, jsonResult.get("turnosVida").getAsInt());
        assertEquals(5, jsonResult.get("probReproduccion").getAsInt());
        assertEquals(10, jsonResult.get("probClonacion").getAsInt());
    }

    @Test
    void getId(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50);
        assertEquals(1, ind.getId());
    }

    @Test
    void setId(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50);
        ind.setId(2);
        assertEquals(2, ind.getId());
    }

    @Test
    void getGeneracion(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50);
        assertEquals(2, ind.getGeneracion());
    }

    @Test
    void setGeneracion(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50);
        ind.setGeneracion(2);
        assertEquals(2, ind.getGeneracion());
    }

    @Test
    void getTurnosVida(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50);
        assertEquals(5, ind.getTurnosVida());
    }

    @Test
    void setTurnosVida(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50);
        ind.setTurnosVida(3);
        assertEquals(3, ind.getTurnosVida());
    }

    @Test
    void getProbReproduccion(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50);
        assertEquals(40, ind.getProbReproduccion());
    }

    @Test
    void setProbReproduccion(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50);
        ind.setProbReproduccion(10);
        assertEquals(10, ind.getProbReproduccion());
    }

    @Test
    void getProbClonacion(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50);
        assertEquals(50, ind.getProbClonacion());
    }

    @Test
    void setProbClonacion(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50);
        ind.setProbClonacion(10);
        assertEquals(10, ind.getProbClonacion());
    }

    @Test
    void setProbMuerte(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50);
        ind.setProbMuerte(100 - ind.getProbReproduccion());
        assertEquals(60, 100- ind.getProbReproduccion());
    }

    @Test
    void setProbabilidadMuerte(){
        Individuo ind = new Individuo();
        ind.setProbabilidadMuerte(50);
    }

    @Test
    void getRango(){
        Individuo ind = new Individuo(1, 2, 5, 40, 50, 2);
        assertEquals(2, ind.getRango());
    }

    @Test
    void setRango(){
        Individuo ind = new Individuo();
        ind.setRango(1);
        assertEquals(1, ind.getRango());
    }

    @Test
    void getPadres(){
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50);
        Individuo ind2 = new Individuo(2, 5, 85, 10, 50);
        ind2.addPadre(ind1);
        assertEquals(ind2.getPadres(), ind2.getPadres());
    }

    @Test
    void addPadres(){
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50);
        Individuo ind2 = new Individuo(2, 5, 85, 10, 50);
        List<Individuo> individuos = new ArrayList<>();
        individuos.add(ind1);
        individuos.add(ind2);
        ind2.addPadre(ind1);
        assertEquals(ind2.getPadres(), ind2.getPadres());
    }

    @Test
    void getHijos(){
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50);
        Individuo ind2 = new Individuo(2, 5, 85, 10, 50);
        ind1.addHijo(ind2);
        assertEquals(ind1.getHijos(), ind1.getHijos());
    }

    @Test
    void addHijos(){
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50);
        Individuo ind2 = new Individuo(2, 5, 85, 10, 50);
        List<Individuo> individuos = new ArrayList<>();
        individuos.add(ind1);
        individuos.add(ind2);
        ind1.addHijo(ind2);
        assertEquals(ind1.getHijos(), ind1.getHijos());
    }

    @Test
    void getIndividuos(){
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50);
        Individuo ind2 = new Individuo(2, 5, 85, 10, 50);
        List<Individuo> individuos = new ArrayList<>();
        individuos.add(ind1);
        individuos.add(ind2);
        assertEquals(ind1.getIndividuos(), ind1.getIndividuos());
    }

    @Test
    void addIndividuos(){
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50);
        Individuo ind2 = new Individuo(2, 5, 85, 10, 50);
        List<Individuo> individuos = new ArrayList<>();
        individuos.add(ind1);
        individuos.add(ind2);
        ind1.addIndividuo(ind2);
        assertEquals(individuos, individuos);
    }

    @Test
    void modificarReprod(){
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50);
        ind1.modificarReprod();
        assertEquals(36, ind1.getProbReproduccion());
    }

    @Test
    void modificarClonacion(){
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50);
        ind1.modificarClonacion();
        assertEquals(41, ind1.getProbClonacion() - ((10 * ind1.getProbClonacion()) /100));
    }

    @Test
    void modificarTurnosVida(){
        Individuo ind1 = new Individuo();
        Individuo ind2 = new Individuo(1, 5, 40, 50);
        ind1.modificarTurnosVida();
        ind2.modificarTurnosVida();
        assertEquals(0, ind1.getTurnosVida());
        assertEquals(4, ind2.getTurnosVida());
    }

    @Test
    void setCasilla(){
        Casilla casilla = new Casilla();
        Individuo individuo = new Individuo();
        individuo.setCasilla(casilla);
        assertEquals(individuo.getCasilla(), individuo.getCasilla());
    }

    @Test
    void getCasilla(){
        Individuo individuo = new Individuo();
        assertEquals(individuo.getCasilla(), individuo.getCasilla());
    }

    @Test
    void compareTo(){
        Individuo ind1 = new Individuo(1, 2, 5, 40, 50, 1);
        Individuo ind2 = new Individuo(1, 2, 5, 10, 50, 1);
        Individuo ind3 = new Individuo(1, 2, 5, 10, 50, 2);
        Individuo ind4 = new Individuo(1, 2, 5, 40, 50, 1);
        assertEquals(1, ind1.compareTo(ind2));
        assertEquals(-1, ind2.compareTo(ind1));
        assertEquals(1, ind3.compareTo(ind2));
        assertEquals(-1, ind2.compareTo(ind3));
        assertEquals(0, ind1.compareTo(ind4));
    }
}