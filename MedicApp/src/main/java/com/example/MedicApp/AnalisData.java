package com.example.MedicApp;

public class AnalisData {
    private String analisName;
    private String analisDate;
    private String analisPrice;

    public AnalisData(String analisName, String analisDate, String analisPrice) {
        this.analisName = analisName;
        this.analisDate = analisDate;
        this.analisPrice = analisPrice;
    }

    public String getAnalisName() {
        return analisName;
    }

    public void setAnalisName(String analisName) {
        this.analisName = analisName;
    }

    public String getAnalisDate() {
        return analisDate;
    }

    public void setAnalisDate(String analisDate) {
        this.analisDate = analisDate;
    }

    public String getAnalisPrice() {
        return analisPrice;
    }

    public void setAnalisPrice(String analisPrice) {
        this.analisPrice = analisPrice;
    }
}
