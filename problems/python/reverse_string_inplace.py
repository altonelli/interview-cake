
# If not allowed to use the swap, use a temp variable

def reverse_string_inplace(string):
    string_list = list(string)
    for idx in range(len(string_list) / 2):
        print(string_list[idx])
        string_list[idx], string_list[len(string_list) - 1 - idx] = string_list[len(string_list) - 1 - idx], string_list[idx]
        print(string_list[idx])
    return ''.join(string_list)

def main():
    print(reverse_string_inplace("reverse_string"))

if __name__ == '__main__':
    main()
