package meuPacote;

import javax.swing.JOptionPane;

import Pessoa.meuPacote;

public class Funcionario extends meuPacote{
	
	private String carteira;
	private String cargo;
	private int salario;
	
	public void setCarteira(String novacarteira)
	{
		carteira =novacarteira;
	}

	public String getCarteira()
	{
		return carteira;
	}
	public void setCargo(String novoCargo)
	{
		cargo=novoCargo;
	}

	public String getCargo()
	{
		return cargo;
	}
	public void setSalario (int novosalario)
	{
		salario = novosalario ;
	}

	public int getSalario()
	{
		return salario;
	}

	public static void main(String[] args) {
		Funcionario teste = new Funcionario();
		String nome;
		String data;
		String email;
		int reg;
		String cargo;
		String Carteira;
		int Salario;
		nome = JOptionPane.showInputDialog("Digite o nome");
		data  = JOptionPane.showInputDialog("Digite a data de nascimento");
		email  = JOptionPane.showInputDialog("Digite o email");
		reg = Integer.parseInt(JOptionPane.showInputDialog("Digite o RG"));
		cargo = JOptionPane.showInputDialog("Digite o Cargo");
		Salario  = Integer.parseInt(JOptionPane.showInputDialog("Digite o Salario"));
		Carteira  = JOptionPane.showInputDialog("Digite a Carteira");
		teste.setCargo(cargo);
		teste.setCarteira(Carteira);
		teste.setSalario(Salario);
		teste.setNome(nome);
		teste.setdataNascimento(data);
		teste.setemail(email);
		teste.setreg(reg);
		
		System.out.println("Nome = " + teste.getNome());
		System.out.println("Data De Nascimento = " +teste.getdataNasc());
		System.out.println("RG = " +teste.getregi());
		System.out.println("Email = " +teste.getemail());
		System.out.println("Cargo = " +teste.getCargo());
		System.out.println("Carteira = " +teste.getCarteira());
		System.out.println("Salario = " +teste.getSalario());

	}

}
