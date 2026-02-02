package com.example.Family.Event.Reminder.familyRepository;

import com.example.Family.Event.Reminder.familyModel.familyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface familyRepo  extends JpaRepository<familyMember, Integer> {
}
