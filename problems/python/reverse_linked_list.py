

# TODO: Refactor to not need the if statement and simplify use of old_tail
# REVIEW

class LinkedListNode:

    def __init__(self, value):
        self.value = value
        self.next  = None


def reverse_linked_list(head):
    if not head or not head.next:
        return head
    old_tail = head
    current = head
    new_tail = None

    while current:
        old_tail = old_tail.next
        current.next = new_tail
        new_tail = current
        current = old_tail
    return current

def main():
    pass

if __name__ == '__main__':
    main()
