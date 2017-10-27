
# NOTE: Very good review and explaination of trade offs

# First, it doesn't work for deleting the last node in the list.
# We could change the node we're deleting to have a value of None,
# but the second-to-last node's next pointer would still point to a
# node, even though it should be None. This could work—we could
# treat this last, "deleted" node with value None as a "dead node" or
# a "sentinel node," and adjust any node traversing code to stop
# traversing when it hits such a node. The trade-off there is we
# couldn't have non-dead nodes with values set to None. Instead we
# chose to throw an exception in this case.

# There are two potential side-effects:
#
# 1) Any references to the input node have now effectively been reassigned
# to its next node. In our example, we "deleted" the node assigned to
# the variable b, but in actuality we just gave it a new value (2) and
# a new next! If we had another pointer to b somewhere else in our code
# and we were assuming it still had its old value (8), that could cause bugs.
# 2) If there are pointers to the input node's original next node, those
# pointers now point to a "dangling" node (a node that's no longer
# reachable by walking down our list). In our example above, c is now
# dangling. If we changed c, we'd never encounter that new value by
# walking down our list from the head to the tail.

class LinkedListNode:

    def __init__(self, value):
        self.value = value
        self.next  = None

def delete_node(node):
    if node.next:
        node.value = node.next.value
        node.next = node.next.next
    else:
        node = None

def main():
    a = LinkedListNode('A')
    b = LinkedListNode('B')
    c = LinkedListNode('C')


    a.next = b
    b.next = c

    node = a
    while node:
        print(node.value)
        node = node.next

    delete_node(b)

    node = a
    while node:
        print(node.value)
        node = node.next



if __name__ == '__main__':
    main()
