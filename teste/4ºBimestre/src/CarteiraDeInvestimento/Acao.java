package CarteiraDeInvestimento;

import javax.swing.JOptionPane;

public class Acao {
	double Saldo;
	String Nome;
	int mes;
	int ano;
	Bolsa valor = new Bolsa();
	public Acao()
	{
	this.Nome = JOptionPane.showInputDialog("Digite o nome da ação");
	this.Saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da ação"));
	this.mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mes de criação da ação"));
	this.ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de criação da ação"));
	}
	public void calcularganho(int mes ,int ano)
	{
		boolean resposta = false;
		while(ano >= this.ano && resposta == false)
		{
			if(ano > this.ano)
			{
			while(this.mes <= 12)
			{
				this.Saldo = this.Saldo + this.Saldo * valor.Percento();
				this.mes++;
			}
			this.mes = 0;
			this.ano++;
			}
			else
			{
				while(mes >= this.mes)
				{
					this.Saldo = this.Saldo + this.Saldo * valor.Percento();
					this.mes++;
				}
				resposta = true;
			}
		}
		this.mes = mes + 1;
		this.ano = ano;
	}
	public double getSaldo() {
		return Saldo;
	}
	public String getNome() {
		return Nome;
	}
}
