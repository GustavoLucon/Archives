package Primeiros;
import java.util.Random;

import javax.swing.JOptionPane;

class sub{
	String nome = new String();
	sub conx;
	int pos;
	
}

public class Hasing {
    public static void printar(String[] n,String chave,sub j) 
    {
    	for(int o = 0;n.length > o;o++)
    	{
    		if(n[o] != null && n[o] != chave)
    		{
    			System.out.print(n[o] + " ");
    		}
    	}
    	printarsub(n,j);
    }
    public static void printarsub(String[] n,sub j) 
    {
		if(j.conx != null)
		{
			printarsub(n,j.conx); 
		}
		else
		{
			System.out.print(j.nome + " ");
		}
	}
    public static void printarlista(sub j) 
    {
    	if(j.conx != null)
    	{
    		printarlista(j.conx);
    		System.out.print(j.nome+ " ");
    	}
    	else
    	{
    		System.out.print(j.nome+ " ");	
    	}
    }
    public static void buscarSeq(String[] n, String nome, int posicao,int vezes) 
    {
    	if(n[posicao] != null)
    	{
    	if(posicao < n.length)
    	{
    	if(nome.equals(n[posicao]))
    	{
    		System.out.println("Valor encontrado na posicao " + posicao);
    	}
    	else
    	{
    		for(int p = 0; p < vezes;p++)
    		{
    		posicao++;	
    		}
    		vezes++;
    		buscarSeq(n,nome,posicao,vezes);
    	}
    	}
    	else
    	{
    		System.out.println("Valor nao foi encontrado");
    	}
    	}
    	else
    	{
    		System.out.println("Valor nao foi encontrado");
    	}
    }
    public static void buscar(String[] n, String nome, int posicao) 
    {
    	if(n[posicao] != null)
    	{
    	if(posicao < n.length)
    	{
    	if(nome.equals(n[posicao]))
    	{
    		System.out.print("Valor encontrado na posicao " + posicao);
    	}
    	else
    	{
    		buscar(n,nome,posicao++);
    	}
    	}
    	else
    	{
    		System.out.print("Valor nao foi encontrado");
    	}
    	}
    	else
    	{
    		System.out.print("Valor nao foi encontrado");
    	}
    }
    public static void procuraDuplo(String nome,String chave , sub j) 
    {
    	if(nome == j.nome)
    	{
    		System.out.print("Valor encontrado");
    	}
    	else
    	{
    		procuraDuplo(nome,chave,j);
    	}
    }
    public static void buscarDuplo(String[] n, String nome, int posicao,String chave , sub j) 
    {
    	if(n[posicao] != null)
    	{
    	if(posicao < n.length)
    	{
    	if(nome.equals(n[posicao]))
    	{
    		System.out.print("Valor encontrado na posicao " + posicao);
    	}
    	else
    	{
    		if(chave.equals(n[posicao]))
    		{
    			procuraDuplo(nome,chave,j);
    		}
    		else
    		{
    		buscarDuplo(n,nome,posicao++,chave,j);
    		}
    	}
    	}
    	else
    	{
    		System.out.print("Valor nao foi encontrado");
    	}
    	}
    	else
    	{
    		System.out.print("Valor nao foi encontrado");
    	}
    	
    }
    public static void inserir(String[] n, String nome,String chave , sub novo) 
    {
    	boolean resp = true;
    	int o;
    	o =atribuir(n,nome);
    	do{
    	if(n[o] == null)
    	{
    		n[o] = nome;
			resp = false;
    	}
    	else
    	{
    		if(n[o] == chave )
    		{
    		subclasse(nome,o,novo);
    		resp = false;
    		}
    		else if(n[o] != chave)
    		{
        	subclasse(n[o],o,novo);
        	subclasse(nome,o,novo);
        	n[o] = chave;
        	resp = false;
    		}
    		}
    	}	
    while(n[o] != "" && resp == true);	
    }
    
    private static void subclasse(String nome, int o , sub k) {
		if(k.nome == null)
		{
        k.pos = o;
    	k.nome = nome;
		}
		else
		{
			if(k.conx != null)
			{
				subclasse(nome,o,k.conx);
			}
	}
	}
	public static int atribuir(String[] n,String nome) 
    {
    	int res = 0;
    	String[] separado;
    	separado = nome.split("");
    	for(int i=1;separado.length > i;i++){
   		if(separado[i].equals("a"))
    	{
    		res = res + 1; 
    		res = res^i;
    	}
    	if(separado[i].equals("b"))
    	{
    		res = res + 2;  
    		res = res^i;
    	}
    	if(separado[i].equals("c"))
    	{
    		res = res + 3;
    		res = res^i;
    	}
    	if(separado[i].equals("d"))
    	{
    		res = res + 4;
    		res = res^i;
    	}
    	if(separado[i].equals("e"))
    	{
    		res = res + 5; 
    		res = res^i;
    	}
    	if(separado[i].equals("f"))
    	{
    		res = res + 6;  
    		res = res^i;
    	}
    	if(separado[i].equals("g"))
    	{
    		res = res + 7;
    		res = res^i;
    	}
    	if(separado[i].equals("h"))
    	{
    		res = res + 8;
    		res = res^i;
    	}
    	if(separado[i].equals("i"))
    	{
    		res = res + 9;
    		res = res^i;
    	}
    	if(separado[i].equals("j"))
    	{
    		res = res + 10;
    		res = res^i;
    	}
    	if(separado[i].equals("k"))
    	{
    		res = res + 11;
    		res = res^i;
    	}
    	if(separado[i].equals("l"))
    	{
    		res = res + 12;
    		res = res^i;
    	}
    	if(separado[i].equals("m"))
    	{
    		res = res + 13;
    		res = res^i;
    	}
    	if(separado[i].equals("n"))
    	{
    		res = res + 14;  
    		res = res^i;
    	}
    	if(separado[i].equals("o"))
    	{
    		res = res + 15;  
    		res = res^i;
    	}
    	if(separado[i].equals("p"))
    	{
    		res = res + 16;  
    		res = res^i;
    	}
    	if(separado[i].equals("q"))
    	{
    		res = res + 17;
    		res = res^i;
    	}
    	if(separado[i].equals("r"))
    	{
    		res = res + 18;
    		res = res^i;
    	}
    	if(separado[i].equals("s"))
    	{
    		res = res + 19;
    		res = res^i;
    	}
    	if(separado[i].equals("t"))
    	{
    		res = res + 20; 
    		res = res^i;
    	}
    	if(separado[i].equals("u"))
    	{
    		res = res + 21;  
    		res = res^i;
    	}
    	if(separado[i].equals("v"))
    	{
    		res = res + 22;  
    		res = res^i;
    	}
    	if(separado[i].equals("x"))
    	{
    		res = res + 23;  
    		res = res^i;
    	}
    	if(separado[i].equals("w"))
    	{
    		res = res + 24; 
    		res = res^i;
    	}
    	if(separado[i].equals("y"))
    	{
    		res = res + 25;
    		res = res^i;
    	}
    	if(separado[i] == "z")
    	{
    		res = res + 26; 
    		res = res^i;
    	}
    	}
    	res = 10000 * 50 * res/n.length;
    	while(res > n.length)
    	{
    		res--;	
    	}
    	return res;
    }
	public static void main(String[] args){
		String[] lista = new String[10000];
		String adi[] = {"The","Targum","Jonathan","states","that","the","Nephilim","were","given","this","name","because","they","were","descended","from","fallen","angels.[11]","The","New","American","Bible","commentary","draws","a","parallel","to","the","Epistle","of","Jude","and","the","statements","set","forth","in","Genesis","","suggesting","that","the","Epistle","refers","implicitly","to","the","paternity","of","Nephilim","as","heavenly","beings","who","came","to","earth","and","had","sexual","intercourse","with","women.[12]","The","footnotes","of","the","Jerusalem","Bible","suggest","that","the","Biblical","author","intended","the","Nephilim","to","be","an","anecdote","of","a","superhuman","race","Genesis","6:4","implies","that","the","Nephilim","have","inhabited","the","earth","in","at","least","two","different","time","periods—in","antediluvian","times","and","afterward","If","the","Nephilim","were","supernatural","beings","themselves","","or","at","least","the","progeny","of","supernatural","beings","","it","is","possible","that","the","giants","of","Canaan","in","Book","of","Numbers","13:33","were","the","direct","descendants","of","the","antediluvian","Nephilim","","or","were","fathered","by","the","same","supernatural","parents","In","Aramaic","culture","","the","term","Nephila","specifically","referred","to","the","constellation","of","Orion","","and","thus","Nephilim","to","Orion's","semi-divine","descendants","(cf.","Anakim","from","Anak);[14]","the","implication","being","that","this","also","is","the","origin","of","the","Biblical","Nephilim","Some","Christian","commentators","have","argued","against","this","view[15]","citing","Jesus'","statement","that","angels","do","not","marry.[16]","Others","believe","that","Jesus","was","only","referring","to","angels","in","heaven.[17]","[edit]","Descendants","of","Seth","and","Cain","Many","Jewish","commentaries","and","translations","describe","the","Nephilim","as","being","from","the","offspring","of","sons","of","nobles","rather","than","from","sons","of","God","or","sons","of","angels","[18]","This","is","also","the","rendering","suggested","in","the","Targum","Onkelos","Likewise","","a","long-held","view","among","some","Christians","is","that","the","sons","of","God","did","not","birth","the","Nephilim","spoken","of","in","the","text","","but","the","formerly","righteous","descendants","of","Seth","who","rebelled","","while","the","daughters","of","men","were","the","unrighteous","descendants","of","Cain","","and","the","Nephilim","the","offspring","of","their","union.[19]","This","view","dates","to","at","least","the","3rd","century","AD","","with","references","in","Sextus","Julius","Africanus","[20]","as","well","as","throughout","the","Clementine","literature.[21]","Holders","of","this","view[22]","have","looked","for","support","in","Jesus'","statement","that","in","the","days","before","the","flood","they","(humans)","were","marrying","and","giving","in","marriage","[23]","[edit]","Similar","terms","In","the","Hebrew","Bible","","there","are","a","number","of","other","words","that","","like","Nephilim","are","sometimes","translated","as","giants","*","Emim","the","fearful","ones","*","Rephaim","the","dead","ones","*","Anakim","the","[long]-necked","ones","[edit]","Anakim","Anakim","(or","Anakites)","are","the","descendants","of","Anak","","and","dwelt","in","the","south","of","Canaan","","in","the","neighbourhood","of","Hebron.","In","the","days","of","Abraham","","they","inhabited","the","region","afterwards","known","as","Edom","and","Moab","","east","of","the","Jordan","river.","They","are","mentioned","during","the","report","of","the","spies","about","the","inhabitants","of","the","land","of","Canaan.","The","book","of","Joshua","states","that","Joshua","","expelled","them","from","the","land","","excepting","a","remnant","that","found","a","refuge","in","the","cities","of","Gaza","","Gath","","and","Ashdod.","The","Philistine","giant","Goliath","","whom","David[24]","later","encountered","","was","supposedly","a","descendant","of","the","Anakim","The","land","","through","which","we","have","gone","to","spy","it","out","","is","a","land","that","devours","its","inhabitants","","and","all","the","people","that","we","saw","in","it","are","of","great","height.","And","there","we","saw","the","Nephilim","(the","sons","of","Anak","","who","come","from","the","Nephilim)","","and","we","seemed","to","ourselves","like","grasshoppers","","and","so","we","seemed","to","them","—[25]","It","is","more","commonly","suggested","by","traditional","Jewish","sources","(such","as","the","Midrash)","that","the","spies","saw","large","and","powerful","inhabitants","in","Canaan","and","because","of","their","own","fears","","cowardice","","and","inadequate","faith","in","Yahweh","","saw","themselves","as","grasshoppers","in","the","eyes","of","the","Canaanites","","whether","they","were","actual","giants","or","not","[edit]","In","other","texts"};
		Random chave = new Random();
		sub novo = new sub();
		chave.nextInt(50000);
		String random = chave.toString(); 
		String entrar;
		int resposta = 0;
		for(int y=0 ;y < adi.length ; y++)
		{
		inserir(lista,adi[y],random , novo);
		}
		
		while(resposta != 6)
		{
		resposta = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite : \n 1 para Inserir \n 2 Para ver toda lista \n 3 Para Buscar Linear \n 4 Para Busca Sequencial \n 5 Para busca com Hashing Dupo Incluido \n 6 para Sair")) ;
		if(resposta == 1)
			{
			entrar = JOptionPane.showInputDialog("Digite o nome para adicionar");
			inserir(lista,entrar,random , novo);
			}
		if (resposta == 2)
		{
			printar(lista,random,novo);
		}
		if (resposta == 3)
		{
			int calculo;
			entrar = JOptionPane.showInputDialog("Digite o nome para procurar");
			calculo = atribuir(lista,entrar);
			buscar(lista ,entrar, calculo);
		}
		if (resposta == 4)
		{
			int calculo;
			int vzs = 0;
			entrar = JOptionPane.showInputDialog("Digite o nome para procurar");
			calculo = atribuir(lista,entrar);
			buscarSeq(lista ,entrar, calculo,vzs);
		}
		if (resposta == 5)
		{
			int calculo;
			entrar = JOptionPane.showInputDialog("Digite o nome para procurar");
			calculo = atribuir(lista,entrar);
			buscarDuplo(lista ,entrar, calculo,random,novo);
		}
		}
	}

}
