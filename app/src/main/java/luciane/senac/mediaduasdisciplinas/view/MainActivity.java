package luciane.senac.mediaduasdisciplinas.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import luciane.senac.mediaduasdisciplinas.R;
import luciane.senac.mediaduasdisciplinas.controller.MainControl;

public class MainActivity extends AppCompatActivity {
    private MainControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new MainControl(this);
    }

    public void proxima (View v){
        control.proximoAction();
    }

}
