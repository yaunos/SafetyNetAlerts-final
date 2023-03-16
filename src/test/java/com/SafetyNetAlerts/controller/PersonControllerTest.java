
package com.SafetyNetAlerts.controller;

import com.SafetyNetAlerts.service.PersonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @Test
    public void testGetPersons() throws Exception {
        mockMvc.perform(get("/person")).andExpect(status().isOk());
    }

    @Test
    public void testGetPersonsByName() throws Exception {
        mockMvc.perform(get("/person?firstName=Roger&lastName=Boyd")).andExpect(status().isOk()).andExpect((ResultMatcher) jsonPath("$.firstName", is("John")));

    }

    @Test void testPostPerson() throws Exception {
        String personInJson = "\"firstName\":\"Adrian\",\"lastName\":\"NOWAY\",\"address\"1 rue Ronde\",\"City\":\"Viville\"zip\":\"30000\",\"phone\":\"888-555-3333\",\"email\":\"anoway@mail.com\"}";

        mockMvc.perform(post("/person").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(personInJson)).andExpect(status().isOk()).andReturn();

    }
}