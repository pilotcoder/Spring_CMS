package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
    public List<Article> findAll(){
        return entityManager.createQuery("select  a from Article a").getResultList();

    }

    public void update(Article article) {
        entityManager.merge(article);
    }

    public void delete(Long id){
        Article article = findById(id);
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article) );
    }
}
