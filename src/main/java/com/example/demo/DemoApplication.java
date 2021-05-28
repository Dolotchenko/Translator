package com.example.demo;

import com.example.demo.services.ParserService;
import com.example.demo.services.DbService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class DemoApplication implements CommandLineRunner {

    private final DbService DBService;

    private final ParserService parserService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        DBService.saveRusToEng(parserService.extractDict("src/main/resources/dictRUStoENG.xml"));
        DBService.saveEngtoRus(parserService.extractDict("src/main/resources/dictENGtoRUS.xml"));
        System.out.println();
    }
}
