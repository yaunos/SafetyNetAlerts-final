package com.SafetyNetAlerts.controller;

import com.SafetyNetAlerts.model.Person;
import com.SafetyNetAlerts.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class PersonController {

     private Logger logger = LogManager.getLogger(PersonController.class);

  //  @Autowired
   // private FirestationService firestationService;

    @Autowired
    private PersonService personService;

/*
    @GetMapping("/childAlert")
    public List<Person>  findPersonsByAddress(@RequestParam("address") String address) {
        return personService.findPersonsByAddress(address);
    }
    /*

    @GetMapping("/personInfo")
    public List<Person>  findPersonsByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return personService.findPersonsByFirstNameAndLastName(firstName,lastName);
    }
    */

    /**
     * Create - Add a new person
     *
     */
    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        logger.info("Command POST /person requested. Creating a new person");
        personService.addPersonInDataSource(person);
        return person;
    }

    /**
     * Update - update a new person
     *
     */
    @PutMapping("/person")
    public Person updatePerson(@RequestBody Person person, @RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
        logger.info("Command PUT /person requested. Updating a registered person");
        personService.updatePersonInDataSource(person, firstName, lastName);
        return person;
    }


    /**
     * Delete - delete a person
     *
     */

    @DeleteMapping("person")
    public void deletePerson(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
        logger.info("Command DELETE /person requested from firstName=" + firstName + " & lastName =" + lastName +"");
        personService.deletePersonInDataSource(firstName, lastName);
    }



}