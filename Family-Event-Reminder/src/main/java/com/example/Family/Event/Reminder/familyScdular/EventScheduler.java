package com.example.Family.Event.Reminder.familyScdular;

import com.example.Family.Event.Reminder.familyModel.familyEvent;
import com.example.Family.Event.Reminder.familyRepository.familyRepoEvent;
import com.example.Family.Event.Reminder.familyService.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component   // ⭐ VERY IMPORTANT
public class EventScheduler {

    @Autowired
    private familyRepoEvent familyRepoEvent;

    @Autowired
    private EmailService emailService;

    // Every day morning 9 AM
    @Scheduled(cron = "0 17 9 * * ?")
    mvn -version
    public void sendEventReminder() {

        LocalDate today = LocalDate.now();

        List<familyEvent> events =
                familyRepoEvent.findByEventDate(today);

        for (familyEvent event : events) {

            String email = event.getMember().getEmailID();

            String message =
                    "Hi " + event.getMember().getName() + ",\n\n" +
                            "Today is your " + event.getEventName() + ". 🎉\n" +
                            "Have a great day!\n\n" +
                            "- Family Event Reminder";

            emailService.sendEmail(
                    email,
                    "Event Reminder",
                    message
            );
        }
    }
}
