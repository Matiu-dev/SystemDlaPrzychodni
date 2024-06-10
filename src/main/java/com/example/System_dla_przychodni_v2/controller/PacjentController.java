package com.example.System_dla_przychodni_v2.controller;

import com.example.System_dla_przychodni_v2.model.Pacjent;
import com.example.System_dla_przychodni_v2.model.Uzytkownik;
import com.example.System_dla_przychodni_v2.repository.PacjentRepository;
import com.example.System_dla_przychodni_v2.repository.UzytkownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PacjentController {

    @Autowired
    private PacjentRepository pacjentRepository;
    @Autowired
    private UzytkownikRepository uzytkownikRepository;
    @PostMapping("/createPacjent")
    public ResponseEntity<Void> addUser(@RequestBody Pacjent pacjentRequest) {

        Uzytkownik uzytkownik = uzytkownikRepository.findById(pacjentRequest.getUzytkownik().getIdUzytkownika());

        pacjentRequest.setUzytkownik(uzytkownik);
        pacjentRepository.save(pacjentRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deletePacjent/{idPacjenta}")
    public ResponseEntity<Void> deletePacjent(@PathVariable long idPacjenta) {

        pacjentRepository.deleteById(idPacjenta);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getPacjent/{idPacjenta}")
    public Pacjent getPacjent(@PathVariable long idPacjenta) {

        return pacjentRepository.findById(idPacjenta);
    }
}
