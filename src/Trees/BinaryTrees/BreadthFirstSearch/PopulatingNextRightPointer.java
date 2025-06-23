package Trees.BinaryTrees.BreadthFirstSearch;

import Trees.BinaryTrees.Node;

public class PopulatingNextRightPointer {

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalTest levelOrder = new BinaryTreeLevelOrderTraversalTest();
        // Populating Next Right Pointers in Each Node
        levelOrder.root = new Node(3);
        levelOrder.root.left = new Node(1);
        levelOrder.root.right = new Node(5);
        levelOrder.root.left.left = new Node(0);
        levelOrder.root.left.right = new Node(2);
        levelOrder.root.right.left = new Node(4);
        levelOrder.root.right.right = new Node(6);
        System.out.println("Populating Next Right Pointers in Each Node " + connect(levelOrder.root));

    }

    public static Node connect(Node root) {
        if(root == null) {
            return null;
        }

        Node currNode = root;

        while(currNode.left != null) {
            Node node = currNode;
            while(node != null) {
                node.left.next = node.right;

                if (node.next != null) {
                    node.right.next = node.next.left;
                }
                node = node.next;
            }
            currNode = currNode.left;
        }

        return root;
    }
}
