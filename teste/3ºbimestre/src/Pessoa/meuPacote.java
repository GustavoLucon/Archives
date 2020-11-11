package Pessoa;

import javax.swing.*;

public class meuPacote {
	String nome;
	String dataNascimento;
	int rg;
	String email;

	public void setNome(String novoNome)
	{
		nome=novoNome;
	}

	public String getNome()
	{
		return nome;
	}
	public void setdataNascimento(String dataNasc)
	{
		dataNascimento = dataNasc;
	}

	public String getdataNasc()
	{
		return dataNascimento;
	}
	public void setreg(int regi)
	{
		rg = regi;
	}

	public int getregi()
	{
		return rg;
	}
	public void setemail(String emaill)
	{
		email = emaill;
	}

	public String getemail()
	{
		return email;
	}
	

	
	public static void main(String[] args) {
		meuPacote teste = new meuPacote();
		teste.setNome("Teste");
		teste.setdataNascimento("12/12/2012");
		teste.setemail("teste01");
		teste.setreg(12345);
		
		System.out.println(teste.getdataNasc());
		System.out.println(teste.getemail());
		System.out.println(teste.getNome());
		System.out.println(teste.getregi());
	}

}
