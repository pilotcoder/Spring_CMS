package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CategoryDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Category category){
        entityManager.persist(category);
    }
}
