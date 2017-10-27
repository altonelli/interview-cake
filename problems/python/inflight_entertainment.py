
# TODO: Can do in one pass and with simpler code if use only a set to store seen movies

def movie_selector(flight_length, movie_lengths):
    movie_length_dict = {}
    for idx, movie_length in enumerate(movie_lengths):
        movies_with_length = movie_length_dict.get(movie_length)
        if movies_with_length:
            movies_with_length.add(idx)
        else:
            movie_length_dict[movie_length] = {idx}
    for idx, movie_length in enumerate(movie_lengths):
        second_movie_length = flight_length - movie_length
        second_movie_length_set = movie_length_dict.get(second_movie_length)
        if second_movie_length_set and idx is not in second_movie_length_set:
            return True
    return False


def main():
    pass

if __name__ == '__main__':
    main()
