package info.elyasi.springframework.spring5webapp.repositories;

import info.elyasi.springframework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
