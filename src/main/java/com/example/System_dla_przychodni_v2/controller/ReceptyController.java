package com.example.System_dla_przychodni_v2.controller;

import com.example.System_dla_przychodni_v2.model.Pacjent;
import com.example.System_dla_przychodni_v2.model.Recepty;
import com.example.System_dla_przychodni_v2.model.Uzytkownik;
import com.example.System_dla_przychodni_v2.model.Wizyty;
import com.example.System_dla_przychodni_v2.repository.PacjentRepository;
import com.example.System_dla_przychodni_v2.repository.ReceptyRepository;
import com.example.System_dla_przychodni_v2.repository.UzytkownikRepository;
import com.example.System_dla_przychodni_v2.repository.WizytyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReceptyController {

    @Autowired
    private PacjentRepository pacjentRepository;
    @Autowired
    private WizytyRepository wizytyRepository;
    @Autowired
    private ReceptyRepository receptyRepository;

    @PostMapping("/createRecepty")
    public ResponseEntity<Void> addRecepty(@RequestBody Recepty recepty) {

        Pacjent pacjent = pacjentRepository.findById(recepty.getPacjent().getIdPacjenta());
        Wizyty wizyty = wizytyRepository.findById(recepty.getWizyty().getIdWizyty());

        recepty.setPacjent(pacjent);
        recepty.setWizyty(wizyty);

        receptyRepository.save(recepty);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteRecepty/{idRecepty}")
    public ResponseEntity<Void> deleteRecepty(@PathVariable long idRecepty) {

        System.out.println("delete recepty " + receptyRepository.findById(idRecepty));

        receptyRepository.deleteById(idRecepty);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getRecepty/{idRecepty}")
    public Recepty getRecepty(@PathVariable long idRecepty) {

        return receptyRepository.findById(idRecepty);
    }
}
