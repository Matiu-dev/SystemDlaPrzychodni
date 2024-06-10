package com.example.System_dla_przychodni_v2.model;

import jakarta.persistence.*;

@Entity
public class Uzytkownik {

    @Id
    private long idUzytkownika;
    private String haslo;
    private String dataRejestracji;
    private String email;
    @OneToOne(mappedBy = "uzytkownik")
    private Pacjent pacjent;

    public Uzytkownik() {}

    public Uzytkownik(long idUzytkownika, String haslo, String dataRejestracji, String email) {
        this.idUzytkownika = idUzytkownika;
        this.haslo = haslo;
        this.dataRejestracji = dataRejestracji;
        this.email = email;
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

    @Override
    public String toString() {
        return "Uzytkownik{" +
                "idUzytkownik=" + idUzytkownika +
                ", haslo='" + haslo + '\'' +
                ", dataRejestracji='" + dataRejestracji + '\'' +
                ", email='" + email + '\'' +
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