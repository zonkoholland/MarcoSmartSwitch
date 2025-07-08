package com.example.smartSwitch.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.HashMap;
import java.util.Map;

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
}
