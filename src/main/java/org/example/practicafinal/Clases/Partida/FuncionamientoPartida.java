package org.example.practicafinal.Clases.Partida;

import org.example.practicafinal.Clases.BuclesDeControl.Bucles;
import org.example.practicafinal.Clases.Individuo.Individuo;
import org.example.practicafinal.Clases.Individuo.IndividuoAvanzado;
import org.example.practicafinal.Clases.Individuo.IndividuoNormal;
import org.example.practicafinal.Clases.Tablero.Casilla;

import java.util.ArrayList;
import java.util.List;

public class FuncionamientoPartida {
    public static void main(String[] args) {
        Bucles bucle = new Bucles();
        List<Casilla> casillas = new ArrayList<>();
        Partida partida = new Partida(70, 70, 3, 4, 3, 5, 2, 2);
        for (int i =0 ; i<3; i++){
            for (int j = 0; j<3; j++){
                Casilla casilla = new Casilla(i, j);
                casillas.add(casilla);
            }
        }
        partida.setListaCasillas(casillas);
        partida.individuosInicio();
        List<Individuo> individuos = partida.getListaIndividuos();
        for (Individuo individuo:individuos){
            System.out.println(individuo.getId());
            System.out.println(individuo.getCasilla().getId());
        }
        for (Casilla casilla:partida.listaCasillas){
            System.out.println(casilla.getId());
            System.out.println(casilla.getIndividuosIdCasilla());
            for (Individuo individuo : casilla.getIndividuosCasilla()){
                System.out.println("Id: "+individuo.getId()+", rango: "+individuo.getRango());
            }
            System.out.println(bucle.reordenar(casilla));
            bucle.evaluacionFinal(casilla);
            System.out.println(casilla.getIndividuosIdCasilla());
        }
    }
}
