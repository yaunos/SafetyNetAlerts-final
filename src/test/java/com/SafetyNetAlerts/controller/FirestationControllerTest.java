package com.SafetyNetAlerts.controller;

import com.SafetyNetAlerts.model.GlobalData;
import com.SafetyNetAlerts.repository.GlobalDataRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)

public class FirestationControllerTest {

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
        public void testGetFirestations() throws Exception   {
            mockMvc.perform(get("/firestation?station_number=3")).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("persons[0].address").value("1509 Culver St"));
        }



        @Test
        public void testPostFirestation() throws Exception {

            String jsonFirestation = "{\"address\":\"1 Dale Ave \", \"station\":\"5\" }";

            mockMvc.perform(
                            post("/firestation").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(jsonFirestation))
                    .andExpect(status().isOk()).andReturn();
        }



        @Test
        public void testPutFirestation() throws Exception {

            String jsonFirestation = "{\"address\":\"29 15th St\", \"station\":\"1\" }";

            mockMvc.perform(
                            put("/firestation?address=29 15th St&station=1").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(jsonFirestation))
                    .andExpect(status().isOk()).andReturn();
        }




        @Test
        public void testDeleteFirestation() throws Exception {

            mockMvc.perform(delete("/firestation?address=834 Binoc Ave"))
                    .andExpect(status().isOk());
        }
}


