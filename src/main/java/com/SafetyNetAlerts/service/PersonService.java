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

    void updatePersonInDataSource(Person person);

    void deletePersonInDataSource(String firstName, String lastName);
}