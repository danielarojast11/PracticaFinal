package org.example.practicafinal.Dialogs;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import org.example.practicafinal.Clases.Tablero.Casilla;

import java.io.IOException;

public class CasillaDialog extends Dialog<Casilla> {
    private Casilla casilla;

    public CasillaDialog(Casilla casilla) {
        super();
        this.setTitle("Elementos en casilla " + casilla.getFila() + " - " + casilla.getColumna());
        this.casilla = casilla;

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/org/example/practicafinal/configuracionCasilla-view.fxml"));
            loader.setController(this);

            DialogPane dialogPane = loader.load();
            setDialogPane(dialogPane);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
