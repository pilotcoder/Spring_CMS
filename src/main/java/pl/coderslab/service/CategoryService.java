package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Category;

import javax.transaction.Transactional;

@Service
@Transactional
public class CategoryService {

    CategoryDao categoryDao = new CategoryDao();

    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public void save(Category category){
        categoryDao.save(category);
    }

    public Category findById(Long id) {
        return categoryDao.findById(id);
    }


    public void update(Category article) {
        categoryDao.update(article);
    }

    public void deleteById(Long id){
        categoryDao.delete(id);
    }
}
