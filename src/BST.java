import java.util.*;
public class BST {
     
	
	
	private ArrayList<BST_node> right;
	BST_node root;
	
	public BST(int r)
	{
	    
		root = new BST_node(r);
	}
	
	
	public int Balance(ArrayList<Integer> left, ArrayList<Integer> right)
	{
		return 0;
	}
	
	public int height(ArrayList<Integer> raw)
	{
		return -1;
	}
	//key is value that is to be added, root1 has an existing or non-existing value key
	public BST_node addNode(BST_node root1, int key)
	{
		
		if(key < root1.key)
		{ 
	       if(root1.left == null)
	    	   {
	    	     root1.left= new BST_node(key);
	    	     return root1.left;
	    	   }
	       else
	    	   return addNode(root1.left,key);

			
		}
		else if(key > root1.key)
		{
			if(root1.right == null)
		     {
			  root1.right= new BST_node(key);
			  return root1.right;
		     }
			else
		       return addNode(root1.right, key);

		}
		
		return null;

	}
     
	public void adder(int key) 
	{
		addNode(this.root, key);
	}
	
	public void in_order(BST_node parent)
	{
		if(parent != null)
		{
		    in_order(parent.left);
			System.out.print(" "+ parent.key);
			in_order(parent.right);

		}
		
	}
			
	public void ascend(int key)
	{
		in_order(this.root);
	}
	
    
	
	public static void main(String[] args)
	{
		BST alpha = new BST(4);
		alpha.adder(2);
		alpha.adder(3);
		alpha.adder(1);
		
	
		alpha.ascend(4);
		
		AVL beta = new AVL(4, alpha.root);
		System.out.println("\n"+beta.balance(beta.root, -1));
		if (beta.balance(beta.root, -1).equals("R"))
		{
			while(beta.balance(beta.root, -1).equals("B")== false)
			{
				beta.root =beta.double_right(beta.root, beta.root.right);

			}
		}
		else if (beta.balance(beta.root, -1).equals("L"))
		{
			while(beta.balance(beta.root, -1).equals("B")== false)
			{
				beta.root =beta.double_left(beta.root, beta.root.left);

			}
		}
		
		System.out.println(beta.root.key);
		/*
		beta.root =beta.right_heavy(beta.root, beta.root.right);
		System.out.println(beta.root.key);
		System.out.println(beta.balance(beta.root, -1));
		
		beta.root =beta.right_heavy(beta.root, beta.root.right);
		System.out.println(beta.root.key);
		System.out.println("\n"+beta.balance(beta.root, -1));
        */
	
		
		//System.out.println(beta.root.left.right.key); 
		//beta.right_heavy(beta.root);
		//System.out.println("\n"+ beta.balance(beta.root, -1)); 
		

		
		
  	}
}
