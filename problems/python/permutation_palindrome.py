
# TODO: can refactor to use a set of unpaired characters and assert that the size of the set at the end is <= 1

def is_palindrome(string):
    char_counts = {}

    for char in string:
        char_count = char_counts.get(char)
        if not char_count:
            char_counts[char] = 1
        else:
            char_counts[char] += 1

    num_of_odds = 0
    for char, count in char_counts.iteritems():
        if count % 2 == 1:
            num_of_odds += 1
            if num_of_odds > 1:
                return False
    return True

def main():
    print(is_palindrome("civic")) # True
    print(is_palindrome("ivicc")) # True
    print(is_palindrome("civil")) # False
    print(is_palindrome("livci")) # False


if __name__ == '__main__':
    main()
