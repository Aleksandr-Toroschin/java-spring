package ru.toroschin.spring.web.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.toroschin.spring.web.model.Category;
import ru.toroschin.spring.web.model.Product;
import ru.toroschin.spring.web.util.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryRepository {
    private final HibernateUtils hibernateUtils;

    @Autowired
    public CategoryRepository(HibernateUtils hibernateUtils) {
        this.hibernateUtils = hibernateUtils;
    }

    public Optional<Category> findById(Long id) {
        try (Session session = hibernateUtils.getCurrentSession()) {
            session.beginTransaction();
            Category category = session.get(Category.class, id);
            session.getTransaction().commit();
            return Optional.ofNullable(category);
        }
    }

    public Optional<List<Product>> findProductsByCategory(Long id) {
        try (Session session = hibernateUtils.getCurrentSession()) {
            session.beginTransaction();
            Category category = session
                    .createNamedQuery("withProducts", Category.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.getTransaction().commit();
            return Optional.ofNullable(category.getProducts());
        } catch (NoResultException e) {
            return Optional.empty();
        }

    }
}
