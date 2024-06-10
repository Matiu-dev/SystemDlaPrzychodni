package com.example.System_dla_przychodni_v2.controller;

import com.example.System_dla_przychodni_v2.model.Pacjent;
import com.example.System_dla_przychodni_v2.model.UnikalneKodyPacjentow;
import com.example.System_dla_przychodni_v2.model.Uzytkownik;
import com.example.System_dla_przychodni_v2.repository.PacjentRepository;
import com.example.System_dla_przychodni_v2.repository.UnikalnyKodPacjentaRepository;
import com.example.System_dla_przychodni_v2.repository.UzytkownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UnikalnyKodPacjentaController {

    @Autowired
    private PacjentRepository pacjentRepository;
    @Autowired
    private UnikalnyKodPacjentaRepository unikalnyKodPacjentaRepository;
    @PostMapping("/createUnikalnyKodPacjenta")
    public ResponseEntity<Void> addUnikalnyKodPacjenta(@RequestBody UnikalneKodyPacjentow unikalneKodyPacjentow) {
//
        Pacjent pacjent = pacjentRepository.findById(unikalneKodyPacjentow.getPacjent().getIdPacjenta());

        unikalneKodyPacjentow.setPacjent(pacjent);

        unikalnyKodPacjentaRepository.save(unikalneKodyPacjentow);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUnikalnyKodPacjenta/{idUnikalnyKodPacjenta}")
    public ResponseEntity<Void> deleteUnikalnyKodPacjenta(@PathVariable long idUnikalnyKodPacjenta) {

        unikalnyKodPacjentaRepository.deleteById(idUnikalnyKodPacjenta);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getUnikalnyKodPacjenta/{idUnikalnyKodPacjenta}")
    public UnikalneKodyPacjentow getUnikalnyKodPacjenta(@PathVariable long idUnikalnyKodPacjenta) {

        return unikalnyKodPacjentaRepository.findById(idUnikalnyKodPacjenta);
    }
}
