
def find_rotation_point(words):
    return search(words, 0, len(words) - 1)

def search(words, start, end):
    while start < end:
        mid = start + (end - start) / 2
        if words[mid - 1] > words[mid]:
            return mid
        elif words[start] > words[mid]:
            end = mid - 1
        else:
            start = mid
    return end

def main():
    words = [
            'supplant',
            'undulate',
            'xenoepist',
            'asymptote', # <-- rotates here!
            'babka',
            'banoffee',
            'engender',
            'karpatka',
            'othellolagkage',
            'ptolemaic',
            'retrograde',
            ]
    print(find_rotation_point(words))

if __name__ == '__main__':
    main()
