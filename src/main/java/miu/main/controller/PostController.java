package miu.main.controller;

import miu.main.domain.Post;
import miu.main.service.PostSerivceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import miu.main.service.PostService;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping()
    public List<Post> getPosts(){
        List<Post> posts =  postService.findAll();
        return posts;
    }

    @GetMapping("/{id}")
    public Optional<Post> getPostById(@PathVariable String id){
        Optional<Post> p=  postService.findById(Long.parseLong(id));
        return  p;
    }

    @PostMapping
    public void addPost(@RequestBody Post post){
        postService.addPost(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        postService.deletePost(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Post post){
        postService.updatePost(id, post);
    }

    @GetMapping("/admin")
    public String inValidTest2(){
        return "OK";
    }


}
