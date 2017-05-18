import java.util.HashMap;
import java.util.Map;

public class InFlightMovie {

    private static boolean getTwoMovies(int flightLength, int[] movieLengths) {
        Map <Integer, Integer> lengthPairs = new HashMap<Integer, Integer>();

        for (int movie : movieLengths) {
            int remainder = flightLength - movie;
            lengthPairs.put(movie, remainder);
        }

        for (Map.Entry<Integer, Integer> pair : lengthPairs.entrySet()) {
            Integer remainder = pair.getValue();
            if (lengthPairs.get(remainder) != null && !lengthPairs.get(remainder).equals(remainder))
              return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] testArr1 = new int[]{1,2,4,3,6};
        int testInt1 = 6;

        int[] testArr2 = new int[]{6,2,4};
        int testInt2 = 5;

        int[] testArr3 = new int[]{6,3,4};
        int testInt3 = 6;

        System.out.println(getTwoMovies(testInt1, testArr1));
        System.out.println(getTwoMovies(testInt2, testArr2));
        System.out.println(getTwoMovies(testInt3, testArr3));

    }
}