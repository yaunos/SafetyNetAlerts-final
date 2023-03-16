package com.SafetyNetAlerts.controller;

import com.SafetyNetAlerts.model.GlobalData;
import com.SafetyNetAlerts.repository.GlobalDataRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
public class MedicalRecordControllerTest {

    public class MedicalRecordsControllerTest {

        @Autowired
        public MockMvc mockMvc;

        @Autowired
        private GlobalDataRepository globalDataRepository;

        public GlobalData initialData;


        @BeforeAll
        public void saveInitialdata() {
            initialData = globalDataRepository.read();
        }

        @AfterAll
        public void getBackToInitialData() {
            globalDataRepository.write(initialData);
        }

        @Test
        public void testGetMedicalRecords () throws Exception   {
            mockMvc.perform(get("/medicalRecords")).andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", is("John")));
        }

        @Test
        public void testGetMedicalRecordByName () throws Exception   {
            mockMvc.perform(get("/medicalRecord?firstName=Jonanathan&lastName=Marrack")).andExpect(status().isOk()).andExpect(jsonPath("$.birthdate", is("01/03/1989")));
        }

        @Test
        public void testPostMedicalRecord() throws Exception {

            String jsonMedicalrecord = "{ \"firstName\":\"Jean\", \"lastName\":\"Test\", \"birthdate\":\"01/01/1990\", \"medications\":[\"candy:500mg\", \"gum:100mg\"], \"allergies\":[\"vegetables\"] }";

            mockMvc.perform(
                            post("/medicalRecord").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(jsonMedicalrecord))
                    .andExpect(status().isOk()).andReturn();
        }

        @Test
        public void testPutMedicalRecord() throws Exception {

            String jsonMedicalrecord = "{ \"firstName\":\"Jacob\", \"lastName\":\"Boyd\", \"birthdate\":\"01/01/1990\", \"medications\":[\"candy:500mg\", \"gum:100mg\"], \"allergies\":[\"vegetables\"] }";

            mockMvc.perform(
                            put("/medicalRecord").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(jsonMedicalrecord))
                    .andExpect(status().isOk()).andReturn();
        }

        @Test
        public void testDeleteMedicalRecord() throws Exception {

            mockMvc.perform(delete("/person?firstName=Peter&lastName=Duncan"))
                    .andExpect(status().isOk());
        }
    }
}
