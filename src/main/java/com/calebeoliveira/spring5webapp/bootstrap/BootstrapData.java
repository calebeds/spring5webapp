package com.calebeoliveira.spring5webapp.bootstrap;

import com.calebeoliveira.spring5webapp.domain.Author;
import com.calebeoliveira.spring5webapp.domain.Book;
import com.calebeoliveira.spring5webapp.domain.Publisher;
import com.calebeoliveira.spring5webapp.repositories.AuthorRepository;
import com.calebeoliveira.spring5webapp.repositories.BookRepository;
import com.calebeoliveira.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development Without EJB", "3739393693");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher publisher = new Publisher();
        publisher.setName("CDSO Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisher.setAddressLine1("Address line 1");

        publisherRepository.save(publisher);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher Count: " +  publisherRepository.count());
    }
}
