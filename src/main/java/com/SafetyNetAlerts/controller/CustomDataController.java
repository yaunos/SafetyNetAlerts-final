package com.SafetyNetAlerts.controller;

import com.SafetyNetAlerts.DTO.*;
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

    /** URL 1
     * Read - Get persons covered by a Station number
     *
     * @param station_number
     * @return a list of persons covered with firstName, lastName, address, phone number, then return Number of adults then Number of children for the area
     */


    @GetMapping("/firestation")
    public PersonsByStationNumberNbAdultsNbChildrenDTO findPersonsByFirestationNumber(@RequestParam("station_number") int station_number) {
        log.info("Command /firestation requested. Returning a list of persons in the area covered by station number : "+ station_number);
        PersonsByStationNumberNbAdultsNbChildrenDTO result = customDataService.findPersonsByFirestationNumber(station_number);
        return result;
    }

    /** URL 2
     * Read - Get a list of children living at one address + a list of adults at this same address
     *
     * @param address
     * @return a list of children covered with firstName, lastName, Age and a list of adults
     */
    @GetMapping("/childAlert")
    public PersonChildrenAdultsByAddressDTO findChildrenByAddress(@RequestParam(name="address")String address) {
        log.info("Command /childAlert requested. List of children with age living at  " + address);
        PersonChildrenAdultsByAddressDTO result = customDataService.findChildrenByAddress(address);
        return result;
    }



    /** URL 3
    * Read - Get persons from their firstname and last name and return their info and medical records
    * @param station_number
    * @return all phone numbers around this area
    */
    @GetMapping("/phoneAlert")
    public List<String> findPhoneNumbersByFirestationNumber(@RequestParam("firestation") int station_number) {
        log.info("Command /phoneAlert requested. Returning a list of phone numbers in the area covered by station number : "+ station_number);
        List<String> result = customDataService.findPhoneNumbersByFirestationNumber(station_number);
        return result;
    }

    /** URL 4
     * Read - Get persons from their Address
     * @param address
     * @return all persons info and Medical Records
     * @return Firestation number
     */

    @GetMapping("/fire")
    public List<PersonNamePhoneAgeMedicalDTO> findPersonsByAddress(@RequestParam("address") String address) {
        log.info("Command /fire list requested. Returning a list of persons with info and medical records from address");
        List<PersonNamePhoneAgeMedicalDTO> result = customDataService.findPersonsByAddress(address);
        return result;
    }

    /** URL 5
     * Read - Get persons from a list of station numbers
     * @param list of numbers 1,2,3
     * @return all persons info and Medical Records by address for each station number
     */
    @GetMapping("/flood/stations")
    public List<PersonsByAddressByStationDTO> findPersonsByStations(@RequestParam(name="stations") List<Long> stationNumber) {
        log.info("Command /flood/stations requested. Listing all residents by address for each station number");
        List<PersonsByAddressByStationDTO> result = customDataService.findPersonsByStations(stationNumber);
        return result;
    }


    /** URL 6
     * Read - Get persons from their firstname and last name and return their info and medical records
     *
     * @param firstName and lastName
     * @return persons info and medical records
     */


    @GetMapping("/personInfo")
    public List<PersonNameAddressAgeEmailMedicalDTO> findPersonsByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        log.info("Command /personInfo list requested. Returning a list of persons with info and medical records");
        List<PersonNameAddressAgeEmailMedicalDTO> result = customDataService.findPersonsByFirstNameAndLastName(firstName, lastName);
        return result;
    }

    /** URL 7
     * Read - Get persons from one city and return their email
     *
     * @param city
     * @return a List of the email of each person
     */


    @GetMapping("/communityEmail")
    public List<String> findEmailsByCity(@RequestParam("city") String city) {
    log.info("Command /getEmailsByCity requested. Returning a list of emails at "+ city +" city");
    List<String> result = customDataService.findEmailsByCity(city);
    return result;
    }


}
