/// Incorrect: Need to reimplement by checking on side and not both



class RotateWords {

    public static int findRotatingPoint (String[] words) {
        if (words[0].compareTo(words[words.length - 1]) < 0) {
            return 0;
        }
        return findIdx_rec (1, words.length - 1, words);
    }

    private static int findIdx_rec (int start, int end, String[] words) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (words[mid].compareTo(words[mid - 1]) < 0) {
            return mid;
        }

        int lower = findIdx_rec(start, mid - 1, words);
        int upper = findIdx_rec(mid + 1, end, words);

        return Math.max(lower, upper);

    }

    public static void main(String[] args) {

        String[] words = new String[]{
            "ptolemaic",
            "retrograde",
            "supplant",
            "undulate",
            "xenoepist",
            "asymptote", // <-- rotates here!
            "babka",
            "banoffee",
            "engender",
            "karpatka",
            "othellolagkage",
        };

        String[] words1 = new String[]{
            "asymptote", // <-- rotates here!
            "babka",
            "banoffee",
            "engender",
            "karpatka",
            "othellolagkage",
            "ptolemaic",
            "retrograde",
            "supplant",
            "undulate",
            "xenoepist",
        };

        String[] words2 = new String[]{
            "babka",
            "banoffee",
            "engender",
            "karpatka",
            "othellolagkage",
            "ptolemaic",
            "retrograde",
            "supplant",
            "undulate",
            "xenoepist",
            "asymptote", // <-- rotates here!
        };

        int test = findRotatingPoint (words);
        int test1 = findRotatingPoint (words1);
        int test2 = findRotatingPoint (words2);

        System.out.println (test);
        System.out.println (test1);
        System.out.println (test2);

    }
}