package com.SafetyNetAlerts.repository;

import com.SafetyNetAlerts.TestUtils;
import com.SafetyNetAlerts.model.GlobalData;
import com.SafetyNetAlerts.model.Person;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

//@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
//@RunWith(SpringRunner.class)
public class PersonRepositoryTest {

    @MockBean
    private GlobalDataRepository globalDataRepository;

    @Autowired
    private PersonRepository personRepository;

    @BeforeEach()
    public void beforeEach(){
        GlobalData global = TestUtils.initDatas();
        Mockito.when(globalDataRepository.read()).thenReturn(global);
    }

    @Test
    public void getPersonsFromGlobalDataTest(){
        List<Person> results = personRepository.getPersonsFromGlobalData();

        Assert.assertNotNull(results);
        Assert.assertEquals(results.size(), 3);
    }

    @Test
    public void findPersonsByFirstNameAndLastNameTest(){
        List<Person> results = personRepository.findPersonsByFirstNameAndLastName("Ali", "Baba");

        Assert.assertNotNull(results);
        Assert.assertEquals(results.size(), 1);
        Person person = results.get(0);
        Assert.assertEquals("Ali", person.getFirstName());
        Assert.assertEquals("Baba", person.getLastName());

    }

    @Test
    public void getPersonsByAddressTest(){
        List<Person> results = personRepository.getPersonsByAddress("32 rue Taplace");

        Assert.assertNotNull(results);
        Assert.assertEquals(results.size(), 1);
        Person person = results.get(0);
        Assert.assertEquals("32 rue Taplace", person.getAddress());

    }

    @Test
    public void getPersonsByCityTest(){
        List<Person> results = personRepository.getPersonsByCity("Yaoundé");

        Assert.assertNotNull(results);
        Assert.assertEquals(results.size(), 1);
        Person person = results.get(0);
        Assert.assertEquals("Yaoundé", person.getCity());

    }

    @Test
    public void addPersonTest() {
        Person p4 = new Person();
        p4.setAddress("31 rue Maplace");
        p4.setCity("Yaoundé");
        p4.setEmail("lolo4@free.fr");
        p4.setPhone("0698765432");
        p4.setZip("30000");
        p4.setFirstName("Lilian");
        p4.setLastName("Pagrand");
        personRepository.addPersonInDataSource(p4);

        List<Person> persons = personRepository.getPersonsFromGlobalData();

        Assert.assertNotNull(persons);
        Assert.assertEquals(4, persons.size());
        Person person = persons.get(3);
        Assert.assertEquals("Yaoundé", person.getCity());

    }


    @Test
    public void updatePersonTest() {
        Person newPerson = new Person();
        newPerson.setAddress("34 rue Maplace");
        newPerson.setCity("Yaoundé");
        newPerson.setZip("30000");
        newPerson.setPhone("0620304050");
        newPerson.setEmail("cutugno@libre.fr");

        newPerson.setFirstName("Ali");
        newPerson.setLastName("Baba");
        personRepository.updatePersonInDataSource(newPerson,"Ali","Baba");

        List<Person> persons = personRepository.getPersonsFromGlobalData();

        Assert.assertNotNull(persons);
        //Assert.assertEquals("firstName=Ali, lastName=Baba, address=31 rue Maplace, city=Yaoundé, zip=30000, phone=076059820, email=toto@free.fr", persons.get(0));
        Person person = persons.get(0);
        Assert.assertEquals("0620304050", person.getPhone());

    }


    /*
    @Test
    public void addPersonInDataSourceTest(){
        List<Person> results = personRepository.getPersonsFromGlobalData();
        Assert.assertNotNull(results);

        Person p4 = new Person();
        p4.setAddress("31 rue Maplace");
        p4.setCity("Yaoundé");
        p4.setEmail("lolo4@free.fr");
        p4.setPhone("0698765432");
        p4.setZip("30000");
        p4.setFirstName("Lilian");
        p4.setLastName("Pagrand");

        results = personRepository.addPersonInDataSource(p4);

     //   Assert.assertEquals(results.size(), 4);

        Person person = results.get(3);
        Assert.assertEquals("Yaoundé", person.getCity());

    }
*/


    @Test
    public void deletePersonFromDatasourceTest(){
        List<Person> results = personRepository.deletePersonFromDataSource("Ali", "Baba");

        //Assert.assertNotNull(results);
        Assert.assertEquals(results.size(), 2);
        Person person = results.get(0);
        Assert.assertEquals("Hervé", person.getFirstName());

    //    return results;
    }


    /*
    @Test
    public void addPersonInDataSourceTest(){

        Person p4 = new Person();
        p4.setAddress("31 rue Maplace");
        p4.setCity("Yaoundé");
        p4.setEmail("lolo@free.fr");
        p4.setPhone("0698765432");
        p4.setZip("30000");
        p4.setFirstName("Laurent");
        p4.setLastName("TATION");
        //results.add(p4);
        List<Person> results = personRepository.getPersonsFromGlobalData().add(p4);
       // List<Person> results = personRepository.addPersonInDataSource(p4);

        Assert.assertNotNull(results);
        Assert.assertEquals(results.size(), 4);
        Person person = results.get(3);
        Assert.assertEquals("Yaoundé", person.getCity());

    }
    */


    /*
    public static List<Person> allPersons;


    @BeforeAll
    public void setUp() {
        allPersons = personRepository.getPersonsFromGlobalData();
    }

    @Test
    public void getPersonsByAppDataTest() {
        String firstName0 = allPersons.get(0).getFirstName();
        String lastName3 = allPersons.get(3).getLastName();

        assertEquals("John", firstName0);
        assertEquals("Boyd", lastName3);
    }


    @Test
    public void getPersonByNameTest() {
        List<Person> foundperson = personRepository.getPersonsByFirstNameAndLastName("Jonanathan", "Marrack");

        String firstName = foundperson.get(0).getFirstName();
        String address = foundperson.get(0).getAddress();

        assertEquals("Jonanathan", firstName);
        assertEquals("29 15th St", address);
    }

    @Test
    public void getPersonByAddressTest() {
        List<Person> foundpersons = personRepository.getPersonsByAddress("29 15th St");

        String firstName = foundpersons.get(0).getFirstName();
        String address = foundpersons.get(0).getAddress();

        assertEquals("Jonanathan", firstName);
        assertEquals("29 15th St", address);
    }

    @Test
    public void getPersonsByCityTest() {
        List<Person> foundpersons = personRepository.getPersonsByCity("Culver");

        String firstName = foundpersons.get(0).getFirstName();
        String address = foundpersons.get(0).getAddress();

        assertEquals("John", firstName);
        assertEquals("1509 Culver St", address);

    }*/

}
