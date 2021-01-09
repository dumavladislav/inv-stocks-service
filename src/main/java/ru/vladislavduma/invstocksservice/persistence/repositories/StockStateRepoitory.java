package ru.vladislavduma.invstocksservice.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vladislavduma.invstocksservice.persistence.datamodel.StockState;

public interface StockStateRepoitory extends JpaRepository<StockState, Long> {
    StockState findByTicker(String ticker);
}
