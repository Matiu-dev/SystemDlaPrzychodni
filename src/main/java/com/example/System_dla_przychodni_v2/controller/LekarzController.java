package com.example.System_dla_przychodni_v2.controller;

import com.example.System_dla_przychodni_v2.model.Lekarz;
import com.example.System_dla_przychodni_v2.model.Pacjent;
import com.example.System_dla_przychodni_v2.model.Uzytkownik;
import com.example.System_dla_przychodni_v2.repository.LekarzRepository;
import com.example.System_dla_przychodni_v2.repository.PacjentRepository;
import com.example.System_dla_przychodni_v2.repository.UzytkownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LekarzController {

    @Autowired
    private LekarzRepository lekarzRepository;
    @PostMapping("/createLekarz")
    public ResponseEntity<Void> addUser(@RequestBody Lekarz lekarzRequest) {

        lekarzRepository.save(lekarzRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteLekarz/{idLekarza}")
    public ResponseEntity<Void> deleteUser(@PathVariable long idLekarza) {

        lekarzRepository.deleteById(idLekarza);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getLekarz/{idLekarza}")
    public Lekarz getUser(@PathVariable long idLekarza) {

        return lekarzRepository.findById(idLekarza);
    }
}
