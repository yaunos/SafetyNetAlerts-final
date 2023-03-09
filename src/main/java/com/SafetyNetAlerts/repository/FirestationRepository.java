package com.SafetyNetAlerts.repository;

import com.SafetyNetAlerts.model.Firestation;

import java.util.List;


public interface FirestationRepository {

    /* Get the firestations from the Json file */
    List<Firestation> getFirestationsFromGlobalData();

    List<Firestation> getFirestationsByAddressLocation(List<Firestation> firestations, String address);

    List<Firestation> getFirestationsByStation(List<Firestation> firestations, int station);

    Firestation addFirestationInDataSource(Firestation firestation);

    //Firestation updateFirestationInDataSource(String address);

    Firestation updateFirestationInDataSource(Firestation firestation, String address, Long station);

    void deleteFirestationInDataSource(Long station, String address);

    List<String> getAdressesByStationNumber(long stationNumber);
}