package com.SafetyNetAlerts.repository.Impl;

import com.SafetyNetAlerts.model.GlobalData;
import com.SafetyNetAlerts.repository.CustomDataRepository;
import com.SafetyNetAlerts.repository.GlobalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomDataRepositoryImpl implements CustomDataRepository {

    @Autowired
    private GlobalDataRepository globalDataRepository;

    @Override
    public List<String> getPersonsMedicalInformation(String firstName, String lastName) {
    return null;
    }

    /*
    @Override
    public List<String> getAddressesByStation(int station_number) {
        GlobalData datas = globalDataRepository.read();
        List<String> addresses = new ArrayList<>();
        datas.getFirestations().forEach((firestation -> {
            if(Objects.equals(station_number, firestation.getStation())){
                addresses.add(firestation.getAddress())


            }
        }));
    }
    */

    /**
     * @param city
     * @return a list of emails
     */
    @Override
    public List<String> getEmailsByCity(String city) {
        GlobalData datas = globalDataRepository.read();
        List<String> emails = new ArrayList<>();
        datas.getPersons().forEach((person -> {
            if (city.equals(person.getCity()) && (!emails.contains(person.getEmail()))) {
                emails.add(person.getEmail());
            }
        }));
        return emails;
    }
}
