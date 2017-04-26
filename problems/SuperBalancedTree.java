import java.util.Stack;

class SuperBalancedTree {

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

    public static boolean isSuperBalanced (BinaryTreeNode root) {
        if (root == null) {
            return false;
        }
        int[] branchLengths = new int[2]{0,0};

        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        Stack<Integer> countStack = new Stack<Integer>();

        stack.push(root);
        countStack.push(0);

        while (stack.isEmpty()) {
            BinaryTreeNode currentNode = stack.pop();
            Integer currentCount = countStack.pop()

            if (currentNode.left == null && currentNode.right == null) {

                if (branchLengths[0] == currentCount || branchLengths[1] == currentCount) {
                    continue;
                } else {
                    if (branchLengths[0] == 0) {
                        branchLengths[0] = currentCount;
                    } else if (branchLengths[1] = 0) {
                        if (Math.abs(currentCount - branchLengths[0]) > 1)
                            return false;
                        branchLengths[1] = currentCount;
                    } else {
                        return false;
                    }
                }

            } else {

                Integer nextCount = currentCount + 1;
                if (currentNode.left != null) {
                    stack.push(currentNode.left);
                    countStack.push(nextCount);
                }
                if (currentNode.left != null) {
                    stack.push(currentNode.left);
                    countStack.push(nextCount);
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        // implementation should work. would be better for consistence to subclass NodeDepthPair
    }
}