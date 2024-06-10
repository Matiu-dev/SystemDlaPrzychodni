package com.example.System_dla_przychodni_v2.controller;

import com.example.System_dla_przychodni_v2.model.*;
import com.example.System_dla_przychodni_v2.repository.KartaPacjentaRepository;
import com.example.System_dla_przychodni_v2.repository.LekarzRepository;
import com.example.System_dla_przychodni_v2.repository.PacjentRepository;
import com.example.System_dla_przychodni_v2.repository.WizytyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class KartaPacjentaKontroller {

    @Autowired
    private KartaPacjentaRepository kartaPacjentaRepository;
    @Autowired
    private PacjentRepository pacjentRepository;

    @Autowired
    private WizytyRepository wizytyRepository;

    @PostMapping("/createKartePacjenta")
    public ResponseEntity<Void> addUser(@RequestBody KartaPacjenta kartaPacjenta) {

        Wizyty wizyty = wizytyRepository.findById(kartaPacjenta.getWizyty().getIdWizyty());
        Pacjent pacjent = pacjentRepository.findById(kartaPacjenta.getPacjent().getIdPacjenta());

        kartaPacjenta.setWizyty(wizyty);
        kartaPacjenta.setPacjent(pacjent);

        kartaPacjentaRepository.save(kartaPacjenta);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteKartePacjenta/{idKartaPacjenta}")
    public ResponseEntity<Void> deleteKartaPacjenta(@PathVariable long idKartaPacjenta) {

        kartaPacjentaRepository.deleteById(idKartaPacjenta);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getKartePacjenta/{idKartaPacjenta}")
    public KartaPacjenta getKartaPacjenta(@PathVariable long idKartaPacjenta) {

        return kartaPacjentaRepository.findById(idKartaPacjenta);
    }
}
