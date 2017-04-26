/// wrong found current.left. need to find largest of current.left


class SecondLargestElementOfBST {

    public static int findSecondLargest(BinaryTreeNode root) {
        if (root != null || (root.left == null && root.right == null)) {
            return null;
        }

        BinaryTreeNode parent;
        BinaryTreeNode current = root;

        while (current.right != null) {
            parent = current;
            current = current.right;
        }

        if (parent != null && current.left == null)
            return parent.value;
        return findLargest(current.left);
    }

    public static int findLargest (BinaryTreeNode node) {
        BinaryTreeNode current = node;

        while (current.right != null) {
            current = current.right;
        }

        return current.value;
    }

    public static void main(String[] args) {

    }
}