package ru.vladislavduma.invstocksservice;

public class InstrumentData {

    // Tinkoff Fields
    private String figi;
    private String ticker;
    private String isin;
    private Double minPriceIncrement;
    private Integer lot;
    private String currency;
    private String name;
    private String type;

    // Additional
    private Double currentPrice;


    public InstrumentData() {}

    public InstrumentData(String figi, String ticker, String isin, Double minPriceIncrement, Integer lot, String currency, String name, String type, Double currentPrice) {
        this.figi = figi;
        this.ticker = ticker;
        this.isin = isin;
        this.minPriceIncrement = minPriceIncrement;
        this.lot = lot;
        this.currency = currency;
        this.name = name;
        this.type = type;
        this.currentPrice = currentPrice;
    }

    public String getFigi() {
        return figi;
    }

    public void setFigi(String figi) {
        this.figi = figi;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public Double getMinPriceIncrement() {
        return minPriceIncrement;
    }

    public void setMinPriceIncrement(Double minPriceIncrement) {
        this.minPriceIncrement = minPriceIncrement;
    }

    public Integer getLot() {
        return lot;
    }

    public void setLot(Integer lot) {
        this.lot = lot;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
