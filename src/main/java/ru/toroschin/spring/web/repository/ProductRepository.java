package ru.toroschin.spring.web.repository;

import org.springframework.stereotype.Component;
import ru.toroschin.spring.web.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Шариковая ручка", 12.5));
        products.add(new Product(2L, "Гелевая ручка", 15));
        products.add(new Product(3L, "Фломастер красный", 32.5));
        products.add(new Product(4L, "Карандаш простой твердый", 7));
        products.add(new Product(5L, "Карандаш цветной зеленый", 16.2));
    }

    public boolean isExists(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public Product getProduct(int id) {
        for (Product product : products) {
            if (product.getId()==id) {
                return product;
            }
        }
        throw new NoSuchElementException("Не найден элемент с id="+id);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

}
