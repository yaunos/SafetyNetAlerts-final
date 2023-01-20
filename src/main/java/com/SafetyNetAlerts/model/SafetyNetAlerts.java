package com.SafetyNetAlerts.model;

public class SafetyNetAlerts {

    private String value = "SafetyNetAlerts is up and running !";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}