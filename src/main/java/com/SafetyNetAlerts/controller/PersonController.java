package com.SafetyNetAlerts.controller;

import com.SafetyNetAlerts.model.Person;
import com.SafetyNetAlerts.service.FirestationService;
import com.SafetyNetAlerts.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class PersonController {

    // private Logger logger = LogManager.getLogger(FirestationController.class);

    @Autowired
    private FirestationService firestationService;

    @Autowired
    private PersonService personService;

    @GetMapping("/communityEmail")
    public List<Person>  findPersonsByCity(@RequestParam("city") String city){
        return personService.findPersonsByCity(city);
    }

    @GetMapping("/childAlert")
    public List<Person>  findPersonsByAddress(@RequestParam("address") String address){
        return personService.findPersonsByAddress(address);
    }

    @GetMapping("/personInfo")
    public List<Person>  findPersonsByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return personService.findPersonsByFirstNameAndLastName(firstName,lastName);
    }

}