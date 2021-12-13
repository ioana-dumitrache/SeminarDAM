package com.example.myapplication_fitify;

public class Clase {
private String denumire;
private String tip;
private String instructor;
private String data;

    public Clase(String denumire, String tip, String instructor, String data) {
        this.denumire = denumire;
        this.tip = tip;
        this.instructor = instructor;
        this.data = data;
    }

    public Clase() {

    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "denumire='" + denumire + '\'' +
                ", tip='" + tip + '\'' +
                ", instructor='" + instructor + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
