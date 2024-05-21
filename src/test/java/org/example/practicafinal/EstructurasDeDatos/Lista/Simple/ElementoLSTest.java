package org.example.practicafinal.EstructurasDeDatos.Lista.Simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoLSTest {

    @Test
    void getData() {
        ElementoLS e1 = new ElementoLS();
        e1.getData();
    }

    @Test
    void setData() {
        ElementoLS e1 = new ElementoLS();
        e1.setData(e1);
        e1.getData();
    }
}