package springZoro.com.spring5WebApp.repositories;

import org.springframework.data.repository.CrudRepository;

import springZoro.com.spring5WebApp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
