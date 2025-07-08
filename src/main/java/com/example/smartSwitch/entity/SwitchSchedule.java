package com.example.smartSwitch.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.Month;

@Entity
public class SwitchSchedule {
    @Id
    @GeneratedValue
    private long id;

    private String action;
    private LocalTime time;
    private DayOfWeek dayOfWeek;
    private Month month;

}
