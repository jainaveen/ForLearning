package Trees.BinaryTrees;

public class BinaryTreeImpl {

    public TreeNode root;

    public void traverse(TreeNode treeNode) {
        if (treeNode != null) {
            traverse(treeNode.left);
            System.out.print(" " + treeNode.value);
            traverse(treeNode.right);
        }
    }
}


