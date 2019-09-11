package luciane.senac.mediaduasdisciplinas.controller;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import luciane.senac.mediaduasdisciplinas.R;
import luciane.senac.mediaduasdisciplinas.model.Boletim;
import luciane.senac.mediaduasdisciplinas.model.BoletimBO;
import luciane.senac.mediaduasdisciplinas.model.Disciplina;
import luciane.senac.mediaduasdisciplinas.model.DisciplinaBO;
import luciane.senac.mediaduasdisciplinas.uteis.Constantes;
import luciane.senac.mediaduasdisciplinas.view.Disciplina2Activity;

public class MainControl {

    private Activity activity;
    private EditText editNome;
    private NumberPicker npNota1;
    private NumberPicker npNota2;
    private NumberPicker npNota3;

    public MainControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }
    public void initComponents(){
        editNome = activity.findViewById(R.id.editNomeDisciplina1);
        npNota1 = activity.findViewById(R.id.npNota1);
        npNota2 = activity.findViewById(R.id.npNota2);
        npNota3 = activity.findViewById(R.id.npNota3);
        configurarNumberPicker(npNota1);
        configurarNumberPicker(npNota2);
        configurarNumberPicker(npNota3);
    }

    private void configurarNumberPicker(NumberPicker np) {
        np.setMinValue(Constantes.Nota.MINIMO);
        np.setMaxValue(Constantes.Nota.MAXIMO);
        np.setValue(0);
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
        Disciplina disciplina1 = new Disciplina();
        disciplina1.setDisciplina(editNome.getText().toString());
        disciplina1.setNota1((double) npNota1.getValue());
        disciplina1.setNota2((double) npNota2.getValue());
        disciplina1.setNota3((double) npNota3.getValue());

        DisciplinaBO disciplinaBO= new DisciplinaBO(disciplina1);

        if(valida(disciplinaBO)){
            Intent it = new Intent(activity, Disciplina2Activity.class);
            it.putExtra(Constantes.Parametros.DISCIPLINA1, disciplina1);
            activity.startActivity(it);
        }
    }

}
