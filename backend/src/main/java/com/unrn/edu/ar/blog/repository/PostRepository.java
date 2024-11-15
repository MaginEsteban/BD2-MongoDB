package com.unrn.edu.ar.blog.repository;

import com.unrn.edu.ar.blog.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {


    List<Post> findTop4ByOrderByDateDesc();

    List<Post> findByAuthor(String author);

    @Query("{ 'text' : { $regex: ?0, $options: 'i' } }")
    List<Post> findByTextContaining(String text);
}
