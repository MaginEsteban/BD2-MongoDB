package com.unrn.edu.ar.blog.controller;

import com.unrn.edu.ar.blog.model.Post;
import com.unrn.edu.ar.blog.service.PostServiceMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostServiceMongoDB postService;

    @GetMapping("/latest")
    public ResponseEntity<List<Post>> getLatestPosts() {
        List<Post> latestPosts = postService.getLatestPosts();
        return ResponseEntity.ok(latestPosts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable String id) {
        Post post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/author/{authorName}")
    public ResponseEntity<List<Post>> getAuthorByName(@PathVariable String authorName) {
        List<Post> post = postService.getPostsByAuthor(authorName);
        return ResponseEntity.ok(post);
    }
}
