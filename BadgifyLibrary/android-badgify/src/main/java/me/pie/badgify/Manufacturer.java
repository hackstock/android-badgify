package me.pie.badgify;

/**
 * Created by pie on 23/02/2016.
 */
public enum Manufacturer {
    SAMSUNG("Samsung"),
    HTC("HTC"),
    LG("LG"),
    MOTOROLA("Motorola"),
    SONY("Sony"),
    ZTE("ZTE"),
    GARMIN_ASUS("Garmin-Asus"),
    PANTECH("Pantech"),
    ACER("Acer"),
    COOLPAD("Coolpad"),
    KYOCERA("Kyocera"),
    ASUS("Asus");

    private String commonName;

    Manufacturer(String commonName) {
        this.commonName = commonName;
    }

    public String getCommonName() {
        return commonName;
    }
}
