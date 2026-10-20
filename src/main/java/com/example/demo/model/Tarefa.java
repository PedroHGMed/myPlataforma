package com.example.demo.model;

import java.time.LocalDate;

public class Tarefa {
    private String titulo;
    private String descricao;
    private LocalDate dataEntrega;
    private boolean concluida;

    public Tarefa(String titulo, String descricao, LocalDate dataEntrega) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título da tarefa não pode ser vazio.");
        }
        if (dataEntrega == null) {
            throw new IllegalArgumentException("A data de entrega não pode ser nula.");
        }
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.concluida = false;
    }

    public void marcarComoConcluida() {
        this.concluida = true;
    }

    public boolean estaAtrasada() {
        return !concluida && dataEntrega.isBefore(LocalDate.now());
    }

    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public LocalDate getDataEntrega() { return dataEntrega; }
    public boolean isConcluida() { return concluida; }

    @Override
    public String toString() {
        String status = concluida ? "Concluída" : (estaAtrasada() ? "ATRASADA" : "Pendente");
        return titulo + " (entrega: " + dataEntrega + ") - " + status;
    }
}