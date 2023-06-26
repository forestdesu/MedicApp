package com.example.MedicApp;

public class AnalisJSON {

    private int id;
    private String name;
    private String time;
    private String price;

    public AnalisJSON(int id, String name, String time, String price) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
