package com.example.System_dla_przychodni_v2.controller;

import com.example.System_dla_przychodni_v2.model.Lekarz;
import com.example.System_dla_przychodni_v2.model.Pacjent;
import com.example.System_dla_przychodni_v2.model.Uzytkownik;
import com.example.System_dla_przychodni_v2.model.Wizyty;
import com.example.System_dla_przychodni_v2.repository.LekarzRepository;
import com.example.System_dla_przychodni_v2.repository.PacjentRepository;
import com.example.System_dla_przychodni_v2.repository.WizytyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WizytyController {

    @Autowired
    private WizytyRepository wizytyRepository;
    @Autowired
    private PacjentRepository pacjentRepository;
    @Autowired
    private LekarzRepository lekarzRepository;

    @PostMapping("/createWizyty")
    public ResponseEntity<Void> addUser(@RequestBody Wizyty wizyty) {

        Pacjent pacjent = pacjentRepository.findById(wizyty.getPacjent().getIdPacjenta());
        Lekarz lekarz = lekarzRepository.findById(wizyty.getLekarz().getIdLekarza());

        wizyty.setPacjent(pacjent);
        wizyty.setLekarz(lekarz);

        wizytyRepository.save(wizyty);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteWizyty/{idWizyty}")
    public ResponseEntity<Void> deleteWizyty(@PathVariable long idWizyty) {

        wizytyRepository.deleteById(idWizyty);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getWizyty/{idWizyty}")
    public Wizyty getUser(@PathVariable long idWizyty) {

        return wizytyRepository.findById(idWizyty);
    }
}
