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
	this.Nome = JOptionPane.showInputDialog("Digite o nome da a��o");
	this.Saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da a��o"));
	this.mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mes de cria��o da a��o"));
	this.ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de cria��o da a��o"));
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
