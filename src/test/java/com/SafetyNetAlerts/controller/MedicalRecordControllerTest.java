package com.SafetyNetAlerts.controller;

import com.SafetyNetAlerts.model.GlobalData;
import com.SafetyNetAlerts.repository.GlobalDataRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MedicalRecordControllerTest {

        @Autowired
        public MockMvc mockMvc;

        @Autowired
        private GlobalDataRepository globalDataRepository;

        public GlobalData initialData;

        public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));


        @BeforeAll
        public void saveInitialdata() {
            initialData = globalDataRepository.read();
        }

        @AfterAll
        public void getBackToInitialData() {
            globalDataRepository.write(initialData);
        }


/*
        @Test
        public void testGetMedicalRecords () throws Exception   {
            mockMvc.perform(get("/medicalRecord")).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value("John"));
        }

*/


        @Test
        public void testGetMedicalRecordByName () throws Exception   {
            mockMvc.perform(get("/medicalRecord?firstName=Jonanathan&lastName=Marrack")).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName").value("Marrack"));
        }
/*
        @Test
        public void testPostMedicalRecord() throws Exception {

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            List<String> allergies = new ArrayList();
            List<String> medications = new ArrayList();

            String jsonMedicalrecord = "{ \"firstName\":\"Medhi\", \"lastName\":\"Callrec\", \"birthdate\":\"01/01/1990\", \"medications\":[\"zig:500mg\", \"zag:100mg\"], \"allergies\":[\"mango\"] }";
            MedicalRecord medicalRecord = new MedicalRecord();
            medicalRecord.setFirstName("Didier");
            medicalRecord.setLastName("Delaville");
            medicalRecord.setBirthdate(sdf.parse("07/12/1999"));
            medicalRecord.setAllergies(allergies);
            medicalRecord.setMedications(medications);

            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
            ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
            String requestJson=ow.writeValueAsString(medicalRecord);

            mockMvc.perform(
                            post("/medicalRecord")
                                    .contentType(APPLICATION_JSON_UTF8)
                                    //.characterEncoding("UTF-8")
                                    .content(requestJson))
                                    .andExpect(status().isOk()).andReturn();
        }
*/


/*
        @Test
        public void testPutMedicalRecord() throws Exception {

            String jsonMedicalrecord = "{\"firstName\":\"Jacob\", \"lastName\":\"Boyd\", \"birthdate\":\"01/01/1990\", \"medications\":[\"zig:500mg\", \"zag:100mg\"], \"allergies\":[\"mango\"] }";

            mockMvc.perform(
                            put("/medicalRecord?firstName=Jacob&lastName=Boyd").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(jsonMedicalrecord))
                    .andExpect(status().isOk()).andReturn();
        }

 */




        @Test
        public void testDeleteMedicalRecord() throws Exception {

            mockMvc.perform(delete("/medicalRecord?firstName=Peter&lastName=Duncan"))
                    .andExpect(status().isOk());
        }
}
