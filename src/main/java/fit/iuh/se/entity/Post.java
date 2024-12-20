package fit.iuh.se.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Title cannot be blank")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Content cannot be blank")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @NotBlank(message = "Author cannot be blank")
    @Column(nullable = false, length = 100)
    private String author;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}