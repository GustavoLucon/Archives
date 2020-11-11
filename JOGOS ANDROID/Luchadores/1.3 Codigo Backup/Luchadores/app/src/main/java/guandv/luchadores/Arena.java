package guandv.luchadores;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Arena extends Activity {

    private int listaGolpes;
    private Luchadores player;
    private Luchadores adversario;
    private int derrotados;
    public boolean especial;
    public int cooldown;
    private int round;
    GifView gifView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.arena);

        round = 0;
        CriarJogo();
        setupAtaque();
        setupDefesa();
        setupAgarra();
        setupEspecial();
        setupRetry();
    }


    private void CriarJogo() {
        
        player = new Luchadores(3, 0);
        derrotados = 0;
        especial = false;
        cooldown =0;
        GerarAdversario();
        ConferirVidas();
    }

    private void ConferirVidas() {

        ImageView opVida1 = (ImageView) findViewById(R.id.opvida1);
        ImageView opVida2 = (ImageView) findViewById(R.id.opvida2);
        ImageView opVida3 = (ImageView) findViewById(R.id.opvida3);

        ImageView plVida1 = (ImageView) findViewById(R.id.plvida1);
        ImageView plVida2 = (ImageView) findViewById(R.id.plvida2);
        ImageView plVida3 = (ImageView) findViewById(R.id.plvida3);

        if(player.getVida()== 3)
        {
            plVida1.setVisibility(View.VISIBLE);
            plVida2.setVisibility(View.VISIBLE);
            plVida3.setVisibility(View.VISIBLE);
        }
        else if (player.getVida() == 2)
        {
            plVida1.setVisibility(View.VISIBLE);
            plVida2.setVisibility(View.VISIBLE);
            plVida3.setVisibility(View.INVISIBLE);
        }
        else
        {
            plVida1.setVisibility(View.VISIBLE);
            plVida2.setVisibility(View.INVISIBLE);
            plVida3.setVisibility(View.INVISIBLE);
        }

        if(adversario.getVida()== 3)
        {
            opVida1.setVisibility(View.VISIBLE);
            opVida2.setVisibility(View.VISIBLE);
            opVida3.setVisibility(View.VISIBLE);
        }
        else if (adversario.getVida() == 2)
        {
            opVida1.setVisibility(View.VISIBLE);
            opVida2.setVisibility(View.VISIBLE);
            opVida3.setVisibility(View.INVISIBLE);
        }
        else
        {
            opVida1.setVisibility(View.VISIBLE);
            opVida2.setVisibility(View.INVISIBLE);
            opVida3.setVisibility(View.INVISIBLE);
        }

    }

    private void GerarAdversario() {
        
        int dificuldade = 0;
        for (int i = 0; i < derrotados; i = i + 3) {
            dificuldade++;
        }
        adversario = new Luchadores(1 + dificuldade, 0);
        Toast.makeText(Arena.this, "Desafiante novo apareceu",
                Toast.LENGTH_LONG).show();
    }

    private void setupAtaque() {
        
        Button Botaochampselect = (Button) findViewById(R.id.Punch);
        Botaochampselect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                
                listaGolpes = 0;
                Combater();

            }
        });
    }

    private void setupDefesa() {
        
        Button Botaochampselect = (Button) findViewById(R.id.Shield);
        // Botaochampselect.setBackgroundColor(Color.TRANSPARENT);
        Botaochampselect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                
                listaGolpes = 1;
                Combater();
            }
        });
    }

    private void setupAgarra() {
        
        Button Botaochampselect = (Button) findViewById(R.id.Stomp);
        // Botaochampselect.setBackgroundColor(Color.TRANSPARENT);
        Botaochampselect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                
                listaGolpes = 2;
                Combater();

                    }
});
    }

    private void setupEspecial() {
        
        Button Botaochampselect = (Button) findViewById(R.id.special);
        // Botaochampselect.setBackgroundColor(Color.TRANSPARENT);
        Botaochampselect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                
                if (!especial) {
                    if(cooldown == 0)
                    {
                        Toast.makeText(Arena.this, "Especial Ativado",
                                Toast.LENGTH_LONG).show();
                        especial = true;
                    }
                    else
                    {
                        Toast.makeText(Arena.this, "Especial esta em Cooldown por "+ cooldown + " turnos",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Arena.this, "Especial Desativado",
                            Toast.LENGTH_LONG).show();
                    especial = false;
                }
            }
        });
    }

    private void setupRetry() {
        
        Button Botaochampselect = (Button) findViewById(R.id.Retry);
        // Botaochampselect.setBackgroundColor(Color.TRANSPARENT);
        Botaochampselect.setVisibility(View.INVISIBLE);
        Botaochampselect.setEnabled(false);
        Botaochampselect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                

                Derrotado(1);
                ConferirVidas();
            }
        });
    }


    protected void Combater() {
        
        String resultado = "";
        int resposta = RespostadoAdversario();
               round++;


        //0 = soco
        //1 = cordas
        //2 = agarrar
                if (listaGolpes == 0) {
                    if (player.getEspecial() == 0 && especial) {
                        if (resposta == 0) {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + " Vocês Trocam dois ganchos de direita mas o seu especial te da vantagem : Oponente Toma um Dano\n";
                            adversario.setVida(adversario.getVida() - 1);
                        } else if (resposta == 1) {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + "  Seu oponente pula seu golpe usando as cordas \n";
                        } else {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + " Seu oponente recebe seu especial na cara OUCH : Oponente toma dois danos\n";
                            adversario.setVida(adversario.getVida() - 2);
                        }
                        usouEspecial();

                    } else {
                        if (resposta == 0) {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + " Vocês Trocam pequenos soquinhos mas ninguem acerta um bom golpe : Nenhum dano \n";
                        } else if (resposta == 1) {
                            resultado = resultado + "Round:" + (round)
                                    + "  Seu oponente usou as cordas para criar distancia\n";
                        } else {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + " Seu oponente recebe uma bordoada bem na cara : Oponente toma um dano\n";
                            adversario.setVida(adversario.getVida() - 1);

                        }
                    }
                } else if (listaGolpes == 1) {
                    if (player.getEspecial() == 1 && especial) {
                        if (resposta == 0) {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + " Vocês usa as cordas com maestria desferindo um golpe : Oponente recebe um dano \n";
                            adversario.setVida(adversario.getVida() - 1);

                        } else if (resposta == 1) {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + " Você pula para atingir seu oponente mas este escapa ileso \n";
                        } else {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + " Seu oponente te ve tentando subir as cordas e te agarra: Tome um dano \n";
                            player.setVida(player.getVida() - 1);

                        }
                        usouEspecial();
                    } else {
                        if (resposta == 0) {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + " Vocês pulou o soco do adversario, as aulas de balé valeram a pena \n";
                        } else if (resposta == 1) {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + " Voces pulam ao mesmo tempo nas cordas mas estão fora do alcance um do outro \n";
                        } else {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + " Seu oponente ve voce tentando subir as cordas e te atinge com um soco : Tome um dano\n";
                            player.setVida(player.getVida() - 1);

                        }
                    }
                } else {
                    if (player.getEspecial() == 2 && especial) {
                        if (resposta == 0) {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + "Voce tenta correr com tudo contra seu oponente mas recebe um chute no estomago: Tome um dano\n";
                            player.setVida(player.getVida() - 1);

                        } else if (resposta == 1) {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + "Voce agarra seu oponente e o atira com maestria em um dos postes : Oponente toma um dano\n";
                            adversario.setVida(adversario.getVida() - 1);

                        } else {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + " Voces dois correm para o centro do ringue e tentam erguer um ao outro\n";
                            resultado = resultado
                                    + "Voce usa seu treinamento para erguer seu oponente e o arremessa de cabeça no chão  : Oponente toma dois danos\n";
                            adversario.setVida(adversario.getVida() - 2);

                        }
                        usouEspecial();
                    } else {
                        if (resposta == 0) {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + "Voce tenta agarrar seu oponente mas um soco em cheio te impede: Tome um dano\n";
                            player.setVida(player.getVida() - 1);

                        } else if (resposta == 1) {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + "Voce agarra seu oponente e o arremessa contra o chao: Oponente toma um dano";
                            adversario.setVida(adversario.getVida() - 1);

                        } else {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + "Voces tentam erguer um ao outro mas percebem que isso é inutil e constrangedor\n";
                                }
                            }
                        }

        if (cooldown > 0)
        {
            cooldown--;
        }

        if (ConfereDerrota(adversario)) {
            resultado = resultado
                    + " Você Derrotou seu oponente , Meus parabens Luchador\n";
            derrotados++;
            GerarAdversario();
        }
        if (ConfereDerrota(player)) {
            resultado = resultado
                    + "Você cai no canto do ringue desnortado : Voce sobreviveu a "
                    + derrotados + " Oponentes";
            Derrotado(0);
        }
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(resultado);
        dlgAlert.setTitle("Resultados");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
        ConferirVidas();

    }

    private void usouEspecial() {
        
        cooldown = 3;
        especial = false;

    }

    private void Derrotado(int i) {
        
        Button Btnatq = (Button) findViewById(R.id.Punch);
        Button Btndef = (Button) findViewById(R.id.Shield);
        Button Btnagr = (Button) findViewById(R.id.Stomp);
        Button Btnesp = (Button) findViewById(R.id.special);
        Button Btnretry = (Button) findViewById(R.id.Retry);

        if (i == 0) {
            Btnatq.setEnabled(false);
            Btndef.setEnabled(false);
            Btnagr.setEnabled(false);
            Btnesp.setEnabled(false);

            Btnretry.setEnabled(true);
            Btnretry.setVisibility(View.VISIBLE);
        } else {
            Btnatq.setEnabled(true);
            Btndef.setEnabled(true);
            Btnagr.setEnabled(true);
            Btnesp.setEnabled(true);


            derrotados = 0;
            GerarAdversario();
            player.setVida(3); // rever depois

            Btnretry.setEnabled(false);
            Btnretry.setVisibility(View.INVISIBLE);
        }

    }


    private boolean ConfereDerrota(Luchadores personagem) {

        return personagem.getVida() == 0 || personagem.getVida() < 0;
    }

    private int RespostadoAdversario() {
        Random gerador = new Random();
        return gerador.nextInt(2);
    }
}
