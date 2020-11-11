package guandv.luchadores;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Arena extends Activity {

    private int listaGolpes;
    private Luchadores player;
    private Luchadores adversario;
    private int derrotados;
    public boolean especial;
    public int cooldown;
    private int round;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle extras = getIntent().getExtras();
        String transferido;
        int vidasluchador = 0;

        if (extras != null) {
            transferido = extras.getString("edittextvalue");
            vidasluchador = Integer.parseInt(transferido);
        }

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.arena);

        round = 0;
        CriarJogo(Vidatotais(vidasluchador));
        setupAtaque();
        setupDefesa();
        setupAgarra();
        setupEspecial();
        setupRetry();
        //EstadoLutadores(0,0);
    }

    private int Vidatotais(int vidasluchador) {
        if(vidasluchador == 0)
        {
            return 5;
        }
        else if (vidasluchador == 1)
        {
            return 3;
        }
        else
        {
            return 4;
        }
    }

   /* private void EstadoLutadores(int estadoplayer , int estadooponente) {
        GifView oponente = (GifView) findViewById(R.id.oponente);
        GifView oponenteSoco = (GifView) findViewById(R.id.oponenteSoco);
        GifView oponenteAgarra = (GifView) findViewById(R.id.oponenteAga);
        GifView oponenteCorda = (GifView) findViewById(R.id.oponenteCord);

        GifView player = (GifView) findViewById(R.id.player);
        GifView playerSoco = (GifView) findViewById(R.id.playerSoc);
        GifView playerAgarra = (GifView) findViewById(R.id.playerAga);
        GifView playerCorda = (GifView) findViewById(R.id.playerCord);

        if(estadooponente == 0)
        {
        oponente.setVisibility(View.VISIBLE);
        oponenteSoco.setVisibility(View.INVISIBLE);
            oponenteAgarra.setVisibility(View.INVISIBLE);
            oponenteCorda.setVisibility(View.INVISIBLE);


        }
        else if (estadooponente == 1)
        {
            oponente.setVisibility(View.INVISIBLE);
            oponenteSoco.setVisibility(View.VISIBLE);
            oponenteAgarra.setVisibility(View.INVISIBLE);
            oponenteCorda.setVisibility(View.INVISIBLE);

        }
        else if (estadooponente == 2)
        {
            oponente.setVisibility(View.INVISIBLE);
            oponenteSoco.setVisibility(View.INVISIBLE);
            oponenteAgarra.setVisibility(View.VISIBLE);
            oponenteCorda.setVisibility(View.INVISIBLE);
        }
        else  if (estadooponente == 3)
        {
            oponente.setVisibility(View.INVISIBLE);
            oponenteSoco.setVisibility(View.INVISIBLE);
            oponenteAgarra.setVisibility(View.INVISIBLE);
            oponenteCorda.setVisibility(View.VISIBLE);
        }

        if(estadoplayer == 0)
        {
            player.setVisibility(View.VISIBLE);
            playerSoco.setVisibility(View.INVISIBLE);
            playerAgarra.setVisibility(View.INVISIBLE);
            playerCorda.setVisibility(View.INVISIBLE);

        }
        else if (estadoplayer == 1)
        {
            player.setVisibility(View.INVISIBLE);
            playerSoco.setVisibility(View.VISIBLE);
            playerAgarra.setVisibility(View.INVISIBLE);
            playerCorda.setVisibility(View.INVISIBLE);

        }
        else if (estadoplayer == 2)
        {
            player.setVisibility(View.INVISIBLE);
            playerSoco.setVisibility(View.INVISIBLE);
            playerAgarra.setVisibility(View.VISIBLE);
            playerCorda.setVisibility(View.INVISIBLE);
        }
        else if (estadoplayer == 3)
        {
            player.setVisibility(View.INVISIBLE);
            playerSoco.setVisibility(View.INVISIBLE);
            playerAgarra.setVisibility(View.INVISIBLE);
            playerCorda.setVisibility(View.VISIBLE);
        }


    }
*/

    public void CriarJogo(int i) {
        
        player = new Luchadores(i, 0);
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

        if(player.getVida()== 5)
        {
            plVida1.setVisibility(View.VISIBLE);
            plVida1.setBackgroundResource(R.drawable.coracaoazul);
            plVida2.setVisibility(View.VISIBLE);
            plVida2.setBackgroundResource(R.drawable.coracaoazul);
            plVida3.setVisibility(View.VISIBLE);
        }
        else if(player.getVida()== 4)
        {
            plVida1.setVisibility(View.VISIBLE);
            plVida1.setBackgroundResource(R.drawable.coracaoazul);
            plVida2.setVisibility(View.VISIBLE);
            plVida2.setBackgroundResource(R.drawable.coracao);
            plVida3.setVisibility(View.VISIBLE);
        }
        else if(player.getVida()== 3)
        {
            plVida1.setVisibility(View.VISIBLE);
            plVida1.setBackgroundResource(R.drawable.coracao);
            plVida2.setVisibility(View.VISIBLE);
            plVida2.setBackgroundResource(R.drawable.coracao);
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
        
        Button Botaochampselect = (Button) findViewById(R.id.pontuação);
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
                                    + " Vocês trocam socos , que bom que voce usou seu especial: Oponente toma um dano \n";
                            adversario.setVida(adversario.getVida() - 1);
                        } else if (resposta == 1) {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + "  Seu oponente pula seu golpe usando as cordas e te ataca: Tome um dano \n";
                            player.setVida(player.getVida() - 1);
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
                                    + "  Seu oponente usou as cordas para criar distancia e pular em voce: Tome um dano \n";
                            player.setVida(player.getVida() - 1);

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
                                    + " Vocês usa as cordas com maestria desferindo um golpe : Oponente recebe dois danos \n";
                            adversario.setVida(adversario.getVida() - 2);

                        } else if (resposta == 1) {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + " Você pula para atingir seu oponente quase errando ele no ar : Oponente toma um dano \n";
                            adversario.setVida(adversario.getVida() - 1);
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
                                    + " Vocês pulou o soco do adversario, as aulas de balé valeram a pena : oponente toma um dano \n";
                            adversario.setVida(adversario.getVida() - 1);
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
                                    + "Voce agarra seu oponente e o atira com maestria em um dos postes : Oponente toma dois danos\n";
                            adversario.setVida(adversario.getVida() - 2);

                        } else {
                            resultado = resultado
                                    + "Round:"
                                    + (round)
                                    + " Voces dois correm para o centro do ringue e tentam erguer um ao outro\n";
                            resultado = resultado
                                    + "Voce usa seu treinamento para erguer seu oponente e o arremessa de cabeça no chão  : Oponente toma um dano\n";
                            adversario.setVida(adversario.getVida() - 1);

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

        //EstadoLutadores(listaGolpes,resposta);


        if (ConfereDerrota(adversario)) {
            resultado = resultado
                    + " Você Derrotou seu oponente , Meus parabens Luchador\n";
            derrotados++;
            GerarAdversario();
        }
        if (ConfereDerrota(player)) {
            AbrirScore();
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

    private void AbrirScore() {

        Intent act2 = new Intent(Arena.this, Score.class);
        String str = "" + derrotados;
        act2.putExtra("edittextvalue" , str);
        startActivity(act2);
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
        Button Btnretry = (Button) findViewById(R.id.pontuação);

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
