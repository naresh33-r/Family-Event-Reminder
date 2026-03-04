package com.example.Family.Event.Reminder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FamilyEventReminderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FamilyEventReminderApplication.class, args);
	}

}
