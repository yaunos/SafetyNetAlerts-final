package com.SafetyNetAlerts.repository.Impl;

import com.SafetyNetAlerts.model.GlobalData;
import com.SafetyNetAlerts.model.Person;
import com.SafetyNetAlerts.repository.GlobalDataRepository;
import com.SafetyNetAlerts.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    private GlobalDataRepository globalDataRepository;

    public List<Person> getPersonsByFirstNameAndLastName(String firstName, String lastName) {
        List<Person> matchingPerson = new LinkedList<>();
        GlobalData datas = globalDataRepository.read();
        for (Person p: datas.getPersons()) {
            if (p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)) {
                matchingPerson.add(p);
            }
//
        }
       return matchingPerson;
//        return null;
    }

    public List<Person> getPersonsByAddress(String address) {
        List<Person> output = new ArrayList<>();
        GlobalData datas = globalDataRepository.read();
        for (Person person: datas.getPersons()) {
            //if(person.getAddress() == address){     //   erreur de comparaison en tant qu'adresse mémoire au lieu de valeur
            if(person.getAddress().equals(address)) {  //Bon car comparaison des valeurs
                output.add(person);
            }
        }
        return output;
    }


    public List<Person> getPersonsByCity(String city) {
        List<Person> output = new ArrayList<>();
        GlobalData datas = globalDataRepository.read();
        for (Person person : datas.getPersons()) {
            if (person.getCity().equals(city)) {
                output.add(person);
            }
        }
            return output;
    }

    @Override
    public List<Person> getPersonsFromGlobalData() {
        return null;
    }

    @Override
    public void addPersonInDataSource(Person person) {
        globalDataRepository.addPerson(person); //create
    }

    @Override
    public void updatePersonInDataSource(Person person) {
        globalDataRepository.updatePerson(person); //update
    }

    @Override
    public void deletePersonFromDataSource(String firstName, String LastName) {
        globalDataRepository.deletePerson(firstName, LastName); //delete
    }
}
