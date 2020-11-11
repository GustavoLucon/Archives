package CarteiraDeInvestimento2;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class AplicacaoPre extends Instrumento{
	double Saldo;
	double Valor;
	int mes;
	int ano;
	int duracao;
	double totalrendimento;
	double rendimentomes;
	private Date d = new Date();
    private GregorianCalendar datahora;
    private TimeZone timezone;
	public AplicacaoPre(double Valor,int mes, int ano,int duracao,int totalredimento)
	{
		this.Valor = Valor;
		this.mes = mes;
		this.ano = ano;
		this.duracao = duracao;
		this.totalrendimento = totalredimento;
		pormes();
	}
	public void pormes()
	{
		this.rendimentomes = this.totalrendimento /this.duracao;
	}
	@Override
	public double valor() {
		int mes = d.getMonth();
		int ano = d.getYear()+1900;
		boolean resposta = false;
		int soma = 0;
		if(ano > this.ano || mes > this.mes)
		{
		while(ano >= this.ano && resposta == false)
		{
			if(ano > this.ano)
			{
			while(this.mes <= 12)
			{
				soma++;
						this.mes++;
			}
			this.mes = 0;
			this.ano++;
				}
				else
				{
					while(mes >= this.mes)
					{
						soma++;
						this.mes++;
					}
					if(soma < duracao)
					{
					this.Saldo = this.Valor + (this.Valor * (this.rendimentomes * soma));
					}
					else
					{
						int a;
						a = soma - duracao;
						this.Saldo = this.Valor + (this.Valor * (this.rendimentomes * duracao)) + (this.Valor * (this.totalrendimento * a));				
					}
					this.duracao = duracao - soma;
					resposta = true;
					this.ano = ano;
					this.mes = mes+1; 
				}
			}
		}
		return this.Saldo;
	}
}
