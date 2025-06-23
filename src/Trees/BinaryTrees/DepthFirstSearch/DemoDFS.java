package Trees.BinaryTrees.DepthFirstSearch;


import Trees.BinaryTrees.TreeNode;

public class DemoDFS {
    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new TreeNode(1);
        bst.root.left = new TreeNode(2);
        bst.root.right = new TreeNode(5);
        bst.root.left.left = new TreeNode(3);
        bst.root.left.right = new TreeNode(4);
        bst.root.right.left = new TreeNode(8);
       //    bst.root.right.right = new TreeNode(6);
        //Diameter of binary tree
        System.out.println("Diameter of binary tree " + bst.diameterOfBinaryTree(bst.root));
        //Invert Binary Tree
        TreeNode res = bst.invertBinaryTree(bst.root);
        System.out.print("Invert Binary tree ");
        bst.printNode(res);
        System.out.println();
        //max depth tree
        System.out.println("max depth tree " + bst.maxDepth(bst.root));

        //Convert Sorted Array to Binary Search Tree
        TreeNode resultNode = bst.sortedArrayToBST(new int[] {-10,-3,0,5,9});
        System.out.print("Convert Sorted Array to Binary Search Tree");
        bst.printNode(resultNode);

        System.out.println();

        //Flatten Binary Tree to Linked List
        BinarySearchTree bst1 = new BinarySearchTree();
        bst1.root = new TreeNode(1);
        bst1.root.left = new TreeNode(2);
        bst1.root.right = new TreeNode(5);
        bst1.root.left.left = new TreeNode(3);
        bst1.root.left.right = new TreeNode(4);
        // bst.root.right.left = new TreeNode(8);
        bst1.root.right.right = new TreeNode(6);
        bst1.flatten(bst1.root);
        System.out.print("Flatten Binary Tree to Linked List " );
        bst1.printNode(bst1.root);

        //Validate binary tree
        BinarySearchTree bst2 = new BinarySearchTree();
        bst2.root = new TreeNode(1);
        bst2.root.left = new TreeNode(2);
        bst2.root.right = new TreeNode(2);
        bst2.root.left.left = new TreeNode(4);
        bst2.root.left.right = new TreeNode(5);
        bst2.root.right.left = new TreeNode(6);
        bst2.root.right.right = new TreeNode(8);
        /*
        bst2.root.left.right.left = new TreeNode(7);
        bst2.root.left.right.right = new TreeNode(4);
        bst2.root.right.right.left = new TreeNode(9);
        bst2.root.right.right.right = new TreeNode(19);

         */
        System.out.println();
        System.out.println("Validate Binary Tree " + bst2.isValidBST(bst2.root));

        //. Lowest Common Ancestor of a Binary Tree
        System.out.print("Lowest Common Ancestor of a Binary Tree " );
        TreeNode ancestorNode = bst2.lowestCommonAncestor(bst2.root
                       ,bst2.root.left, bst2.root.right.right.right);
        bst2.printNode(ancestorNode);

        //Count Complete Tree Nodes
        System.out.println();
        System.out.println("Count Complete Tree Nodes " + bst2.countNodes(bst2.root));

        //Same Tree
        BinarySearchTree bst3 = new BinarySearchTree();
        bst3.root = new TreeNode(3);
        bst3.root.left = new TreeNode(1);
        bst3.root.right = new TreeNode(4);
        bst3.root.left.right = new TreeNode(2);
        BinarySearchTree bst4 = new BinarySearchTree();
        bst4.root = new TreeNode(1);
        bst4.root.left = new TreeNode(2);
       // bst4.root.right = new TreeNode(3);
        System.out.println("Same Tree " + bst3.isSameTree(bst3.root,bst4.root));

        //Kth Smallest Element in a BST
        BinarySearchTree bst5 = new BinarySearchTree();
        bst5.root = new TreeNode(5);
        bst5.root.left = new TreeNode(3);
        bst5.root.right = new TreeNode(6);
        bst5.root.left.left = new TreeNode(2);
        bst5.root.left.right = new TreeNode(4);
        bst5.root.left.left.left = new TreeNode(1);
        System.out.println("Kth Smallest Element in a BST " + bst3.kthSmallest(bst5.root,3));

        //Construct Binary Tree from Preorder and Inorder Traversal
        bst5 = new BinarySearchTree();
        bst5.root = new TreeNode(3);
        bst5.root.left = new TreeNode(9);
        bst5.root.right = new TreeNode(20);
        bst5.root.right.left = new TreeNode(15);
        bst5.root.right.right = new TreeNode(7);

        System.out.print("Construct Binary Tree from Preorder and Inorder Traversal " );
        bst5.printNode(bst5.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7}));

        bst5 = new BinarySearchTree();
        bst5.root = new TreeNode(3);
        bst5.root.left = new TreeNode(9);
        bst5.root.right = new TreeNode(20);
        bst5.root.right.left = new TreeNode(15);
        bst5.root.right.right = new TreeNode(7);
        System.out.println();
        System.out.print("Construct Binary Tree from Inorder and Postorder Traversal " );
        bst5.printNode(bst5.buildTree2(new int[] {9,3,15,20,7}, new int[] {9,15,7,20,3}));

    }
}
