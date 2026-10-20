import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();

        Disciplina p2 = new Disciplina("Programação 2", "CC102", "Prof. Silva");
        Tarefa t1 = new Tarefa("Lista de exercícios 1", "Classes e objetos", hoje.minusDays(5));
        Tarefa t2 = new Tarefa("Projeto parcial", "Implementar o sistema", hoje.plusDays(7));
        Tarefa t3 = new Tarefa("Lista de exercícios 2", "Herança", hoje.minusDays(2));
        t3.marcarComoConcluida();
        p2.adicionarTarefa(t1); // atrasada
        p2.adicionarTarefa(t2); // pendente
        p2.adicionarTarefa(t3); // concluída

        Prova ab1 = new Prova("AB1", hoje.minusDays(10), 1.0);
        ab1.registrarNota(8.5);
        p2.adicionarProva(ab1);
        p2.adicionarProva(new Prova("AB2", hoje.plusDays(20), 1.0));

        Disciplina calc = new Disciplina("Cálculo 1", "MAT101", "Profa. Souza");
        Tarefa c1 = new Tarefa("Lista de limites", "Limites e continuidade", hoje.minusDays(1));
        c1.marcarComoConcluida();
        Tarefa c2 = new Tarefa("Lista de derivadas", "Regras de derivação", hoje.plusDays(3));
        calc.adicionarTarefa(c1);
        calc.adicionarTarefa(c2);
        calc.adicionarProva(new Prova("Prova 1", hoje.plusDays(10), 2.0));

        System.out.println(p2);
        System.out.println(calc);

        // Testando validação
        try {
            ab1.registrarNota(11);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}