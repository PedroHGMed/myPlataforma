package com.example.demo.controller;

import com.example.demo.model.Disciplina;
import com.example.demo.model.Prova;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DisciplinaController {

    @GetMapping("/disciplinas")
    public List<Disciplina> ola() {
        Disciplina fmcc1 = new Disciplina("fmcc1", "67", "Everton");
        Disciplina IC = new Disciplina("IC", "42", "Joseana");
        fmcc1.adicionarProva(new Prova("Polinomios", LocalDate.of(2026, 3, 16), 1));
        IC.adicionarProva(new Prova("Polinomios", LocalDate.of(2026, 3, 13), 1.5));
        List<Disciplina> discs = new ArrayList<>();
        discs.add(fmcc1);
        discs.add(IC);
        return discs;
    }
}