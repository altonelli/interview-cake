
# TODO: Could refactor to use O(1) space and just use a coutn variable as the len of the stack

def parenthesis_matching(string, opening):
    string_list = list(string)
    stack_opening = []

    for idx, char in enumerate(string_list):
        if char == '(':
            stack_opening.append(idx)
        if char == ')':
            opening_idx = stack_opening.pop()
            if opening_idx == opening:
                return idx
    return 0

def main():
    string = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing."
    print(parenthesis_matching(string, 10))


if __name__ == '__main__':
    main()
