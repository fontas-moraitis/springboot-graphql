package me.fontas.demo.controller;

import me.fontas.demo.model.Content;
import me.fontas.demo.repository.ContentRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ContentController {

    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {

        this.repository = repository;

    }

    @QueryMapping
    public List<Content> contents() {
        return repository.findAll();
    }
}
