package fit.iuh.se.service;

import fit.iuh.se.entity.Category;
import fit.iuh.se.entity.Post;

import java.util.List;
public interface CategoryService {
    List<Category> getAllCategories();
    Category saveCategory(Category category);
    Category getCategoryById(int id);
    void deleteCategory(int id);
}
