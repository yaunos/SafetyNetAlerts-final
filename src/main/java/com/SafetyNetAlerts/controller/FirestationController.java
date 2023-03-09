package com.SafetyNetAlerts.controller;

import com.SafetyNetAlerts.model.Firestation;
import com.SafetyNetAlerts.model.Person;
import com.SafetyNetAlerts.service.FirestationService;
import com.SafetyNetAlerts.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class FirestationController {

     private Logger logger = LogManager.getLogger(FirestationController.class);

    @Autowired
    private FirestationService firestationService;

    @Autowired
    private PersonService personService;

    @GetMapping("/Firestation")
    public List<Person>  findPersonsAroundStation(@RequestParam("station_number") long station_number) {
        logger.info("Get started with firestation - by number - log");
        return personService.findPersonsByStationNumber(station_number);
    }

    /**
     * Create a firestation
     */
    @PostMapping("/firestation")
    public Firestation addFirestation(@RequestBody Firestation firestation) {
        logger.info("Command POST /firestation and address requested. Creating a new mapping address, firestation");
        return firestationService.addFirestationIntoDataSource(firestation);
    }

    /**
     * Read a firestation
     */

    /**
     * Update a firestation
     */
    @PutMapping("/firestation")
    public Firestation updateFirestation(@RequestBody Firestation firestation, @RequestParam(name="address") String address, @RequestParam(name="station") Long station) {
        logger.info("Command PUT /firestation from address requested. Updating firestation number");
        return firestationService.updateFirestationIntoDataSource(firestation, address, station);
    }

    /**
     * Delete a firestation
     */
    @DeleteMapping("/firestation")
    public void deleteFirestation(@RequestParam(name="station", required = false) Long station, @RequestParam(name="address", required = false) String address) {
        logger.info("Command DELETE /firestation from address requested. Deleting firestation number");
        firestationService.deleteFirestationIntoDataSource(station, address);
    }
}
