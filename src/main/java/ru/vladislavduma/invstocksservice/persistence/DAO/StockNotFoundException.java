package ru.vladislavduma.invstocksservice.persistence.DAO;

public class StockNotFoundException extends RuntimeException {
    public StockNotFoundException(String ticker) {
        super("Stock not found by ticker " + ticker);
    }
}
