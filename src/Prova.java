import java.time.LocalDate;

public class Prova {
    private String nome;
    private LocalDate data;
    private Double nota; // null enquanto a prova não foi feita
    private double peso;

    public Prova(String nome, LocalDate data, double peso) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome da prova não pode ser vazio.");
        }
        if (data == null) {
            throw new IllegalArgumentException("A data da prova não pode ser nula.");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("O peso deve ser maior que zero.");
        }
        this.nome = nome;
        this.data = data;
        this.peso = peso;
        this.nota = null;
    }

    public boolean foiRealizada() {
        return nota != null;
    }

    public void registrarNota(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
        }
        this.nota = nota;
    }

    public String getNome() { return nome; }
    public LocalDate getData() { return data; }
    public Double getNota() { return nota; }
    public double getPeso() { return peso; }

    @Override
    public String toString() {
        String notaTexto = foiRealizada() ? String.format("%.1f", nota) : "sem nota";
        return nome + " (" + data + ", peso " + peso + ") - " + notaTexto;
    }
}