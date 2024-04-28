package org.example.practicafinal.Clases.Partida;

import org.example.practicafinal.Clases.Individuo.Individuo;
import org.example.practicafinal.Clases.Individuo.IndividuoAvanzado;
import org.example.practicafinal.Clases.Individuo.IndividuoNormal;

public class FuncionamientoPartida {
    public static void main(String[] args) {
        Partida partida = new Partida();
        partida.setId(1);
        IndividuoAvanzado parentone = partida.crearAvanzado();
        IndividuoNormal parentwo = partida.crearNormal();
        Individuo hijo = partida.reproducir(parentone,parentwo);
        System.out.println(hijo.getClass());
        System.out.println(hijo.getId());
    }
}
