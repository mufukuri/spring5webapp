package za.co.douglas.chifetete.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;
import za.co.douglas.chifetete.spring5webapp.model.Author;


public interface AuthorRepository extends CrudRepository<Author, Long> {
}
