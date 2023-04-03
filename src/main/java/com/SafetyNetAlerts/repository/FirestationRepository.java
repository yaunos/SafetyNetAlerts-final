package com.SafetyNetAlerts.repository;

import com.SafetyNetAlerts.model.Firestation;

import java.util.List;


public interface FirestationRepository {

    /* Get the firestations from the Json file */
    List<Firestation> getFirestationsFromGlobalData();
    Firestation addFirestationInDataSource(Firestation firestation);
    Firestation updateFirestationInDataSource(Firestation firestation, String address, Long station);
    void deleteFirestationInDataSource(Long station, String address);
    List<String> getAdressesByStationNumber(long stationNumber);
}