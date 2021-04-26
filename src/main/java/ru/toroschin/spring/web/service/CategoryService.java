package ru.toroschin.spring.web.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.toroschin.spring.web.model.Category;
import ru.toroschin.spring.web.model.Product;
import ru.toroschin.spring.web.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<Product> findProductsByCategory(Long id) {
        return categoryRepository.hqlFindById(id).getProducts();
    }
}
