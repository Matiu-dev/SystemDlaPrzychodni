package com.example.System_dla_przychodni_v2.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Pacjent {

    @Id
    @Column(name="id_pacjenta")
    private long idPacjenta;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUzytkownika",
            referencedColumnName = "idUzytkownika")
    private Uzytkownik uzytkownik;
    @OneToOne(mappedBy = "pacjent", cascade = CascadeType.ALL)
    private UnikalneKodyPacjentow unikalneKodyPacjentow;
    @OneToOne(mappedBy = "pacjent", cascade = CascadeType.ALL)
    private Recepty recepty;
    private String imie;
    private String nazwisko;
    private int pesel;
    private int numerTelefonu;
    private String dataUrodzenia;
    private String adres;

    @OneToMany(mappedBy = "pacjent")
    private Set<Wizyty> wizyty;

    @OneToMany(mappedBy = "pacjent")
    private Set<KartaPacjenta> kartaPacjenta;

    public long getIdPacjenta() {
        return idPacjenta;
    }

    public void setIdPacjenta(long idPacjenta) {
        this.idPacjenta = idPacjenta;
    }

//    public UnikalneKodyPacjentow getUnikalneKodyPacjentow() {
//        return unikalneKodyPacjentow;
//    }
//
//    public void setUnikalneKodyPacjentow(UnikalneKodyPacjentow unikalneKodyPacjentow) {
//        this.unikalneKodyPacjentow = unikalneKodyPacjentow;
//    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public int getNumerTelefonu() {
        return numerTelefonu;
    }

    public void setNumerTelefonu(int numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(String dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}

//  "imie": "xd",
//  "nazwisko": "xd",
//  "pesel": 654321,
//  "numerTelefonu": 654321,
//  "dataUrodzenia": "2051-06-05",
//  "adres": "tajne"
