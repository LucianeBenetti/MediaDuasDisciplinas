package luciane.senac.mediaduasdisciplinas.controller;

import android.app.Activity;
import android.widget.TextView;

import luciane.senac.mediaduasdisciplinas.R;
import luciane.senac.mediaduasdisciplinas.model.Boletim;
import luciane.senac.mediaduasdisciplinas.model.BoletimBO;
import luciane.senac.mediaduasdisciplinas.model.Disciplina;
import luciane.senac.mediaduasdisciplinas.model.DisciplinaBO;

public class ResultadoControl {

    private Activity activity;
    private TextView tvDisciplina1;
    private TextView tvMedia1;
    private TextView tvSituacao1;
    private TextView tvDisciplina2;
    private TextView tvMedia2;
    private TextView tvSituacao2;
    private TextView tvMediaGeral;
    private TextView tvSituacaoGeral;


    public ResultadoControl(Activity activity) {
        this.activity = activity;
        initComponents();
        showResultado();
    }

    private void initComponents() {

      tvDisciplina1 = activity.findViewById(R.id.tvDisciplina1);
      tvMedia1 = activity.findViewById(R.id.tvMedia1);
      tvSituacao1 = activity.findViewById(R.id.tvSituacao1);
      tvDisciplina2 = activity.findViewById(R.id.tvDisciplina2);
      tvMedia2 = activity.findViewById(R.id.tvMedia2);
      tvSituacao2 = activity.findViewById(R.id.tvSituacao2);
      tvMediaGeral = activity.findViewById(R.id.tvMediaGeral);
      tvSituacaoGeral = activity.findViewById(R.id.tvSituacaoGeral);
    }

    private void showResultado(){
        //resgatar parametro envidado pela activity chamadora
      Disciplina disciplina1 = (Disciplina) activity.getIntent().getSerializableExtra("disciplina1");
      Disciplina disciplina2 = (Disciplina) activity.getIntent().getSerializableExtra("disciplina2");

               tvDisciplina1.setText("Disciplina1: " + disciplina1.getDisciplina());
               DisciplinaBO disciplinaBO = new DisciplinaBO(disciplina1);
               tvMedia1.setText(String.valueOf(disciplinaBO.getMedia()));
               tvSituacao1.setText(disciplinaBO.getTextoAprovado());

               tvDisciplina2.setText("Disciplina2: " + disciplina2.getDisciplina());
               DisciplinaBO disciplinaBO2 = new DisciplinaBO(disciplina2);
               tvMedia2.setText(String.valueOf(disciplinaBO2.getMedia()));
               tvSituacao2.setText(disciplinaBO2.getTextoAprovado());

               Boletim boletim = new Boletim(disciplina1, disciplina2);
               BoletimBO boletimBO = new BoletimBO(boletim);
               tvMediaGeral.setText(String.valueOf(boletimBO.getMedia()));
               tvSituacaoGeral.setText(boletimBO.getTextoSituacao());
           }

    public void voltarAction(){
        activity.finish();
    }
}


