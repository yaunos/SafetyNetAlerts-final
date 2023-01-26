package com.SafetyNetAlerts.controller;

import com.SafetyNetAlerts.model.MedicalRecord;
import com.SafetyNetAlerts.service.MedicalRecordService;
import com.SafetyNetAlerts.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class MedicalRecordController {

    // private Logger logger = LogManager.getLogger(MedicalRecordsController.class);

    @Autowired
    private MedicalRecordService medicalRecordService;

    @Autowired
    private PersonService personService;

    @GetMapping("/medrec")
    public List<MedicalRecord> findMedicalRecordsByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return medicalRecordService.findMedicalRecordsByFirstNameAndLastName(firstName, lastName);
    }
}

