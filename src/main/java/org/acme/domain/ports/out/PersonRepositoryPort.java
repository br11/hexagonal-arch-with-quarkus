package org.acme.domain.ports.out;


import org.acme.domain.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepositoryPort {
    List<Person> findAll();
    Optional<Person> findById(Long id);
    Person save(Person person);
    void deleteById(Long id);
}
