package ARvore;

//class Tree definition  
public class arvore {  
   private no root;  
  
   // construct an empty Tree of integers  
   public arvore()   
   {   
      root = null;   
   }  
  
   // insert a new node in the binary search tree  
   public synchronized void insertNode()  
   {  
      if ( root == null )  
         root = new no(""); // create the root node here  
  
      else  
         root.inserir( ); // call the insert method  
   }
}
  
