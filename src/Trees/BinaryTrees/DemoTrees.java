package Trees.BinaryTrees;

public class DemoTrees {

    public static void main(String[] args) {
        BinaryTreeImpl bt = new BinaryTreeImpl();
        bt.root = new TreeNode(12);
        bt.root.left = new TreeNode(23);
        bt.root.right = new TreeNode(4);
        bt.root.left.left = new TreeNode(5);

        System.out.print("\nBinary Tree: ");
        bt.traverse(bt.root);
        System.out.println();

        System.out.println("-------------------");
        System.out.println("Binary Search Tree");
        System.out.println("-------------------");

        BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
        bst.insert(45);
        bst.insert(10);
        bst.insert(7);
        bst.insert(12);
        bst.insert(90);
        bst.insert(50);
        //print the BST
        System.out.println("The BST Created with input data(Left-root-right):");
        bst.inorder();
    }
}
