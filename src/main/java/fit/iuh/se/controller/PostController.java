package fit.iuh.se.controller;



import fit.iuh.se.dao.CategoryRepository;
import fit.iuh.se.entity.Post;
import fit.iuh.se.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String listPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("categories", categoryRepository.findAll());
        return "post-form";
    }

    @PostMapping("/create")
    public String createPost(@Valid @ModelAttribute Post post, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryRepository.findAll());
            return "post-form";
        }
        postService.savePost(post);
        return "redirect:/posts";
    }

    // Xem chi tiết bài viết
    @GetMapping("/{id}")
    public String viewPost(@PathVariable int id, Model model) {
        Post post = postService.getPostById(id);
        if (post == null) {
            return "redirect:/posts";
        }
        model.addAttribute("post", post);
        return "post-details";
    }

    // Hiển thị form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Post post = postService.getPostById(id);
        if (post == null) {
            return "redirect:/posts";
        }
        model.addAttribute("post", post);
        model.addAttribute("categories", categoryRepository.findAll());
        return "post-form";
    }

    // Cập nhật bài viết
    @PostMapping("/edit/{id}")
    public String updatePost(@PathVariable int id, @Valid @ModelAttribute Post post, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryRepository.findAll());
            return "post-form";
        }
        post.setId(id); // Đảm bảo ID không bị mất
        postService.savePost(post);
        return "redirect:/posts";
    }

    // Xóa bài viết
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable int id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }
}
