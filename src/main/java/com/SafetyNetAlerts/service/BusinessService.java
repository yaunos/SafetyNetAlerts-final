package com.SafetyNetAlerts.service;

import com.SafetyNetAlerts.model.SafetyNetAlerts;
import org.springframework.stereotype.Component;


@Component
public class BusinessService {

    public SafetyNetAlerts getSafetyNetAlerts() {
        SafetyNetAlerts sna = new SafetyNetAlerts();
        return sna;
    }
}