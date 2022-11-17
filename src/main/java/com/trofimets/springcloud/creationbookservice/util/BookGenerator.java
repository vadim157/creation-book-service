package com.trofimets.springcloud.creationbookservice.util;

import com.trofimets.springcloud.creationbookservice.model.Book;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BookGenerator {
    private final Random random = new Random();

    public Book creationNewBook(){
        return Book.builder()
                .id(random.nextInt(100))
                .name("name " + random.nextInt(100))
                .description("description " + random.nextInt(100))
                .price(random.nextInt(100))
                .status("unchecked").build();
    }

}
