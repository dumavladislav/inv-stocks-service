package ru.vladislavduma.invstocksservice;

import org.springframework.web.bind.annotation.*;
import ru.vladislavduma.invstocksservice.persistence.DAO.StockNotFoundException;
import ru.vladislavduma.invstocksservice.persistence.datamodel.StockState;
import ru.vladislavduma.invstocksservice.persistence.repositories.StockStateRepoitory;

import java.util.List;

@RestController
public class StocksServiceController {

    StockStateRepoitory stockStateRepoitory;

    StocksServiceController(StockStateRepoitory stockStateRepoitory) {
        this.stockStateRepoitory = stockStateRepoitory;
    }

    @GetMapping("/stocks")
    List<StockState> all() {
        return stockStateRepoitory.findAll();
    }

    @PostMapping("/stocks") 
    StockState newStockState(@RequestBody StockState stockState) {
        return stockStateRepoitory.save(stockState);
    }

    @GetMapping("/stocks/{ticker}")
    StockState one(@PathVariable String ticker) {
        return stockStateRepoitory.findByTicker(ticker)
                //.orElseThrow(() -> new StockNotFoundException(ticker))
        ;
    }

}
