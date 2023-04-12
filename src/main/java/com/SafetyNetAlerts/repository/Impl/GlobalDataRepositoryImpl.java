package com.SafetyNetAlerts.repository.Impl;

import com.SafetyNetAlerts.model.Firestation;
import com.SafetyNetAlerts.model.GlobalData;
import com.SafetyNetAlerts.model.MedicalRecord;
import com.SafetyNetAlerts.model.Person;
import com.SafetyNetAlerts.repository.GlobalDataRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

@Repository
public class GlobalDataRepositoryImpl implements GlobalDataRepository {

    private static final Logger log = LogManager.getLogger(GlobalDataRepositoryImpl.class);

    public static void main(String[] args) {

        GlobalDataRepositoryImpl gdr = new GlobalDataRepositoryImpl();

        GlobalData globaldata = gdr.read();
        System.out.println(globaldata);

    }

    /**
     * This method reads the Json file and put it in a string
     *
     */
    @Override
    public GlobalData read() {
        try {
            // create Gson instance
            //Gson gson = new Gson();
            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            //Gson gson = new Gson().getAdapter("dd/MM/yyyy").create();

            //create a variable globaldata
            GlobalData globaldata;

            // create a reader
            String file = "src/main/resources/data.json";
            String json = readFileToString(file);

            // convert JSON file to objects
            globaldata = gson.fromJson(json, GlobalData.class);

            return globaldata;

        } catch (Exception e) {
            e.printStackTrace();
        }return null;
    }

    private String readFileToString(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    /**
     * This method takes some string data and write it into the original Json file
     *
     */
    @Override
    public void write(GlobalData globalData) {

        //Init which file will be written
        String file = "src/main/resources/data.json";

        //Convert Global Data into a Json format string
        Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(globalData);

        //Insert some data into the file
        PrintWriter writer;

        try {
            writer = new PrintWriter(file);
            writer.println(json);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.error("Error. Can't write into the file");
        }

    }

    @Override
    public void addPerson(Person personToAdd) {
        GlobalData globalData = read();

        //globalData.addPerson(personToAdd);

        write(globalData);

    }

    @Override
    public void updatePerson(Person person) {

    }

    @Override
    public void deletePerson(String firstName, String lastName) {

    }

    @Override
    public void addFirestation(Firestation firestation) {

    }

    @Override
    public void updateFirestation(Firestation firestation) {

    }

    @Override
    public void deleteFirestation(String address) {

    }

    @Override
    public void addMedicalRecord(MedicalRecord medicalRecord) {

    }

    @Override
    public void updateMedicalRecord(MedicalRecord medicalRecord) {

    }

    @Override
    public void deleteMedicalRecord(String firstName, String lastName) {

    }
}