package br.ufrn.SmartRecibos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "br.ufrn")
@EntityScan("br.ufrn")
@EnableJpaRepositories("br.ufrn")

public class SmartRecibosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartRecibosApplication.class, args);
	}
}
