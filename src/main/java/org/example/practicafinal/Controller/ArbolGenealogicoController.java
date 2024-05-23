package org.example.practicafinal.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import org.example.practicafinal.Entity.Individuo;
import org.example.practicafinal.Controller.EscenariosController;
import org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada.ListaDoblementeEnlazada;

public class ArbolGenealogicoController {
    public Pane paneArbol;
    EscenariosController controladorEscenarios;
    private ListaDoblementeEnlazada<Individuo> listaIndividuos;

    @FXML
    private Button btnEnd;

    @FXML
    void salir() {
        controladorEscenarios.cargarEscenarioInicio();
    }

    public void setControladorEscenarios(EscenariosController controladorEscenarios) {
        this.controladorEscenarios = controladorEscenarios;
    }

    public void mostrarIndividuos(ListaDoblementeEnlazada<Individuo> listaIndividuos){
        /*for (Individuo individuo : listaIndividuos){
            mostrarIndiviuo(individuo, null, false, 0, false, true);
        }*/

        /*Individuo individuo1 = new Individuo();
        individuo1.setRango(1);
        Individuo individuo2 = new Individuo();
        individuo2.setRango(2);
        individuo1.addPadre(individuo2);
        Individuo individuo3 = new Individuo();
        individuo3.setRango(3);
        Individuo individuo4 = new Individuo();
        individuo4.setRango(1);
        individuo2.addPadre(individuo3);
        individuo2.addPadre(individuo4);
        Individuo individuo5 = new Individuo();
        individuo5.setRango(2);
        individuo4.addPadre(individuo5);
        Individuo individuo6 = new Individuo();
        individuo6.setRango(3);
        Individuo individuo7 = new Individuo();
        individuo7.setRango(1);
        individuo1.addHijo(individuo6);
        individuo1.addHijo(individuo7);
        Individuo individuo8 = new Individuo();
        individuo8.setRango(1);
        individuo7.addHijo(individuo8);
        mostrarIndiviuo(individuo1, null, false, 0, false);*/
    }

    private void mostrarIndiviuo(
            Individuo individuoActual,
            Coordenadas coordenadasAnteriores,
            boolean padre,
            int numero,
            boolean derecha,
            boolean inicial
    ){
        Circle circulo = crearCirculoIndividuo(individuoActual);
        double x = 0;
        double y = 0;
        if (coordenadasAnteriores == null){
            x = paneArbol.getPrefWidth() /2;
            y = paneArbol.getPrefHeight() /2;
        } else {
            double operador = (padre) ? -60 : 60;
            if (numero == 1){
                x = coordenadasAnteriores.getX();
                y = coordenadasAnteriores.getY() + operador;
            } else {
                double operador2 = (derecha) ? 60: -60;
                x = coordenadasAnteriores.getX() + operador2;
                y = coordenadasAnteriores.getY() + operador;
            }
        }
        circulo.setCenterX(x);
        circulo.setCenterY(y);
        paneArbol.getChildren().add(circulo);

        if (coordenadasAnteriores != null) {
            Line linea = new Line(
                    coordenadasAnteriores.getX(),
                    coordenadasAnteriores.getY(),
                    x,
                    y
            );
            paneArbol.getChildren().add(linea);
        }

        Coordenadas coordenadas = new Coordenadas(x, y);
        for(int i = 0; i < individuoActual.getPadres().getNumeroElementos(); i++){
            boolean d = i > 0;
            //mostrarIndiviuo(individuoActual.getPadres().get(i), coordenadas, true, individuoActual.getPadres().size(), d, false);
            //mostrarIndiviuo(individuoActual.getPadres().get(i), coordenadas, true, individuoActual.getPadres().getNumeroElementos(), d);
        }
        for (int i = 0; i < individuoActual.getHijos().getNumeroElementos(); i++){
            boolean d = i > 0;
            //mostrarIndiviuo(individuoActual.getHijos().get(i), coordenadas, false, individuoActual.getHijos().size(), d, false);
            //mostrarIndiviuo(individuoActual.getHijos().get(i), coordenadas, false, individuoActual.getHijos().getNumeroElementos(), d);
        }
    }

    private Circle crearCirculoIndividuo(Individuo individuo){
        Circle circulo = new Circle();
        int rango = individuo.getRango();
        if (rango == 3) {
            circulo.setStroke(Color.rgb(255, 74, 123));
            circulo.setFill(Color.rgb(255,74,123));
        } else if (rango == 2) {
            circulo.setStroke(Color.rgb(241, 241, 70));
            circulo.setFill(Color.rgb(241, 241, 70));
        } else {
            circulo.setStroke(Color.rgb(169, 250, 70));
            circulo.setFill(Color.rgb(169, 250, 70));
        }
        circulo.setRadius(20);
        return circulo;
    }

    class Coordenadas {
        private final double x;
        private final double y;
        public Coordenadas(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }
        public double getY(){
            return y;
        }
    }
}

