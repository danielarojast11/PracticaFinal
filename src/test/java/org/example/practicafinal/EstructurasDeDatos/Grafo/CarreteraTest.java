package org.example.practicafinal.EstructurasDeDatos.Grafo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarreteraTest {

    @Test
    void Carretera(){
        Ciudad c1 = new Ciudad("Madrid");
        Ciudad c2 = new Ciudad("Salamanca");
        Carretera carretera = new Carretera(c1, c2);
        assertEquals(carretera, carretera);
    }

    @Test
    void CarreteraTest(){
        Ciudad c1 = new Ciudad("Madrid");
        Ciudad c2 = new Ciudad("Salamanca");
        Carretera carretera = new Carretera(c1, c2, 2);
        assertEquals(carretera, carretera);
    }

    @Test
    void getVecinaDe(){
        Ciudad c1 = new Ciudad("Madrid");
        Ciudad c2 = new Ciudad("Salamanca");
        Ciudad c3 = new Ciudad();
        Carretera carretera = new Carretera(c1, c2, 2);
        Carretera carretera2 = new Carretera();
        assertEquals(c2, carretera.getVecinaDe(c1));
        assertEquals(c1, carretera.getVecinaDe(c2));
        assertEquals(null, carretera2.getVecinaDe(c3));
    }

    @Test
    void getCiudad1(){
        Ciudad c1 = new Ciudad("Madrid");
        Ciudad c2 = new Ciudad("Salamanca");
        Carretera carretera = new Carretera(c1, c2, 2);
        assertEquals(c1, carretera.getCiudad1());
    }

    @Test
    void getCiudad2(){
        Ciudad c1 = new Ciudad("Madrid");
        Ciudad c2 = new Ciudad("Salamanca");
        Carretera carretera = new Carretera(c1, c2, 2);
        assertEquals(c2, carretera.getCiudad2());
    }

    @Test
    void getPeso(){
        Ciudad c1 = new Ciudad("Madrid");
        Ciudad c2 = new Ciudad("Salamanca");
        Carretera carretera = new Carretera(c1, c2, 2);
        assertEquals(2, carretera.getPeso());
    }

    @Test
    void setPeso(){
        Ciudad c1 = new Ciudad("Madrid");
        Ciudad c2 = new Ciudad("Salamanca");
        Carretera carretera = new Carretera(c1, c2, 2);
        carretera.setpeso(2);
        assertEquals(2, carretera.getPeso());
    }

    @Test
    void compareTo(){
        Ciudad c1 = new Ciudad("Madrid");
        Ciudad c2 = new Ciudad("Salamanca");
        Ciudad c3 = new Ciudad("Madrid");
        Carretera carretera1 = new Carretera(c1, c2);
        Carretera carretera2 = new Carretera(c2, c3);
        Carretera carretera3 = new Carretera(c1, c3);
        assertFalse(carretera1.compareTo(carretera2) < 0); // carretera1 < carretera2
        assertFalse(carretera2.compareTo(carretera1) > 0); // carretera2 > carretera1
        assertTrue(carretera1.compareTo(carretera3) == 0); // carretera1 == carretera3
    }

    @Test
    void testToString(){
        Ciudad c1 = new Ciudad("Madrid");
        Ciudad c2 = new Ciudad("Salamanca");
        Carretera carretera2 = new Carretera();
        Carretera carretera = new Carretera(c1, c2, 2);
        assertEquals("({ Madrid, Salamanca}, 2)", carretera.toString());
    }

    @Test
    void testHashCode(){
        Ciudad c1 = new Ciudad("Madrid");
        Ciudad c2 = new Ciudad("Salamanca");
        Carretera carretera = new Carretera(c1, c2, 2);
        assertEquals(carretera.hashCode(), carretera.hashCode());
    }

    @Test
    void equals(){
        Ciudad c1 = new Ciudad("Madrid");
        Ciudad c2 = new Ciudad("Salamanca");
        Ciudad c3 = new Ciudad("Barcelona");
        Carretera carretera1 = new Carretera(c1, c2, 2);
        Carretera carretera2 = new Carretera(c2, c1, 2);
        Carretera carretera3 = new Carretera(c1, c3, 2);
        String o = new String();
        assertFalse(carretera2.equals(o));
        assertTrue(carretera1.equals(carretera2));
        assertFalse(carretera2.equals(carretera3));
    }
}