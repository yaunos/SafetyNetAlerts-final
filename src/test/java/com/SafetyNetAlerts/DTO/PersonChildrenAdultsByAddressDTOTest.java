package com.SafetyNetAlerts.DTO;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonChildrenAdultsByAddressDTOTest {
    @Test
    public void DTOEqualsWhenEqualsTest() {


            PersonNameDTO DTOTest = new PersonNameDTO();
            PersonNameDTO DTOTest2 = new PersonNameDTO();

            DTOTest.setFirstName("Gil");
            DTOTest2.setFirstName("Gil");

            assertEquals(true, DTOTest.equals(DTOTest2));
        }

        @Test
        public void DTOEqualsWhenNotEqualsTest() {

            PersonNameDTO DTOTest = new PersonNameDTO();
            PersonNameDTO DTOTest2 = new PersonNameDTO();

            DTOTest.setFirstName("Gil");
            DTOTest2.setFirstName("Gilian");

            assertEquals(false, DTOTest.equals(DTOTest2));
        }


        @Test
        public void DTOToStringTest() {

            PersonNameDTO DTOTest = new PersonNameDTO();
            String DTOTestString = "PersonNameDTO(firstName=Gilian, lastName=null)";

            DTOTest.setFirstName("Gilian");

            assertEquals(DTOTestString, DTOTest.toString());
        }

        @Test
        public void DTOHashCodeTest() {

            PersonNameDTO DTOTest = new PersonNameDTO();
            int code = DTOTest.hashCode();

            assertNotEquals(0, code);

        }

}

