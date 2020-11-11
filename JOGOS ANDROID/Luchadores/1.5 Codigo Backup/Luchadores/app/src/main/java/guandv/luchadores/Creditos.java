package guandv.luchadores;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class Creditos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.creditos);



        voltar();


    }

    private void voltar() {
        final Button switchact = (Button) findViewById(R.id.voltar);
        switchact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               finish();

            }
        });
    }
}
