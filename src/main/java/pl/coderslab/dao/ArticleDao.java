package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ArticleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Article article){
        entityManager.persist(article);
    }

    public Article findById(Long id) {
        return entityManager.find(Article.class, id);
    }

    public void update(Article article) {
        entityManager.merge(article);
    }
}
