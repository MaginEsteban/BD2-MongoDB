package com.unrn.edu.ar.blog.repository;

import com.unrn.edu.ar.blog.model.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PageRepository extends MongoRepository<Page, String> {
    Optional<Page> findById(String id);

    /*

    Optional<Page> findById(String id);
    List<Page> findAll();

    Optional<Page> findByTitle(String title);


     */
}