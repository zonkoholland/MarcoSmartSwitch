package com.example.smartSwitch.service;

import com.example.smartSwitch.entity.SwitchSchedule;
import com.example.smartSwitch.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScheduleService {
    private final WebClient webClient;

    @Value("${shelly.ip}")
    private String shellyIp;

    public Map<String, Object> basePayload(String timespec){
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("enable", true);
        map.put("timespec", timespec);
        return map;
    }

    public Mono<String> scheduleOn(String timespec) {
        Map<String, Object> payload = basePayload(timespec);
        Map<String, Object> calls = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        payload.put("calls", calls);
        params.put("id", 0);
        params.put("on", true);
    }

    @Autowired
    private ScheduleRepository repo;

    @Autowired
    private SwitchService switchService;

    public ScheduleService(WebClient webClient) {
        this.webClient = webClient;
    }
}
