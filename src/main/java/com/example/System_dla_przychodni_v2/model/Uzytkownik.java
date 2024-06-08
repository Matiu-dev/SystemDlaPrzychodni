package com.example.System_dla_przychodni_v2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Uzytkownik {

    @Id
    private long idUzytkownika;
    private String haslo;
    private String dataRejestracji;
    private String email;
    private String imie;
    private String nazwisko;

    private int pesel;
    private int numerTelefonu;
    private String dataUrodzenia;
    private String adres;

    public Uzytkownik() {}

    public Uzytkownik(long idUzytkownika, String haslo, String dataRejestracji, String email, String imie, String nazwisko, int pesel, int numerTelefonu, String dataUrodzenia, String adres) {
        this.idUzytkownika = idUzytkownika;
        this.haslo = haslo;
        this.dataRejestracji = dataRejestracji;
        this.email = email;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.numerTelefonu = numerTelefonu;
        this.dataUrodzenia = dataUrodzenia;
        this.adres = adres;
    }

    public long getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(long idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getDataRejestracji() {
        return dataRejestracji;
    }

    public void setDataRejestracji(String dataRejestracji) {
        this.dataRejestracji = dataRejestracji;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Uzytkownik{" +
                "idUzytkownika=" + idUzytkownika +
                ", haslo='" + haslo + '\'' +
                ", dataRejestracji='" + dataRejestracji + '\'' +
                ", email='" + email + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel=" + pesel +
                ", numerTelefonu=" + numerTelefonu +
                ", dataUrodzenia='" + dataUrodzenia + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }
}


//    CREATE TABLE `uzytkownicy` (
//        `id_uzytkownika` int NOT NULL,
//        `haslo` varchar(45) NOT NULL,
//        `data_rejestracji` date NOT NULL,
//        `email` varchar(45) NOT NULL,
//        `imie` varchar(45) NOT NULL,
//        `nazwisko` varchar(45) NOT NULL,
//        `pesel` int NOT NULL,
//        `numer_telefonu` int NOT NULL,
//        `data_urodzenia` date NOT NULL,
//        `adres` varchar(45) NOT NULL,
//        PRIMARY KEY (`id_uzytkownika`),
//        UNIQUE KEY `pesel_UNIQUE` (`pesel`),
//        UNIQUE KEY `email_UNIQUE` (`email`)
//        )