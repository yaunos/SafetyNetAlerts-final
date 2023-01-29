package com.SafetyNetAlerts.service.Impl;

import com.SafetyNetAlerts.repository.CustomDataRepository;
import com.SafetyNetAlerts.service.CustomDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomDataServiceImpl implements CustomDataService {
    @Autowired
    private CustomDataRepository customDataRepository;

    @Override
    public List<String> findEmailsByCity(String city) {
        //List<Person> persons = globalDataRepository.read().getPersons();
        List<String> emails = customDataRepository.getEmailsByCity(city);
        return emails;

    }

}