package com.SafetyNetAlerts.model;

import lombok.Data;

@Data
public class Firestation {
    public String address;
    public long station;
    public String city;
    public long zip;
    public String phone;

    public String getAddress() { return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public long getStation() {
        return station;
    }

    public void setStation(long station) {
        this.station = station;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
