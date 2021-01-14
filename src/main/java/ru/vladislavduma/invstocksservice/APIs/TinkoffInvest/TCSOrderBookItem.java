package ru.vladislavduma.invstocksservice.APIs.TinkoffInvest;

public class TCSOrderBookItem {

    private Double price;
    private Integer quantity;

    public TCSOrderBookItem() {}

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
