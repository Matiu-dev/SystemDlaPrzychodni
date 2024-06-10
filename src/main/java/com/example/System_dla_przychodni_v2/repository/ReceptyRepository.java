package com.example.System_dla_przychodni_v2.repository;

import com.example.System_dla_przychodni_v2.model.Recepty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptyRepository extends JpaRepository<Recepty, Long> {

    Recepty findById(long idRecepty);
}
