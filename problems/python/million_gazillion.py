

# TODO: return whether or not the url is new using an end of word character

class MillionGazillion(object):
    website_tree = {}

    def add_to_tree(url):
        current_node = self.website_tree
        for character in url:
            if current_node.get(character) is None:
                current_node[character] = {}
            current_node = current_node.get(character)
