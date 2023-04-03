package com.SafetyNetAlerts.service;

import com.SafetyNetAlerts.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getPersons();


    List<Person> findPersonsByFirstNameAndLastName(String firstName, String lastName);

    List<Person> findPersonsByAddress(String Address);

    List<Person> findPersonsByCity(String city);

    List<Person> findPersonsByStationNumber(long station_number);

    void addPersonInDataSource(Person person);

    Person updatePersonInDataSource(Person person, String firstName, String lastName);

    List<Person> deletePersonInDataSource(String firstName, String lastName);
}