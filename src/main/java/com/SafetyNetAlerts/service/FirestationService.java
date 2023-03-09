package com.SafetyNetAlerts.service;

import com.SafetyNetAlerts.model.Firestation;

import java.util.List;


public interface FirestationService {

    List<Firestation> getFirestations();

    List<Firestation> getFirestationByItsLocationAddress(String address);

    List<Firestation> getFirestationByStation(List<Firestation> firestations, int station);

    Firestation addFirestationIntoDataSource(Firestation firestation);

    Firestation updateFirestationIntoDataSource(Firestation firestation, String address, Long station);

    void deleteFirestationIntoDataSource(Long station, String address);

}