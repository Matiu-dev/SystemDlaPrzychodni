package com.example.System_dla_przychodni_v2.repository;

import com.example.System_dla_przychodni_v2.model.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UzytkownikRepository extends JpaRepository<Uzytkownik, Long> {

    Uzytkownik findById(long id);
}
