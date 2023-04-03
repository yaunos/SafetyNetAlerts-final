package com.SafetyNetAlerts.DTO;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

public class PersonNameAddressPhoneDTOTest {
    @Test
    public void DTOEqualsWhenEqualsTest() {

        PersonNameAddressPhoneDTO DTOTest = new PersonNameAddressPhoneDTO();
        PersonNameAddressPhoneDTO DTOTest2 = new PersonNameAddressPhoneDTO();

        DTOTest.setFirstName("Jacques");
        DTOTest.setAddress("adresse");

        DTOTest2.setFirstName("Jacques");
        DTOTest2.setAddress("adresse");

        assertEquals(true, DTOTest.equals(DTOTest2));
    }

    @Test
    public void DTOEqualsWhenNotEqualsTest() {

        PersonNameAddressPhoneDTO DTOTest = new PersonNameAddressPhoneDTO();
        PersonNameAddressPhoneDTO DTOTest2 = new PersonNameAddressPhoneDTO();

        DTOTest.setFirstName("Jacques");
        DTOTest.setAddress("adresse");

        DTOTest2.setFirstName("Jean");
        DTOTest2.setAddress("adresse");

        assertEquals(false, DTOTest.equals(DTOTest2));
        System.out.println(DTOTest.toString());
    }

    @Test
    public void DTOToStringTest() {

        PersonNameAddressPhoneDTO DTOTest = new PersonNameAddressPhoneDTO();
        String DTOTestString = "PersonNameAddressPhoneDTO(firstName=Jacques, lastName=null, address=adresse, phone=null)";

        DTOTest.setFirstName("Jacques");
        DTOTest.setAddress("adresse");

        assertEquals(DTOTestString,DTOTest.toString());
    }

    @Test
    public void DTOHashCodeTest() {

        PersonNameAddressPhoneDTO DTOTest = new PersonNameAddressPhoneDTO();
        int code = DTOTest.hashCode();

        assertNotEquals(0, code);

    }
}
