import java.util.Arrays;

public class ProductOfAllOtherNumbers {

    public static int[] getProductsOfAllIntsExceptAtIndex (int[] numbers) {
        int len = numbers.length;
        int[] bottomUp = new int[len];
        bottomUp[0] = 1;
        int[] topDown = new int[len];
        topDown[len - 1] = 1;
        int[] allInts = new int[len];

        for (int i = 1; i < len; i++) {
            bottomUp[i] = bottomUp[i - 1] * numbers[i - 1];
        }

        for (int i = len - 2; i >= 0; i--) {
            topDown[i] = topDown[i + 1] * numbers[i + 1];
        }

        for (int i = 0; i < len; i++) {
            allInts[i] = bottomUp[i] * topDown[i];
        }

        return allInts;
    }

    public static void main(String[] args) {
        System.out.println("Running ProductOfAllOtherNumbers");

        int[] input = new int[]{1, 7, 3, 4};
        int[] output = new int[]{84, 12, 28, 21};

        int[] myOutput = getProductsOfAllIntsExceptAtIndex(input);

        boolean passesTest = Arrays.equals(output,myOutput);
        System.out.println(passesTest);
    }
}