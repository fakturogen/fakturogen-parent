package pl.fakturogen.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.fakturogen.comarchconnector.connector.ComarchApiTokenConnector;

@SpringBootApplication
public class FakturogenWebApplication {

	@Bean
	public ComarchApiTokenConnector comarchApiTokenConnector() {
		return new ComarchApiTokenConnector();
	}

	public static void main(String[] args) {
		SpringApplication.run(FakturogenWebApplication.class, args);
	}

}
