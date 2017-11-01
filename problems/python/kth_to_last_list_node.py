
# TODO: Could refactor for readability.
# Another option is to have a k long space in between leader and follower and have leader go to end.

class LinkedListNode:

    def __init__(self, value):
        self.value = value
        self.next  = None


def kth_to_last_node(k, head):
    leader = head
    follower = head
    count = 1

    while leader.next:
        leader = leader.next
        count += 1
    count = count - k
    while count > 0:
        if not follower:
            raise Exception()
        follower = follower.next
        count = count - 1
    return follower

def main():
    a = LinkedListNode("Angel Food")
    b = LinkedListNode("Bundt")
    c = LinkedListNode("Cheese")
    d = LinkedListNode("Devil's Food")
    e = LinkedListNode("Eccles")

    a.next = b
    b.next = c
    c.next = d
    d.next = e

    kth_to_last = kth_to_last_node(2, a)

    print(kth_to_last.value)

if __name__ == '__main__':
    main()
