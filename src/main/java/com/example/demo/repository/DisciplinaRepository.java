package com.example.demo.repository;

import com.example.demo.model.Disciplina;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DisciplinaRepository {
    private final Map<Long, Disciplina> disciplinas = new HashMap<>();
    private Long proximoId = 1L;

    public List<Disciplina> listarTodas() {
        // TODO
    }

}
