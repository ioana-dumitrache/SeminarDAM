package com.example.myapplication_fitify;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Exercitii")
public class Exercitii {
    @ColumnInfo(name = "denumire")
    private String denumire;
    @PrimaryKey(autoGenerate = true)
    private Integer durata;
    @ColumnInfo(name = "descriere")
    private String descriere;

    public Exercitii(String denumire,Integer durata, String descriere) {
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

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
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
