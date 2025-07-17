package com.example.smartSwitch.controller;

import com.example.smartSwitch.service.SwitchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("marcoSwitch")
public class SwitchController {

    private final SwitchService switchService;

    public SwitchController(SwitchService switchService) {
        this.switchService = switchService;
    }

    @PostMapping("/toggle")
    public Mono<String> toggleSwitch() {
        return switchService.toggleSwitch();
    }

    @PostMapping("/on")
    public Mono<String> switchOn() {
        return switchService.switchOn();
    }

    @PostMapping("/off")
    public Mono<String> switchOff() {
        return switchService.switchOff();
    }
}
