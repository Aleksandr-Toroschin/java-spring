package ru.toroschin.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.toroschin.spring.web.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByTitleLike(String title);
    List<Product> findAllByCostGreaterThan(int min);
    List<Product> findAllByCostBetween(int min, int max);
    List<Product> findAllByCostGreaterThanEqualAndTitleLike(int min, String title);
    List<Product> findAllByCostBetweenAndTitleLike(int min, int max, String title);

//    @Query("Select p FROM Product p WHERE p.title like :title")
//    List<Product> hqlFindAllByTitle(String title);
//    List<Product> findAllByTitle(String title);
//    List<Product> findAllByIdLessThanAndCostGreaterThan(Long maxId, int minPrice);
}
