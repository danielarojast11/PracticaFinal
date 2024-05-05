package org.example.practicafinal.Clases.BuclesDeControl;

import org.example.practicafinal.Clases.Entorno.Elementos;
import org.example.practicafinal.Clases.Individuo.Individuo;
import org.example.practicafinal.Clases.Tablero.Casilla;

import java.util.List;

public class Bucles {

    //Parameters
    private List<Individuo> listaIndividuos;
    private List<Elementos> listaElementos;
    private List<Casilla> tablero;
    private Individuo individuo;

    //Methods
    public List<Individuo> actualizarTiempoVida(List<Individuo> listaIndividuos){
        for (Individuo individuo : listaIndividuos){
            individuo.setTurnosVida(individuo.getTurnosVida()-1);
            if (individuo.getTurnosVida() == 0){
                listaIndividuos.remove(individuo);
            }
        }
        return listaIndividuos;
    }

    public List<Elementos> actualizarElementos(List<Elementos> listaElementos){
        for (Elementos elemento : listaElementos){
            elemento.setTiempoActividad(elemento.getTiempoActividad() -1);
            if (elemento.getTiempoActividad() == 0){
                listaElementos.remove(elemento);
            }
        }
        return listaElementos;
    }

    public List<Individuo> individuoEnCasilla(List<Casilla> tablero, List<Individuo> listaIndividuos){
        for (Casilla casilla : tablero){
            if (individuo.getIndividuos().size() > 3){
                for (Individuo individuo :  listaIndividuos){
                    individuo.getTurnosVida();
                    //listaIndividuos.sort();
                }
            }
        }
        return listaIndividuos;
    }
}
