package springZoro.com.spring5WebApp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
 

import org.springframework.stereotype.Component;

import springZoro.com.spring5WebApp.model.Author;
import springZoro.com.spring5WebApp.model.Book;
import springZoro.com.spring5WebApp.model.Publisher;
import springZoro.com.spring5WebApp.repositories.AuthorRepository;
import springZoro.com.spring5WebApp.repositories.BookRepository;
import springZoro.com.spring5WebApp.repositories.PublisherRepository;



@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    

    public DevBootstrap(AuthorRepository authorRepository,
			BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher publisher1=new Publisher("Harper Collins");
        publisherRepository.save(publisher1);
        
        Book  ddd = new Book("Domain Driven Design", "1234",publisher1);
        
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);
      

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher publisher2=new Publisher("Wrox");
        publisherRepository.save(publisher2);
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher2 );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
      
    }
}