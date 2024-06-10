package com.example.System_dla_przychodni_v2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Lekarz {

    @Id
    private long idLekarza;
    private String specjalizacja;

    @OneToMany(mappedBy = "lekarz")
    Set<Wizyty> wizyty;

    public long getIdLekarza() {
        return idLekarza;
    }

    public void setIdLekarza(long idLekarza) {
        this.idLekarza = idLekarza;
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(String specjalizacja) {
        this.specjalizacja = specjalizacja;
    }
}
