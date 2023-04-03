package com.SafetyNetAlerts.service;

import com.SafetyNetAlerts.TestUtils;
import com.SafetyNetAlerts.model.GlobalData;
import com.SafetyNetAlerts.model.Person;
import com.SafetyNetAlerts.repository.FirestationRepository;
import com.SafetyNetAlerts.repository.PersonRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @MockBean
    private PersonRepository personRepository;

    @MockBean
    private FirestationRepository firestationRepository;

    @BeforeEach
    public void beforeEach(){
        GlobalData globalData = TestUtils.initDatas();
        Mockito.when(personRepository.getPersonsFromGlobalData()).thenReturn(globalData.getPersons());
        Mockito.when(personRepository.getPersonsByAddress("32 Rue Maplace")).thenReturn(globalData.getPersons().subList(0,0));
        //Mockito.when(personRepository.addPersonInDataSource(Mockito.any())).thenReturn(globalData.getPersons().subList(0,0));
    }

    @Test
    public void testGetPersons(){

        List<Person> results = personService.getPersons();

        Assert.assertNotNull(results);
        Assert.assertEquals(3, results.size());

    }

/*
    @Test
    public void testAddPersons(){
        Person person = new Person();
        person.setAddress("31 rue Maplace");
        person.setCity("Yaoundé");
        person.setEmail("lolo4@free.fr");
        person.setPhone("0698765432");
        person.setZip("30000");
        person.setFirstName("Lilian");
        person.setLastName("Pagrand");
        personService.addPersonInDataSource(person);

        List<Person> results = personService.getPersons();

        Assert.assertNotNull(results);
        Assert.assertEquals(4, results.size());
    }

    */

    /*
    @Test
    public void testDeletePersons() {
        List<Person> results = personService.deletePersonInDataSource("Ali", "Baba");
        //Assert.assertEquals(results.size(), 2);
        Person person = results.get(0);
        Assert.assertEquals("Hervé", person.getFirstName());
    }
    */











}
