package org.example.practicafinal.EstructurasDeDatos.Grafo;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GrafoTest {

    @Test
    void insertarCarretera2(){
        Ciudad ciudad1 = new Ciudad("Madrid");
        Ciudad ciudad2 = new Ciudad("Salamanca");
        Grafo grafo = new Grafo();
        grafo.insertarCarretera2(ciudad1, ciudad2);
        assertEquals(grafo.contieneCarretera(new Carretera(ciudad1, ciudad2)), true);
    }

    @Test
    void insertarCarretera(){
        Ciudad ciudad1 = new Ciudad("Madrid");
        Ciudad ciudad2 = new Ciudad("Salamanca");
        Ciudad ciudad3 = new Ciudad("Madrid");
        Grafo grafo = new Grafo();
        grafo.insertarCiudad(ciudad1, false);
        grafo.insertarCiudad(ciudad2, false);
        grafo.insertarCiudad(ciudad3, false);
        assertTrue(grafo.insertarCarretera(ciudad1, ciudad2, 10));
        assertFalse(grafo.insertarCarretera(ciudad1, ciudad1, 5));
        assertFalse(grafo.insertarCarretera(ciudad1, ciudad2, 10));
        assertFalse(grafo.insertarCarretera(ciudad1, ciudad3, 15));
        assertFalse(grafo.insertarCarretera(ciudad1, ciudad2, 20));
        assertEquals(1, ciudad1.getVecinos().size());
        assertEquals(1, ciudad2.getVecinos().size());
        assertEquals(0, ciudad3.getVecinos().size());
    }

    @Test
    void contieneCarretera(){
        Ciudad ciudad1 = new Ciudad("Madrid");
        Ciudad ciudad2 = new Ciudad("Salamanca");
        Ciudad ciudad3 = new Ciudad();
        Carretera carretera1 = new Carretera(ciudad1, ciudad2);
        Carretera carretera2 = new Carretera();
        Grafo grafo = new Grafo();
        grafo.insertarCiudad(ciudad3, false);
        grafo.insertarCarretera(ciudad1, ciudad2, 1);
        assertFalse(grafo.contieneCarretera(carretera2));
        assertTrue(grafo.contieneCarretera(carretera1));
    }

    @Test
    void eliminarCarretera(){
        Ciudad ciudad1 = new Ciudad("Madrid");
        Ciudad ciudad2 = new Ciudad("Salamanca");
        Ciudad ciudad3 = new Ciudad();
        Carretera carretera1 = new Carretera(ciudad1, ciudad2);
        Carretera carretera2 = new Carretera();
        Grafo grafo = new Grafo();
        grafo.insertarCiudad(ciudad3, false);
        grafo.insertarCarretera(ciudad1, ciudad2, 1);
        grafo.insertarCarretera(ciudad1, ciudad2, 1);
        assertTrue(grafo.contieneCarretera(carretera1));
        grafo.eliminarCarretera(carretera1);
        assertFalse(grafo.contieneCarretera(carretera1));
    }

    @Test
    void contieneCiudad(){
        Ciudad ciudad1 = new Ciudad("Madrid");
        Grafo grafo = new Grafo();
        grafo.insertarCiudad(ciudad1, false);
        assertTrue(grafo.contieneCiudad(ciudad1));
    }

    @Test
    void getCiudad(){
        Ciudad ciudad1 = new Ciudad("Madrid");
        Grafo grafo = new Grafo();
        grafo.insertarCiudad(ciudad1, false);
        assertEquals(ciudad1, grafo.getCiudad("Madrid"));
    }

    @Test
    void insertarCiudad(){
        Ciudad ciudad1 = new Ciudad("Madrid");
        Ciudad ciudad2 = new Ciudad("Salamanca");
        Grafo grafo = new Grafo();
        assertTrue(grafo.insertarCiudad(ciudad1, false));
        assertEquals(ciudad1, grafo.getCiudad("Madrid"));
        assertFalse(grafo.insertarCiudad(ciudad1, false));
        assertTrue(grafo.insertarCiudad(ciudad2, false));
        assertEquals(ciudad1, grafo.getCiudad("Madrid"));
        assertEquals(ciudad2, grafo.getCiudad("Salamanca"));
    }

    @Test
    void verticeKeys(){
        Ciudad ciudad1 = new Ciudad("Madrid");
        Ciudad ciudad2 = new Ciudad("Salamanca");
        Ciudad ciudad3 = new Ciudad("Valencia");
        Grafo grafo = new Grafo();
        grafo.insertarCiudad(ciudad1, false);
        grafo.insertarCiudad(ciudad2, false);
        grafo.insertarCiudad(ciudad3, false);
        Set<String> keys = grafo.verticeKeys();
        assertTrue(keys.contains("Madrid"));
        assertTrue(keys.contains("Salamanca"));
        assertTrue(keys.contains("Valencia"));
    }

    @Test
    void getCarreteras(){
        Ciudad ciudad1 = new Ciudad("Madrid");
        Ciudad ciudad2 = new Ciudad("Salamanca");
        Ciudad ciudad3 = new Ciudad("Valencia");
        Grafo grafo = new Grafo();
        grafo.insertarCarretera2(ciudad1, ciudad2);
        grafo.insertarCarretera2(ciudad2, ciudad3);
        grafo.insertarCarretera2(ciudad3, ciudad1);
        Set<Carretera> carreteras = grafo.getCarreteras();
        assertEquals(3, carreteras.size());
    }
}