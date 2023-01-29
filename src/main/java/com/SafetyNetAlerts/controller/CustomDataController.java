package com.SafetyNetAlerts.controller;

import com.SafetyNetAlerts.service.CustomDataService;
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
public class CustomDataController {
    private static final Logger log = LogManager.getLogger(CustomDataController.class);

    @Autowired
    private CustomDataService customDataService;

    /**
     * Read - Get persons from one city and return their email
     *
     * @param city
     * @return the email of a person
     */

    @GetMapping("/communityEmail")
    public List<String> findEmailsByCity(@RequestParam("city") String city) {
    log.info("Command /getEmails requested. Returning a list of emails at "+ city +" city");
    List<String> result = customDataService.findEmailsByCity(city);
    return result;
    }


}
