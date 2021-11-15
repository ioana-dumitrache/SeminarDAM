package com.example.myapplication_fitify;

public class Exercitii {
    private String denumire;
    private float durata;
    private String descriere;

    public Exercitii(String denumire, float durata, String descriere) {
        this.denumire = denumire;
        this.durata = durata;
        this.descriere = descriere;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public float getDurata() {
        return durata;
    }

    public void setDurata(float durata) {
        this.durata = durata;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    @Override
    public String toString() {
        return "Exercitii{" +
                "denumire='" + denumire + '\'' +
                ", durata=" + durata +
                ", descriere='" + descriere + '\'' +
                '}';
    }
}
