package datastructure.tree.qa.lowestcommonancestor;

/*
 * This program assumes that both the values are present in the tree
 * */

/**
 * @author Shubhadeep Sarkar
 *
 */
public class LowestCommonAncestor1 {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
 
        System.out.println("LCA(4, 5): " + (tree.findLCA(4,5) == null ? "Not found":tree.findLCA(4,5).data));
        System.out.println("LCA(4, 6): " + (tree.findLCA(4,6) == null ? "Not found":tree.findLCA(4,6).data));
        System.out.println("LCA(3, 4): " + (tree.findLCA(3,4) == null ? "Not found":tree.findLCA(3,4).data));
        System.out.println("LCA(2, 4): " + (tree.findLCA(2,4) == null ? "Not found":tree.findLCA(2,4).data));
        System.out.println("LCA(2, 9): " + (tree.findLCA(2,9) == null ? "Not found":tree.findLCA(2,9).data));
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
	//static boolean v1 = false, v2 = false;

	public BinaryTree()
	{
		root = null;
	}

	Node findLCA(int a, int b)
	{
		//v1=v2=false;
		return findLCA(root,a,b);		
	}
	
	Node findLCA(Node node, int a, int b)
	{
		// Base case
        if (node == null)
            return null;
        System.out.println(node.data+" ");
 
        if (node.data == a || node.data == b)
            return node;
 
        // Look for keys in left and right subtrees
        Node left_lca = findLCA(node.left, a, b);
        Node right_lca = findLCA(node.right, a, b);
 
        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null)
            return node;
        if(left_lca == null && right_lca == null)
        	return null;
 
        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
	}

}