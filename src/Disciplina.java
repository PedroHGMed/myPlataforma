import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Disciplina {
    private String nome;
    private String codigo;
    private String professor;
    private List<Tarefa> tarefas;
    private List<Prova> provas;

    public Disciplina(String nome, String codigo, String professor) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome da disciplina não pode ser vazio.");
        }
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("O código da disciplina não pode ser vazio.");
        }
        this.nome = nome;
        this.codigo = codigo;
        this.professor = professor;
        this.tarefas = new ArrayList<>();
        this.provas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        if (tarefa == null) {
            throw new IllegalArgumentException("A tarefa não pode ser nula.");
        }
        tarefas.add(tarefa);
    }

    public void adicionarProva(Prova prova) {
        if (prova == null) {
            throw new IllegalArgumentException("A prova não pode ser nula.");
        }
        provas.add(prova);
    }

    /** Retorna a porcentagem (0 a 100) de tarefas concluídas. */
    public double calcularProgresso() {
        if (tarefas.isEmpty()) {
            return 0.0;
        }
        long concluidas = tarefas.stream().filter(Tarefa::isConcluida).count();
        return (concluidas * 100.0) / tarefas.size();
    }

    public double calcularMediaPonderada() {
        double totalNotas = 0;
        double totalPesos = 0;

        for (Prova p : provas) {
            if (p.foiRealizada()) {
                totalNotas += p.getNota() * p.getPeso();
                totalPesos += p.getPeso();
            }
        }

        if (totalPesos == 0) {
            return 0;
        }

        return totalNotas / totalPesos;
    }

    public String getNome() { return nome; }
    public String getCodigo() { return codigo; }
    public String getProfessor() { return professor; }

    // Listas somente leitura: quem usa a classe não consegue alterar a lista por fora
    public List<Tarefa> getTarefas() { return Collections.unmodifiableList(tarefas); }
    public List<Prova> getProvas() { return Collections.unmodifiableList(provas); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(codigo).append(" - ").append(nome)
                .append(" (Prof. ").append(professor).append(")\n");
        sb.append(String.format("Progresso: %.1f%%\n", calcularProgresso()));
        sb.append("Tarefas:\n");
        for (Tarefa t : tarefas) {
            sb.append("  - ").append(t).append("\n");
        }
        sb.append("Provas:\n");
        for (Prova p : provas) {
            sb.append("  - ").append(p).append("\n");
        }
        return sb.toString();
    }
}