package com.unrn.edu.ar.blog.api;

import com.unrn.edu.ar.blog.model.Post;

import java.util.List;
import java.util.Map;

public interface PostService {
    List<Post> getLatestPosts();

    Post getPostById(String id);

    List<Map<String, Object>> getPostCountByAuthor();

    List<Post> getPostsByAuthor(String authorName);

    List<Post> searchPostsByText(String text);
}
