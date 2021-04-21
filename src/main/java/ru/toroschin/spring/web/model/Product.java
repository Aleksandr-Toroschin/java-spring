package ru.toroschin.spring.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private double cost;

    public void incrementCost() {
        if (cost < Integer.MAX_VALUE) {
            cost++;
        }
    }

    public void decrementCost() {
        if (cost > 0) {
            cost--;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", '" + title + '\''
                + "}";
    }
}
