import sys

from binary_tree_node import BinaryTreeNode

# TODO: remove second chekc of if left/right is >/< the current value. This is redundent and already
# Checked in the first if statement aonce the group is later popped.
# *Don't forget or equal to*

def is_binary_search_tree(node):
    upper_bound = sys.maxint
    lower_bound = - sys.maxint - 1
    stack = []
    group = (node, lower_bound, upper_bound)
    stack.append(group)
    while len(stack) > 0:
        current_group = stack.pop()
        current_node = current_group[0]
        current_lower_bound = current_group[1]
        current_upper_bound = current_group[2]

        if current_node.value <= current_lower_bound or current_node.value >= current_upper_bound:
            return False
        if current_node.left:
            if current_node.left.value > current_node.value or :
                return False
            else:
                next_group_left = (current_node.left, current_lower_bound, current_node.value)
                stack.append(next_group_left)
        if current_node.right:
            if current_node.right.value < current_node.value or :
                return False
            else:
                next_group_right = (current_node.right, current_node.value, current_upper_bound)
                stack.append(next_group_right)
    return True

def main():
    pass


if __name__ == '__main__':
    main()
