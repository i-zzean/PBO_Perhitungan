package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerhitunganRepository extends JpaRepository<Perhitungan, Long> {
    // Menyediakan method findAll(), save(), findById(), dll secara otomatis
}