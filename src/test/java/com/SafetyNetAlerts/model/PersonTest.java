package com.SafetyNetAlerts.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
    public class PersonTest {

        @Test
        public void PersonSetAndGetTest() {

            Person personTest = new Person();

            personTest.setFirstName("Jean");
            personTest.setLastName("TILLET");
            personTest.setAddress("rue ronde");
            personTest.setZip("30000");
            personTest.setCity("Viville");
            personTest.setPhone("888-333-5555");
            personTest.setEmail("jeantillet@courrier.fr");

            assertEquals("Jean", personTest.getFirstName());
            assertEquals("TILLET", personTest.getLastName());
            assertEquals("rue ronde", personTest.getAddress());
            assertEquals("30000", personTest.getZip());
            assertEquals("Viville", personTest.getCity());
            assertEquals("888-333-5555", personTest.getPhone());
            assertEquals("jeantillet@courrier.fr", personTest.getEmail());
        }

    @Test
    public void PersonEqualsAPersonTest() {

        Person personTest = new Person();
        Person personTest2 = new Person();

        personTest.setFirstName("prenom");
        personTest.setLastName("nom");
        personTest.setAddress("adresse");
        personTest.setZip("30000");
        personTest.setCity("Viville");
        personTest.setPhone("888-555-3333");
        personTest.setEmail("mail@mail.fr");

        personTest2.setFirstName("prenom");
        personTest2.setLastName("nom");
        personTest2.setAddress("adresse");
        personTest2.setZip("30000");
        personTest2.setCity("Viville");
        personTest2.setPhone("888-555-3333");
        personTest2.setEmail("mail@mail.fr");

        assertEquals(true, personTest.equals(personTest2));
    }

    @Test
    public void PersonDoesntEqualsAPersonTest() {

        Person personTest = new Person();
        Person personTest2 = new Person();

        personTest.setFirstName("Jean");
        personTest.setLastName("DUPONT");
        personTest.setAddress("adresse");
        personTest.setZip("1234");
        personTest.setCity("Viville");
        personTest.setPhone("888-555-3333");
        personTest.setEmail("mon@mail.fr");

        personTest2.setFirstName("Jean");
        personTest2.setLastName("DUPOND");
        personTest2.setAddress("adresse");
        personTest2.setZip("1234");
        personTest2.setCity("Viville");
        personTest2.setPhone("888-555-3333");
        personTest2.setEmail("mon@mail.fr");

        assertEquals(false, personTest.equals(personTest2));
    }
    @Test
    public void PersonToStringTest() {

        String personTestString = "Person(firstName=Jo, lastName=NATHAN, address=New Street, city=Viville, zip=30000, phone=888-555-3333, email=jo@nathan.mail)";
        Person personTest = new Person();

        personTest.setFirstName("Jo");
        personTest.setLastName("NATHAN");
        personTest.setAddress("New Street");
        personTest.setZip("30000");
        personTest.setCity("Viville");
        personTest.setPhone("888-555-3333");
        personTest.setEmail("jo@nathan.mail");

        assertEquals(personTestString, personTest.toString());

    }

        @Test
        public void PersonHashCodeTest() {

            Person personTest = new Person();
            int code = personTest.hashCode();

            assertNotEquals(0, code);

        }

    }
