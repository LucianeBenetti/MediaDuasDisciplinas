package luciane.senac.mediaduasdisciplinas.controller;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import luciane.senac.mediaduasdisciplinas.R;
import luciane.senac.mediaduasdisciplinas.model.Boletim;
import luciane.senac.mediaduasdisciplinas.model.Disciplina;
import luciane.senac.mediaduasdisciplinas.model.DisciplinaBO;
import luciane.senac.mediaduasdisciplinas.uteis.Constantes;
import luciane.senac.mediaduasdisciplinas.view.ResultadoActivity;

public class Disciplina2Control {
    private Activity activity;
    private EditText editNome;
    private NumberPicker npNota1;
    private NumberPicker npNota2;
    private NumberPicker npNota3;

    public Disciplina2Control(Activity activity) {
        this.activity = activity;
        initComponents();
    }
    public void initComponents(){
        editNome = activity.findViewById(R.id.editNomeDisciplina2);
        npNota1 = activity.findViewById(R.id.npNota1D2);
        npNota2 = activity.findViewById(R.id.npNota2D2);
        npNota3 = activity.findViewById(R.id.npNota3D2);
        configurarNumberPicker();
    }

    private void configurarNumberPicker() {
        npNota1.setMinValue(0);
        npNota1.setMaxValue(10);
        npNota1.setValue(0);

        npNota2.setMinValue(0);
        npNota2.setMaxValue(10);
        npNota2.setValue(0);

        npNota3.setMinValue(0);
        npNota3.setMaxValue(10);
        npNota3.setValue(0);
    }

    public boolean valida(DisciplinaBO disciplinaBO){
        if(!disciplinaBO.validaNota1()){
            Toast.makeText(activity, "Digite a nota corretamente", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!disciplinaBO.validaNota2()){
            Toast.makeText(activity, "Digite a nota corretamente", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!disciplinaBO.validaNota3()){
            Toast.makeText(activity, "Digite a nota corretamente", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!disciplinaBO.validaNomeDiciplina()){
            editNome.setError("Preencha corretamente o nome");
            return false;
        }
        return true;
    }
    public void proximoAction(){
        Disciplina disciplina2 = new Disciplina();
        disciplina2.setDisciplina(editNome.getText().toString());
        disciplina2.setNota1((double) npNota1.getValue());
        disciplina2.setNota2((double) npNota2.getValue());
        disciplina2.setNota3((double) npNota3.getValue());

        DisciplinaBO disciplinaBO = new DisciplinaBO(disciplina2);
        Disciplina disciplina1 = (Disciplina) activity.getIntent().getSerializableExtra(Constantes.Parametros.DISCIPLINA1);

        if(valida(disciplinaBO)){
            Intent it = new Intent(activity, ResultadoActivity.class);
            it.putExtra("disciplina1", disciplina1);
            it.putExtra("disciplina2", disciplina2);
            activity.startActivity(it);
        }
    }
}
