package com.tugas_day12.model.dao;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class BookDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column private String title;
    @Column private String author;
    @Column private String descriptions;
    @Column private String cover;
    @Column private double price;
    @Column private long stocks;

    public BookDAO() {
    }

    public BookDAO(String title, String author, String descriptions, String cover, double price, long stocks) {
        this.title = title;
        this.author = author;
        this.descriptions = descriptions;
        this.cover = cover;
        this.price = price;
        this.stocks = stocks;
    }

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
