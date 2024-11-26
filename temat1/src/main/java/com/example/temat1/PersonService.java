package com.example.temat1;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PersonService {
    private List<Person> people;

    @PostConstruct
    public void init() {
        people = new ArrayList<>();
        people.add(new Person("Bolesław", "Śmiały"));
        people.add(new Person("Zygmunt", "Stary"));
    }

    public List<Person> getPeople() {
        return people;
    }

    public Person getPerson(int index) {
        if (index >= 0 && index < people.size()) {
            return people.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void setPerson(int index, Person person) {
        if (index >= 0 && index < people.size()) {
            people.set(index, person);
        } else {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    public void removePerson(int index) {
        if (index >= 0 && index < people.size()) {
            people.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }
}
