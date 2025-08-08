package org.acme.adapters.out.persistence;

import jakarta.persistence.Embeddable;

@Embeddable
public class AddressEmbeddable {
    public String street;
    public int number;
    public String city;
    public String state;
}
