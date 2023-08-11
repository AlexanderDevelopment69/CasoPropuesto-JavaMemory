package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {
    private Properties prop;

    public Configuracion(String archivoConfig) {
        prop = new Properties();

        try {
            FileInputStream configFile = new FileInputStream(archivoConfig);
            prop.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String obtenerTipoAlmacenamiento() {
        return prop.getProperty("almacenamiento");


    }
}
