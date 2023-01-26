package com.SafetyNetAlerts.service.Impl;

import com.SafetyNetAlerts.model.Person;
import com.SafetyNetAlerts.repository.FirestationRepository;
import com.SafetyNetAlerts.repository.GlobalDataRepository;
import com.SafetyNetAlerts.repository.PersonRepository;
import com.SafetyNetAlerts.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private GlobalDataRepository globalDataRepository;

    @Autowired
    private FirestationRepository firestationRepository;

    @Override
    public List<Person> getPersons() {
        return personRepository.getPersonsFromGlobalData();
    }

//    @Override
//    public List<Person> findPersonsByFirstNameAndLastName(String firstName, String lastName) {
//        List<Person> persons = globalDataRepository.read().getPersons();
//        return personRepository.getPersonByFirstNameAndLastName (persons, firstName, lastName);

//       return null;
//    }

    @Override
    public List<Person> findPersonsByFirstNameAndLastName(String firstName, String lastName) {
        List<Person> persons = globalDataRepository.read().getPersons();
        List<Person> matchingFirstNameAndLastName = personRepository.getPersonsByFirstNameAndLastName(firstName, lastName);

        return matchingFirstNameAndLastName;
    }

    @Override
    public List<Person> findPersonsByAddress(String address) {
        List<Person> persons = new ArrayList<>();
        List<Person> peopleByAddress = personRepository.getPersonsByAddress(address);
        return peopleByAddress;
    }

    @Override
    public List<Person> findPersonsByCity(String city) {
        List<Person> persons = new ArrayList<>();
 //       List<Person> persons = globalDataRepository.read().getPersons();
 //       return (List<Person>) personRepository.getPersonsByCity(persons, city);
        List<Person> emails = personRepository.getPersonsByCity(city);
        return emails;
    }

    @Override
    public List<Person> findPersonsByStationNumber(long station_number) {
        List<Person> output = new ArrayList<>();
        // Retrouver les adresses
        List<String> adresses = firestationRepository.getAdressesByStationNumber(station_number);

        // Retrouver les personnes qui vivent à ces adresses
        for(String adresse: adresses){
            List<Person> persons = personRepository.getPersonsByAddress(adresse);
            output.addAll(persons);
        }

        return output;
    }

    @Override
    public void addPersonInDataSource(Person person) {
        personRepository.addPersonInDataSource(person);
    }

    @Override
    public void updatePersonInDataSource(Person person) {
        personRepository.updatePersonInDataSource(person);
    }

    @Override
    public void deletePersonInDataSource(String firstName, String lastName) {
        personRepository.deletePersonFromDataSource(firstName, lastName);
    }
}
