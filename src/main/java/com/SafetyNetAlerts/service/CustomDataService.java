package com.SafetyNetAlerts.service;

import com.SafetyNetAlerts.DTO.PersonChildrenAdultsByAddressDTO;
import com.SafetyNetAlerts.DTO.PersonNameAddressAgeEmailMedicalDTO;
import com.SafetyNetAlerts.DTO.PersonNamePhoneAgeMedicalDTO;
import com.SafetyNetAlerts.DTO.PersonsByStationNumberNbAdultsNbChildrenDTO;

import java.util.List;

public interface CustomDataService {

    /** URL 1
     * find inhabitants from a station number
     * @param station_number
     *
     * @return an object PersonsByStationNumberNbAdultsNbChildren containing all needed information
     */
     public PersonsByStationNumberNbAdultsNbChildrenDTO findPersonsByFirestationNumber(int station_number);

    /** URL 2
     *
    */
    public PersonChildrenAdultsByAddressDTO findChildrenByAddress(String address);

    /** URL 3
     *
     */
    public List<String> findPhoneNumbersByFirestationNumber(int station_number);


    /** URL 4
     *
     */

    public List<PersonNamePhoneAgeMedicalDTO> findPersonsByAddress(String address);

    /** URL 5
     *
     */

    /* public PersonsByAddressByStationDTO findPersonsByStation(int station_number); */

    /** URL 6
     * find medical Records of an inhabitant by firstname and lastname
     * @param firstName
     * @param lastName
     * @return an object NameAddressAgeEmailMedicalDTO containing all needed information
     */
    public List<PersonNameAddressAgeEmailMedicalDTO> findPersonsByFirstNameAndLastName(String firstName, String lastName);

    /** URL 7
     * find the emails of people living in a city
     * @param City
     * @return List<String> of emails
     */
    public List<String> findEmailsByCity(String City);


}