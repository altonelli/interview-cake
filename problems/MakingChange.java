

public class MakingChange {

    public static int waysToMakeChange (int amount, int[] denominations) {
        int rows = denominations.length;
        int cols = amount + 1;
        int[][] dpTable = new int[rows][cols];
        // for (int i = 0; i < rows; i++) {
        //     dpTable[i][0] = 1;
        // }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    dpTable[i][j] = 1;
                    continue;
                }

                int currentWays = 0;
                if (i > 0) {
                    currentWays = dpTable[i - 1][j];
                }
                if (j - denominations[i] >= 0) {
                    currentWays = currentWays + dpTable[i][j - denominations[i]];
                }
                dpTable[i][j] = currentWays;
            }
        }

        return dpTable[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int testAmount = 4;
        int[] testDenominations = new int[]{1,2,3};

        int numberOfWays = waysToMakeChange(testAmount, testDenominations);
        System.out.println(numberOfWays);

        int usAmount = 100;
        int[] usDenominations = new int[]{1,5,10,25,50,100};

        int usNumberOfWays = waysToMakeChange(usAmount, usDenominations);
        System.out.println(usNumberOfWays);
    }
}