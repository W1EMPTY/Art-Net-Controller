package com.MetaLive.ArtNetController.model;

import java.util.List;

public class BrightnessUpdateRequest {
    private int brightness;
    private List<Integer> dmxAddrList;

    // Getters and Setters
    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public List<Integer> getDmxAddrList() {
        return dmxAddrList;
    }

    public void setDmxAddrList(List<Integer> dmxAddrList) {
        this.dmxAddrList = dmxAddrList;
    }
}
