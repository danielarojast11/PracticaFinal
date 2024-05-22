package org.example.practicafinal.Clases.Partida;

import org.example.practicafinal.Clases.BuclesDeControl.Bucles;
import org.example.practicafinal.Entity.Individuo;
import org.example.practicafinal.Clases.Tablero.Casilla;

import java.util.ArrayList;
import java.util.List;

public class FuncionamientoPartida {
    public static void main(String[] args) {
        List<Casilla> casillas = new ArrayList<>();
        Partida partida = new Partida(70, 70, 3, 4, 4, 0, 2, 2, 3, 0, 2, 3, 3, 2, 2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Casilla casilla = new Casilla(i, j);
                casillas.add(casilla);
            }
        }
        List<Individuo> individuos = new ArrayList<>();
        Bucles bucle = new Bucles();
        bucle.setPartida(partida);
        individuos.add(new Individuo(9, 8, 10, 10));
        partida.setListaCasillas(casillas);
        partida.individuosInicio(individuos);
        for (Individuo individuo:individuos) {
            System.out.println(individuo.getId());
        }
        for (Casilla casilla : casillas){
            System.out.println(casilla.getId());
            System.out.println(casilla.getIndividuosIdCasilla());
            bucle.evaluacionFinal();
            System.out.println(casilla.getIndividuosIdCasilla());
        }
        for (int i = 0; i<3; i++){
            for (Individuo individuo:individuos){
               individuo.modificarTurnosVida();
            }
        }
        List<Individuo> individuoscopia = new ArrayList<>();
        individuoscopia.addAll(individuos);
        individuos.clear();
        for (Individuo individuo:individuoscopia){
            System.out.println(individuo.getId());
            if (individuo.getTurnosVida()>0){
                individuos.add(individuo);
            }
        }
        for (Individuo individuo:individuos){
            System.out.println(individuo.getId());
        }
    }
}
