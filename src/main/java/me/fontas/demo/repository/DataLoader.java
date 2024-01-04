package me.fontas.demo.repository;

import me.fontas.demo.model.Content;
import me.fontas.demo.model.Status;
import me.fontas.demo.model.Type;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final ContentRepository repository;

    public DataLoader(ContentRepository repository) {
        this.repository = repository;
    }

//    @Profile("!prod")
    @Override
    public void run(String... args) throws Exception {
        Content content = new Content(
                null,
                "Init title",
                "Init description",
                Status.COMPLETED,
                Type.VIDEO,
                LocalDateTime.now(),
                null,
                null
        );

        repository.save(content);
    }
}
