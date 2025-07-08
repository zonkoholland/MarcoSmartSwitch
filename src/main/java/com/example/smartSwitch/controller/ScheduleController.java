package com.example.smartSwitch.controller;

import com.example.smartSwitch.entity.SwitchSchedule;
import com.example.smartSwitch.repository.ScheduleRepository;
import com.example.smartSwitch.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("marcoSwitch/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @Autowired
    private ScheduleRepository repo;

    @PostMapping("/on")
    public ResponseEntity<?> addScheduleOn(@RequestBody SwitchSchedule schedule) {
        repo.save(schedule);
        return ResponseEntity.ok("Scheduled");
    }

    @PostMapping("/off")
    public ResponseEntity<?> addScheduleOff(@RequestBody SwitchSchedule schedule) {

    }

    @PostMapping("/toggle")
    public ResponseEntity<?> addScheduleToggle(@RequestBody SwitchSchedule schedule) {

    }

    @GetMapping
    public List<SwitchSchedule> getAll() {
        return repo.findAll();
    }
}
