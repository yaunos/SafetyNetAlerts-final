
package com.SafetyNetAlerts.controller;

import com.SafetyNetAlerts.model.GlobalData;
import com.SafetyNetAlerts.repository.GlobalDataRepository;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonControllerTest {

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

    /*
    @Test
    public void testGetPersons() throws Exception {
        mockMvc.perform(get("/person")).andExpect(status().isOk());
    }
    */


    @Test
    public void testGetPersonsByName() throws Exception {
        mockMvc.perform(get("/person?firstName=Roger&lastName=Boyd")).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("person[0].firstName").value("Roger"));
    }


    @Test
    public void testPostPerson() throws Exception {
        String personInJson = "\"firstName\":\"Adrian\",\"lastName\":\"NOWAY\",\"address\"1 rue Ronde\",\"City\":\"Viville\"zip\":\"30000\",\"phone\":\"888-555-3333\",\"email\":\"anoway@mail.com\"}";

        mockMvc.perform(post("/person")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
                .content(personInJson))
                .andExpect(status().isOk()).andReturn();

    }

    @Test
    public void testPutPerson() throws Exception {
        String personInJson = "\"firstName\":\"Roger\",\"lastName\":\"Boyd\",\"address\"1 rue Ronde\",\"City\":\"Viville\"zip\":\"30000\",\"phone\":\"888-555-3333\",\"email\":\"anoway@mail.com\"}";

        mockMvc.perform(put("/person").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(personInJson)).andExpect(status().isOk()).andReturn();

    }

    @Test
    public void testDeletePerson() throws Exception {
        mockMvc.perform(delete("/person?firstName=Roger&lastName=Boyd")).andExpect(status().isOk());
    }
}