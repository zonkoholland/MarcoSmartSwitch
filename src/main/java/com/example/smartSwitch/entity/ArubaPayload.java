package com.example.smartSwitch.entity;

public class ArubaPayload {

    private String mac;
    private int rssi;
    private String timestamp;
    private String uuid;

    // Getters and Setters
    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "ArubaPayload{" +
                "mac='" + mac + '\'' +
                ", rssi=" + rssi +
                ", timestamp='" + timestamp + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
