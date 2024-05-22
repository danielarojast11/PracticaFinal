package org.example.practicafinal.Dialog;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import org.example.practicafinal.Entity.*;
import java.io.IOException;

public class CasillaDialog extends Dialog<PartidaCasilla> {
    //Parametros Tipos de Individuos
    private Slider sliderBasico;
    private Slider sliderNormal;
    private Slider sliderAvanzado;

    //Parametros Entorno
    private Slider sliderAgua;
    private Slider sliderComida;
    private Slider sliderMontanas;
    private Slider sliderCofres;
    private Slider sliderBibliotecas;
    private Slider sliderPozos;

    //Botones
    private Button btnCancel;
    private Button btnOk;

    private final Casilla casilla;
    private final Partida partida;

    public CasillaDialog(Casilla casilla, Partida partida) {
        super();
        this.setTitle("Elementos en casilla " + casilla.getFila() + " - " + casilla.getColumna());
        this.casilla = casilla;
        this.partida = partida;

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/org/example/practicafinal/configuracionCasilla-view.fxml"));
            loader.setController(this);

            DialogPane dialogPane = loader.load();
            setDialogPane(dialogPane);

            int maxBasico = Math.min(partida.getMaxIndividuos(), partida.getNumeroIndividuosBasicos());
            sliderBasico = (Slider) loader.getNamespace().get("sliderBasico");
            sliderBasico.setMax(maxBasico);
            int maxNormal = Math.min(partida.getMaxIndividuos(), partida.getNumeroIndividuosNormal());
            sliderNormal = (Slider) loader.getNamespace().get("sliderNormal");
            sliderNormal.setMax(maxNormal);
            int maxAvanzado = Math.min(partida.getMaxIndividuos(), partida.getNumeroIndividuosAvanzados());
            sliderAvanzado = (Slider) loader.getNamespace().get("sliderAvanzado");
            sliderAvanzado.setMax(maxAvanzado);

            int maxAgua = Math.min(partida.getMaxElementos(), partida.getAgua());
            sliderAgua = (Slider) loader.getNamespace().get("sliderAgua");
            sliderAgua.setMax(maxAgua);
            int maxComida = Math.min(partida.getMaxElementos(), partida.getComida());
            sliderComida = (Slider) loader.getNamespace().get("sliderComida");
            sliderComida.setMax(maxComida);
            int maxMontanas = Math.min(partida.getMaxElementos(), partida.getMontana());
            sliderMontanas = (Slider) loader.getNamespace().get("sliderMontanas");
            sliderMontanas.setMax(maxMontanas);
            int maxCofres = Math.min(partida.getMaxElementos(), partida.getCofre());
            sliderCofres = (Slider) loader.getNamespace().get("sliderCofres");
            sliderCofres.setMax(maxCofres);
            int maxBibliotecas = Math.min(partida.getMaxElementos(), partida.getBiblioteca());
            sliderBibliotecas = (Slider) loader.getNamespace().get("sliderBibliotecas");
            sliderBibliotecas.setMax(maxBibliotecas);
            int maxPozos = Math.min(partida.getMaxElementos(), partida.getPozo());
            sliderPozos = (Slider) loader.getNamespace().get("sliderPozos");
            sliderPozos.setMax(maxPozos);

            btnCancel = (Button) loader.getNamespace().get("btnCancel");
            btnCancel.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                        setResult(new PartidaCasilla(null, null));
                    }
                }
            });
            btnOk = (Button) loader.getNamespace().get("btnOk");
            btnOk.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                        actualizarDatos();
                        setResult(new PartidaCasilla(casilla, partida));
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void actualizarDatos() {
        int valor = (int) sliderBasico.getValue();
        this.partida.setNumeroIndividuosBasicos(
            this.partida.getNumeroIndividuosBasicos() - valor
        );
        this.colocarIndividuos(valor, 1);
        valor = (int) sliderNormal.getValue();
        this.partida.setNumeroIndividuosNormal(
                this.partida.getNumeroIndividuosNormal() - valor
        );
        this.colocarIndividuos(valor, 2);
        valor = (int) sliderAvanzado.getValue();
        this.partida.setNumeroIndividuosAvanzados(
                this.partida.getNumeroIndividuosAvanzados() - valor
        );
        this.colocarIndividuos(valor, 3);

        valor = (int) sliderAgua.getValue();
        this.partida.setAgua(
                this.partida.getAgua() - valor
        );
        for (int i = 0; i < valor; i++) {
            this.casilla.addElementoCasilla(
                new Agua(partida.getTiempoActividad(), casilla)
            );
        }
        valor = (int) sliderComida.getValue();
        this.partida.setComida(
                this.partida.getComida() - valor
        );
        for (int i = 0; i < valor; i++) {
            this.casilla.addElementoCasilla(
                new Comida(partida.getTiempoActividad(), casilla)
            );
        }
        valor = (int) sliderMontanas.getValue();
        this.partida.setMontana(
                this.partida.getMontana() - valor
        );
        for (int i = 0; i < valor; i++) {
            this.casilla.addElementoCasilla(
                new Montaña(partida.getTiempoActividad(), casilla)
            );
        }
        valor = (int) sliderCofres.getValue();
        this.partida.setCofre(
                this.partida.getCofre() - valor
        );
        for (int i = 0; i < valor; i++) {
            this.casilla.addElementoCasilla(
                new Tesoro(partida.getTiempoActividad(), casilla)
            );
        }
        valor = (int) sliderBibliotecas.getValue();
        this.partida.setBiblioteca(
                this.partida.getBiblioteca() - valor
        );
        for (int i = 0; i < valor; i++) {
            this.casilla.addElementoCasilla(
                new Biblioteca(partida.getTiempoActividad(), casilla)
            );
        }
        valor = (int) sliderPozos.getValue();
        this.partida.setPozo(
                this.partida.getPozo() - valor
        );
        for (int i = 0; i < valor; i++) {
            this.casilla.addElementoCasilla(
                new Pozo( partida.getTiempoActividad(), casilla)
            );
        }
    }

    private void colocarIndividuos(int valor, int rango) {
        for (int i = 0; i < valor; i++) {
            partida.aumentarid();
            Individuo in = new Individuo(
                    partida.getId(),
                    partida.getTurno(),
                    partida.getTurnosVida(),
                    partida.getProbReproduccion(),
                    partida.getProbClonacion(),
                    rango,
                    casilla
            );
            this.casilla.addIndividuo(in);
        }
    }
}
