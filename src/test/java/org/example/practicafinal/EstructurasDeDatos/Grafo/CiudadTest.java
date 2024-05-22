package org.example.practicafinal.EstructurasDeDatos.Grafo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CiudadTest {

    @Test
    void insertarVecina(){
        Ciudad ciudad1 = new Ciudad("Madrid");
        Carretera carretera = new Carretera(ciudad1, ciudad1);
        ciudad1.insertarVecina(carretera);
        assertNotNull(ciudad1.getVecinos().contains(carretera));
        assertTrue(ciudad1.getVecinos().contains(carretera));
    }

    @Test
    void contieneCiudad(){
        Ciudad ciudad1 = new Ciudad("Madrid");
        Carretera carretera = new Carretera(ciudad1, ciudad1);
        ciudad1.insertarVecina(carretera);
        assertTrue(ciudad1.contieneCiudad(carretera));
    }

    @Test
    void getCarretera(){
        //Creo las ciudades para poder crear las carreteras
        Ciudad ciudad1 = new Ciudad("Madrid");
        Ciudad ciudad2 = new Ciudad("Salamanca");
        Ciudad ciudad3 = new Ciudad("Valencia");
        Carretera carretera1 = new Carretera(ciudad1, ciudad1);
        Carretera carretera2 = new Carretera(ciudad2, ciudad2);
        Carretera carretera3 = new Carretera(ciudad3, ciudad3);
        //Creo una ArrayList y añado las carreteras creadas
        Ciudad ciudad = new Ciudad();
        ArrayList<Carretera> carreteras = new ArrayList<>();
        carreteras.add(carretera1);
        carreteras.add(carretera2);
        carreteras.add(carretera3);
        ciudad.setVecindad(carreteras);
        assertEquals(carretera1, ciudad.getCarretera(0));
        assertEquals(carretera2, ciudad.getCarretera(1));
        assertEquals(carretera3, ciudad.getCarretera(2));
    }

    @Test
    void setVecindad(){
        Ciudad ciudad1 = new Ciudad("Madrid");
        Ciudad ciudad2 = new Ciudad("Salamanca");
        Ciudad ciudad3 = new Ciudad("Valencia");
        Carretera carretera1 = new Carretera(ciudad1, ciudad1);
        Carretera carretera2 = new Carretera(ciudad2, ciudad2);
        Carretera carretera3 = new Carretera(ciudad3, ciudad3);
        //Creo una ArrayList y añado las carreteras creadas
        Ciudad ciudad = new Ciudad();
        ArrayList<Carretera> carreteras = new ArrayList<>();
        carreteras.add(carretera1);
        carreteras.add(carretera2);
        carreteras.add(carretera3);
        ciudad.setVecindad(carreteras);
        assertEquals(carreteras, ciudad.getVecinos());
    }

    @Test
    void eliminarCiudad(){
        Ciudad ciudad1 = new Ciudad("Madrid");
        Ciudad ciudad2 = new Ciudad("Salamanca");
        Ciudad ciudad3 = new Ciudad("Valencia");
        Carretera carretera1 = new Carretera(ciudad1, ciudad1);
        Carretera carretera2 = new Carretera(ciudad2, ciudad2);
        Carretera carretera3 = new Carretera(ciudad3, ciudad3);
        Ciudad ciudad = new Ciudad();
        ArrayList<Carretera> carreteras = new ArrayList<>();
        carreteras.add(carretera1);
        carreteras.add(carretera2);
        carreteras.add(carretera3);
        ciudad.setVecindad(carreteras);
        assertEquals(carretera2,ciudad.eliminarCiudad(1));
    }

    @Test
    void eliminarCiudadVecina() {
        Ciudad ciudad1 = new Ciudad("Madrid");
        Ciudad ciudad2 = new Ciudad("Salamanca");
        Ciudad ciudad3 = new Ciudad("Valencia");
        Carretera carretera1 = new Carretera(ciudad1, ciudad1);
        Carretera carretera2 = new Carretera(ciudad2, ciudad2);
        Carretera carretera3 = new Carretera(ciudad3, ciudad3);
        Ciudad ciudad = new Ciudad();
        ArrayList<Carretera> carreteras = new ArrayList<>();
        carreteras.add(carretera1);
        carreteras.add(carretera2);
        carreteras.add(carretera3);
        ciudad.setVecindad(carreteras);
        ciudad.eliminarCiudadVecina(carretera2);
        assertFalse(ciudad.getVecinos().contains(carretera2));
    }

    @Test
    void getContarVecinos(){
        Ciudad ciudad1 = new Ciudad("Madrid");
        Ciudad ciudad2 = new Ciudad("Salamanca");
        Ciudad ciudad3 = new Ciudad("Valencia");
        Carretera carretera1 = new Carretera(ciudad1, ciudad1);
        Carretera carretera2 = new Carretera(ciudad2, ciudad2);
        Carretera carretera3 = new Carretera(ciudad3, ciudad3);
        Ciudad ciudad = new Ciudad("Nueva Ciudad");
        ArrayList<Carretera> carreteras = new ArrayList<>();
        carreteras.add(carretera1);
        carreteras.add(carretera2);
        carreteras.add(carretera3);
        ciudad.setVecindad(carreteras);
        assertEquals(3, ciudad.getContarVecinos());
    }

    @Test
    void getNombre(){
        Ciudad ciudad1 = new Ciudad("Valencia");
        assertEquals("Valencia", ciudad1.getNombre());
    }

    @Test
    void equals(){
        Ciudad c1 = new Ciudad("Madrid");
        Ciudad c2 = new Ciudad("Salamanca");
        Ciudad c3 = new Ciudad("Madrid");
        assertTrue(c1.equals(c3));
        assertFalse(c2.equals(c3));
    }

    @Test
    void testToString(){
        Ciudad ciudad1 = new Ciudad("Madrid");
        assertEquals("Ciudad: Madrid", ciudad1.toString());
    }

    @Test
    void testHashCode(){
        Ciudad c1 = new Ciudad("Madrid");
        assertEquals(c1.hashCode(), c1.hashCode());
    }

    @Test
    void getVecinos(){
        Ciudad ciudad1 = new Ciudad("Madrid");
        Ciudad ciudad2 = new Ciudad("Salamanca");
        Ciudad ciudad3 = new Ciudad("Valencia");
        Carretera carretera1 = new Carretera(ciudad1, ciudad1);
        Carretera carretera2 = new Carretera(ciudad2, ciudad2);
        Carretera carretera3 = new Carretera(ciudad3, ciudad3);
        Ciudad ciudad = new Ciudad("Nueva Ciudad");
        ArrayList<Carretera> carreteras = new ArrayList<>();
        carreteras.add(carretera1);
        carreteras.add(carretera2);
        carreteras.add(carretera3);
        ciudad.setVecindad(carreteras);
        assertEquals(carreteras, ciudad.getVecinos());
    }
}