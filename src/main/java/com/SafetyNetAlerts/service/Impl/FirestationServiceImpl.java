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
    public Firestation addFirestationIntoDataSource(Firestation firestation) {
        return firestationRepository.addFirestationInDataSource(firestation);
    }

    @Override
    public Firestation updateFirestationIntoDataSource(Firestation firestation, String address, Long station) {
        return firestationRepository.updateFirestationInDataSource(firestation, address, station);
    }

    @Override
    public void deleteFirestationIntoDataSource(Long station, String address) {
        firestationRepository.deleteFirestationInDataSource(station, address);
    }
}



