package pl.coderslab.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.service.CategoryService;
import pl.coderslab.entity.Category;

@Controller
public class CategoryController {
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("/category")
    public void save(@RequestParam String name, @RequestParam String description){
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        categoryService.save(category);
    }
    @GetMapping("/category/{id}")
    public Category findbyId(@PathVariable Long id){
        Category category = new Category();
        category = categoryService.findById(id);
        return category;
    }
    @PostMapping("/category/update")
    public void update(@RequestParam Long id, @RequestParam String name, @RequestParam String description){
        Category category = new Category();
        category = categoryService.findById(id);
        category.setName(name);
        category.setDescription(description);
        categoryService.update(category);
    }
}
