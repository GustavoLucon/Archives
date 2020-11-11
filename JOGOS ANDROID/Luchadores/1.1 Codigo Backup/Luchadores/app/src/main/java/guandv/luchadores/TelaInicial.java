package guandv.luchadores;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tela_inicial);



        EntrarGuest();
        EntrarFB();


    }

    private void EntrarGuest() {
        final Button switchact = (Button) findViewById(R.id.EntrarGuest);
        switchact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent act2 = new Intent(view.getContext(), ChampSelect.class);
                startActivity(act2);

            }
        });
    }
    private void EntrarFB() {
        final Button switchact = (Button) findViewById(R.id.LoginFB);
        switchact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(TelaInicial.this,"Ainda nao implementado", Toast.LENGTH_LONG).show();

            }
        });
    }
}
