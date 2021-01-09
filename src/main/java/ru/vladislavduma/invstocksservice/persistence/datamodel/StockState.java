package ru.vladislavduma.invstocksservice.persistence.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class StockState extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ticker;
    private double price;
    private Date priceDate;
    private String currency;

    public StockState() {}

    public StockState(String ticker) {
        this.ticker = ticker;
    }
    public StockState(String ticker, double stockRate) {
        this.ticker = ticker;
        this.price = stockRate;
    }

    public StockState(String ticker, double price, Date priceDate, String currency) {
        this.ticker = ticker;
        this.price = price;
        this.priceDate = priceDate;
        this.currency = currency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getStockRate() {
        return price;
    }

    public void setStockRate(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if( this == o ) return true;
        if(!(o instanceof StockState)) return false;
        StockState ss = (StockState) o;
        return Objects.equals(this.ticker, ((StockState) o).ticker)
                && Objects.equals(this.price, ((StockState) o).price)
                && Objects.equals(this.priceDate, ((StockState) o).priceDate)
                && Objects.equals(this.currency, ((StockState) o).currency);
    }

    @Override
    public String toString() {
        return this.ticker + " : " + this.price + " " + this.currency + " : " + this.priceDate;
    }

}
