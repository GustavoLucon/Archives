package GrafoTotal;

import javax.swing.JOptionPane;

public class Ponto {
	// Esqueci qual é aresta e qual e vertice =D
	private String nome;
	private Linha conexoes[] = new Linha[20000];
	private int NumeroConexoes = 0;
	
	public Ponto(String n)
	{
		nome = n;
	}
	// Cria conexão entre dois pontos validos
	public void GerarConexões(Ponto A, Ponto B,String nome) 
	{
		conexoes[NumeroConexoes] = new Linha(A,B,nome);
		NumeroConexoes++;
		
	}
	// Proocura uma conexão entre eles
	public boolean ProcurarLinha(String nome2)
	{
		String a;
		a = this.nome + "-" + nome2;
		for(int i =0 ; i <= NumeroConexoes;i++)
		{
			if( a.equals(conexoes[i]))
			{
				return true;
			}
		}
		return false;
	}
	public String getNome() {
		return nome;
	}

	public int getNumeroConexoes() {
		return NumeroConexoes;
	}
	// Retorna quem esta conectado a este ponto
	public String LerConexoes() {
		if(NumeroConexoes == 0)
		{
			return "Ninguem";
		}
		else
		{
			String a = "";
			for(int i =0 ; i < NumeroConexoes;i++)
			{
				
				a = a + conexoes[i].Ligar(this.nome).getNome() + ",";
			}
			return a;
		}

	}
	// Checa se é Hamiltoniano
	public boolean ChecarCaminho(String inicial,String[] caminho, int local,int tamanho) 
	{
		if(NumeroConexoes > 0)
		{
			if(this.nome.equals(inicial)&& local != 0)
			{
				if(Repetiu(caminho) == false)
				{
					if(PassouEmTodos(local,tamanho))
					{
					return true;
					}
				}
			}
			else
				{
				if(local != 0)
				{
					caminho[local] = this.nome;
				}
					local++;
					if(ProcuraMais(caminho,local,inicial,tamanho))
					{
						return true;
					}
				}
			}
			return false;
}
	
public boolean Repetiu(String[] caminho)
{
	int cont = 0;
for(int a =0; a < NumeroConexoes;a++)
{
	for(int i =0; i < caminho.length;i++)
	{
		if(caminho[i]!= null && this.nome.equals(caminho[i]))
		{
			cont++;
		}
	}
}
if(cont == 0)
{
	return false;
}
else
{
return true;	
}
}


public boolean ProcuraMais(String[] caminho,int local,String inicial, int tamanho)
{
	for(int a =0; a < NumeroConexoes;a++)
	{			
		if(conexoes[a].Ligar(this.nome).ChecarCaminho(inicial, caminho,local,tamanho))
		{
		return true;
		}	
	}
	return false;
}


public boolean PassouEmTodos(int atual,int total)
{
	if(atual == total)
	{
		return true;
	}
	else
	{
		return false;
	}
}
}
