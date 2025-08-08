package org.acme.adapters.out.persistence;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

@Entity
public class PersonEntity extends PanacheEntity {
    public String name;
    public int age;

    @Embedded
    public AddressEmbeddable address;
}
