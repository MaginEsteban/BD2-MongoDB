package com.unrn.edu.ar.blog.service;
import com.unrn.edu.ar.blog.api.PageService;
import com.unrn.edu.ar.blog.model.Page;
import com.unrn.edu.ar.blog.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PageServiceMongoDB implements PageService {

    @Autowired
    private PageRepository pageRepository;

    @Override
    public Page getPageById(String id) {
        System.out.println(pageRepository.findById(id));
        return pageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro la pagina con id: " + id));

    }

    /*
    public Optional<Page> getPageById(String id) {
        return pageRepository.findById(id);
    }
    public List<Page> getAllPages() {
        return pageRepository.findAll();
    }









    /*
    public Page getPageById(String id) {
        //System.out.println(pageRepository.findById(id));
        System.out.println("ID solicitado: " + id);
        Optional<Page> result = pageRepository.findById(new ObjectId(id));
        System.out.println("Resultado de búsqueda: " + result.orElse(null));
        return pageRepository.findById(new ObjectId(id)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagina no encontrada"));

    }
    public Page getPageByTitle(String title) {
        System.out.println("Título solicitado: " + title);
        Query query = new Query();
        query.addCriteria(Criteria.where("title").is(title));
        Page page = mongoTemplate.findOne(query, Page.class);
        if (page == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagina no encontrada");
        }
        return page;
    }

    @PostConstruct
    public void testMongoConnection() {
        // Crear una nueva página
        Page page = new Page();
        page.setTitle("Test Page");
        page.setText("This is a test page.");
        page.setAuthor("Test Author");
        page.setDate(LocalDate.now());

        // Guardar la página
        mongoTemplate.save(page);

        // Recuperar la página
        Page retrievedPage = pageRepository.findById(new ObjectId(page.getId())).orElse(null);
        if (retrievedPage != null) {
            System.out.println("Page retrieved: " + retrievedPage.getTitle());
        } else {
            System.out.println("Page not found.");
        }
    }

     */
}

