package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author ovinan
 */
@SpringBootApplication
public class CrudH2Application {
        // Si en el fichero application.properties tenemos habilitado: spring.h2.console.enabled=true
        // ..podremos conectarnos al editor de la base de datos H2 en la URL: http://localhost:8080/h2-console.
        // NOTA: El fichero application.properties esta en src/main/resources/default-package
	public static void main(String[] args) {
		SpringApplication.run(CrudH2Application.class, args);
	}

}
