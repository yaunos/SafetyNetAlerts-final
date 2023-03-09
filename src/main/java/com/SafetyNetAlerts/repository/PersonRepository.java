package com.SafetyNetAlerts.repository;

import com.SafetyNetAlerts.model.Person;

import java.util.List;

public interface PersonRepository {

    List<Person> getPersonsFromGlobalData();

    List<Person> getPersonsByFirstNameAndLastName(String firstName, String lastName);
        Person matchingPerson = null;

    List<Person> getPersonsByAddress(String Address);

    List<Person> getPersonsByCity(String city);

    void addPersonInDataSource(Person person);


    //Person updatePersonInDataSource(Person person);

    Person updatePersonInDataSource(Person person, String lastName, String firstName);

    void deletePersonFromDataSource(String firstName, String LastName);
}