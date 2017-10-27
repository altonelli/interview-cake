
# TODO: Could do better on runtime and practicing this one

class Stack:

    # initialize an empty list
    def __init__(self):
        self.items = []

    # push a new item to the last index
    def push(self, item):
        self.items.append(item)

    # remove the last item
    def pop(self):
        # if the stack is empty, return None
        # (it would also be reasonable to throw an exception)
        if not self.items:
            return None
        return self.items.pop()

    # see what the last item is
    def peek(self):
        if not self.items:
            return None
        return self.items[-1]


class MaxStack(Stack):

    def __init__(self):
        self.max_stack = Stack()
        super(MaxStack, self).__init__()

    def push(self, item):
        if item >= self.max_peek():
            self.max_stack.push(item)
        self.items.append(item)

    def pop(self):
        if not self.items:
            return None
        popped = self.items.pop()
        if popped == self.max_stack.peek()
            self.max_stack.pop()
        return popped

    def get_max():
        if self.max_stack:
            return self.max_stack.peek()
        else:
            raise Exception


def main():
    pass


if __name__ == '__main__':
    main()
