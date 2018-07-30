package springZoro.com.spring5WebApp.repositories;

import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;

import springZoro.com.spring5WebApp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
