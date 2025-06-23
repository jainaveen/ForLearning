package Trees.BinaryTrees.BreadthFirstSearch;

import Trees.BinaryTrees.BinaryTreeImpl;
import Trees.BinaryTrees.Node;
import Trees.BinaryTrees.TreeNode;

public class DemoBFS {

    public static void main(String[] args) {
        BinaryTreeImpl bt = new BinaryTreeImpl();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.left.right = new TreeNode(5);
        bt.root.right.left = new TreeNode(6);
        bt.root.right.right = new TreeNode(7);

        //Level order traversal
        BinaryTreeLevelOrderTraversalTest levelOrder = new BinaryTreeLevelOrderTraversalTest();
        System.out.println("Level order traversal " + levelOrder.levelOrder(bt.root));
        //Level order traversal - recursion
        System.out.println("Level order traversal - recursion " + levelOrder.levelOrderRec(bt.root));
        //Level order traversal  - Average of Level
        System.out.println("Level order traversal - average of levels " + levelOrder.averageOfLevels(bt.root));
        //Level Order Successor of a node
     //   System.out.println("Level Order Successor of a node " + levelOrder.levelOrderSuccessor(bt.root,0).value);

        //Binary Tree Zigzag Level Order Traversal
        System.out.println("Binary Tree Zigzag Level Order Traversal " + levelOrder.zigzagLevelOrder(bt.root));
        // Binary Tree Level Order Traversal II
        System.out.println("Binary Tree Level Order Traversal II " + levelOrder.levelOrderII(bt.root));

        // Populating Next Right Pointers in Each Node
        levelOrder.root = new Node(3);
        levelOrder.root.left = new Node(1);
        levelOrder.root.right = new Node(5);
        levelOrder.root.left.left = new Node(0);
        levelOrder.root.left.right = new Node(2);
        levelOrder.root.right.left = new Node(4);
        levelOrder.root.right.right = new Node(6);
        System.out.println("Populating Next Right Pointers in Each Node " + levelOrder.connect(levelOrder.root));

        //Binary Tree Right Side View
        System.out.println("Binary Tree Right Side View " + levelOrder.rightSideView(bt.root));

        //Cousins in Binary Tree
        System.out.println("Cousins in Binary Tree " + levelOrder.isCousins(bt.root,7,5));

        //Is Symmetric
        System.out.println("Is Symmetric " + levelOrder.isSymmetric(bt.root));
        System.out.println("is symmetric using recrusion " + levelOrder.isSymmetricRecursion(bt.root));

    }
}
