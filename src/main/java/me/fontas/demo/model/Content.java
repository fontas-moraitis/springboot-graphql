package me.fontas.demo.model;

import jakarta.validation.constraints.NotBlank;
import me.fontas.demo.model.Status;
import me.fontas.demo.model.Type;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Content(
        @Id
        Integer id,
        @NotBlank
        String title,
        String description,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {
}
