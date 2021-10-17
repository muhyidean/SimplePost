package miu.main.service;

import miu.main.domain.Post;
import miu.main.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostSerivceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();

    }

    @Override
    public void addPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void updatePost(long id, Post p) {
        Optional<Post> existingPost = postRepository.findById(id);
        if (existingPost != null) {
            p.setId(id);
            postRepository.save(p);
        }
    }
}