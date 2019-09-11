package luciane.senac.mediaduasdisciplinas.model;

public class BoletimBO  {

    Boletim boletim;
    private double mediaFinal;

    public BoletimBO(Boletim boletim) {

        this.boletim = boletim;
    }

    public double getMedia(){
        DisciplinaBO disciplinaBO1 = new DisciplinaBO(boletim.getDisciplina1());
        DisciplinaBO disciplinaBO2 = new DisciplinaBO(boletim.getDisciplina2());
        double media1 = disciplinaBO1.getMedia();
        double media2 = disciplinaBO2.getMedia();
        mediaFinal = (media1 + media2)/2;
        return mediaFinal;
    }

    public boolean getSituacaogeral(){

        return mediaFinal >=7;
    }

    public String getTextoSituacao(){

        if(getSituacaogeral())
            return "Aprovado";
        else
            return "Reprovado";
    }
}
