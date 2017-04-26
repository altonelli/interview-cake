

class BinarySearchTreeChecker {


    // Should make this into a seperate file since consitently used
    public static class BinaryTreeNode {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }


    // True BST must have left smaller and right larger
    // Gotcha: right-left must be larger than left-right
    public static boolean isBinarySearchTree (BinaryTreeNode root) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        return isBST_rec (root, min, max);
    }

    public static boolean isBST_rec (BinaryTreeNode node, int lowerBound, int upperBound) {
        if (node.value <= lowerBound || node.value => upperBound) {
            return false;
        }

        boolean left = true;
        boolean right = true;
        if (node.left != null)
          left = isBST_rec (node.left, lowerBound, node.value);
        if (node.right != null)
          right = isBST_rec (node.right, node.value, upperBound);

        return left && right;
    }

    public static void main(String[] args) {
        // Recursive implementation. The solution online was iterative.

        BinaryTreeNode node50 = new BinaryTreeNode(50);
        BinaryTreeNode node30 = new BinaryTreeNode(30);
        BinaryTreeNode node20 = new BinaryTreeNode(20);
        BinaryTreeNode node60 = new BinaryTreeNode(60);
        BinaryTreeNode node80 = new BinaryTreeNode(80);
        BinaryTreeNode node70 = new BinaryTreeNode(70);
        BinaryTreeNode node90 = new BinaryTreeNode(90);

        node50.left = node30;
        node50.right = node80;

        node30.left = node20;
        node30.right = node60;

        node80.left = node70;
        node80.right = node90;

        System.out.println(isBinarySearchTree(node50));

    }

}