
# Note: Something you learned here was the usage of class variables vs instance variuables in Python
# be thorough when using class variables and knwoing when and when not to use init

class Stack(object):

    def __init__(self):
        self.stack = []

    def pop(self):
        popped = self.stack.pop()
        return popped

    def push(self, value):
        self.stack.append(value)
        return value

    def is_empty(self):
        return len(self.stack) == 0

class Queue(object):

    def __init__(self):
        self.in_stack = Stack()
        self.out_stack = Stack()

    def enqueue(self, value):
        print("in_stack {}".format(str(len(self.in_stack.stack))))
        print("out_stack {}".format(str(len(self.out_stack.stack))))
        return self.in_stack.push(value)

    def dequeue(self):
        if self.out_stack.is_empty():
            while not self.in_stack.is_empty():
                moving_value = self.in_stack.pop()
                print("moving {}".format(str(moving_value)))
                self.out_stack.push(moving_value)
        return self.out_stack.pop()

    def is_empty(self):
        return len(self.in_stack.stack) + len(self.out_stack.stack) == 0

def main():
    stack = Stack()

    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)

    while not stack.is_empty():
        print(stack.pop())

    queue = Queue()

    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    queue.enqueue(4)

    print(queue.dequeue())

    queue.enqueue(5)
    queue.enqueue(6)

    while not queue.is_empty():
        print(queue.dequeue())



if __name__ == '__main__':
    main()
