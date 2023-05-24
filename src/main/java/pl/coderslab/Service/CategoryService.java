package pl.coderslab.Service;

import org.springframework.stereotype.Service;
import pl.coderslab.dao.CategoryDao;
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
}
