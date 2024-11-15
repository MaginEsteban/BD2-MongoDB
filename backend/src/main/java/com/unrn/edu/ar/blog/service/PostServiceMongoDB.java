package com.unrn.edu.ar.blog.service;

import com.unrn.edu.ar.blog.api.PostService;
import com.unrn.edu.ar.blog.model.Post;
import com.unrn.edu.ar.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostServiceMongoDB implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getLatestPosts() {
        return postRepository.findTop4ByOrderByDateDesc();
    }

    @Override
    public Post getPostById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El Post on id: " + id + " no existe"));
    }

    @Override
    public List<Map<String, Object>> getPostCountByAuthor() {
        List<Post> posts = postRepository.findAll();  // Obtener todos los posts

        // Agrupar los posts por autor (String) y contar la cantidad de posts por autor
        return posts.stream()
                .collect(Collectors.groupingBy(Post::getAuthor, Collectors.counting())) // Agrupar por el campo 'author'
                .entrySet().stream()
                .map(entry -> {
                    Map<String, Object> result = new HashMap<>();
                    result.put("id", entry.getKey());      // El autor (ID como String)
                    result.put("count", entry.getValue());  // La cantidad de posts
                    return result;
                })
                .collect(Collectors.toList());
    }


    @Override
    public List<Post> getPostsByAuthor(String authorName) {
        List<Post> posts = postRepository.findByAuthor(authorName);
        if (posts.isEmpty()) {
            throw new RuntimeException("No posts found for author: " + authorName);
        }
        return posts;
    }

    public List<Post> searchPostsByText(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto de búsqueda no puede estar vacío");
        }
        return postRepository.findByTextContaining(text);
    }
}