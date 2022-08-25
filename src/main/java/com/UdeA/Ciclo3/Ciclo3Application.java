package com.UdeA.Ciclo3;

import com.UdeA.Ciclo3.modelos.Empresa;
import org.hibernate.annotations.GeneratorType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class Ciclo3Application {
	@GetMapping("/Hola")
	public String hello(){
		return "Hola Ciclo 3... Saldremos vivos de esto!";
	}

	@GetMapping("/test")
	public String test(){
		Empresa emp = new Empresa("BikeHouse", "Calle 67 #53 - 108", "2198332", "890980040-8");
		emp.setNombre("BikeHouseProject");
		return emp.getNombre();
	}

	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);

	}

}
