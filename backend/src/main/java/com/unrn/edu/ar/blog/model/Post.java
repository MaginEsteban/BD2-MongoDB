package com.unrn.edu.ar.blog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("Posts")
public class Post {

    @Id
    private String id;
    private String title;
    private String text;
    private List<String> tags;
    private String resume;
    private List<String> relatedLinks;
    private String author;
    private LocalDateTime date;

    public Post(String id, String title, String text, List<String> tags, String resume, List<String> relatedLinks, String author, LocalDateTime date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.tags = tags;
        this.resume = resume;
        this.relatedLinks = relatedLinks;
        this.author = author;
        this.date = date;
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public List<String> getRelatedLinks() {
        return relatedLinks;
    }

    public void setRelatedLinks(List<String> relatedLinks) {
        this.relatedLinks = relatedLinks;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}