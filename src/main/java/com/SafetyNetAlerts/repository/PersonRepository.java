package com.SafetyNetAlerts.repository;

import com.SafetyNetAlerts.model.Person;

import java.util.List;

public interface PersonRepository {

    List<Person> getPersonsFromGlobalData();

    List<Person> getPersonsByFirstNameAndLastName(String firstName, String lastName);

    List<Person> getPersonsByAddress(String Address);

    List<Person> getPersonsByCity(String city);

    void addPersonInDataSource(Person person);

    void updatePersonInDataSource(Person person);

    void deletePersonFromDataSource(String firstName, String LastName);
}