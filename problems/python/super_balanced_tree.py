from binary_tree_node import BinaryTreeNode

# TODO: move the check depths logic in to the the get_dpeths else statement.
# I ~believe~ Big-O for worst case senario is the same, but would short circut earlier and
# save on average time.

def check_if_super_balanced(node):
    stack = []
    current_depth = 0
    stack.append(node)
    depths = []
    while len(stack) > 0:
        (depths, current_depth, stack) = get_depths(depths=depths,
                                                      current_depth=current_depth,
                                                      stack=stack)
    return check_depths(depths)

def get_depths(depths, current_depths, stack):
    node = stack.pop()
    if node.left:
        stack.append(node.left)
    if node.right:
        stack.append(node.right)
    if node.right or node.left:
        current_depth += 1
    else:
        depths.append(current_depth)
        current_depth = 0
    return (depths, current_depth, stack)

def check_depths(depths):
    max_depth = 0
    for depth in depths:
        if depth > max_depth:
            max_depth = depth
    for depth in depths:
        if abs(depth - max_depth) > 1:
            return False
    return True

def main():
    pass


if __name__ == '__main__':
    main()
