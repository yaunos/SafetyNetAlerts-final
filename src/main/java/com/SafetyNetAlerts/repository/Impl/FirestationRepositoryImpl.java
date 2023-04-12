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


    /**
     * @return a list of firestations from globalDataRepository
     */
    @Override
    public List<Firestation> getFirestationsFromGlobalData() {
        List<Firestation> firestations = globalDataRepository.read().getFirestations();
        return firestations;
    }


    /**
     * This method adds a firesatation in a list of firestations
     *
     * @param firestation
     *
     */
    @Override
    public Firestation addFirestationInDataSource(Firestation firestation) {
        GlobalData global = globalDataRepository.read();
        global.getFirestations().add(firestation);
        globalDataRepository.write(global);
        return firestation;
    }


    /**
     * This method updates a firestation in a list of firestations
     *
     */
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

    /**
     * This method delete a firestation in a list of firestations
     *
     */
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

    /**
     * This method gets all addresses around a station number
     *
     */
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
