package com.SafetyNetAlerts.service;

import com.SafetyNetAlerts.model.Firestation;

import java.util.List;


public interface FirestationService {

    List<Firestation> getFirestations();

    Firestation addFirestationIntoDataSource(Firestation firestation);

    Firestation updateFirestationIntoDataSource(Firestation firestation, String address, Long station);

    void deleteFirestationIntoDataSource(Long station, String address);

}