package com.MetaLive.ArtNetController.model;


public class Light {
    private int id;
    private int Brightness;
    private int dmxAddress;
    private String status;
    public Light(int id, int brightness, int dmxAddress, String status) {
        this.id = id;
        Brightness = brightness;
        this.dmxAddress = dmxAddress;
        this.status = status;
    }
    @Override
    public String toString() {
        return "light{" +
                "id=" + id +
                ", Brightness=" + Brightness +
                ", dmxAddress=" + dmxAddress +
                ", status='" + status + '\'' +
                '}';
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getBrightness() {
        return Brightness;
    }

    public void setBrightness(int brightness) {
        Brightness = brightness;
    }

    public int getDmxAddress() {
        return dmxAddress;
    }

    public void setDmxAddress(int dmxAddress) {
        this.dmxAddress = dmxAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
