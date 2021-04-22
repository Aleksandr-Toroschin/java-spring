package ru.toroschin.spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.toroschin.spring.web.model.Category;
import ru.toroschin.spring.web.model.Product;
import ru.toroschin.spring.web.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService {
    private ProductRepository productRepository;
    private CategoryService categoryService;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findOneById(Long id) {
        return productRepository.findOneById(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void saveWithCategory(String title, int cost, Long id_category) {
        categoryService.findById(id_category).ifPresent(c -> productRepository.save(new Product(title, cost, c)));
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void incrementScore(Product product) {
        product.incrementCost();
        productRepository.save(product);
    }

    public void decrementScore(Product product) {
        product.decrementCost();
        productRepository.save(product);
    }

}
