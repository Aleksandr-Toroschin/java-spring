package ru.toroschin.spring.web.model;

public class Product {
    private final Long id;
    private final String title;
    private final double cost;

    public Product(Long id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", '" + title + '\''
                + "}";
    }
}
