package com.example.Family.Event.Reminder.familyService;

import com.example.Family.Event.Reminder.familyModel.familyEvent;
import com.example.Family.Event.Reminder.familyModel.familyMember;
import com.example.Family.Event.Reminder.familyRepository.familyRepo;
import com.example.Family.Event.Reminder.familyRepository.familyRepoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class familyService {
    @Autowired
    familyRepo familyRepo;
    @Autowired
    familyRepoEvent familyRepoEvent;

    public List<familyMember> availablefamilyMember() {
      return   familyRepo.findAll();
            
        }

    public List<familyEvent> availablefamilyEvent() {
        return familyRepoEvent.findAll();
    }

    public void addMembers(String name, String emailId, String relation) {
        familyMember familyMember =new familyMember(name,emailId,relation);
        familyRepo.save(familyMember);
    }
    public void addEvent(String eventName, String eventDate, Long memberId) {

        familyMember member = familyRepo.findById(Math.toIntExact(memberId)).orElseThrow();

        familyEvent event = new familyEvent();
        event.setEventName(eventName);
        event.setEventDate(LocalDate.parse(eventDate));
        event.setMember(member);

        familyRepoEvent.save(event);
    }



}

// @Autowired
//    CourseRepo courseRepo;
//    @Autowired
//    courseRepoRegis Co;
//    public List<Course> availablecourse() {
//       return courseRepo.findAll();
//
//    }