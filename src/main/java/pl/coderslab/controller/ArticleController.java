package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;
import pl.coderslab.service.ArticleService;
import pl.coderslab.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final CategoryService categoryService;



    private final ArticleService articleService;


    //@RequestParam String name, @RequestParam String description,
    @PostMapping("/article")
    public void save(@RequestParam String title, @RequestParam String content, @RequestParam String name, @RequestParam String description, @RequestParam String firstName, @RequestParam String lastName) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        categoryService.save(category);
        List<Category> categories = new ArrayList<>();
        categories.add(category);

        article.setAuthor(author);
        article.setCategories(categories);
        articleService.save(article);


    }
    @PostMapping("/article/addcategory")
    public void addCategory(@RequestParam String description, @RequestParam String name, @RequestParam Long articleId){
        Article article = new Article();
        article = articleService.findById(articleId);
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        categoryService.save(category);
        List<Category> categories = article.getCategories();
        categories.add(category);
        article.setCategories(categories);
        articleService.update(article);
    }
    @PostMapping("/article/update")
    public void update(@RequestParam Long articleId,@RequestParam String title, @RequestParam String content){
        Article article = new Article();
        article = articleService.findById(articleId);
        article.setTitle(title);
        article.setContent(content);
       articleService.update(article);
    }

    @PostMapping("/article/delete")
    public void delete(@RequestParam Long id){
        articleService.deleteById(id);
    }

    @GetMapping("/articles")
    public String findAllToString(){
        List<Article> articles = articleService.findAllToString();

        return articles.toString();
    }


}
