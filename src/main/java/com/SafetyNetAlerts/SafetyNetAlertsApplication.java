package com.SafetyNetAlerts;

import com.SafetyNetAlerts.model.SafetyNetAlerts;
import com.SafetyNetAlerts.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SafetyNetAlertsApplication implements CommandLineRunner{

	@Autowired
	private BusinessService bs;

	public static void main(String[] args) {
		SpringApplication.run(SafetyNetAlertsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SafetyNetAlerts sna = bs.getSafetyNetAlerts();
		System.out.println(sna);
	}


}
