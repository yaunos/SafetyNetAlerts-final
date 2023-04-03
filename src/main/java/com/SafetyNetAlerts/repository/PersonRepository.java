package com.SafetyNetAlerts.repository;

import com.SafetyNetAlerts.model.Person;

import java.util.List;

public interface PersonRepository {

    List<Person> getPersonsFromGlobalData();

    List<Person> findPersonsByFirstNameAndLastName(String firstName, String lastName);
        Person matchingPerson = null;

    List<Person> getPersonsByAddress(String Address);

    List<Person> getPersonsByCity(String city);

    List<Person> addPersonInDataSource(Person person);


    //Person updatePersonInDataSource(Person person);

    Person updatePersonInDataSource(Person person, String firstName, String lastName);

    List<Person> deletePersonFromDataSource(String firstName, String LastName);
}