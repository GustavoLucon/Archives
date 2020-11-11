package Testar;

import java.io.IOException;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

public class teste<T extends Comparable<T>> {

    private static teste<Integer> tree = new teste<Integer>();
    private static teste<Integer> tree2 = new teste<Integer>();

    public static void main(String args[]) throws IOException {

    	int value ;
        int resposta = 0;
        int qual;
        int alugado;
        String ver;
        String letras;
        String cliente;
        String cidade;
        String status;
        String compararpre;
        String compararpre2;
        String compararpos;
        String compararpos2;
        int tamanho;
        while (resposta != 8)
        {
     	   resposta =Integer.parseInt(JOptionPane.showInputDialog("Digite : \n 1: Cadastrar Placa \n 2: Ver Arvore \n 3: Comparar Arvores \n 4: Deletar Carro \n 5: Calcular Tamanho da Arvore \n 6: Pesquisar Registro \n 7: Alterar Registro \n 8: Sair"));
     	    if (resposta == 1)
     	    {
     	    	qual = Integer.parseInt(JOptionPane.showInputDialog("Digite a Arvore a ser Inserido 1 ou 2"));
     	    	if(qual == 1 || qual == 2)
     	    	{
     	    	ver = JOptionPane.showInputDialog("Digite o Numero Da Placa a Ser Inserido");
     	    	letras = JOptionPane.showInputDialog("Digite As Letras a Serem Inserido");
     	    	if(letras.length() == 3 && ver.length() == 4)
        	    {
     	    	cliente = JOptionPane.showInputDialog("Digite O Nome de Quem esta Usando o Veiculo");
     	     	cidade = JOptionPane.showInputDialog("Digite A Cidade De Registro do Veiculo");
     	     	alugado = Integer.parseInt(JOptionPane.showInputDialog("O Numero de Vezes Alugado"));
     	     	status = JOptionPane.showInputDialog("O Status Atual do Veiculo");
     	     	letras = letras.toUpperCase();
         	    value = Integer.parseInt(ver);
     	    	if(qual == 1)
     	    	{
     	    		tree.insert(value,letras,cliente,cidade,alugado,status);
     	    	}
     	    	else if (qual == 2)
     	    	{
     	    		tree2.insert(value,letras,cliente,cidade,alugado,status);
     	    	}
     	    	}
         	    else
         	    {
         	    System.out.println("Letras Invalidas \n Exemplo : Placa-1385 Letras-njb ");	
         	    }
     	    	}
     	    	else
     	    	{
     	    		 System.out.println("Arvore Nao Existe ");	   
     	    	}
     	    		
     	    }
     	    else if (resposta == 2)
     	    {
     	    	value = Integer.parseInt(JOptionPane.showInputDialog("Digite : \n 1 Para Pre Ordem \n 2 Para Pos Ordem \n 3 Para In Ordem"));
     	    	qual = Integer.parseInt(JOptionPane.showInputDialog("Digite a Arvore 1 ou 2"));
         	   if(qual == 1)
         	   {
     	    	if(value == 1)
     	    	{
     	    		System.out.println(tree.preOrder());
     	    	}
     	    	else if(value == 2)
     	    	{
     	    		System.out.println(tree.postOrder());     	    	
         	   	}
     	    	else if(value == 3)
         	  	{
     	    		System.out.println(tree.inOrder());     	 
   	    		}
     	    	else
         	  	{
   	    		System.out.println("Este numero nao faz nada");     	 
   	    		}
       	   	}
         	   else  if(qual == 2)
        	   {
    	    	if(value == 1)
    	    	{
    	    		System.out.println(tree2.preOrder());
    	    	}
    	    	else if(value == 2)
    	    	{
    	    		System.out.println(tree2.postOrder());     	    	
        	   	}
    	    	else if(value == 3)
        	  	{
  	    		System.out.println(tree2.inOrder());     	 
  	    		}
    	    	else
        	  	{
  	    		System.out.println("Este numero nao faz nada");     	 
  	    		}
      	   	}
         	   else
         	   {
         		  System.out.println("Esta Arvore Nao Existe");     	 
           	   }
        }
     	    else if (resposta == 3)
    	    {
     		compararpre = tree.preOrder();
     		compararpre2 = tree2.preOrder();
     		compararpos = tree.postOrder();
     		compararpos2 = tree2.postOrder();
     		if(compararpre.equals(compararpre2) && compararpos.equals(compararpos2))
     		{
     			System.out.println(tree.inOrder()); 
     			System.out.println("As Arvores Sao Iguais");     	 
       		}
     		else
     		{
     			System.out.println(tree.inOrder()); 
     			System.out.println(tree2.inOrder()); 
     			System.out.println("As Arvores Sao Diferentes"); 
     		}
    	    }
     	    else if(resposta == 4)
     	    {
     	   	value = Integer.parseInt(JOptionPane.showInputDialog("Digite o Valor da placa a Ser Deletado"));
 	    	qual = Integer.parseInt(JOptionPane.showInputDialog("Digite a Arvore 1 ou 2"));
 	    	if(qual == 1)
     	   {
 	    	System.out.println("Arvore Antes " + tree.inOrder()); 
     		tree.delete(value);
     		System.out.println("Arvore Depois " + tree.inOrder()); 
     	   }
     	   else if(qual == 2)
     	   {
     		System.out.println("Arvore Antes " + tree2.inOrder()); 
     		tree2.delete(value);
     		System.out.println("Arvore Depois" + tree2.inOrder()); 
     	   }
    		else
     		{
     			System.out.println("Esta Arvore Nao Existe"); 
     		}
     	    }
    	    else if(resposta == 5)
     	    {
    	    qual = Integer.parseInt(JOptionPane.showInputDialog("Digite a Arvore 1 ou 2"));
     	   if(qual == 1)
     	   {
     		   tamanho = tree.getHeight() + 1;
     		  System.out.println("Altura e de " + tamanho);
     	   }
     	   else if(qual == 2)
     	   {
     		  tamanho = tree2.getHeight() + 1;
     		  System.out.println("Altura e de " + tamanho);
     	   }
    		else
     		{
    			System.out.println("Esta Arvore Nao Existe"); 
     		}
     	    }
    	    else if(resposta == 6)
     	    {
    	    value = Integer.parseInt(JOptionPane.showInputDialog("Digite os Numero Da Placa para Obter as Informações"));   
    	    qual = Integer.parseInt(JOptionPane.showInputDialog("Digite a Arvore 1 ou 2"));
      	   	if(qual == 1)
      	   	{
    	    tree.busca(value);
      	   	}
      	   	else if(qual == 2)
      	   	{
      	   	tree2.busca(value);
      	   	}
      	   	else
      	   	{
      	   	System.out.println("Esta Arvore Nao Existe"); 
      	   	}
     	    }
    	    else if(resposta == 7)
     	    {
    	    	value = Integer.parseInt(JOptionPane.showInputDialog("Digite os Numero Da Placa para Atualizar as Informações"));
    	    	qual = Integer.parseInt(JOptionPane.showInputDialog("Digite a Arvore a ser Inserido 1 ou 2"));
     	     	cliente = JOptionPane.showInputDialog("Digite O Nome de Quem esta Usando o Veiculo");
     	     	cidade = JOptionPane.showInputDialog("Digite A Cidade De Registro do Veiculo");
     	     	alugado = Integer.parseInt(JOptionPane.showInputDialog("O Numero de Vezes Alugado"));
     	     	status = JOptionPane.showInputDialog("O Status Atual do Veiculo");
     	     	if(qual == 1)
     	     	{
     	     	tree.Mudar(value,cliente,cidade,alugado,status);
     	     	}
     	     	else if(qual == 2)
     	     	{
     	     	tree2.Mudar(value,cliente,cidade,alugado,status);	
     	     	}
     	     	else
     	     	{
     	     		System.out.println("Esta Arvore Nao Existe"); 
     	        }
     	    }
    	    else if(resposta == 8)
     	    {
	     		System.out.println("");
	    		System.out.println("Tenha um Bom Dia"); 
	    		System.exit(0);  
     	    }
    	    else
     	    {
    	    	System.out.println("Este numero nao faz nada"); 	
     	    }
        }
    }   
    private Node root;
    public void Automovel() {
        root = null;
    }
    public void Automovel(Node root) {
        this.root = root;
    }
    public void insert(T info,String letras,String cliente, String cidade,int alugado,String status ) {
        insert(info, root, null, false,letras, cliente, cidade, alugado,status);
    }
    public boolean isMember(T info) {
        return isMember(info, root);
    }
    public void busca(int value) {
        busca(value,root);
    }
    public void Mudar(int value,String cliente, String cidade,int alugado,String status ) {
        Mudar(value,root,cliente,cidade,alugado,status);
    }
    public void delete(T info) {
        delete(info, root);
    }
    public String toString() {
        return inOrder();
    }
    public String inOrder() {
        return inOrder(root);
    } 
    public String preOrder() {
        return preOrder(root);
    }
    public String postOrder() {
        return postOrder(root);
    }
    public int getHeight() {
        return getHeight(root);
    }
    
    private void busca(int value , Node node) 
    {
    	if(node != null)
    	{
    		if(node.information.equals(value))
    		{
    		System.out.println("A Placa é :" + node.information + node.letras + " \nO nome do Cliente é :" + node.cliente + " \nO nome da Cidade é :" +node.cidade + " \nO numero de vezes alugado foram :" + node.alugado + " \nE o status Atual e:" + node.status);
    		}
    		else
    		{
    		busca(value,node.left);
    		busca(value,node.right);
    		}
    	}
    	else
    	{
    	System.out.println("Nao foi Encontrado");
    	}
    }
    private void Mudar(int value , Node node,String cliente,String cidade,int alugado,String status) 
    {
    	if(node != null)
    	{
    		if(node.information.equals(value))
    		{
    		node.cliente = cliente;
    		node.cidade = cidade;
    		node.alugado = alugado;
    		node.status = status;
    		}
    		else
    		{
    		busca(value,node.left);
    		busca(value,node.right);
    		}
    	}
    	else
    	{
    	System.out.println("Nao foi Encontrado");
    	}
    }
    private void insert(T info, Node node, Node parent, boolean right , String letras ,String cliente, String cidade, int alugado ,String status ) {

        if (node == null) {
            if (parent == null) {
                root = node = new Node(info, parent,letras,cliente,cidade,alugado, status);
            } else if (right) {
                parent.right = node = new Node(info, parent , letras,cliente,cidade,alugado,status);
            } else {
                parent.left = node = new Node(info, parent, letras,cliente,cidade,alugado,status);
            }
            restructInsert(node, false);
        } else if (info.compareTo(node.information) == 0) {
            node.information = info;
        } else if (info.compareTo(node.information) > 0) {
            insert(info, node.right, node, true,letras, cidade, cidade, alugado ,status);
        } else {
            insert(info, node.left, node, false,letras, cidade, cidade, alugado,status);
        }
    }
    private boolean isMember(T info, Node node) {

        boolean member = false;

        if (node == null) {
            member = false;
        } else if (info.compareTo(node.information) == 0) {
            member = true;
        } else if (info.compareTo(node.information) > 0) {
            member = isMember(info, node.right);
        } else {
            member = isMember(info, node.left);
        }

        return member;
    }
    private void delete(T info, Node node) throws NoSuchElementException {

        if (node == null) {
            throw new NoSuchElementException();
        } else if (info.compareTo(node.information) == 0) {
            deleteNode(node);
        } else if (info.compareTo(node.information) > 0) {
            delete(info, node.right);
        } else {
            delete(info, node.left);
        }
    }
    private void deleteNode(Node node) {

        Node eNode, minMaxNode, delNode = null;
        boolean rightNode = false;

        if (node.isLeaf()) {
            if (node.parent == null) {
                root = null;
            } else if (node.isRightNode()) {
                node.parent.right = null;
                rightNode = true;
            } else if (node.isLeftNode()) {
                node.parent.left = null;
            }
            delNode = node;
        } else if (node.hasLeftNode()) {
            minMaxNode = node.left;
            for (eNode = node.left; eNode != null; eNode = eNode.right) {
                minMaxNode = eNode;
            }
            delNode = minMaxNode;
            node.information = minMaxNode.information;

            if (node.left.right != null) {
                minMaxNode.parent.right = minMaxNode.left;
                rightNode = true;
            } else {
                minMaxNode.parent.left = minMaxNode.left;
            }

            if (minMaxNode.left != null) {
                minMaxNode.left.parent = minMaxNode.parent;
            }
        } else if (node.hasRightNode()) {
            minMaxNode = node.right;
            delNode = minMaxNode;
            rightNode = true;

            node.information = minMaxNode.information;

            node.right = minMaxNode.right;
            if (node.right != null) {
                node.right.parent = node;
            }
            node.left = minMaxNode.left;
            if (node.left != null) {
                node.left.parent = node;
            }
        }
        restructDelete(delNode.parent, rightNode);
    }
    private int getHeight(Node node) {
        int height = 0;

        if (node == null) {
            height = -1;
        } else {
            height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }
        return height;
    }
    private String inOrder(Node node) {

        String result = "";
        if (node != null) {
            result = result + inOrder(node.left) + " ";
            result = result + node.information.toString()+ "-" + node.letras.toString() + " ";
            result = result + inOrder(node.right);
        }
        return result;
    }
    private String preOrder(Node node) {

        String result = "";
        if (node != null) {
            result = result + node.information.toString() + "-" + node.letras.toString() + " ";
            result = result + preOrder(node.left);
            result = result + preOrder(node.right);
        }
        return result;
    }
    private String postOrder(Node node) {

        String result = "";
        if (node != null) {
            result = result + postOrder(node.left);
            result = result + postOrder(node.right);
            result = result + node.information.toString() + "-"  + node.letras.toString() + " ";
        }
        return result;
    }
    private void restructInsert(Node node, boolean wasRight) {

        if (node != root) {
            if (node.parent.balance == '_') {
                if (node.isLeftNode()) {
                    node.parent.balance = '/';
                    restructInsert(node.parent, false);
                } else {
                    node.parent.balance = '\\';
                    restructInsert(node.parent, true);
                }
            } else if (node.parent.balance == '/') {
                if (node.isRightNode()) {
                    node.parent.balance = '_';
                } else {
                    if (!wasRight) {
                        rotateRight(node.parent);
                    } else {
                        doubleRotateRight(node.parent);
                    }
                }
            } else if (node.parent.balance == '\\') {
                if (node.isLeftNode()) {
                    node.parent.balance = '_';
                } else {
                    if (wasRight) {
                        rotateLeft(node.parent);
                    } else {
                        doubleRotateLeft(node.parent);
                    }
                }
            }
        }
    }
    private void restructDelete(Node z, boolean wasRight) {

        Node parent;
        boolean isRight = false;
        boolean climb = false;
        boolean canClimb;

        if (z == null) {
            return;
        }

        parent = z.parent;
        canClimb = (parent != null);

        if (canClimb) {
            isRight = z.isRightNode();
        }

        if (z.balance == '_') {
            if (wasRight) {
                z.balance = '/';
            } else {
                z.balance = '\\';
            }
        } else if (z.balance == '/') {
            if (wasRight) {
                if (z.left.balance == '\\') {
                    doubleRotateRight(z);
                    climb = true;
                } else {
                    rotateRight(z);
                    if (z.balance == '_') {
                        climb = true;
                    }
                }
            } else {
                z.balance = '_';
                climb = true;
            }
        } else {
            if (wasRight) {
                z.balance = '_';
                climb = true;
            } else {
                if (z.right.balance == '/') {
                    doubleRotateLeft(z);
                    climb = true;
                } else {
                    rotateLeft(z);
                    if (z.balance == '_') {
                        climb = true;
                    }
                }
            }
        }

        if (canClimb && climb) {
            restructDelete(parent, isRight);
        }
    }
    private void rotateLeft(Node a) {

        Node b = a.right;

        if (a.parent == null) {
            root = b;
        } else {
            if (a.isLeftNode()) {
                a.parent.left = b;
            } else {
                a.parent.right = b;
            }
        }

        a.right = b.left;
        if (a.right != null) {
            a.right.parent = a;
        }

        b.parent = a.parent;
        a.parent = b;
        b.left = a;

        if (b.balance == '_') {
            a.balance = '\\';
            b.balance = '/';
        } else {
            a.balance = '_';
            b.balance = '_';
        }
    }
    private void rotateRight(Node a) {

        Node b = a.left;

        if (a.parent == null) {
            root = b;
        } else {
            if (a.isLeftNode()) {
                a.parent.left = b;
            } else {
                a.parent.right = b;
            }
        }

        a.left = b.right;
        if (a.left != null) {
            a.left.parent = a;
        }

        b.parent = a.parent;
        a.parent = b;
        b.right = a;

        if (b.balance == '_') {
            a.balance = '/';
            b.balance = '\\';
        } else {
            a.balance = '_';
            b.balance = '_';
        }
    }
    private void doubleRotateLeft(Node a) {

        Node b = a.right;
        Node c = b.left;

        if (a.parent == null) {
            root = c;
        } else {
            if (a.isLeftNode()) {
                a.parent.left = c;
            } else {
                a.parent.right = c;
            }
        }

        c.parent = a.parent;

        a.right = c.left;
        if (a.right != null) {
            a.right.parent = a;
        }
        b.left = c.right;
        if (b.left != null) {
            b.left.parent = b;
        }

        c.left = a;
        c.right = b;

        a.parent = c;
        b.parent = c;

        if (c.balance == '/') {
            a.balance = '_';
            b.balance = '\\';
        } else if (c.balance == '\\') {
            a.balance = '/';
            b.balance = '_';
        } else {
            a.balance = '_';
            b.balance = '_';
        }

        c.balance = '_';
    }
    private void doubleRotateRight(Node a) {

        Node b = a.left;
        Node c = b.right;

        if (a.parent == null) {
            root = c;
        } else {
            if (a.isLeftNode()) {
                a.parent.left = c;
            } else {
                a.parent.right = c;
            }
        }

        c.parent = a.parent;

        a.left = c.right;
        if (a.left != null) {
            a.left.parent = a;
        }
        b.right = c.left;
        if (b.right != null) {
            b.right.parent = b;
        }

        c.right = a;
        c.left = b;

        a.parent = c;
        b.parent = c;

        if (c.balance == '/') {
            b.balance = '_';
            a.balance = '\\';
        } else if (c.balance == '\\') {
            b.balance = '/';
            a.balance = '_';
        } else {
            b.balance = '_';
            a.balance = '_';
        }
        c.balance = '_';
    }
    class Node {

        T information;
        
        String letras;
        
        String cliente;
        
        String cidade;
        
        String status;
        
        int alugado;

        Node parent;

        Node left;

        Node right;

        char balance;

        public Node(T information, Node parent , String letras ,String cliente , String cidade ,int alugado ,String status) 
        {
            this.information = information;
            this.letras = letras;
            this.cliente = cliente;
            this.cidade = cidade;
            this.alugado = alugado;
            this.status = status;
            this.parent = parent;
            this.left = null;
            this.right = null;
            this.balance = '_';
        }

        boolean isLeaf() {
            return ((left == null) && (right == null));
        }

        boolean isNode() {
            return !isLeaf();
        }

        boolean hasLeftNode() {
            return (null != left);
        }

        boolean hasRightNode() {
            return (right != null);
        }

        boolean isLeftNode() {
            return (parent.left == this);
        }

        boolean isRightNode() {
            return (parent.right == this);
        }
    }
}
