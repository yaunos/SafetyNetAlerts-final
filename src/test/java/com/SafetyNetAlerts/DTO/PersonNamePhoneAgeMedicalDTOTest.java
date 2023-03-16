package com.SafetyNetAlerts.DTO;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonNamePhoneAgeMedicalDTOTest {

    @Test
    public void DTOEqualsWhenEqualsTest() {

        PersonNamePhoneAgeMedicalDTO DTOTest = new PersonNamePhoneAgeMedicalDTO();
        PersonNamePhoneAgeMedicalDTO DTOTest2 = new PersonNamePhoneAgeMedicalDTO();

        DTOTest.setFirstName("Jo");
        DTOTest.setAge(40);

        DTOTest2.setFirstName("Jo");
        DTOTest2.setAge(40);

        assertEquals(true, DTOTest.equals(DTOTest2));
    }

    @Test
    public void DTOEqualsWhenNotEqualsTest() {

        PersonNamePhoneAgeMedicalDTO DTOTest = new PersonNamePhoneAgeMedicalDTO();
        PersonNamePhoneAgeMedicalDTO DTOTest2 = new PersonNamePhoneAgeMedicalDTO();

        DTOTest.setFirstName("Jeff");
        DTOTest.setAge(40);

        DTOTest2.setFirstName("Jeff");
        DTOTest.setAge(40);

        assertEquals(false, DTOTest.equals(DTOTest2));
    }

    @Test
    public void DTOToStringTest() {

        PersonNamePhoneAgeMedicalDTO DTOTest = new PersonNamePhoneAgeMedicalDTO();
        String DTOTestString = "PersonNamePhoneAgeMedicalDTO(firstName=Aline, lastName=null, phone=null, age=40, medications=null, allergies=null)";

        DTOTest.setFirstName("Aline");
        DTOTest.setAge(40);

        assertEquals(DTOTestString, DTOTest.toString());
    }

    @Test
    public void DTOHashCodeTest() {

        PersonNamePhoneAgeMedicalDTO DTOTest = new PersonNamePhoneAgeMedicalDTO();
        int code = DTOTest.hashCode();

        assertNotEquals(0, code);

    }

}