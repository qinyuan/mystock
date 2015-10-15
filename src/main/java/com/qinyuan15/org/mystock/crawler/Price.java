package com.qinyuan15.org.mystock.crawler;

public class Price {
    private Stock stock;
    private double price;
    private double rate;

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Stock getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return stock + " " + price + " " + rate;
    }
}
