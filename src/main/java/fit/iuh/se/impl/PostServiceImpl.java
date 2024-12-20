package fit.iuh.se.impl;


import fit.iuh.se.dao.PostRepository;
import fit.iuh.se.entity.Post;
import fit.iuh.se.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getPostById(int id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePost(int id) {
        postRepository.deleteById(id);
    }
}