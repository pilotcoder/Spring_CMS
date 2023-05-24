package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.Service.CategoryService;
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
}
