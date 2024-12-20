package fit.iuh.se.service;

import fit.iuh.se.entity.Post;
import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post savePost(Post post);
    Post getPostById(int id);
    void deletePost(int id);
}