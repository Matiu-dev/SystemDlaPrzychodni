package com.example.System_dla_przychodni_v2.repository;

import com.example.System_dla_przychodni_v2.model.Wizyty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WizytyRepository extends JpaRepository<Wizyty, Long> {
    Wizyty findById(long id);
}
