
# TODO: refactor to use a dictionary of opener: closer and create the tuples/sets from that

def bracket_validator(string):
    openers = ('(', '{', '[')
    closers = (')', '}', ']')

    stack = []

    for char in string:
        if char in openers:
            stack.append(char)
        if char in closers:
            if len(stack) == 0:
                return False
            popped = stack.pop()
            if popped is not openers[closers.index(char)]:
                return False
    return len(stack) == 0

def main():
    print(bracket_validator("{ [ ] ( ) }"))
    print(bracket_validator("{ [ ( ] ) }"))
    print(bracket_validator("{ [ }"))



if __name__ == '__main__':
    main()
