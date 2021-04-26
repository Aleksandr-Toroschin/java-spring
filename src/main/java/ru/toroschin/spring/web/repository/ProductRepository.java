package ru.toroschin.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.toroschin.spring.web.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("Select p FROM Product p WHERE p.title like %:title%")
    List<Product> hqlFindAllByTitle(String title);
//    List<Product> findAllByTitle(String title);
    List<Product> findAllByCostGreaterThan(int min);
    List<Product> findAllByCostBetween(int min, int max);
//    List<Product> findAllByIdLessThanAndCostGreaterThan(Long maxId, int minPrice);
}
