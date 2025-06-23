package Trees.BinaryTrees;

public class BinarySearchTreeImpl {

     TreeNode root;

     public BinarySearchTreeImpl() {
         root = null;
     }

     public void insert(int val) {
         root = insertHelper(root, val);
     }

     private TreeNode insertHelper(TreeNode root, int val) {
         if(root == null) {
             root = new TreeNode(val);
             return root;
         }
         if(root.value > val) {
             root.left = insertHelper(root.left , val);
         } else {
             root.right = insertHelper(root.right, val);
         }
         return root;
     }

    //method for inorder traversal of BST
    void inorder() {
        inorder_Recursive(root);
    }

    private void inorder_Recursive(TreeNode root) {
         if(root != null) {
             inorder_Recursive(root.left);
             System.out.print(" " + root.value);
             inorder_Recursive(root.right);
         }
    }
}
