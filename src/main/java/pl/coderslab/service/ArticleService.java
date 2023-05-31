package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {
   private final ArticleDao articleDao;

   private final AuthorService authorService;

   private final CategoryService categoryService;



    public void save(Article article) {
        Author author = article.getAuthor();
        authorService.save(author);
//        List<Category>  categories = article.getCategories();
//
//        List<Category> filteredCategories = categories.stream()
//                .filter(a -> categoryService.findById(a.getId()) != null)
//                .collect(Collectors.toList());
//        article.setCategories(filteredCategories);
        articleDao.save(article);
    }

    public Article findById(Long id) {
        return articleDao.findById(id);
    }


    public void update(Article article) {
        articleDao.update(article);
    }




}