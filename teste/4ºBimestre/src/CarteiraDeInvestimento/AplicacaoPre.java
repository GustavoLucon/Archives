package CarteiraDeInvestimento;

import javax.swing.JOptionPane;

public class AplicacaoPre {
	double Saldo;
	double Valor;
	String Nome;
	int mes;
	int ano;
	int duracao;
	double totalrendimento;
	double rendimentomes;
	public AplicacaoPre()
	{
		this.Nome = JOptionPane.showInputDialog("Digite o nome da ação");
		this.Valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da ação"));
		this.mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mes de criação da ação"));
		this.ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de criação da ação"));
		this.duracao = Integer.parseInt(JOptionPane.showInputDialog("Digite a duração do mesmo(em meses)"));
		this.totalrendimento = Double.parseDouble(JOptionPane.showInputDialog("Digite o rendimento final do mesmo (Por cento)"));
		pormes();
	}
	public void calcularganho(int mes,int ano)
	{
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
	}
	public void pormes()
	{
		this.rendimentomes = this.totalrendimento /this.duracao;
	}
	public double getSaldo() {
		return Saldo;
	}
	public String getNome() {
		return Nome;
	}
}
