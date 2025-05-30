package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication  // Scans all subpackages (including controller, repository, entity)
@CrossOrigin(origins = "*")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}