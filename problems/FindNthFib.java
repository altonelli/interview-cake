

public class FindNthFib {

    private static int fib(int n) {
        int twoBefore = 0;
        int oneBefore = 1;
        int fib = 1;

        if (n == 0)
          return 0;

        for (int i = 2; i <= n; i++) {
            fib = twoBefore + oneBefore;
            twoBefore = oneBefore;
            oneBefore = fib;
        }

        return fib;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("" + i + " => " + fib(i));
        }
    }
}