package luciane.senac.mediaduasdisciplinas.model;

import luciane.senac.mediaduasdisciplinas.uteis.Constantes;

public class DisciplinaBO {
    private Disciplina disciplina;
    private Double mediaDisciplina;

    public DisciplinaBO(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Double getMedia(){
        Double nota1 = disciplina.getNota1();
        Double nota2 = disciplina.getNota2();
        Double nota3 = disciplina.getNota3();
        mediaDisciplina = (nota1 + nota2 + nota3)/3;
        return mediaDisciplina;
    }

    public boolean isAprovado(){

        return mediaDisciplina >= Constantes.Nota.MEDIA_APROVACAO;
    }

    public String getTextoAprovado(){

        if(isAprovado())
            return "Aprovado";
        else
            return "Reprovado";
    }

    public boolean validaNota1(){
        return this.disciplina.getNota1()!=null
                && this.disciplina.getNota1()>=0;
    }
    public boolean validaNota2(){
        return this.disciplina.getNota2()!=null
                && this.disciplina.getNota2()>=0;
    }
    public boolean validaNota3(){
        return this.disciplina.getNota3()!=null
                && this.disciplina.getNota3()>=0;
    }

    public boolean validaNomeDiciplina(){
        return this.disciplina.getDisciplina() != null
                && !this.disciplina.getDisciplina().isEmpty();
    }


}
