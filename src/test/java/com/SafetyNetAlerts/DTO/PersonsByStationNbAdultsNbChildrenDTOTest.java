package com.SafetyNetAlerts.DTO;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonsByStationNbAdultsNbChildrenDTOTest {

    @Test
    public void DTOEqualsWhenEqualsTest() {

        PersonsByStationNbAdultsNbChildrenDTO DTOTest = new PersonsByStationNbAdultsNbChildrenDTO ();
        PersonsByStationNbAdultsNbChildrenDTO  DTOTest2 = new PersonsByStationNbAdultsNbChildrenDTO ();

        DTOTest.setNumberAdults(2);
        DTOTest2.setNumberAdults(2);

        assertEquals(true, DTOTest.equals(DTOTest2));
    }

    @Test
    public void DTOEqualsWhenNotEqualsTest() {

        PersonsByStationNbAdultsNbChildrenDTO DTOTest = new PersonsByStationNbAdultsNbChildrenDTO();
        PersonsByStationNbAdultsNbChildrenDTO DTOTest2 = new PersonsByStationNbAdultsNbChildrenDTO ();

        DTOTest.setNumberAdults(2);
        DTOTest2.setNumberAdults(3);

        assertEquals(false, DTOTest.equals(DTOTest2));
    }

    @Test
    public void DTOToStringTest() {

        PersonsByStationNbAdultsNbChildrenDTO DTOTest = new PersonsByStationNbAdultsNbChildrenDTO ();
        String DTOTestString = "PersonsByStationNbAdultsNbChildrenDTO(persons=null, numberChildren=0, numberAdults=2)";

        DTOTest.setNumberAdults(2);

        assertEquals(DTOTestString, DTOTest.toString());
    }

    @Test
    public void DTOHashCodeTest() {

        PersonsByStationNbAdultsNbChildrenDTO  DTOTest = new PersonsByStationNbAdultsNbChildrenDTO ();
        int code = DTOTest.hashCode();

        assertNotEquals(0, code);

    }

}