package com.SafetyNetAlerts.repository.Impl;

import com.SafetyNetAlerts.model.Firestation;
import com.SafetyNetAlerts.model.GlobalData;
import com.SafetyNetAlerts.repository.FirestationRepository;
import com.SafetyNetAlerts.repository.GlobalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FirestationRepositoryImpl implements FirestationRepository {

    @Autowired
    private GlobalDataRepository globalDataRepository;

    @Override
    public List<Firestation> getFirestationsFromGlobalData() {
        List<Firestation> firestations = globalDataRepository.read().getFirestations();
        return firestations;
    }

    @Override
    public List<Firestation> getFirestationsByAddressLocation(List<Firestation> firestations, String address) {
       // Firestation firestationAtThisAddress = null;
       // For(Firestation F)
       // If (List.firestationAtThisAddress = null; new LinkedList<>();
        // return firestationAtThisAddress;
        return null;
    }

    @Override
    public List<Firestation> getFirestationsByStation(List<Firestation> firestations, int station) {
        return null;
    }

    @Override
    public Firestation addFirestationInDataSource(Firestation firestation) {
        GlobalData global = globalDataRepository.read();
        global.getFirestations().add(firestation);
        globalDataRepository.write(global);
        return firestation;
    }

    @Override
    public Firestation updateFirestationInDataSource(Firestation firestation, String address, Long station) {
        GlobalData global = globalDataRepository.read();
        global.getFirestations().forEach((firestation1 -> {
            if(firestation1.getAddress().equals(address)&&firestation1.getStation() == station) {
                firestation1.setStation(firestation.getStation());
                firestation1.setAddress(firestation.getAddress());
            }
        }));
        globalDataRepository.write(global);
        return firestation;

    }

    @Override
    public void deleteFirestationInDataSource(Long station, String address) {
        GlobalData global = globalDataRepository.read();
        List<Firestation> lf = new ArrayList<>();

        for (Firestation firestation : global.getFirestations()) {
            if((address!=null && firestation.getAddress().equals(address)) || (station!=null && firestation.getStation() == station)) {
                lf.add(firestation);
            }
        }
        global.getFirestations().removeAll(lf);
        globalDataRepository.write(global);

    }

    @Override
    public List<String> getAdressesByStationNumber(long stationNumber) {
        GlobalData datas = globalDataRepository.read();
        List<String> adresses = new ArrayList<>();
        datas.getFirestations().forEach((firestation -> {
            if(stationNumber == firestation.getStation()){
                adresses.add(firestation.getAddress());
            }
        }));
        return adresses;
    }
}
