package za.co.douglas.chifetete.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;
import za.co.douglas.chifetete.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
}
