import java.lang.Math;

public class FindHighestProductOfThree {

// Fails negative values. Should keep track of lowest or most negative numbers as well.

    public static int getHighestProductOfThree (int[] numbers) {
        if (numbers.length < 3)
            throw new IllegalArgumentException("Need three numbers to take the product of three numbers");

        int largest = Math.max(Math.max(numbers[0],numbers[1]),numbers[2]);
        int secondLargest = Math.max(Math.min(numbers[0],numbers[1]),Math.min(Math.max(numbers[0],numbers[1]),numbers[2]));
        int thirdLargest = Math.max(Math.min(numbers[0],numbers[1]),numbers[2]);

        for (int i = 3; i < numbers.length; i++) {
            int number = numbers[i];
            if (number > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = number;
            } else if (number  > thirdLargest) {
                thirdLargest = number;
            }
        }

        return largest * secondLargest * thirdLargest;
    }

    public static void main(String[] args) {
        System.out.println("Running FindHighestProductOfThree");

        int[] input = new int[]{2,6,8,3,9,1};
        int expectedOutput = 432;
        int product = getHighestProductOfThree(input);

        int[] input1 = new int[]{−10,−10,1,3,2};
        int expectedOutput1 = 300;
        int product1 = getHighestProductOfThree(input1);

        boolean passesTest = (expectedOutput == product && expectedOutput1 == product1);
        System.out.println(passesTest);
    }
}