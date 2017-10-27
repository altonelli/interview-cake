
def find_missing_drone(drone_ids):
    identifier = 0
    for drone_id in drone_ids:
        identifier = identifier ^ drone_id
    return identifier


def main():
    drone_ids = [1,2,3,4,5,1,2,4,5]
    print(find_missing_drone(drone_ids))

if __name__ == '__main__':
    main()
