package za.co.douglas.chifetete.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;
import za.co.douglas.chifetete.spring5webapp.model.Publisher;

public interface PublisherRepository  extends CrudRepository<Publisher,Long> {
}
