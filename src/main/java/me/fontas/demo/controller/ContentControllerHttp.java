package me.fontas.demo.controller;

import jakarta.validation.Valid;
import me.fontas.demo.model.Content;
import me.fontas.demo.model.Status;
import me.fontas.demo.repository.ContentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentControllerHttp {

    private final ContentRepository repository;

    public ContentControllerHttp(ContentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword) {
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status) {
        return repository.listByStatus(status);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@Valid @RequestBody Content content) {
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Content content, @PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }

        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }

        repository.deleteById(id);
    }
}
