package org.example.practicafinal.Clases.Partida;

import org.example.practicafinal.Clases.BuclesDeControl.Bucles;
import org.example.practicafinal.Clases.Entorno.Elementos;
import org.example.practicafinal.Clases.Individuo.Individuo;
import org.example.practicafinal.Clases.Individuo.IndividuoAvanzado;
import org.example.practicafinal.Clases.Individuo.IndividuoNormal;
import org.example.practicafinal.Clases.Tablero.Casilla;

import java.util.ArrayList;
import java.util.List;

public class FuncionamientoPartida {
    public static void main(String[] args) {
        List<Casilla> casillas = new ArrayList<>();
        Partida partida = new Partida(70, 70, 3, 1, 1, 0, 2, 2, 3, 0, 2, 3, 3, 10, 10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Casilla casilla = new Casilla(i, j);
                casillas.add(casilla);
            }
        }
        partida.setListaCasillas(casillas);
        partida.individuosInicio();
        partida.elementosPrincipio();
        List<Individuo> individuos = partida.getListaIndividuos();
        for (Individuo individuo : individuos){
            System.out.println(individuo.getId());
            individuo.setId(3);
        }
        for (Individuo in : individuos){
            System.out.println(in.getId());
        }

    }
}
