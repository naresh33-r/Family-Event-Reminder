package com.example.Family.Event.Reminder.familyController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.Family.Event.Reminder.familyModel.familyEvent;
import com.example.Family.Event.Reminder.familyModel.familyMember;
import com.example.Family.Event.Reminder.familyService.EmailService;
import com.example.Family.Event.Reminder.familyService.familyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "https://family-event-reminder-3mot.vercel.app/")
@RestController
public class familyController {
@Autowired
familyService familyService;
    @GetMapping("/")
    public String home(){
        return "Application Running";
    }

    @GetMapping("familyMem")
    public List<familyMember> availablefamilyMember(){
    return familyService.availablefamilyMember();
}
@GetMapping("familyevent")
    public List<familyEvent>availablefamilyEvent(){
    return familyService.availablefamilyEvent();
}
@PostMapping("/add/familymember")
public String addMembers(@RequestParam("name") String name,
                         @RequestParam("EmailId") String emailId,
                         @RequestParam("Relation") String Relation) {
    familyService.addMembers(name, emailId, Relation);
    return "congrets " + name + " added";

}
    @PostMapping("/addEvent")
    public String addEvent(@RequestParam("eventName") String eventName,
                           @RequestParam("eventDate") String eventDate,
                           @RequestParam("memberId") Long memberId) {

        familyService.addEvent(eventName, eventDate, memberId);

        return "Event " + eventName + " added successfully";
    }
    @Autowired
    private EmailService emailService;

    @GetMapping("/test-email")
    public String testEmail(@RequestParam String to) {

        emailService.sendEmail(
                to,
                "Test Mail - Family Event Reminder",
                "Hello 👋\n\nThis is a test email.\n\nEmail service working fine ✅"
        );

        return "Email sent successfully to " + to;
    }


}
//  private String eventName;
//    private LocalDate eventDate;
//
//    @ManyToOne
//    private familyMember member;
//
//
//