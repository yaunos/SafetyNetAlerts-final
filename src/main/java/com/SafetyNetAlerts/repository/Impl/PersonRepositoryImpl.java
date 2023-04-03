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

    public List<Person> findPersonsByFirstNameAndLastName(String firstName, String lastName) {
        List<Person> matchingPerson = new LinkedList<>();
        GlobalData datas = globalDataRepository.read();
        for (Person p : datas.getPersons()) {
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
        for (Person person : datas.getPersons()) {
            //if(person.getAddress() == address){     //   erreur de comparaison en tant qu'adresse mémoire au lieu de valeur
            if (person.getAddress().equals(address)) {  //Bon car comparaison des valeurs
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
        List<Person> persons = globalDataRepository.read().getPersons();
        return persons;
    }

    @Override
    public List<Person> addPersonInDataSource(Person person) {
        GlobalData global = globalDataRepository.read();
        global.getPersons().add(person);
        globalDataRepository.write(global);
        //return null;
        return null;
    }

    @Override
    public Person updatePersonInDataSource(Person person, String firstName, String lastName) {

        GlobalData global = globalDataRepository.read();
        global.getPersons().forEach((person1 -> {
            if (firstName.equals(person1.getFirstName()) && lastName.equals(person1.getLastName())) {
                person1.setAddress(person.getAddress());
                person1.setCity(person.getCity());
                person1.setZip(person.getZip());
                person1.setPhone(person.getPhone());
                person1.setEmail(person.getEmail());

            }
            //globalDataRepository.updatePerson(person); //update
        }));
        globalDataRepository.write(global);
        return person;
    }


    @Override
    public List<Person> deletePersonFromDataSource(String firstName, String lastName) {
        //globalDataRepository.deletePerson(firstName, lastName); //delete
        GlobalData global = globalDataRepository.read();

        Person personToDelete = null;
        //Person person1 = null;
        for (Person person : global.getPersons()) {
            if((person.getFirstName().equals(firstName)) && (person.getLastName()).equals(lastName)) {
                personToDelete = person;
            }
        }
        global.getPersons().remove(personToDelete);
        globalDataRepository.write(global);
        //A vérifier
        return global.getPersons();
    }
}
