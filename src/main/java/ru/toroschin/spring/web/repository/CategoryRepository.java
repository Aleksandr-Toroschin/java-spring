package ru.toroschin.spring.web.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.toroschin.spring.web.model.Category;
import ru.toroschin.spring.web.model.Product;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("Select c FROM Category c JOIN FETCH c.products WHERE c.id=:id")
    Category hqlFindById(Long id);
//    {
//        try (Session session = hibernateUtils.getCurrentSession()) {
//            session.beginTransaction();
//            Category category = session
//                    .createNamedQuery("withProducts", Category.class)
//                    .setParameter("id", id)
//                    .getSingleResult();
//            session.getTransaction().commit();
//            return Optional.ofNullable(category.getProducts());
//        } catch (NoResultException e) {
//            return Optional.empty();
//        }
//    }
}
