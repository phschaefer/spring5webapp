package de.phschaefer.spring5webapp.bootstrap;

import de.phschaefer.spring5webapp.model.Author;
import de.phschaefer.spring5webapp.model.Book;
import de.phschaefer.spring5webapp.model.Publisher;
import de.phschaefer.spring5webapp.repositories.AuthorRepository;
import de.phschaefer.spring5webapp.repositories.BookRepository;
import de.phschaefer.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){

        Publisher publisher = new Publisher();
        publisher.setName("foo");

        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain Driven Design","1234",publisher);
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book);

        Author bob = new Author("Bob", "Johnson");
        Book book1 = new Book("J2EE Development without EJP","2344",publisher);
        bob.getBooks().add(book1);

        publisherRepository.save(publisher);
        authorRepository.save(bob);
        bookRepository.save(book1);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
