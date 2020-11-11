package CarteiraDeInvestimento2;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.swing.JOptionPane;

public class Fundo extends Instrumento {
	double Saldo;
	private Date d = new Date();
    private GregorianCalendar datahora;
    private TimeZone timezone;
	int atualizacaomes;
	int atualizacaoano;
	BAnco valor = new BAnco();
	public Fundo(double saldo, int atualizacaomes , int atualizacaoano)
	{
	this.Saldo = saldo;
	this.atualizacaomes = atualizacaomes;
	this.atualizacaoano = atualizacaoano;
	}
	@Override
	public double valor() {
		int mes = d.getMonth();
		int ano = d.getYear()+1900;
		boolean resposta = false;
		while(ano >= this.atualizacaoano && resposta == false)
		{
			if(ano > this.atualizacaoano)
			{
			while(mes >= 12)
			{
				this.Saldo = this.Saldo + this.Saldo * valor.Percento();
				this.atualizacaomes++;
			}
			this.atualizacaomes = 0;
			this.atualizacaoano++;
			}
			else
			{
				while(mes >= this.atualizacaomes)
				{
					this.Saldo = this.Saldo + this.Saldo * valor.Percento();
					this.atualizacaomes++;
				}
				resposta = true;
			}
		}
		this.atualizacaomes = mes + 1;
		this.atualizacaoano = ano;
		return Saldo;
	}
}
