package com.SafetyNetAlerts.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomDataControllerTest {

    @Autowired
    public MockMvc mockMvc;


    @Test
    public void testGetPersonsByStation () throws Exception   {
        mockMvc.perform(get("/firestation?station_number=3")).andExpect(status().isOk()).andExpect(jsonPath("numberChildren", is(3)));
    }

    @Test
    public void testGetChildrenByAddress () throws Exception   {
        mockMvc.perform(get("/childAlert?address=1509 Culver St")).andExpect(status().isOk()).andExpect(jsonPath("listChildren[0].firstName", is("Tenley")));
    }

    @Test
    public void testGetPhoneByStation () throws Exception   {
        mockMvc.perform(get("/phoneAlert?firestation=1")).andExpect(status().isOk()).andExpect(jsonPath("$[0]", is("841-874-6512")));
    }

/*
    @Test
    public void testFindPersonsByAddress () throws Exception   {
        mockMvc.perform(get("/fire?address=112 Steppes Pl")).andExpect(status().isOk()).andExpect(jsonPath("residents[0].firstName", is("Tony")));
    }
 */
    @Test
    public void testFindPersonsByAddress () throws Exception   {
        mockMvc.perform(get("/fire?address=112 Steppes Pl")).andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", is("Tony")));
    }

    @Test
    public void testGetAddressesByStations () throws Exception   {
        mockMvc.perform(get("/flood/stations?stations=1,2")).andExpect(status().isOk()).andExpect(jsonPath("$[0].address", is("644 Gershwin Cir")));
    }


    @Test
    public void testGetPersonsInfosByName () throws Exception   {
        mockMvc.perform(get("/personInfo?firstName=Jonanathan&lastName=Marrack")).andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", is("Jonanathan")));
    }


    @Test
    public void testGetEmailsByCity () throws Exception   {
        mockMvc.perform(get("/communityEmail?city=Culver")).andExpect(status().isOk()).andExpect(jsonPath("$[0]", is("jaboyd@email.com")));
    }

}
