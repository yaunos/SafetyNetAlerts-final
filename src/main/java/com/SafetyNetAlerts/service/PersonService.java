package com.SafetyNetAlerts.service;

import com.SafetyNetAlerts.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getPersons();

    List<Person> getPersonsByFirstNameAndLastName(String firstName, String lastName);

    List<Person> getPersonsByAddress(String Address);

    List<Person> getPersonsByCity(String city);

    void addPersonInDataSource(Person person);

    void updatePersonInDataSource(Person person);

    void deletePersonInDataSource(String firstName, String lastName);
}