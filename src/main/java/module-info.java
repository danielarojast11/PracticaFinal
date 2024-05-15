module org.example.practicafinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires org.jetbrains.annotations;
    requires com.google.gson;
    requires com.fasterxml.jackson.databind;

    opens org.example.practicafinal to javafx.fxml;
    exports org.example.practicafinal;
}