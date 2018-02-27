package info.elyasi.springframework.spring5webapp.bootstrap;

import info.elyasi.springframework.spring5webapp.model.Author;
import info.elyasi.springframework.spring5webapp.model.Book;
import info.elyasi.springframework.spring5webapp.repositories.AuthorRepository;
import info.elyasi.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        // Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        // Rod
        Author rod = new Author("Rob", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", "Wrox");
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
