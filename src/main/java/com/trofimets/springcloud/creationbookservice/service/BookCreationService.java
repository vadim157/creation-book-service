package com.trofimets.springcloud.creationbookservice.service;

import com.trofimets.springcloud.creationbookservice.model.Book;
import com.trofimets.springcloud.creationbookservice.util.BookGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@EnableScheduling
@EnableBinding(Source.class)
public class BookCreationService {
    private final BookGenerator bookGenerator;
    private final Source source;

    @Autowired
    public BookCreationService(BookGenerator bookGenerator, Source source) {
        this.bookGenerator = bookGenerator;
        this.source = source;
    }

    private final Logger logger = Logger.getLogger(BookCreationService.class.getName());


    @Scheduled(fixedRate = 5000)
    private void sendMessage() {
        logger.log(Level.INFO, "Call method bookGenerator and create new Book");
        Book book = bookGenerator.creationNewBook();
        logger.log(Level.INFO, "Create book: " + book);

        source.output()
                .send(MessageBuilder.withPayload(book).build());
        logger.log(Level.INFO, "Book sended");


    }
}
