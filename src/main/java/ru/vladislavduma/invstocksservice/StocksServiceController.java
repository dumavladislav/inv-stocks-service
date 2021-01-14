package ru.vladislavduma.invstocksservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import ru.vladislavduma.invstocksservice.APIs.TinkoffInvest.TCSApi;
import ru.vladislavduma.invstocksservice.APIs.TinkoffInvest.TCSSearchByTickerResponseJson;
import ru.vladislavduma.invstocksservice.persistence.datamodel.StockState;
import ru.vladislavduma.invstocksservice.persistence.repositories.StockStateRepoitory;

import java.util.List;

@Component
@RestController
public class StocksServiceController {

    StockStateRepoitory stockStateRepoitory;

    @Autowired
    private TCSApi tinkoffApi;

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
    StockServiceResponseJson one(@PathVariable String ticker) {
        return tinkoffApi.searchByTicker(ticker);

//        stockStateRepoitory.findByTicker(ticker)
//                //.orElseThrow(() -> new StockNotFoundException(ticker))
//        ;
    }

}
