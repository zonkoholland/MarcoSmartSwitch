package com.example.smartSwitch.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

@Entity
public class SwitchSchedule {
    @Id
    @GeneratedValue
    private long id;

    private String action;
    private int hour;
    private int minute;
    private int dayOfWeek;
    private Integer month;
    private Integer dayOfMonth;

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getDayOfMonth() {
        return dayOfMonth;
    }

    public String getAction() {
        return action;
    }
}
