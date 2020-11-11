package Pai;

public class BD {
	public String nome;
	public int ID;
	public String anotacao;
	public BD filho;
	public void BD(int ID,String nom,String anota)
	{
		this.nome = nom;
		this.ID = ID;
		this.anotacao = anota;
	}
	public void CriarFilho(int ID,String nom,String anota)
	{
		if(filho == null)
		{
			filho = new BD();
			filho.BD(ID, nom, anota);
		}
		else
		{
			filho.CriarFilho(ID, nom, anota);
		}
	}
	public String[] BuscarNom (String nom)
	{
		if(this.nome == nom)
		{
		String Info[] = new String[3];
		Info[0] = this.nome;
		Info[1] = Integer.toString(this.ID);
		Info[2] = this.anotacao;
		return Info;
		}
		else {
			if(filho == null)
			{
				String Info[] = new String[3];
				Info[0] = "Nao achado";
				Info[1] = "Nao achado";
				Info[2] = "Nao achado";
				return Info;
			}
			else
			{
				return filho.BuscarNom(nom);
			}
		}
	}
}
