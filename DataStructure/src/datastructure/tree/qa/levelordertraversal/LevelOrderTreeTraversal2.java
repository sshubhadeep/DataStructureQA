package datastructure.tree.qa.levelordertraversal;

import java.util.LinkedList;
import java.util.Queue;

/*Iterative Queue based Java program to do level order traversal of Binary Tree method2

Algorithm:
For each node, first the node is visited and then it’s child nodes are put in a FIFO queue.

printLevelorder(tree)
1) Create an empty queue q
2) temp_node = root 
3) Loop while temp_node is not NULL
    a) print temp_node->data.
    b) Enqueue temp_node’s children (first left then right children) to q
    c) Dequeue a node from q and assign it’s value to temp_node

Implementation:
Queue is implemented using an array with maximum size of 500. We can implement queue as 
linked list also.

Time Complexity: O(n) where n is number of nodes in the binary tree */

/**
 * @author Shubhadeep Sarkar
 *
 */
public class LevelOrderTreeTraversal2 {

	public static void main(String[] args) {
		/* creating a binary tree and entering 
        the nodes */
       Tree tree_level = new Tree();
       tree_level.root = new Node(1);
       tree_level.root.left = new Node(2);
       tree_level.root.right = new Node(3);
       tree_level.root.left.left = new Node(4);
       tree_level.root.left.right = new Node(5);

       System.out.println("Level order traversal of binary tree is - ");
       tree_level.printLevelOrder();

	}
}

/* Class to represent Tree node 
class Node {
    int data;
    Node left, right;
 
    public Node(int item) {
        data = item;
        left = null;
        right = null;
    }
}*/
 
/* Class to print Level Order Traversal */
class Tree extends BinaryTree{
 
    Node root;
 
    /* Given a binary tree. Print its nodes in level order
     using array for implementing queue  */
    @Override
    void printLevelOrder() 
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) 
        {
 
            // poll() removes the present head.
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
 
            //Enqueue left child 
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            //Enqueue right child
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
}
