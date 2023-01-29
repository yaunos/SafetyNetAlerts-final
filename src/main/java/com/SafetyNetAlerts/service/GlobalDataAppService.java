package com.SafetyNetAlerts.service;

import com.SafetyNetAlerts.model.GlobalData;
import org.springframework.stereotype.Component;

@Component
public interface GlobalDataAppService {

    GlobalData readDataFromJson();

    void writeDataInJson(GlobalData globalData);

}
