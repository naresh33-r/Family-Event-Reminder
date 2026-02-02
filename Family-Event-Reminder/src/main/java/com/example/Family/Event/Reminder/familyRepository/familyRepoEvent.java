package com.example.Family.Event.Reminder.familyRepository;

import com.example.Family.Event.Reminder.familyModel.familyEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface familyRepoEvent extends JpaRepository<familyEvent, Long> {

  List<familyEvent> findByEventDate(LocalDate eventDate);
}
//@Repository
//public interface familyRepoEvent extends JpaRepository<familyEvent, Long> {
//
//    List<familyEvent> findByEventDate(LocalDate eventDate);
//}
//@Repository
//public interface familyRepoEvent extends JpaRepository<familyEvent, Long> {
//
//    List<familyEvent> findByEventDate(LocalDate eventDate);
//}