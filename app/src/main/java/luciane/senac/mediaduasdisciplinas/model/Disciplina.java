package luciane.senac.mediaduasdisciplinas.model;

import java.io.Serializable;

public class Disciplina implements Serializable {

    private String disciplina;
    private Double nota1;
    private Double nota2;
    private Double nota3;

    public Disciplina() {
    }

    public Disciplina(String disciplina, Double nota1, Double nota2, Double nota3) {
        this.disciplina = disciplina;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public Double getNota3() {
        return nota3;
    }

    public void setNota3(Double nota3) {
        this.nota3 = nota3;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "disciplina='" + disciplina + '\'' +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", nota3=" + nota3 +
                '}';
    }
}
