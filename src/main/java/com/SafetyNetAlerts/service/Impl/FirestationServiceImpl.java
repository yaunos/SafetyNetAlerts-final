package com.SafetyNetAlerts.service.Impl;

import com.SafetyNetAlerts.model.Firestation;
import com.SafetyNetAlerts.repository.FirestationRepository;
import com.SafetyNetAlerts.repository.GlobalDataRepository;
import com.SafetyNetAlerts.service.FirestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirestationServiceImpl implements FirestationService {
    @Autowired
    private FirestationRepository firestationRepository;
    @Autowired
    private GlobalDataRepository globalDataRepository;

    @Override
    public List<Firestation> getFirestations() {
        return firestationRepository.getFirestationsFromGlobalData();
    }

    @Override
    public List<Firestation> getFirestationByItsLocationAddress(String address) {
        List<Firestation> firestations = globalDataRepository.read().getFirestations();
        return firestationRepository.getFirestationsByAddressLocation(firestations, address);
    }

    @Override
    public List<Firestation> getFirestationByStation(List<Firestation> firestations, int station) {
        return firestationRepository.getFirestationsByStation(firestations, station);
    }

    @Override
    public void addFirestationIntoDataSource(Firestation firestation) {
        firestationRepository.addFirestationInDataSource(firestation);
    }

    @Override
    public void updateFirestationIntoDataSource(Firestation firestation) {
        firestationRepository.updateFirestationInDataSource(firestation);
    }

    @Override
    public void deleteFirestationIntoDataSource(String address) {
        firestationRepository.deleteFirestationInDataSource(address);
    }
}



