package com.example.smartSwitch.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class SwitchService {
    private final WebClient webClient;

    public SwitchService(WebClient webClient) {
        this.webClient = webClient;
    }

    @Value("${shelly.ip}")
    private String shellyIp;

    public Map<String, Object> basePayload(){
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("src", "user_admin");
        return map;
    }

    public Mono<String> switchOn() {
        Map<String, Object> payload = basePayload();
        payload.put("method", "Switch.Set");
        Map<String, Object> params = new HashMap<>();
        payload.put("params", params);
        params.put("id", 0);
        params.put("on", true);

        return webClient.post()
                .uri(shellyIp + "/rpc")
                .bodyValue(payload)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> switchOff() {
        Map<String, Object> payload = basePayload();
        payload.put("method", "Switch.Set");
        Map<String, Object> params = new HashMap<>();
        payload.put("params", params);
        params.put("id", 0);
        params.put("on", false);

        return webClient.post()
                .uri(shellyIp + "/rpc")
                .bodyValue(payload)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> toggleSwitch() {
        Map<String, Object> payload = basePayload();
        payload.put("method", "Switch.Toggle");
        Map<String, Object> params = new HashMap<>();
        payload.put("params", params);
        params.put("id", 0);

        return webClient.post()
                .uri(shellyIp + "/rpc")
                .bodyValue(payload)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> addSchedule(String cron, String method) {
        Map<String, Object> payload = basePayload();
        payload.put("method", "Schedule.Create");
        Map<String, Object> params = new HashMap<>();
        payload.put("params", params);
        params.put("enable", true);
        params.put("timespec", cron);
        List<Map<String, Object>> calls = new ArrayList<>();
        Map<String, Object> call = new HashMap<>();
        switch(method){
            case "on":
                call.put("method", "Switch.Set");
                Map<String, Object> callParamsOn = new HashMap<>();
                callParamsOn.put("id", 0);
                callParamsOn.put("on", true);
                call.put("params", callParamsOn);
                break;
            case "off":
                call.put("method", "Switch.Set");
                Map<String, Object> callParamsOff = new HashMap<>();
                callParamsOff.put("id", 0);
                callParamsOff.put("on", false);
                call.put("params", callParamsOff);
                break;
            case "toggle":
                call.put("method", "Switch.Toggle");
                Map<String, Object> callParamsToggle = new HashMap<>();
                callParamsToggle.put("id", 0);
                call.put("params", callParamsToggle);
                break;
            default:
                throw new IllegalArgumentException("Invalid method: " + method);
        }
        calls.add(call);
        params.put("calls", calls);

        return webClient.post()
                .uri(shellyIp + "/rpc")
                .bodyValue(payload)
                .retrieve()
                .bodyToMono(String.class);
    }
}
