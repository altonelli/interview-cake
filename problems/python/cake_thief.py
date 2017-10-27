
def max_duffel_bag_value(cake_tuples, weight_capacity):
    max_gains = [0] * (weight_capacity + 1)
    for cake_tuple in cake_tuples:
        current_cake_weight = cake_tuple[0]
        current_cake_value = cake_tuple[1]
        for weight, value in enumerate(max_gains):
            weight_without_current_cake = weight - current_cake_weight
            value_with_current_cake = max_gains[weight_without_current_cake] + current_cake_value
            if weight_without_current_cake >= 0 and value_with_current_cake > max_gains[weight]:
                max_gains[weight] = value_with_current_cake
    return max_gains[weight_capacity]


def main():
    cake_tuples = [(7, 160), (3, 90), (2, 15)]
    capacity = 20

    print(max_duffel_bag_value(cake_tuples, capacity))


if __name__ == '__main__':
    main()
