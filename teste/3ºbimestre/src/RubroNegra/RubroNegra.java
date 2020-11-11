package RubroNegra;
import javax.swing.JOptionPane;


public class RubroNegra {
	public static void main(String[] args) {
		int resposta= 0;
		while (resposta != 4)
		{
			resposta = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite sua opção \n 1 Para Inserir")) ; 
			if(resposta == 1)
			{
				Comparable var;
				var = JOptionPane.showInputDialog (null ,"Digite o numero para Inserir"); 
								
			}
		}
	}
	public class RedBlackTree {

		public class RedBlackNode 	{

			protected Comparable element;	 //	store an element
			protected RedBlackNode left;  	// left child node
			protected RedBlackNode right;   // right child node
			protected RedBlackNode parent;	// parent of a node	

			protected int color;

			public RedBlackNode(){}  // default constructor makes everything null

			public RedBlackNode(Comparable element, RedBlackNode parentNode){
				this.element = element;		//	assign the word
				this.parent = parentNode;	//	assign the parent node
				this.left = null;			//	set left child to null
				this.right = null;			//	set right child to null
			}
		}

		private static final int RED = 0;	//	defining red color as 0
		private static final int BLACK = 1;	//	defining black color as 1

		private RedBlackNode root;	//	declare a red black tree node as root
		private int count;	//	keep track of total number of nodes in the tree			
		
		//default constructor which set nodes count to and the root to null 
		public RedBlackTree() {		

			root = null;  
			count = 0;
		}

		//Getter for root
		public RedBlackNode getRoot(){
			return root;
		}
		
		//Same as BinaryTree Search
		private boolean search(RedBlackNode node, Comparable word){

			if(node == null)	//	return null
				return false;
			else if(node.element.compareTo(word) > 0)	//	return left child 
				return search(node.left, word);
			else if(node.element.compareTo(word) < 0)	//	return left child 
				return search(node.right, word);
			else
				return true;	// found the element in the tree, return its node
		}

		//Same as Binary Tree Search but starts searching at root
		public boolean search(Comparable word){

			return search(root, word);	//	return the node, whate above method returns
		}

		
		 // A private method used to find the right location of the word to be inserted
		private RedBlackNode find(Comparable word){

			RedBlackNode node = root;
			boolean absent = false;

			while(!absent && word.compareTo(node.element) != 0){

				if(word.compareTo(node.element) < 0 && node.left != null)
					node = node.left;	//	check left sub tree
				else if(word.compareTo(node.element) > 0 && node.right != null)
					node = node.right;	//	check right sub tree
				else 
					absent=true;		//	duplication occurs or find right location
			}

			return node;	//	return node
		}

		/*
		 *	param@ word: a word to be inserted
		 *	this method insert a word into tree if its not in the tree
		 *	if its in the tree the increment the node frequency
		 */
		private RedBlackNode insertRBT(Comparable word) {

			if(count == 0){
				count = 1;	//	first node of tree
				//	set parent to null as root don't have any parent        
				return root = new RedBlackNode(word, null);  
			}
			else{
				//	call method find and get the right location where new node to be inserted
				RedBlackNode node = find(word);	

				if(word.compareTo(node.element) < 0) {
					//	increment the nodes count and create new node at left of node (what we got from find)
					count++;	
					return node.left = new RedBlackNode(word, node);                
				}
				else if(word.compareTo(node.element) > 0) {
					//	increment the nodes count and create new node at right of node (what we got from find)
					count++;
					return node.right = new RedBlackNode(word, node); 
				}
				else {
					return null;
				} 
			}	
		}

		/*
		 *	param@ word: word to be inserted
		 *	this method is public and used to called from outside
		 */
		public void insert(Comparable word) {      

			//	call insertRBT method which actually do insertion
			RedBlackNode node = insertRBT(word); 

			if(node == null)	//	if word is already there then do nothing
				return;

			node.color = RED;	//	set the color of just inserted node to red

			/*
			 *	this block of code used to adjust the tree by rotations
			 */
			while(!node.equals(root) && node.parent.color == RED) {


				RedBlackNode uncleNode = uncle(node);	//	find the uncle of current node

				/*	if uncle is not null and its color is red
				 *	then set parent's and uncle's color of current to black
				 *	and grand father's color to red and assign current's node to its grandfather
				 */
				if(uncleNode != null && uncleNode.color == RED) {   

					node.parent.color = BLACK;
					uncleNode.color = BLACK;
					grand(node).color = RED;
					node = grand(node);
				}
				else {  

					//	determine whether parent was left child or not
					boolean parentWasLeftChild = isLeftChild(node.parent); 
					//	determine whether current node was left child or not
					boolean wasLeftChild = isLeftChild(node);

					/*
					 *	if parent was left child and current node wasn't left child
					 *	then assign current node to its parent and left rotate current not
					 */
					if(parentWasLeftChild && !wasLeftChild) {
						node = node.parent;
						leftRotate(node);
					}
					/*
					 *	if parent was not left child and current node was left child
					 *	then assign current node to its parent and right rotate current not
					 */
					else if(!parentWasLeftChild && wasLeftChild) {
						node = node.parent;
						rightRotate(node);
					}
					//	set color of current node's parent to black
					node.parent.color = BLACK;
					//	set color of current node's grand father to red
					grand(node).color = RED;

					/*
					 *	if parent was left child then right rotate the grand father of current node
					 *	else left rotate 
					 */
					if(parentWasLeftChild)
						rightRotate(grand(node));
					else 
						leftRotate(grand(node));
				} 
			}
			root.color = BLACK;   // root's color always black
		}

		/*
		 *	param@ key: key to be removed from the tree or decrement its frequency if its more than 1
		 */
		public boolean remove(Comparable key) { 

			RedBlackNode current = root;
			RedBlackNode parent = root;
			boolean isLeftChild = true;

			/*
			 *	this while loop used to determine the node to be deleted
			 **/
			while(current.element.compareTo(key) != 0)        
			{
				parent = current;
				if(current.element.compareTo(key) > 0)      
				{
					isLeftChild = true;
					current = current.left;
				}
				else                            
				{
					isLeftChild = false;
					current = current.right;
				}
				if(current == null)              
					return false;     //	node not found return false            
			}   

			/*
			 *	both child of deleted node are null 
			 */
			if(current.left == null && current.right == null) {

				if(current == root)       //	if current node is root then set root to null
					root = null;                
				else if(isLeftChild)	  //	if the current node is left child then set parent's left to null
					parent.left = null;    
				else                             
					parent.right = null;  // else right node to null		
			}


			else if(current.right == null)	//	if current node's right node is null
				if(current == root)			//  and current is root
					root = current.left;	//	then set root to left of current
				else if(isLeftChild)			//	is current node is left child
					parent.left = current.left; // set parent's left to current's left
				else
					parent.right = current.left; // set parent's right to current's left

			else if(current.left == null)	//	if current node's left node is null
				if(current == root)			//  and current is root
					root = current.right;	//	then set root to right of current
				else if(isLeftChild)			//	is current node is left child
					parent.left = current.right;// set parent's left to current's right
				else
					parent.right = current.right;// set parent's left to current's right
			/*
			 *	if both child of current node's are not null
			 */		
			else 
			{
				//	get the successor of current node
				RedBlackNode successor = getSuccessor(current);

				if(current == root)	//	id current is root then simply assign root to successor
					root = successor;
				else if(isLeftChild)	//	if current is left then set parent's left to successor
					parent.left= successor;
				else
					parent.right = successor;	//	else set parent's right to successor

				successor.left = current.left;	// successor's left to current's left

				/*
				 *	if successor is not null and its color is black
				 * then fix the red black tree
				 */
				if(successor != null && successor.color == BLACK)
					root = fixRBTree(successor);  
			}   

			count--;		//	a node has been deleted so decrement the node counter
			return true;   //	return true;
		}

		/*
		 * method used to find successor of a node
		 */
		private RedBlackNode getSuccessor(RedBlackNode delNode)
		{
			RedBlackNode successorParent = delNode;	//	assign successor's parent to delNode
			RedBlackNode successor = delNode;		//	assign successor to delNode
			RedBlackNode current = delNode.right;	//	declare a current node and set it to right child of delNode

			while(current != null) {	// do untill current become null

				successorParent = successor;	//	set successor parent to succesor
				successor = current;			//	set successor to current
				current = current.left;			//	and current to current's left
			}
			if(successor != delNode.right) {	//	successor is not equals to delNode's right

				successorParent.left = successor.right;	//	successor parent's left to successor's right
				successor.right = delNode.right;		//	and successor's right to delNode's right
			}
			return successor;	//	return successor
		}

		/*
		 *	param@ node: root od a sub tree to be fixed
		 */
		private RedBlackNode fixRBTree(RedBlackNode node){

			RedBlackNode temp;	

			/*
			 *	run loop untill it reaches the root or it's parent color is black
			 */
			while(!node.equals(root) && node.parent.color != BLACK) {

				if(isLeftChild(node)) {	//	is node is left child

					temp = node.parent.right;		//	set temp tp brother of node

					if(temp.color == RED){			//	is temps's color is RED

						temp.color = BLACK;			//	set temp's color to BLACK
						node.parent.color = RED;	//	set parent's of node to RED color
						leftRotate(node.parent);
						temp = node.parent.right;	//	set temp = node's brother
					}
					/*
					 *	if both child of temp are black
					 */
					if(temp.left.color == BLACK && temp.right.color == BLACK) {

						temp.color = RED;	//	set temp's color to red
						node = node.parent;	// and node to node's parent
					}
					/*
					 *	is temp's right child is black
					 */
					else if(temp.right.color == BLACK){

						temp.left.color = BLACK;	//	set temp's left child's color to black
						temp.color = RED;			//	set temp's color to red
						leftRotate(temp);			//	left rotate temp
						temp = node.right;			//	set temp to node's right
					}

					temp.color = node.parent.color;	//	assign the temp's color to node's parent's color
					node.parent.color = BLACK;	//	set node's parent's color to black
					temp.right.color = BLACK;	//	set right child of temp to black
					leftRotate(node.parent);	//	left rotate parent of node

					root = node;				//	root = node
				}
				else {

					temp = node.parent.left;		//	set temp to brother of node

					if(temp.color == RED){			//	is temps's color is RED

						temp.color = BLACK;			//	set temp's color to BLACK
						node.parent.color = RED;	//	set parent's of node to RED color
						rightRotate(node.parent);
						temp = node.parent.left;	//	set temp = node's brother
					}
					/*
					 *	if both child of temp are black
					 */
					if(temp.right.color == BLACK && temp.left.color == BLACK) {

						temp.color = RED;	//	set temp's color to red
						node = node.parent;	// and node to node's parent
					}
					/*
					 *	is temp's left child is black
					 */
					else if(temp.left.color == BLACK){

						temp.right.color = BLACK;	//	set temp's right child's color to black
						temp.color = RED;			//	set temp's color to red
						leftRotate(temp);			//	right rotate temp
						temp = node.left;			//	set temp to node's left
					}

					temp.color = node.parent.color;	//	assign the temp's color to node's parent's color
					node.parent.color = BLACK;	//	set node's parent's color to black
					temp.left.color = BLACK;	//	set left child of temp to black
					rightRotate(node.parent);	//	right rotate parent of node

					root = node;				//	root = node		
				}
			}
			node.color = BLACK;

			return node;
		}

		/*
		 *	param@ mode: the node to be left rotated
		 */
		private RedBlackNode leftRotate(RedBlackNode node){   

			RedBlackNode tempNode = node.right;	//	create a temp node and set it to right of node

			node.right = tempNode.left;			//	and node's right to tempNode's left
			//	basically swaping 2 brothers

			if(tempNode.left != null)			//	if tempNode's left is not null
				tempNode.left.parent = node;	//	set tempNode's left's parent to node

			tempNode.parent = node.parent;		//	set tempNode's parent to node's parent

			if(node.parent == null)		//	if node's parent is null
				root = tempNode;		//	then set root as tempNode
			else if(isLeftChild(node))	//	if node is left child
				node.parent.left = tempNode;	// set node's brother to tempNode
			else 
				node.parent.right = tempNode;	// set node's brother to tempNode

			tempNode.left = node;	//	set tempNode's left to node
			node.parent = tempNode;	//	set node's parent to tempNode

			return node;				//	return node
		}         

		private RedBlackNode rightRotate(RedBlackNode node){

			RedBlackNode tempNode = node.left;	//	create a temp node and set it to left of node

			node.left = tempNode.right;			//	and node's left to tempNode's right
			//	basically swaping 2 brothers

			if(tempNode.right != null)			//	if tempNode's right is not null
				tempNode.right.parent = node;	//	set tempNode's right's parent to node

			tempNode.parent = node.parent;		//	set tempNode's parent to node's parent

			if(node.parent == null)		//	if node's parent is null
				root = tempNode;		//	then set root as tempNode
			else if(isLeftChild(node))	//	if node is right child
				node.parent.left = tempNode;	// set node's brother to tempNode
			else 
				node.parent.right = tempNode;	// set node's brother to tempNode

			tempNode.right = node;	//	set tempNode's right to node
			node.parent = tempNode;	//	set node's parent to tempNode

			return node;				//	return node
		}  

		/*
		 *	method returns the uncle of node 
		 */
		private RedBlackNode uncle(RedBlackNode node) {
			if(node == root || node.parent == root)
				return null;
			else 
				return (isLeftChild(node.parent)?grand(node).right:grand(node).left);
		}

		/*
		 *	method returns whether the node is left child or node
		 */
		private boolean isLeftChild(RedBlackNode node){
			return node != root && node == node.parent.left;
		}

		/*
		 *	method returns the grand parent of node
		 */
		private RedBlackNode grand(RedBlackNode node){
			if(node == root || node.parent == root)
				return null;
			else 
				return node.parent.parent;
		}

		/*
		 *	public method used to display the tree in inorder
		 */
		public void printTree() {

			if(count == 0)
				System.out.println("Empty");
			else 
			{
				System.out.println("Tree contents:");
				inorder(root);   	
			}
		}

		/*
		 *	private method used to display the tree in inorder
		 */     
		private void inorder(RedBlackNode current){

			if(current == null)
				return;

			inorder(current.left);
			System.out.println(current.element);	
			inorder(current.right);
		}

		/*
		 *	public method used to compute black height
		 */
		public void computeSizeHeight(){

			int height = blackHeightR(root) + blackHeightL(root);   	

			System.out.println("Size   : "+count+", Height: "+height);
		}

		/*
		 *	black height for lefts
		 */
		public int blackHeightL(RedBlackNode node) {

			if (node == null) 
				return 0;
			if (node.color == BLACK) 
				return 1 + blackHeightR(node.left);
			else 
				return  blackHeightR(node.left);
		}

		/*
		 *	black height for rights
		 */
		public int blackHeightR(RedBlackNode node) {

			if (node == null) 
				return 0;
			if (node.color == BLACK) 
				return 1 + blackHeightR(node.right);
			else 
				return  blackHeightR(node.right);
		}

	}
}