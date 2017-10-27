
def fibonacci_space(num):
    if num < 2:
        return num
    two_back = 0
    one_back = 1
    current = 1
    for n in range(2, num + 1):
        current = two_back + one_back
        two_back = one_back
        one_back = current
    return current

def fibonacci(nth_num):
    fib_list = []
    fib_list.append(0)
    fib_list.append(1)
    if nth_num > 1:
        for n in range(2, nth_num + 1):
            fib_list.append(fib_list[n - 1] + fib_list[n - 2])
    return fib_list[nth_num]

def main():
    # fib(0) # => 0
    # fib(1) # => 1
    # fib(2) # => 1
    # fib(3) # => 2
    # fib(4) # => 3
    # fib(5) # => 5
    # fib(6) # => 8
    # ...
    for n in range(7):
        print(fibonacci_space(n))

if __name__ == '__main__':
    main()
