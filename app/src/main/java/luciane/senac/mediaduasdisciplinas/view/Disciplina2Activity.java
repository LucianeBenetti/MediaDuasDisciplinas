package luciane.senac.mediaduasdisciplinas.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import luciane.senac.mediaduasdisciplinas.R;
import luciane.senac.mediaduasdisciplinas.controller.Disciplina2Control;

public class Disciplina2Activity extends AppCompatActivity {

    private Disciplina2Control control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplina2);
        control = new Disciplina2Control(this);
    }

    public void proxima (View v){
        control.proximoAction();
    }
}
