package com.example.smartSwitch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.smartSwitch.entity.*;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<SwitchSchedule, Long> {
    List<SwitchSchedule> findByActiveTrue();
}
