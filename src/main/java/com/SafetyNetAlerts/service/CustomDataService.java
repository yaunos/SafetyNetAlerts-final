package com.SafetyNetAlerts.service;

import java.util.List;

public interface CustomDataService {
    public List<String> findEmailsByCity(String City);
}