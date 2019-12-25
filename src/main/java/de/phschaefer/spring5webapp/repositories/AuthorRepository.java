package de.phschaefer.spring5webapp.repositories;

import de.phschaefer.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
