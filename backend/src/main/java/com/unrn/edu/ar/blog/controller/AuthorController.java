package com.unrn.edu.ar.blog.controller;

import com.unrn.edu.ar.blog.api.PostService;
import com.unrn.edu.ar.blog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class AuthorController {

    @Autowired
    private PostService postService;

    @GetMapping("/byauthor")
    public ResponseEntity<List<Map<String, Object>>> getPostCountByAuthor() {
        List<Map<String, Object>> authorsPostCount = postService.getPostCountByAuthor();
        return ResponseEntity.ok(authorsPostCount);
    }

    @GetMapping("/search/{text}")
    public ResponseEntity<?> searchPostsByText(@PathVariable String text) {
        try {
            List<Post> posts = postService.searchPostsByText(text);
            if (posts.isEmpty()) {
                return ResponseEntity.ok().body("No existen posts con ese texto");
            }
            return ResponseEntity.ok(posts);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("El texto de búsqueda no puede estar vacío");
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}

