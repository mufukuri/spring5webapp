package za.co.douglas.chifetete.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import za.co.douglas.chifetete.spring5webapp.model.Author;
import za.co.douglas.chifetete.spring5webapp.model.Book;
import za.co.douglas.chifetete.spring5webapp.model.Publisher;
import za.co.douglas.chifetete.spring5webapp.repository.AuthorRepository;
import za.co.douglas.chifetete.spring5webapp.repository.BookRepository;
import za.co.douglas.chifetete.spring5webapp.repository.PublisherRepository;

@Component
    public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

        private AuthorRepository authorRepository;
        private BookRepository bookRepository;
        private PublisherRepository publisherRepository;

        public DevBootstrap(final AuthorRepository authorRepository, final BookRepository bookRepository, final PublisherRepository publisherRepository) {
            this.authorRepository = authorRepository;
            this.bookRepository = bookRepository;
            this.publisherRepository = publisherRepository;
        }

        @Override
        public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
            initData();
        }

        private void initData(){

            Publisher publisher = new Publisher();
            publisher.setName("foo");
            publisher.setAddress("12th Street, LA");
            publisherRepository.save(publisher);

            //Eric
            Author eric = new Author("Eric", "Evans");
            Book  ddd = new Book("Domain Driven Design", "1234", publisher);
            eric.getBooks().add(ddd);
            ddd.getAuthors().add(eric);


            authorRepository.save(eric);
            bookRepository.save(ddd);


            //Rod
            Author rod = new Author("Rod", "Johnson");
            Book noEJB = new Book("J2EE Development without EJB", "23444",publisher);
            rod.getBooks().add(noEJB);
            noEJB.getAuthors().add(rod);

            authorRepository.save(rod);
            bookRepository.save(noEJB);
        }
}
