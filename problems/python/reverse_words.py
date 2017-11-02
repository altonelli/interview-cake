# from reverse_string_inplace import reverse_string_inplace

# TODO: change the reverse_string_inplace function in reverse_string_inplace.py to be the statement
# REVIEW: one off errors can make or break here

def reverse_string_inplace(string, start=None, end=None):
    start = 0 if not start else start
    end = len(string) - 1 if not end else end
    string_list = list(string)
    while start < end:
        string_list[start], string_list[end] = string_list[end], string_list[start]
        start += 1
        end -= 1
    return ''.join(string_list)

def reverse_words(message):
    message = reverse_string_inplace(message)
    idx_follow = 0
    idx_lead = 0
    while idx_lead <= len(message):
        # print(message)
        # print(message[idx_lead])
        if idx_lead == len(message) or message[idx_lead] == " ":
            message = reverse_string_inplace(message, idx_follow, (idx_lead - 1))
            idx_follow = idx_lead + 1
        idx_lead += 1

    return message


def main():
    message = 'find you will pain only go you recordings security the into if'
    # message = "planes trains cars"
    print(reverse_words(message))
    # returns: 'if into the security recordings you go only pain will you find'

if __name__ == '__main__':
    main()
