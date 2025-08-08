package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.domain.model.Person;
import org.acme.domain.ports.in.PersonUseCase;
import org.acme.domain.ports.out.PersonRepositoryPort;

import java.util.List;

@ApplicationScoped
public class PersonServiceImpl implements PersonUseCase {

    private final PersonRepositoryPort repository;

    public PersonServiceImpl(PersonRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> getAll() {
        return repository.findAll();
    }

    @Override
    public Person getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Person create(Person person) {
        return repository.save(person);
    }

    @Override
    @Transactional
    public Person update(Long id, Person person) {
        Person existing = getById(id);
        existing.name = person.name;
        existing.age = person.age;
        existing.address = person.address;
        return repository.save(existing);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
