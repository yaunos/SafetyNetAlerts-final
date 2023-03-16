package com.SafetyNetAlerts.DTO;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest
public class PersonsByAddressByStationDTOTest {


    @Test
    public void DTOEqualsWhenEqualsTest() {

        PersonsByAddressByStationDTO DTOTest = new PersonsByAddressByStationDTO();
        PersonsByAddressByStationDTO DTOTest2 = new PersonsByAddressByStationDTO();

        DTOTest.setAddress("cetteAdresse");
        DTOTest.setResidents(null);
        DTOTest2.setAddress("cetteAdresse");
        DTOTest2.setResidents(null);

        assertEquals(true, DTOTest.equals(DTOTest2));
    }

    @Test
    public void DTOEqualsWhenNotEqualsTest() {

        PersonsByAddressByStationDTO DTOTest = new PersonsByAddressByStationDTO();
        PersonsByAddressByStationDTO DTOTest2 = new PersonsByAddressByStationDTO();

        DTOTest.setAddress("uneAdresse");
        DTOTest.setResidents(null);
        DTOTest2.setAddress("autreAdresse");
        DTOTest2.setResidents(null);

        assertEquals(false, DTOTest.equals(DTOTest2));
    }


    @Test
    public void DTOToStringTest() {

        PersonsByAddressByStationDTO DTOTest = new PersonsByAddressByStationDTO();
        String DTOTestString = "PersonsByAddressByStationDTO(address=adresse, residents=null)";

        DTOTest.setAddress("adresse");
        DTOTest.setResidents(null);

        assertEquals(DTOTestString, DTOTest.toString());
    }

    @Test
    public void DTOHashCodeTest() {

        PersonsByAddressByStationDTO DTOTest = new PersonsByAddressByStationDTO();
        int code = DTOTest.hashCode();

        assertNotEquals(0, code);

    }
}

