package miu.main.service;

import miu.main.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PostService {

    public Optional<Post> findById(Long id);

    public List<Post> findAll();

    public void addPost(Post post);

    public void deletePost(long id);

    public void updatePost(long id, Post p);
}
