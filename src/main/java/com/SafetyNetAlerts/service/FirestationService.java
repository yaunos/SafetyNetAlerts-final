package com.SafetyNetAlerts.service;

import com.SafetyNetAlerts.model.Firestation;

import java.util.List;

public interface FirestationService {

    List<Firestation> getFirestations();

    List<Firestation> getFirestationByItsLocationAddress(String adress);

    List<Firestation> getFirestationByStation(List<Firestation> firestations, int station);

    void addFirestationIntoDataSource(Firestation firestation);

    void updateFirestationIntoDataSource(Firestation firestation);

    void deleteFirestationIntoDataSource(String Address);

}