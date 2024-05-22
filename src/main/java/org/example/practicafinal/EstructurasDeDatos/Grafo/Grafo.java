package org.example.practicafinal.EstructurasDeDatos.Grafo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Grafo {
    private HashMap<String, Ciudad> ciudades;
    private HashMap<Integer, Carretera> carreteras;

    public Grafo(){
        this.ciudades = new HashMap<String, Ciudad>();
        this.carreteras = new HashMap<Integer, Carretera>();
    }


    public boolean insertarCarretera2(Ciudad c1, Ciudad c2){
        return insertarCarretera(c1, c2,1);
    }

    public boolean insertarCarretera(Ciudad c1, Ciudad c2, int peso){
        if (c1.equals(c2)){
            return false;
        }
        Carretera carretera = new Carretera(c1, c2, peso);
        if (carreteras.containsKey(carretera.hashCode())){
            return false;
        } else if (c1.contieneCiudad(carretera) || c2.contieneCiudad(carretera)){
            return false;
        }
        carreteras.put(carretera.hashCode(), carretera);
        c1.insertarVecina(carretera);
        c2.insertarVecina(carretera);
        return true;
    }

    public boolean contieneCarretera(Carretera carretera){
        if (carretera.getCiudad1()==null||carretera.getCiudad2()==null){
            return false;
        }
        return this.carreteras.containsKey(carretera.hashCode());
    }

    public Carretera eliminarCarretera(Carretera carretera){
        carretera.getCiudad1().eliminarCiudadVecina(carretera);
        carretera.getCiudad2().eliminarCiudadVecina(carretera);
        return this.carreteras.remove(carretera.hashCode());
    }

    public boolean contieneCiudad(Ciudad ciudad){
        return (this.ciudades.get(ciudad.getNombre()))!=null;
    }

    public Ciudad getCiudad(String nombre){
        return (this.ciudades.get(nombre));
    }

    public boolean insertarCiudad(Ciudad ciudad, boolean sobreEscribeCiudad){
        Ciudad actual = this.ciudades.get(ciudad.getNombre());
        if (actual!=null){
            if (!sobreEscribeCiudad){
                return false;
            }
            while (actual.getContarVecinos() >=0){
                this.eliminarCarretera(actual.getCarretera(0));
            }
        }
        ciudades.put(ciudad.getNombre(),ciudad);
        return true;
    }


    public Set<String> verticeKeys(){
        return this.ciudades.keySet();
    }

    public Set<Carretera> getCarreteras(){
        return new HashSet<Carretera>(this.carreteras.values());
    }
}
