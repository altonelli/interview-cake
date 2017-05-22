//// Failed the first time, should review.


public class CakeThief {

    static class InfinityException extends RuntimeException {
        public InfinityException() {
            super("Max value is infinity!");
        }
    }

    public static class CakeType {

      int weight;
      int value;

      public CakeType(int weight, int value) {
          this.weight = weight;
          this.value  = value;
      }

    }


    private static int maxDuffelBagValue(CakeType[] cakes, int weightCap) {
        int[] values = new int[weightCap + 1];
        values[0] = 0;

        for (int i = 1; i < values.length; i++) {
            int currentMax = 0;
            for (CakeType cake : cakes) {
                if (cake.weight == 0 && cake.value != 0) {
                    throw new InfinityException();
                }

                if (cake.weight <= i) {
                    int maxValueUsingCake = cake.value + values[i - cake.weight];
                    currentMax = Math.max(maxValueUsingCake, currentMax);
                }
            }

            values[i] = currentMax;


        }
        return values[weightCap];
    }


    public static void main(String[] args) {
        CakeType[] cakeTypes = new CakeType[]{
            new CakeType(7, 160),
            new CakeType(3, 90),
            new CakeType(2, 15),
        };

        int capacity = 20;

        int maxValue = maxDuffelBagValue(cakeTypes, capacity);

        System.out.println(maxValue);
    }
}