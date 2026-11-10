package com.example.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;


@Controller 
public class PerhitunganController {
    
    @Autowired
    private PerhitunganRepository PerhitunganRepository;

    @GetMapping("/perhitungan")
    public String tampilkanHalamanPerhitungan(Model model) {
        model.addAttribute("listRiwayatOperasi", PerhitunganRepository.findAll(Sort.by(Sort.Direction.ASC, "idOperasi")));
        model.addAttribute("perhitungan", new Perhitungan()); // Objek kosong untuk form input
        return "perhitungan";
    }

    @PostMapping("/perhitungan/simpan")
    public String postMethodName(@ModelAttribute Perhitungan perhitungan) throws IOException { 
        if (perhitungan.getIdOperasi() != null) {
            Perhitungan perhitunganLama = PerhitunganRepository.findById(perhitungan.getIdOperasi()).orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));
            perhitunganLama.setBilangan1(perhitungan.getBilangan1());
            perhitunganLama.setBilangan2(perhitungan.getBilangan2());
            perhitunganLama.setOperator(perhitungan.getOperator());

            PerhitunganRepository.save(perhitunganLama);

        } else {
            PerhitunganRepository.save(perhitungan);
        }

        return "redirect:/perhitungan";

    }

    
    @PostMapping("/perhitungan/delete/{id}")
    public String hapusData(@PathVariable Long id) {

        PerhitunganRepository.deleteById(id);

        return "redirect:/perhitungan";
    }


}
