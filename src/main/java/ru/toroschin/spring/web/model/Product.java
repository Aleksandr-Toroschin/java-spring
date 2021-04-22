package ru.toroschin.spring.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "deleteById", query = "delete from Product p where p.id = :id")
})
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private int cost;

    @ManyToOne
    @JoinColumn(name = "id_category",
            foreignKey = @ForeignKey(name = "FK_PRODUCT_ID"))
    private Category category;

    public Product(String title, int cost, Category category) {
        this.title = title;
        this.cost = cost;
        this.category = category;
    }

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
                ", title=" + title + '\'' +
                ", cost=" + cost + "}";
    }
}
