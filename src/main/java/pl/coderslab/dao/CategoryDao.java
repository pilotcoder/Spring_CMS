package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
//import pl.coderslab.entity.Article;
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

    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }

    public void update(Category category) {
        entityManager.merge(category);
    }

    public void delete(Long id){
        Category category =findById(id);
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }
}
