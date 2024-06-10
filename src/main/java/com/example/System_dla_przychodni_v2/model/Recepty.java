package com.example.System_dla_przychodni_v2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Recepty {

    @Id
    private long idRecepty;
    private String dataWystawienia;
    private String dawkowanie;
    private String nazwaLeku;
    private int ilosc;
    @OneToOne
    @JoinColumn(name = "id_pacjenta")
    private Pacjent pacjent;
    @OneToOne
    @JoinColumn(name = "id_wizyty")
    private Wizyty wizyty;

    public long getIdRecepty() {
        return idRecepty;
    }

    public void setIdRecepty(long idRecepty) {
        this.idRecepty = idRecepty;
    }

    public String getDataWystawienia() {
        return dataWystawienia;
    }

    public void setDataWystawienia(String dataWystawienia) {
        this.dataWystawienia = dataWystawienia;
    }

    public String getDawkowanie() {
        return dawkowanie;
    }

    public void setDawkowanie(String dawkowanie) {
        this.dawkowanie = dawkowanie;
    }

    public String getNazwaLeku() {
        return nazwaLeku;
    }

    public void setNazwaLeku(String nazwaLeku) {
        this.nazwaLeku = nazwaLeku;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }

    public Wizyty getWizyty() {
        return wizyty;
    }

    public void setWizyty(Wizyty wizyty) {
        this.wizyty = wizyty;
    }

    @Override
    public String toString() {
        return "Recepty{" +
                "idRecepty=" + idRecepty +
                ", dataWystawienia='" + dataWystawienia + '\'' +
                ", dawkowanie='" + dawkowanie + '\'' +
                ", nazwaLeku='" + nazwaLeku + '\'' +
                ", ilosc=" + ilosc +
                ", pacjent=" + pacjent +
                ", wizyty=" + wizyty +
                '}';
    }
}
