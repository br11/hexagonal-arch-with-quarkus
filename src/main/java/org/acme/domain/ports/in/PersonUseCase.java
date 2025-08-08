package org.acme.domain.ports.in;


import org.acme.domain.model.Person;

import java.util.List;

public interface PersonUseCase {
    List<Person> getAll();
    Person getById(Long id);
    Person create(Person person);
    Person update(Long id, Person person);
    void delete(Long id);
}
