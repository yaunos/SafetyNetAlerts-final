package com.SafetyNetAlerts.repository;

import java.util.List;

public interface CustomDataRepository {
    public List<String> getEmailsByCity(String city);
}
