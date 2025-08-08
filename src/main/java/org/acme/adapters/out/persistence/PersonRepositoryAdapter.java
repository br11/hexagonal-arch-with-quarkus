package org.acme.adapters.out.persistence;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.domain.model.Person;
import org.acme.domain.ports.out.PersonRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class PersonRepositoryAdapter implements PersonRepositoryPort {

    @Override
    public List<Person> findAll() {
        List<PersonEntity> entities = PersonEntity.listAll();
        return entities.stream()
            .map(this::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Person> findById(Long id) {
        PersonEntity entity = PersonEntity.findById(id);
        return Optional.ofNullable(entity).map(this::toDomain);
    }

    @Override
    public Person save(Person person) {
        PersonEntity entity = fromDomain(person);
        entity.persist();
        person.id = entity.id;
        return person;
    }

    @Override
    public void deleteById(Long id) {
        PersonEntity.deleteById(id);
    }

    private Person toDomain(PersonEntity entity) {
        Person person = new Person();
        person.id = entity.id;
        person.name = entity.name;
        person.age = entity.age;

        Person.Address address = new Person.Address();
        address.street = entity.address.street;
        address.number = entity.address.number;
        address.city = entity.address.city;
        address.state = entity.address.state;
        person.address = address;

        return person;
    }

    private PersonEntity fromDomain(Person domain) {
        PersonEntity entity = new PersonEntity();
        entity.id = domain.id;
        entity.name = domain.name;
        entity.age = domain.age;

        AddressEmbeddable address = new AddressEmbeddable();
        address.street = domain.address.street;
        address.number = domain.address.number;
        address.city = domain.address.city;
        address.state = domain.address.state;
        entity.address = address;

        return entity;
    }
}
