package ru.vladislavduma.invstocksservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableJpaAuditing
public class InvStocksServiceApplication {

	public static void main(String[] args) {

		/*ApplicationContext applicationContext =*/
				SpringApplication.run(InvStocksServiceApplication.class, args);
//		applicationContext.getBean(StocksServiceController.class);

	}

}
