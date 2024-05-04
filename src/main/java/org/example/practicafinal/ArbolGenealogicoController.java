package org.example.practicafinal;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.example.practicafinal.Clases.Individuo.Individuo;

import java.util.List;

public class ArbolGenealogicoController {
    public Pane paneArbol;
    EscenariosController controladorEscenarios;
    private List<Individuo> listaIndividuos;

    @FXML
    private Button btnEnd;

    @FXML
    void salir() {
        controladorEscenarios.cargarEscenarioInicio();
    }

    public void setControladorEscenarios(EscenariosController controladorEscenarios) {
        this.controladorEscenarios = controladorEscenarios;
    }

    public int getRandom(int min, int max){
        int range = (max - min) + 1;
        int random = (int) ((range * Math.random()) + min);
        return random;
    }

    public void mostrarIndividuos(List<Individuo> listaIndividuos){
        for (Individuo individuo : listaIndividuos){
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
            circulo.setCenterX(getRandom(50, 800));
            circulo.setCenterY(getRandom(50, 550));
            paneArbol.getChildren().add(circulo);
            System.out.println(individuo);
        }

    }
}
