package pl.coderslab.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;
import pl.coderslab.service.ArticleService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticleController {
    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    //@RequestParam String name, @RequestParam String description,
    @PostMapping("/article")
    public void save(@RequestParam String title, @RequestParam String content, @RequestParam String firstName, @RequestParam String lastName) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
//        Category category = new Category();
//        category.setName(name);
//        category.setDescription(description);
//        List<Category> categories = new ArrayList<>();
//        categories.add(category);

        article.setAuthor(author);
//        article.setCategories(categories);
        articleService.save(article);

    }
}
