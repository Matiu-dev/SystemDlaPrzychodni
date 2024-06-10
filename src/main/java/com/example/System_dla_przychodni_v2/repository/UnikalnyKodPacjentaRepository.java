package com.example.System_dla_przychodni_v2.repository;

import com.example.System_dla_przychodni_v2.model.UnikalneKodyPacjentow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnikalnyKodPacjentaRepository extends JpaRepository<UnikalneKodyPacjentow, Long> {

    UnikalneKodyPacjentow findById(long UnikalnyKodPacjenta);
}
