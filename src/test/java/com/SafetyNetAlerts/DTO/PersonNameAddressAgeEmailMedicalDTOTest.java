
package com.SafetyNetAlerts.DTO;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonNameAddressAgeEmailMedicalDTOTest {

    @Test
    public void DTOEqualsWhenEqualsTest() {

        PersonNameAddressAgeEmailMedicalDTO DTOTest = new PersonNameAddressAgeEmailMedicalDTO();
        PersonNameAddressAgeEmailMedicalDTO DTOTest2 = new PersonNameAddressAgeEmailMedicalDTO();

        DTOTest.setFirstName("Jacques");
        DTOTest.setAddress("adresse");

        DTOTest2.setFirstName("Jacques");
        DTOTest2.setAddress("adresse");

        assertEquals(true, DTOTest.equals(DTOTest2));
    }

    @Test
    public void DTOEqualsWhenNotEqualsTest() {

        PersonNameAddressAgeEmailMedicalDTO DTOTest = new PersonNameAddressAgeEmailMedicalDTO();
        PersonNameAddressAgeEmailMedicalDTO DTOTest2 = new PersonNameAddressAgeEmailMedicalDTO();

        DTOTest.setFirstName("Jean");
        DTOTest.setAddress("adresse");

        DTOTest2.setFirstName("Jacques");
        DTOTest2.setAddress("adresse2");

        assertEquals(false, DTOTest.equals(DTOTest2));
    }

    @Test
    public void DTOToStringTest() {

        PersonNameAddressAgeEmailMedicalDTO DTOTest = new PersonNameAddressAgeEmailMedicalDTO();
        String DTOTestString = "PersonNameAddressAgeEmailMedicalDTO(firstName=Jacques, lastName=null, address=adresse, age=0, email=null, medication=null, allergies=null)";

        DTOTest.setFirstName("Jacques");
        DTOTest.setAddress("adresse");

        assertEquals(DTOTestString, DTOTest.toString());
    }


    @Test
    public void DTOHashCodeTest() {

        PersonNameAddressAgeEmailMedicalDTO DTOTest = new PersonNameAddressAgeEmailMedicalDTO();
        int code = DTOTest.hashCode();

        assertNotEquals(0, code);

    }

}