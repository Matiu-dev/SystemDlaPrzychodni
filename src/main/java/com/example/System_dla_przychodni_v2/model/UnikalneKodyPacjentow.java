package com.example.System_dla_przychodni_v2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class UnikalneKodyPacjentow {

    @Id
    private long idUnikalneKody;
    private String unikalneKodyPacjentow;
    @OneToOne
    @JoinColumn(name = "id_pacjenta")
    private Pacjent pacjent;

    public long getIdUnikalneKody() {
        return idUnikalneKody;
    }

    public void setIdUnikalneKody(long idUnikalneKody) {
        this.idUnikalneKody = idUnikalneKody;
    }

    public String getUnikalneKodyPacjentow() {
        return unikalneKodyPacjentow;
    }

    public void setUnikalneKodyPacjentow(String unikalneKodyPacjentow) {
        this.unikalneKodyPacjentow = unikalneKodyPacjentow;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }
}
