package com.unrn.edu.ar.blog.controller;

import com.unrn.edu.ar.blog.model.Page;
import com.unrn.edu.ar.blog.service.PageServiceMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pages")
public class PageController {
    @Autowired
    private PageServiceMongoDB pageService;

    @GetMapping("/{id}")
    public ResponseEntity<Page> getPageById(@PathVariable String id) {
        Page page = null;
        try {
            page = pageService.getPageById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(page);

    }

    /*
    @GetMapping("/{id}")
    public Optional<Page> getPageById(@PathVariable String id) {
        //System.out.println(pageService.getPageById(id));
        return pageService.getPageById(id);
    }




    @GetMapping
    public List<Page> getAllPages() {
        return pageService.getAllPages();
    }





    /*

    @GetMapping("/{pageId}")
    public ResponseEntity<?> getPageById(@PathVariable String pageId) {
        Optional<Page> page = pageService.getPageById(pageId);

        if (page.isPresent()) {
            // Retornamos el contenido de la página si está presente
            return ResponseEntity.ok(page.get());
        } else {
            // Si no se encuentra, respondemos con 404
            return ResponseEntity.notFound().build();
        }
    }
    /*



    @GetMapping("/by-title/{title}")
    public ResponseEntity<Page> getPageByTitle(@PathVariable String title) {
        return ResponseEntity.ok(pageService.getPageByTitle(title));
    }

     */
}