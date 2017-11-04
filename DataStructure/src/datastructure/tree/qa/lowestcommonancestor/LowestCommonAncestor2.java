package datastructure.tree.qa.lowestcommonancestor;

/*Recursive implementation to find out the lowest common ancestor method2
 * covering all scenario including 
 * 1. one node is a parent of other
 * 2. one node is not present in the tree
 * 
 * Algorithm:
 * 1. check if the first and second number is present in right or left subtree
 * 2. if one number is the current node and another is present in the left
 * or right subtree then current node is the LCA.
 * 3. if both are present in left subtree, find LCA from left subtree
 * 4. if both are present in left subtree, find LCA from left subtree
 * 5. if one is present in left another in right, current node is the LCA.
 * 6. if none of the above is true then either one of them or both of them
 * are missing form the tree so there is no LCA.
 * 
 * we can take any find(Node node, a) method that is of O(n) time complexity
 * like level order or in order traversal instead of the recursive find 
 * function which is being implemented in this case.
 * 
 * 
 * Time complexity: Worst case time complexity would be O(n^2). Consider a 
 * skewed tree, and the two node is the leaf node and its immediate parent.
 * Hence, we need to drill down to the immediate parent of the leaf node and 
 * that is (n-1) execution of the method findLCA(Node node, int a, int b). For
 * every execution has max 4n time complexity 1 for each find(Node node, int a)
 * call. Hence, the overall time complexity is O(n^2).
 * 
 * */

/**
 * @author Shubhadeep Sarkar
 *
 */
public class LowestCommonAncestor2 {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        
        Node n = tree.findLCA(4,5);
        System.out.println("LCA(4, 5): " + (n == null ? "Not found": n.data));
        n = tree.findLCA(4,6);
        System.out.println("LCA(4, 6): " + (n == null ? "Not found": n.data));
        n = tree.findLCA(3,4);
        System.out.println("LCA(3, 4): " + (n == null ? "Not found": n.data));
        n = tree.findLCA(2,4);
        System.out.println("LCA(2, 4): " + (n == null ? "Not found": n.data));
        n = tree.findLCA(2,9);
        System.out.println("LCA(2, 9): " + (n == null ? "Not found": n.data));

	}

}

class Tree extends BinaryTree
{
	// Root of the Binary Tree
	Node root;
	
	public Tree()
	{
		root = null;
	}

	@Override
	Node findLCA(int a, int b)
	{
		return findLCA(root,a,b);		
	}
	
	@Override
	Node findLCA(Node node, int a, int b)
	{
		// Base case
        if (node == null)
            return null;
        
        boolean left_a = find(node.left,a);
        boolean left_b = find(node.left,b);
        boolean right_a = find(node.right,a);
        boolean right_b = find(node.right,b);
        
        if((node.data == a && (left_b || right_b)) || (node.data == b && (left_a || right_a)))
        	return node;
        
        if(left_a && left_b)
        	return findLCA(node.left,a,b);
        if(right_a && right_b)
        	return findLCA(node.right,a,b);
        if((left_a && right_b) || (right_a && left_b))
        	return node;
        
       // System.out.println(left_a+" is the value");
        
        return null;
    }

	boolean find(Node node, int a){
		if(node == null)
			return false;
		if(node.data == a)
			return true;
		
		boolean l = find(node.left,a);
		boolean r = find(node.right,a);
		
		if(l || r)
			return true;
		
		return false;
	}
}