package dev.knapp.project2v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication // allows auto config
@ComponentScan("dev.knapp") // alerts spring to look for components / stereotypes
@EnableJpaRepositories("dev.knapp.repositories") //tells spring where to find our repos so hibernate can do its work
@EntityScan("dev.knapp.beans") // tells spring where our entities are
public class Project2v2Application {

	public static void main(String[] args) {
		SpringApplication.run(Project2v2Application.class, args);
	}

}
