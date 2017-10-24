from binary_tree_node import BinaryTreeNode

def find_second_largest_node(root):
    if not root.left or not root.right:
        return root.value
    current_largest = root
    second_largest = None
    while current_largest.right:
        second_largest = current_largest
        current_largest = current_largest.right
    if current_largest.left:
        second_largest = current_largest.left
        while second_largest.right:
            second_largest = second_largest.right
    return second_largest.value

def main():
    pass

if __name__ == '__main__':
    main()
