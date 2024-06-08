package com.example.System_dla_przychodni_v2.controller;

import com.example.System_dla_przychodni_v2.model.Uzytkownik;
import com.example.System_dla_przychodni_v2.repository.UzytkownikRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UzytkownikController {

    private UzytkownikRepository uzytkownikRepository;

    public UzytkownikController(UzytkownikRepository uzytkownikRepository) {
        this.uzytkownikRepository = uzytkownikRepository;
    }

    @PostMapping("/createUser")
    public ResponseEntity<Void> addUser(@RequestBody Uzytkownik uzytkownikRequest) {
        uzytkownikRepository.save(uzytkownikRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@PathVariable long idUzytkownika) {

        uzytkownikRepository.deleteById(idUzytkownika);
    }

    @GetMapping("/getUser/{idUzytkownika}")
    public Uzytkownik getUser(@PathVariable long idUzytkownika) {

        return uzytkownikRepository.findById(idUzytkownika);
    }
}
