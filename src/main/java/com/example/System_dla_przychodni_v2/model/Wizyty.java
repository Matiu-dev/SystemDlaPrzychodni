package com.example.System_dla_przychodni_v2.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Wizyty {

    @Id
    private long idWizyty;

    @ManyToOne
    @JoinColumn(name = "id_pacjenta")
    private Pacjent pacjent;

    @ManyToOne
    @JoinColumn(name = "id_lekarza")
    private Lekarz lekarz;

    @OneToMany(mappedBy = "wizyty")
    Set<KartaPacjenta> kartaPacjenta;

    @OneToOne(mappedBy = "wizyty", cascade = CascadeType.ALL)
    private Recepty recepty;

    private String dataWizyty;
    private String historiaLeczenia;

    public long getIdWizyty() {
        return idWizyty;
    }

    public void setIdWizyty(long idWizyty) {
        this.idWizyty = idWizyty;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }

    public Lekarz getLekarz() {
        return lekarz;
    }

    public void setLekarz(Lekarz lekarz) {
        this.lekarz = lekarz;
    }

    public String getDataWizyty() {
        return dataWizyty;
    }

    public void setDataWizyty(String dataWizyty) {
        this.dataWizyty = dataWizyty;
    }

    public String getHistoriaLeczenia() {
        return historiaLeczenia;
    }

    public void setHistoriaLeczenia(String historiaLeczenia) {
        this.historiaLeczenia = historiaLeczenia;
    }
}
