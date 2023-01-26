package com.SafetyNetAlerts.controller;

import com.SafetyNetAlerts.model.Person;
import com.SafetyNetAlerts.service.FirestationService;
import com.SafetyNetAlerts.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class FirestationController {

     private Logger logger = LogManager.getLogger(FirestationController.class);

    @Autowired
    private FirestationService firestationService;

    @Autowired
    private PersonService personService;

    @GetMapping("/firestation")
    public List<Person>  findPersonnessAroundStation(@RequestParam("station_number") long station_number){
        logger.info("Get started with firestation - by number - log");
        return personService.findPersonsByStationNumber(station_number);
    }

}
