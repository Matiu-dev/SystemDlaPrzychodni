package com.example.System_dla_przychodni_v2.repository;

import com.example.System_dla_przychodni_v2.model.KartaPacjenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KartaPacjentaRepository extends JpaRepository<KartaPacjenta, Long> {

    KartaPacjenta findById(long kartaPacjentaId);
}
