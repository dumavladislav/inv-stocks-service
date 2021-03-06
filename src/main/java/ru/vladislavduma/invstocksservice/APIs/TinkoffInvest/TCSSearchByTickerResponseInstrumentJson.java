package ru.vladislavduma.invstocksservice.APIs.TinkoffInvest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TCSSearchByTickerResponseInstrumentJson {
    private String figi;
    private String ticker;
    private String isin;
    private Double minPriceIncrement;
    private Integer lot;
    private String currency;
    private String name;
    private String type;

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
}
