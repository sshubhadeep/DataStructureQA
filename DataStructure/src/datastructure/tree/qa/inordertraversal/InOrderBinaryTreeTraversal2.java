package datastructure.tree.qa.inordertraversal;

import java.util.Stack;

/*Non-recursive Java program for in order traversal of Binary Tree method2

Algorithm :
Using Stack is the obvious way to traverse tree without recursion. Below is an algorithm 
for traversing binary tree using stack. See this for step wise step execution of the algorithm.

1) Create an empty stack S.
2) Initialize current node as root
3) Push the current node to S and set current = current->left until current is NULL
4) If current is NULL and stack is not empty then 
     a) Pop the top item from stack.
     b) Print the popped item, set current = popped_item->right 
     c) Go to step 3.
5) If current is NULL and stack is empty then we are done.

Time Complexity: O(n) 
*/

/**
 * @author Shubhadeep Sarkar
 *
 */
public class InOrderBinaryTreeTraversal2 {

	public static void main(String[] args) {
		/* creating a binary tree and entering 
        the nodes */
       Tree tree = new Tree();
       tree.root = new Node(1);
       tree.root.left = new Node(2);
       tree.root.right = new Node(3);
       tree.root.left.left = new Node(4);
       tree.root.left.right = new Node(5);
       
       System.out.println("In order traversal of binary tree is ");
       tree.printInOrder();
	}

}

/* Class to print the in order traversal */
class Tree extends BinaryTree {
 
    Node root;
 
    @Override
    void printInOrder() {
        if (root == null) {
            return;
        }
        
        //keep the nodes in the path that are waiting to be visited
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
         
        //first node to be visited will be the left one
        while(node != null){
        	stack.push(node);
        	node = node.left;
        }
         
        // traverse the tree
        while(stack.size() > 0){
        	
        	// visit the top node
        	node = stack.pop();
        	System.out.print(node.data+" ");
        	
        	if(node.right != null){
        		node = node.right;
        		
        		// the next node to be visited is the leftmost
        		while(node != null){
        			stack.push(node);
        			node = node.left;
        		}
        	}
        }
    }
}