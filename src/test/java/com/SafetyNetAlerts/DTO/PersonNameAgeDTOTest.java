package com.SafetyNetAlerts.DTO;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

public class PersonNameAgeDTOTest {
    @Test
    public void DTOEqualsWhenEqualsTest() {

        PersonNameAgeDTO DTOTest = new PersonNameAgeDTO();
        PersonNameAgeDTO DTOTest2 = new PersonNameAgeDTO();

        DTOTest.setFirstName("Georgio");
        DTOTest.setAge(40);

        DTOTest2.setFirstName("Georgio");
        DTOTest2.setAge(40);

        assertEquals(true, DTOTest.equals(DTOTest2));
    }

    @Test
    public void DTOEqualsWhenNotEqualsTest() {

        PersonNameAgeDTO DTOTest = new PersonNameAgeDTO();
        PersonNameAgeDTO DTOTest2 = new PersonNameAgeDTO();

        DTOTest.setFirstName("Georgio");
        DTOTest.setAge(40);

        DTOTest2.setFirstName("Julio");
        DTOTest2.setAge(50);

        assertEquals(false, DTOTest.equals(DTOTest2));
    }

    @Test
    public void DTOToStringTest() {

        PersonNameAgeDTO DTOTest = new PersonNameAgeDTO();
        String DTOTestString = "PersonNameAgeDTO(firstName=Julio, lastName=null, age=40)";

        DTOTest.setFirstName("Julio");
        DTOTest.setAge(40);

        assertEquals(DTOTestString,DTOTest.toString());
    }

    @Test
    public void DTOHashCodeTest() {

        PersonNameAgeDTO DTOTest = new PersonNameAgeDTO();
        int code = DTOTest.hashCode();

        assertNotEquals(0, code);

    }

}
