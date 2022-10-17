package br.com.academia.applicaton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;


@SpringBootApplication
@ConfigurationProperties

public class AcademiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademiaApplication.class, args);
	}

}
