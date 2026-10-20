import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private int codigo;
    private String professor;
    private ArrayList <Tarefa> tarefas;
    private ArrayList <Prova> provas;

    public Disciplina(String nome, int codigo, String professor) {
        this.nome = nome;
        this.codigo = codigo;
        this.professor = professor;
        this.tarefas = new ArrayList<Tarefa>();
        this.provas = new ArrayList<Prova>();
    }
}
