package com.SafetyNetAlerts.service.Impl;

import com.SafetyNetAlerts.DTO.*;
import com.SafetyNetAlerts.model.Firestation;
import com.SafetyNetAlerts.model.MedicalRecord;
import com.SafetyNetAlerts.model.Person;
import com.SafetyNetAlerts.repository.*;
import com.SafetyNetAlerts.service.CustomDataService;
import com.SafetyNetAlerts.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class CustomDataServiceImpl implements CustomDataService {
    @Autowired
    private CustomDataRepository customDataRepository;
    @Autowired
    private GlobalDataRepository globalDataRepository;

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    private FirestationRepository firestationRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    //URL 1 OK

    @Override
    public PersonsByStationNumberNbAdultsNbChildrenDTO findPersonsByFirestationNumber(int station_number) {
        //Init
        PersonsByStationNumberNbAdultsNbChildrenDTO output = new PersonsByStationNumberNbAdultsNbChildrenDTO();
        List<PersonNameAddressPhoneDTO> listPersons = new LinkedList<PersonNameAddressPhoneDTO>();
        int nbChildren = 0;
        int nbAdults = 0;

        //Get infos from data source
        List<Firestation> allFirestations = globalDataRepository.read().getFirestations();
        List<Person> allPersons = globalDataRepository.read().getPersons();
        List<MedicalRecord> allMedicalRecords = globalDataRepository.read().getMedicalrecords();

        //Get addresses matching firestation station number
        List<String> matchingStationAddresses = firestationRepository.getAdressesByStationNumber(station_number);

        //for (String address : matchingStationAddresses) {
        //List<Person> person = personRepository.getPersonsByAddress(firestation.getAddress());
        for (String address : matchingStationAddresses) {
            for (Person person : allPersons) {
                if (address.equals(person.getAddress())) {

                    PersonNameAddressPhoneDTO result = new PersonNameAddressPhoneDTO();
                    result.setFirstName(person.getFirstName());
                    result.setLastName(person.getLastName());
                    result.setAddress(person.getAddress());
                    result.setPhone(person.getPhone());
                    listPersons.add(result);
                    //for (Person person : allPersons) {
                        for (MedicalRecord medicalRecord : allMedicalRecords) {
                            if (medicalRecord.getFirstName().equals(person.getFirstName()) && medicalRecord.getLastName().equals(person.getLastName())) {
                                //Set
                                if (calculateAge(medicalRecord.getBirthdate()) < 18) {
                                    nbChildren++;
                                } else {
                                    nbAdults++;
                                }
                            }
                        }
                    }
                }

            output.setPersons(listPersons);
            output.setNumberChildren(nbChildren);
            output.setNumberAdults(nbAdults);

        }
        return output;

    }



    //URL 2 OK

    @Override
    public PersonChildrenAdultsByAddressDTO findChildrenByAddress(String address) {
        //Init Data
        PersonChildrenAdultsByAddressDTO result = new PersonChildrenAdultsByAddressDTO();
        //List<Person> allPersons = globalDataRepository.read().getPersons();
        List<MedicalRecord> allMedicalRecords = globalDataRepository.read().getMedicalrecords();
        List<PersonNameAgeDTO> listChildren = new LinkedList<>();
        List<PersonNameDTO> listAdults = new LinkedList<>();

        //Get all persons living at one address
        List<Person> allPersonsAtTheAddress = personService.findPersonsByAddress(address);

        for (Person person : allPersonsAtTheAddress) {
            for (MedicalRecord medicalRecord : allMedicalRecords) {
                if ((medicalRecord.getFirstName().equals(person.getFirstName()) && (medicalRecord.getLastName().equals(person.getLastName())))) {
                    int age = calculateAge(medicalRecord.getBirthdate());
                    if (age < 18) {
                        PersonNameAgeDTO child = new PersonNameAgeDTO();
                        child.setFirstName(person.getFirstName());
                        child.setLastName(person.getLastName());
                        child.setAge(age);
                        listChildren.add(child);
                    }
                    else {
                        PersonNameDTO adult =  new PersonNameDTO();
                        adult.setFirstName(person.getFirstName());
                        adult.setLastName(person.getLastName());
                        listAdults.add(adult);
                    }
                }
            }
        }
        result.setListChildren(listChildren);
        result.setListAdults(listAdults);
        return result;

    }
    /*
    public List<PersonsByAddressByStationDTO> findPersonsByStation(List<String> Station) {
        //Init Datas
        List<Person> allInhabitants = personRepository.getPersonsFromGlobalData();
        List<MedicalRecord> allMedicalRecords = medicalRecordRepository.getMedicalRecordsFromDataSource();
        List<Firestation> allFirestations = firestationRepository.getFirestationsFromGlobalData();

        List<PersonsByAddressByStationDTO> personsByAddressByStationDTOList = new LinkedList<>();

        //For each station number get all areas by addresses
        for (Firestation firestation : allFirestations) {
            List<Firestation> firestationByAddress = firestationRepository.getFirestationsByStation(allFirestations, i);

            // For each address, get all residents
            for (Firestation f : firestationByAddress) {
                String firestationAddress = f.getAddress();
                List<Person> personByAddress = personRepository.getPersonsByAddress(allInhabitants, firestationAddress);
                List<PersonNamePhoneAgeMedicalDTO> listResidentsDTO = new LinkedList<PersonNamePhoneAgeMedicalDTO>();

                //For each resident, get required information
                for (Person p : personByAddress) {
                    MedicalRecord medicalRecord = medicalRecordRepository.getMedicalRecordsFromFirstNameAndLastName(allMedicalRecords, p.getFirstName(), p.getLastName());
                    PersonNamePhoneAgeMedicalDTO residentDTO = new PersonNamePhoneAgeMedicalDTO();

                    residentDTO.setFirstName(p.getFirstName());
                    residentDTO.setLastName(p.getLastName());
                    residentDTO.setPhone(p.getPhone());
                    residentDTO.setMedications(medicalRecord.getMedication());
                    residentDTO.setAllergies(medicalRecord.getAllergie());
                    residentDTO.setAge(medicalRecordRepository.getAge(medicalRecord));

                    listResidentsDTO.add(residentDTO);
                }

                List<PersonNamePhoneAgeMedicalDTO> residentsDTO = listResidentsDTO.toArray(new PersonNamePhoneAgeMedicalDTO());

                //create and add the final DTO into the list of DTOs
                PersonsByAddressByStationDTO personsByAddressDTO = new PersonsByAddressByStationDTO();
                personsByAddressDTO.setAddress(firestationAddress);
                personsByAddressDTO.setResidents(residentsDTO);

                personsByAddressByStationDTOList.add(personsByAddressDTO);
            }


        }
        //transform the list of residents into a array
        List<PersonsByAddressByStationDTO> PersonsByAddressDTO = personsByAddressByStationDTOList.toArray(new PersonsByAddressByStationDTO[0]);
        return PersonsByAddressDTO;
    }
*/

    //URL 3 OK
    @Override
    public List<String> findPhoneNumbersByFirestationNumber(int station_number) {
        //Init
        List<String> phonesList = new LinkedList<>();
        List<Person> persons = globalDataRepository.read().getPersons();
        List<Firestation> firestations = globalDataRepository.read().getFirestations();

        //Get all addresses around considered station from its number
        //List<Firestation> matchingFirestationsAddresses = firestationRepository.getFirestationsByStation(station_number);


        for (Firestation firestation : firestations) {
            if (firestation.getStation() == station_number) {
                //    foundFirestations.set
                //if (Objects.equals(firestation.getStation(), station_number)) {
                for (Person person : persons) {
                    if (firestation.getAddress().equals(person.getAddress())) {
                        //set
                        if (phonesList.contains(person.getPhone())) {
                        } else
                            phonesList.add(person.getPhone());
                    }
                }

            }

        }
        return phonesList;

    }

    // URL 4 OK but no firestation number
    @Override
    public List<PersonNamePhoneAgeMedicalDTO> findPersonsByAddress(String address) {
        //init
        List<PersonNamePhoneAgeMedicalDTO> result = new LinkedList<PersonNamePhoneAgeMedicalDTO>();
        //int firestationNumber = Integer.parseInt(null);

        //get infos
        List<Firestation> firestations = globalDataRepository.read().getFirestations();
        List<Person> persons = globalDataRepository.read().getPersons();
        List<MedicalRecord> medicalRecords = globalDataRepository.read().getMedicalrecords();

        for (Person person : persons) {

            if (person.getAddress().equals(address)) {

                for (MedicalRecord medicalRecord : medicalRecords) {
                    if ((medicalRecord.getFirstName().equals(person.getFirstName()) && (medicalRecord.getLastName().equals(person.getLastName())))) {
                        //set current content
                        PersonNamePhoneAgeMedicalDTO currentPerson = new PersonNamePhoneAgeMedicalDTO();
                        currentPerson.setFirstName(person.getFirstName());
                        currentPerson.setLastName(person.getLastName());
                        currentPerson.setPhone(person.getPhone());
                        currentPerson.setAge(calculateAge(medicalRecord.getBirthdate()));
                        currentPerson.setMedications(medicalRecord.getMedications());
                        currentPerson.setAllergies(medicalRecord.getAllergies());
                        result.add(currentPerson);
                    }
                }
                // Retourner le n° de la caserne
            }
        }
        return result;
    }





    //URL 5
    @Override
    public  List<PersonsByAddressByStationDTO> findPersonsByStations(List<Long> stationNumber) {
        //Init
        //List<PersonNamePhoneAgeMedicalDTO> result = new linkedList<PersonNamePhoneAgeMedicalDTO();
        List<PersonsByAddressByStationDTO> result = new LinkedList<PersonsByAddressByStationDTO>();

        //get infos
        List<Firestation> firestations = globalDataRepository.read().getFirestations();
        List<Person> persons = globalDataRepository.read().getPersons();
        List<MedicalRecord> medicalRecords = globalDataRepository.read().getMedicalrecords();

        for (Long i : stationNumber) {
            //Get addresses matching firestation station number
            List<String> matchingStationAddresses = firestationRepository.getAdressesByStationNumber(i);
            for (String address : matchingStationAddresses) {
                PersonsByAddressByStationDTO item = new PersonsByAddressByStationDTO();
                item.setAddress(address);
                List<PersonNamePhoneAgeMedicalDTO> resident = findPersonsByAddress(address);
                item.setResidents(resident);
                result.add(item);
            }
        }

        return result;
    }




        //URL 6 OK
        @Override
        public List<PersonNameAddressAgeEmailMedicalDTO> findPersonsByFirstNameAndLastName (String firstName, String
        lastName) {
            //init
            List<PersonNameAddressAgeEmailMedicalDTO> result = new LinkedList<PersonNameAddressAgeEmailMedicalDTO>();

            //get infos
            List<Person> persons = globalDataRepository.read().getPersons();
            List<MedicalRecord> medicalRecords = globalDataRepository.read().getMedicalrecords();

            for (Person person : persons) {
                if (person.getFirstName().equals(firstName) && (person.getLastName().equals(lastName))) {
                    for (MedicalRecord medicalRecord : medicalRecords) {
                        if (medicalRecord.getFirstName().equals(firstName) && (medicalRecord.getLastName().equals(lastName))) {

                            //set
                            PersonNameAddressAgeEmailMedicalDTO result2 = new PersonNameAddressAgeEmailMedicalDTO();
                            result2.setFirstName(person.getFirstName());
                            result2.setLastName(person.getLastName());
                            result2.setAddress(person.getAddress());
                            result2.setAge(calculateAge(medicalRecord.getBirthdate()));
                            result2.setEmail(person.getEmail());
                            result2.setMedication(medicalRecord.getMedications());
                            result2.setAllergies(medicalRecord.getAllergies());

                            result.add(result2);

                        }

                    }
                }
            }

            //
            return result;

        }

        //URL 7 OK
        @Override
        public List<String> findEmailsByCity (String city){
            //List<Person> persons = globalDataRepository.read().getPersons();
            List<String> emails = customDataRepository.getEmailsByCity(city);
            return emails;

        }

        private int calculateAge (Date date){
            LocalDate currentDate = LocalDate.now();

            LocalDate birthDate = new java.sql.Date(date.getTime()).toLocalDate();
            if ((birthDate != null) && (currentDate != null)) {
                return Period.between(birthDate, currentDate).getYears();
            } else {
                return 0;
            }
        }
}






