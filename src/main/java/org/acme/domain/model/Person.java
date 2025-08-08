package org.acme.domain.model;

public class Person {
    public Long id;
    public String name;
    public int age;
    public Address address;

    public static class Address {
        public String street;
        public int number;
        public String city;
        public String state;
    }
}
