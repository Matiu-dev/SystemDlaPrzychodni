package com.example.System_dla_przychodni_v2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class KartaPacjenta {

    @Id
    private long idKartaPacjenta;
    private String dataUtworzenia;
    private String historiaLeczenia;
    @ManyToOne
    @JoinColumn(name = "id_pacjenta")
    private Pacjent pacjent;
    @ManyToOne
    @JoinColumn(name = "id_wizyty")
    private Wizyty wizyty;

    public long getIdKartaPacjenta() {
        return idKartaPacjenta;
    }

    public void setIdKartaPacjenta(long idKartaPacjenta) {
        this.idKartaPacjenta = idKartaPacjenta;
    }

    public String getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(String dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public String getHistoriaLeczenia() {
        return historiaLeczenia;
    }

    public void setHistoriaLeczenia(String historiaLeczenia) {
        this.historiaLeczenia = historiaLeczenia;
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
}
