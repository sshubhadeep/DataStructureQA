package datastructure.tree.qa.inordertraversal;

/*Recursive Java program for in order traversal of Binary Tree method1

Algorithm :
Inorder(tree)
   1. Traverse the left subtree, i.e., call Inorder(left-subtree)
   2. Visit the root.
   3. Traverse the right subtree, i.e., call Inorder(right-subtree)

Time Complexity: O(n) 

Auxiliary Space : If we don’t consider size of stack for function calls then O(1) otherwise O(n).
*/

/**
 * @author Shubhadeep Sarkar
 *
 */
public class InOrderBinaryTreeTraversal1 {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root= new Node(1);
		tree.root.left= new Node(2);
		tree.root.right= new Node(3);
		tree.root.left.left= new Node(4);
		tree.root.left.right= new Node(5);

		System.out.println("In order traversal of binary tree is ");
		tree.printInOrder();
	}

}

/* Class containing left and right child of current node and key value*/
class Node
{
	int data;
	Node left, right;
	public Node(int item)
	{
		data = item;
		left = right = null;
	}
}

class BinaryTree
{
	// Root of the Binary Tree
	Node root;

	public BinaryTree()
	{
		root = null;
	}

	/* function to print level order traversal of tree*/
	void printInOrder()
	{
		if(root == null)
			return;
		
		printInOrder(root);
		
	}
	
	void printInOrder(Node root)
	{
		if(root == null)
			return;
		
		if(root.left != null)
			printInOrder(root.left);
		
		System.out.print(root.data+" ");
		
		if(root.right != null)
			printInOrder(root.right);
		
	}

}