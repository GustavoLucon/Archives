package com.example.luchadores;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Arena extends Activity {
	
	private int[] listaGolpes; 
	private int movimentos;
	private Luchadores player;
	private Luchadores adversario;
	private int derrotados;
	public boolean resposta;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_arena);
		
		CriarJogo();
		setupAtaque();
		setupDefesa();
		setupEspecial();
		setuplimpar();
		setupCombate();
	}

	private void CriarJogo() {
		// TODO Auto-generated method stub
		listaGolpes= new int[3];
		player = new Luchadores(3,0);
		derrotados = 0;
		movimentos = 0;
		GerarAdversario();
	}

	private void GerarAdversario() {
		// TODO Auto-generated method stub
		int dificuldade =0 ;
		for(int i = 0; i < derrotados;i = i + 3)
		{
			dificuldade++;
		}
		adversario = new Luchadores(1+dificuldade,0);
		TextView texto = (TextView) findViewById(R.id.lvlOponente);
		texto.setText("Oponente : LvL " + (1+dificuldade));
		Toast.makeText(Arena.this,"Desafiante novo apareceu", Toast.LENGTH_LONG).show();
	}
	
	  private void setupAtaque() {
		// TODO Auto-generated method stub
			Button Botaochampselect = (Button) findViewById(R.id.Ataque);
			Botaochampselect.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					listaGolpes[movimentos] = 0;
					movimentos++;		
					maxMovimentos();
					atualizarTabelaGolpes("ATAQUE");
				}
			});	
		}



	private void setupDefesa() {
			// TODO Auto-generated method stub
			Button Botaochampselect = (Button) findViewById(R.id.Defend);
			//Botaochampselect.setBackgroundColor(Color.TRANSPARENT);
			Botaochampselect.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					listaGolpes[movimentos] = 1;
					movimentos++;		
					maxMovimentos() ;
					atualizarTabelaGolpes("DEFESA");
				}
			});	
		}
	  private void setupEspecial() {
			// TODO Auto-generated method stub
			Button Botaochampselect = (Button) findViewById(R.id.Especial);
			//Botaochampselect.setBackgroundColor(Color.TRANSPARENT);
			Botaochampselect.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					listaGolpes[movimentos] = 2;
					movimentos++;	
					maxMovimentos() ;
					atualizarTabelaGolpes("ESPECIAL");
				}
			});	
		}
	  private void setuplimpar() {
			// TODO Auto-generated method stub
			Button Botaochampselect = (Button) findViewById(R.id.Limpar);
			//Botaochampselect.setBackgroundColor(Color.TRANSPARENT);
			Botaochampselect.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Toast.makeText(Arena.this,"Voce usou Amnesia", Toast.LENGTH_LONG).show();
					movimentos=0;
					Button Btnconf = (Button) findViewById(R.id.Confirmar);
					Btnconf.setVisibility(View.INVISIBLE);
					Btnconf.setEnabled(false);
					TravarBotoes(1);
					atualizarTabelaGolpes("");
				}
			});	
		}
	  private void setupCombate() {
			// TODO Auto-generated method stub
			Button Botaochampselect = (Button) findViewById(R.id.Confirmar);
			Botaochampselect.setEnabled(false);
			Botaochampselect.setVisibility(View.INVISIBLE);
			Botaochampselect.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Combater();
				}
			});	
	  }
	  
		 protected void atualizarTabelaGolpes(String golpe) {
				// TODO Auto-generated method stub
				 TextView texto = (TextView) findViewById(R.id.Golpes);
				 if(golpe.equals(""))
				 {
					 texto.setText("Golpes:"); 
				 }
				 else
				 {
				 texto.setText(texto.getText() + " " + golpe );
				 }
				
			}
	  protected void Combater() {
		// TODO Auto-generated method stub
		  String resultado= "";
			int [] resposta = RespostadoAdversario();
			boolean derrotado = false;
			
			for(int i =0;i<3;i++)
			{
				if(derrotado == false)
				{
				if(listaGolpes[i] == 0)
				{
					if(resposta[i] == 0)
					{
						resultado = resultado + "Round:" + (i + 1) + " Vocês Trocam dois ganchos de direita : Tomam um dano cada\n";
						player.setVida(player.getVida()-1);
						adversario.setVida(adversario.getVida()-1);
						if(ConfereDerrota(player))
						{
							derrotado = true;
							resultado = resultado +  "Você cai no canto do ringue desnortado : Voce sobreviveu a "+  derrotados + " Oponentes" ;
						}
						else if(ConfereDerrota(adversario))
						{
							derrotado = true;
							resultado = resultado +  "Você Derrotou seu oponente , Meus parabens Luchador";
							derrotados++;
						}
					}
					else if (resposta[i] == 1)
					{
						resultado = resultado + "Round:" + (i + 1) +  "  Seu oponente bloqueia seu golpe\n";
					}
					else
					{
						resultado = resultado + "Round:" + (i + 1) +  " Seu oponente recebe uma bordoada bem na cara\n";
						adversario.setVida(adversario.getVida()-1);
						if(ConfereDerrota(adversario))
						{
							derrotado = true;
							resultado = resultado +  " Você Derrotou seu oponente , Meus parabens Luchador\n";
							derrotados++;
							
						}
					}
				}
				else if(listaGolpes[i] == 1) 
				{
					if(resposta[i] == 0)
					{
						resultado = resultado + "Round:" + (i + 1) +  " Vocês Bloqueia o ataque do seu Adversario\n";
					}
					else if (resposta[i] == 1)
					{
						resultado = resultado + "Round:" + (i + 1) +  " Voces se encaram de forma intimidadora com a defesa alta\n";
					}
					else
					{
						resultado = resultado +  "Round:" + (i + 1) +  " Seu oponente procura por uma abertura mas não acha nenhuma\n";
					}
				}
				else
				{
					if(resposta[i] == 0)
					{
						resultado = resultado + "Round:" + (i + 1) +  "Enquanto voce carrega seu folego um soco voa em sua direção: Tome um dano\n";
						player.setVida(player.getVida()-1);
						if(ConfereDerrota(player))
						{
							derrotado = true;
							resultado = resultado +  "Você cai no canto do ringue desnortado : Voce sobreviveu a "+  derrotados + " Oponentes" ;
						}

					}
					else if (resposta[i] == 1)
					{
						resultado = resultado + "Round:" + (i + 1) + " Voce utiliza o tempo q seu adversario se protege pra carregar seu especial\n";
					}
					else
					{
						resultado = resultado +"Round:" + (i + 1)+  " Voces dois carregam os especiais , a tensão é palpavel\n";
					}
				}
				}
			}
			final Toast tag = Toast.makeText(getBaseContext(), resultado,Toast.LENGTH_SHORT);

			tag.show();

			new CountDownTimer(9000, 1000)
			{

			    public void onTick(long millisUntilFinished) {tag.show();}
			    public void onFinish() {tag.show();}

			}.start();
			
			Button Btnconf = (Button) findViewById(R.id.Confirmar);
			Btnconf.setVisibility(View.INVISIBLE);
			Btnconf.setEnabled(false);
			TravarBotoes(1);
			atualizarTabelaGolpes("");
			movimentos = 0;
			if(ConfereDerrota(adversario))
			{
				GerarAdversario();
			}
			if(ConfereDerrota(player))
			{
			Derrotado();
			}
	}

	private void Derrotado() {
		// TODO Auto-generated method stub
		   Button Btnatq = (Button) findViewById(R.id.Ataque);
		   Button Btndef = (Button) findViewById(R.id.Defend);
		   Button Btnesp = (Button) findViewById(R.id.Especial);
		   Button Btnlim = (Button) findViewById(R.id.Limpar);

		   Btnatq.setEnabled(false);
		   Btndef.setEnabled(false);
		   Btnesp.setEnabled(false);
		   Btnlim.setEnabled(false);

	}

	protected void maxMovimentos() {
		// TODO Auto-generated method stub
		if (movimentos == 3)
		{
			TravarBotoes(0);
			Button Btnconf = (Button) findViewById(R.id.Confirmar);
			Btnconf.setVisibility(View.VISIBLE);
			Btnconf.setEnabled(true);
			
		}
	}
	  
	   private void TravarBotoes(int travar) {
		// TODO Auto-generated method stub
		   Button Btnatq = (Button) findViewById(R.id.Ataque);
		   Button Btndef = (Button) findViewById(R.id.Defend);
		   Button Btnesp = (Button) findViewById(R.id.Especial);
		   if(travar == 0)
		   {
		   Btnatq.setEnabled(false);
		   Btndef.setEnabled(false);
		   Btnesp.setEnabled(false);
		   }
		   else
		   {
			   Btnatq.setEnabled(true);
			   Btndef.setEnabled(true);
			   Btnesp.setEnabled(true);   
		   }
	}

	private boolean ConfereDerrota(Luchadores personagem) {
		// TODO Auto-generated method stub
		   if(personagem.getVida() == 0)
		   {
			   return true;
		   }
		   else
		   {
			   return false;
		   }
		   
		
	}


	private int[] RespostadoAdversario() {
		// TODO Auto-generated method stub
		
		int [] resposta = new int[3];
		Random gerador = new Random();	
		
		for(int i = 0; i < 3;i++)
		{		
			resposta[i] = gerador.nextInt(2);
		}
		return resposta;
	}
}
