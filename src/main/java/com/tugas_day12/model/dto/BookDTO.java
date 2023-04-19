package com.tugas_day12.model.dto;

import javax.persistence.Column;

public class BookDTO {
    private long id;
    private String title;
    private String author;
    private String descriptions;
    private String cover;
    private double price;
    private long stocks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getStocks() {
        return stocks;
    }

    public void setStocks(long stocks) {
        this.stocks = stocks;
    }
}
