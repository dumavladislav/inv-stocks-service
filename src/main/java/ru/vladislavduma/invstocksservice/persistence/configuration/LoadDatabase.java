package ru.vladislavduma.invstocksservice.persistence.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.vladislavduma.invstocksservice.persistence.datamodel.StockState;
import ru.vladislavduma.invstocksservice.persistence.repositories.StockStateRepoitory;

import java.util.Date;

@Configuration
public class LoadDatabase {
    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(StockStateRepoitory repository) {
        return args -> {
            logger.info("Preloading " + repository.save(new StockState("AAPL", 130.5, new Date(), "USD")));
            logger.info("Preloading " + repository.save(new StockState("GMNK", 26400, new Date(), "RUR")));
            logger.info("Preloading " + repository.save(new StockState("BA", 212.5, new Date(), "USD")));
        };
    }

    @Bean
    CommandLineRunner readDatabase(StockStateRepoitory repository) {
        return args -> {
            logger.info("Reading " + repository.findAll().size());
        };
    }

}
