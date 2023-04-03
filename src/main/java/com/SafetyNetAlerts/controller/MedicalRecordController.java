package com.SafetyNetAlerts.controller;

import com.SafetyNetAlerts.model.MedicalRecord;
import com.SafetyNetAlerts.service.MedicalRecordService;
import com.SafetyNetAlerts.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MedicalRecordController {

    private Logger logger = LogManager.getLogger(MedicalRecordController.class);

    @Autowired
    private MedicalRecordService medicalRecordService;

    @Autowired
    private PersonService personService;

    /**
     * Read a MedicalRecord
     */
    @GetMapping("/medicalRecord")
    public List<MedicalRecord> findMedicalRecordsByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return medicalRecordService.findMedicalRecordsByFirstNameAndLastName(firstName, lastName);
    }

    /**
     * Create a MedicalRecord
     */
    @PostMapping("/medicalRecord")
    public MedicalRecord createMedicalRecordInDataSource(@RequestBody MedicalRecord medicalRecord) {
        logger.info("Command POST /medicalRecord requested. Creation of a medical record");
        medicalRecordService.addMedicalRecordInDataSource(medicalRecord);
        return medicalRecord;
    }

    /**
     * Update a MedicalRecord
     */

    @PutMapping("/medicalRecord")
    public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord, @RequestParam (name = "firstName") String firstName, @RequestParam (name = "lastName") String lastName) {
        logger.info("Command PUT /medicalRecord requested. Update of a medical record");
        medicalRecordService.updateMedicalRecordInDataSource(medicalRecord, firstName, lastName);
        return medicalRecord;
    }


    /**
     * Delete a MedicalRecord
     */

    @DeleteMapping("/medicalRecord")
    public void deleteMedicalRecord(@RequestParam (name = "firstName") String firstName, @RequestParam (name = "lastName") String lastName) {
        logger.info("Command DELETE /medicalRecord requested. Deletion of " + firstName + " " + lastName + "'s medical record");
        medicalRecordService.deleteMedicalRecordInDataSource(firstName, lastName);
    }
}

