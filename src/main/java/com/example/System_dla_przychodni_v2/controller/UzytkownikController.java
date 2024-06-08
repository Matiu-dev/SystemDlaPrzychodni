package com.example.System_dla_przychodni_v2.controller;

import com.example.System_dla_przychodni_v2.model.Uzytkownik;
import com.example.System_dla_przychodni_v2.repository.UzytkownikRepository;
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
    public void addUser(@RequestBody Uzytkownik uzytkownikRequest) {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

//        System.out.println(uzytkownikRequest.getIdUzytkownika());

        uzytkownikRepository.save(uzytkownikRequest);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser() {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    }

    @GetMapping("/getUser/{idUzytkownika}")
    public Uzytkownik getUser(@PathVariable long idUzytkownika) {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        return uzytkownikRepository.findById(idUzytkownika);
    }
}
