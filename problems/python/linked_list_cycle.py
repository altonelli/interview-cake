

# Bonus
# 1) How would you detect the first node in the cycle? Define the first
# node of the cycle as the one closest to the head of the list.
# 2) Would the program always work if the fast runner moves three steps
# every time the slow runner moves one step?
# 3) What if instead of a simple linked list, you had a structure where 
# each node could have several "next" nodes? This data structure is
# called a "directed graph." How would you test if your directed
# graph had a cycle?


class LinkedListNode:

    def __init__(self, value):
        self.value = value
        self.next  = None

def contains_cycle(head):
    fast = head
    slow = head.next
    while fast is not None and fast.next is not None:
        if fast == slow:
            return True
        fast = fast.next.next
        slow = slow.next
    return False

def main():
    pass


if __name__ == '__main__':
    main()
