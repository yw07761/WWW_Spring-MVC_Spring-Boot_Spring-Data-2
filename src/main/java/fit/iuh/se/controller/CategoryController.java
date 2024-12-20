package fit.iuh.se.controller;

import fit.iuh.se.entity.Category;
import fit.iuh.se.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Hiển thị form tạo thể loại
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "category-form"; // Chỉ đến file Thymeleaf là category-form.html
    }

    // Xử lý yêu cầu tạo thể loại
    @PostMapping("/create")
    public String createCategory(@Valid @ModelAttribute Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "category-form"; // Nếu có lỗi, quay lại form
        }
        categoryService.saveCategory(category); // Sử dụng CategoryService để lưu thể loại vào cơ sở dữ liệu
        return "redirect:/categories"; // Quay lại trang danh sách thể loại
    }

    // Hiển thị danh sách thể loại
    @GetMapping
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category-list"; // Chỉ đến file Thymeleaf hiển thị danh sách thể loại
    }

    // Hiển thị form chỉnh sửa thể loại
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            return "redirect:/categories"; // Nếu không tìm thấy thể loại, quay lại danh sách
        }
        model.addAttribute("category", category);
        return "category-form"; // Hiển thị lại form để chỉnh sửa
    }

    // Xử lý yêu cầu chỉnh sửa thể loại
    @PostMapping("/edit/{id}")
    public String updateCategory(@PathVariable int id, @Valid @ModelAttribute Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "category-form"; // Nếu có lỗi, quay lại form
        }
        category.setId(id); // Đảm bảo ID không bị mất
        categoryService.saveCategory(category); // Cập nhật thể loại
        return "redirect:/categories"; // Quay lại trang danh sách thể loại
    }

    // Xóa thể loại
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id); // Xóa thể loại
        return "redirect:/categories"; // Quay lại danh sách thể loại
    }
}
