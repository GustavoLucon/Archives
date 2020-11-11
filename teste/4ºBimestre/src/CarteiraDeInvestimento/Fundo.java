package CarteiraDeInvestimento;

import javax.swing.JOptionPane;

public class Fundo {
	double Saldo;
	String Nome;
	int atualizacaomes;
	int atualizacaoano;
	BAnco valor = new BAnco();
	public Fundo()
	{
	this.Nome = JOptionPane.showInputDialog("Digite o nome da ação");
	this.Saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da ação"));
	this.atualizacaomes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mes de criação da ação"));
	this.atualizacaoano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de criação da ação"));
	}
	public void calcularganho(int mes ,int ano)
	{
		boolean resposta = false;
		while(ano >= this.atualizacaoano && resposta == false)
		{
			if(ano > this.atualizacaoano)
			{
			while(mes <= 12)
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
	}
	public double getSaldo() {
		return Saldo;
	}
	public String getNome() {
		return Nome;
	}
}
