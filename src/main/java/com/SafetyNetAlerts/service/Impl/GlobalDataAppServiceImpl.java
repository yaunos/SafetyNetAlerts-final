package com.SafetyNetAlerts.service.Impl;

import com.SafetyNetAlerts.model.GlobalData;
import com.SafetyNetAlerts.repository.GlobalDataRepository;
import com.SafetyNetAlerts.service.GlobalDataAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlobalDataAppServiceImpl implements GlobalDataAppService {

    @Autowired
    private GlobalDataRepository globalDataRepository;

    @Override
    public GlobalData readDataFromJson() {
        return globalDataRepository.read();

    }

    @Override
    public void writeDataInJson(GlobalData globalData) {
        globalDataRepository.write(globalData);


    }
}