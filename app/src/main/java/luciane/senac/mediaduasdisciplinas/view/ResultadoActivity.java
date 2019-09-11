package luciane.senac.mediaduasdisciplinas.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import luciane.senac.mediaduasdisciplinas.R;
import luciane.senac.mediaduasdisciplinas.controller.ResultadoControl;

public class ResultadoActivity extends AppCompatActivity {

    private ResultadoControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        control = new ResultadoControl(this);
    }

    public void voltar (View v){
        control.voltarAction();
    }
}