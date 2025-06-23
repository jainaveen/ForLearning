package Trees;

public class BST {

    public class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

    }

    private Node root;

    public BST() {

    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;

    }

    public void display() {
        display(root, "Root Node : ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.getValue());
        display(node.left, "Left Node of " + node.value + " : ");
        display(node.right, "Right Node of " + node.value + " : ");
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void populateSortedArray(int[] nums) {
        populateSortedArray(nums, 0, nums.length);
    }

    private void populateSortedArray(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        insert(nums[mid]);
        populateSortedArray(nums, start, mid);
        populateSortedArray(nums, mid + 1, end);
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        bst.populateSortedArray(nums);
        bst.display();
    }
}
