package org.example.practicafinal.Dialogs;

import javafx.scene.control.Dialog;
import org.example.practicafinal.Clases.Tablero.Casilla;

public class CasillaDialog extends Dialog<Casilla> {
    private Casilla casilla;

    public CasillaDialog(Casilla casilla) {
        super();
        this.setTitle("Elementos en casilla " + casilla.getFila() + " - " + casilla.getColumna());
        this.casilla = casilla;
    }


}
