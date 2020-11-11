package guandv.luchadores;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Gustavo on 9/2/2016.
 */
public class Score extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.score);

        TextView viewresultado = (TextView) findViewById(R.id.resultado);

       Bundle extras = getIntent().getExtras();
        String transferido;

        if (extras != null) {
            transferido = extras.getString("edittextvalue");
            viewresultado.setText("PARABÉÉÉÉÉÉÉÉÉÉNS\nGRANDE LUCHADOR!\n\n OPONENTES DERROTADOS : " + transferido);

        }

        BotaoVs();
        BotaoMenu();
        BotaoNext();

    }

    private void BotaoVs() {
        final Button switchact = (Button) findViewById(R.id.botaomenu);
        switchact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }

    private void BotaoMenu() {
        final Button switchact = (Button) findViewById(R.id.botaomenu);
        switchact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent act2 = new Intent(view.getContext(), TelaInicial.class);
                startActivity(act2);

            }
        });
    }

    private void BotaoNext() {
        final Button switchact = (Button) findViewById(R.id.botaoNext);
        switchact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent act2 = new Intent(view.getContext(), Creditos.class);
                startActivity(act2);

            }
        });
    }
}


