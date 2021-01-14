package ru.vladislavduma.invstocksservice.APIs.TinkoffInvest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TCSOrderBookResponseJson {
    private String figi;
    private Integer depth;
    private String tradeStatus;
    private Double minPriceIncrement;
    private Double lastPrice;
    private Double closePrice;
    private Double limitUp;
    private Double limitDown;
    private List<TCSOrderBookItem> asks;
    private List<TCSOrderBookItem> bids;

    public TCSOrderBookResponseJson() {}

    public String getFigi() {
        return figi;
    }

    public void setFigi(String figi) {
        this.figi = figi;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public Double getMinPriceIncrement() {
        return minPriceIncrement;
    }

    public void setMinPriceIncrement(Double minPriceIncrement) {
        this.minPriceIncrement = minPriceIncrement;
    }

    public Double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
    }

    public Double getLimitUp() {
        return limitUp;
    }

    public void setLimitUp(Double limitUp) {
        this.limitUp = limitUp;
    }

    public Double getLimitDown() {
        return limitDown;
    }

    public void setLimitDown(Double limitDown) {
        this.limitDown = limitDown;
    }

    public List<TCSOrderBookItem> getAsks() {
        return asks;
    }

    public void setAsks(List<TCSOrderBookItem> asks) {
        this.asks = asks;
    }

    public List<TCSOrderBookItem> getBids() {
        return bids;
    }

    public void setBids(List<TCSOrderBookItem> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return "TCSOrderBookResponseJson{" +
                "figi='" + figi + '\'' +
                ", depth=" + depth +
                ", tradeStatus='" + tradeStatus + '\'' +
                ", minPriceIncrement=" + minPriceIncrement +
                ", lastPrice=" + lastPrice +
                ", closePrice=" + closePrice +
                ", limitUp=" + limitUp +
                ", limitDown=" + limitDown +
                ", asks=" + asks +
                ", bids=" + bids +
                '}';
    }
}
