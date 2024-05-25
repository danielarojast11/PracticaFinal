package org.example.practicafinal;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.practicafinal.Controller.EscenariosController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    /**
     * Generamos un log de sistema para esta clase
     *
     * Necesitamos instalar el paquete apache.logging.log4j.core, en su versión más reciente.
     * Para instalarlo, Open Module Settings -> libraries -> + en la lista -> From maven
     *
     * Además, se necesita configurar un fichero log4j2.xml en la carpeta resources, con la estructura e información
     * del sistema de log que vamos a usar.
     *
     *
     * Ejemplo:

     <?xml version="1.0" encoding="UTF-8"?>
     <Configuration status="DEBUG">
     <Appenders>
     <Console name="LogToConsole" target="SYSTEM_OUT">
     <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
     </Console>
     <RollingFile name="LogToRollingFile" fileName="logs/app.log"
     filePattern="logs/$${date:yyyy-MM}/app-%d{MM-dd-yyyy}-%i.log.gz">
     <PatternLayout>
     <Pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} - %-5level - %logger - %msg%n</Pattern>
     </PatternLayout>
     <Policies>
     <TimeBasedTriggeringPolicy />
     <SizeBasedTriggeringPolicy size="10 MB"/>
     </Policies>
     </RollingFile>

     </Appenders>
     <Loggers>
     <!-- Elimina duplicados con additivity=false -->
     <Logger name="es.uah" level="info" additivity="false">
     <AppenderRef ref="LogToRollingFile"/>
     <AppenderRef ref="LogToConsole"/>
     </Logger>
     <Root level="error">
     <AppenderRef ref="LogToConsole"/>
     </Root>
     </Loggers>
     </Configuration>

     * Este fichero de configuración hace que los logs se guarden en un fichero de la carpeta 'logs' del proyecto
     * que si no existe se creará.
     * los ficheros van guardándose, y se pueden añadir descriptores de hora al nombre para
     * que podamos seguir el rastro de cuándo se creó cada fichero de log.
     * Los logs se pueden enviar a consola o a fichero, como está configurado, pero también
     * se pueden enviar por correo electrónico (SMTP) y a bases de datos en otras configuraciones.
     */

    private static final System.Logger log = LogManager.getLogger(MainApplication.class);
    @Override
    public void start(Stage primaryStage) {
        new EscenariosController(primaryStage);
        primaryStage.setResizable(false);
    }
}
