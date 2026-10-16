import java.math.BigInteger;

public class NumberFactorial {
    /**
     * Compute factorial using BigInteger (handles large n).
     * @param n non-negative integer
     * @return n! as BigInteger
     * @throws IllegalArgumentException if n < 0
     */
    public static BigInteger factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * Compute factorial using long. Will throw ArithmeticException on overflow.
     */
    public static long factorialLong(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        long res = 1L;
        for (int i = 2; i <= n; i++) {
            res = Math.multiplyExact(res, i); // throws ArithmeticException on overflow
        }
        return res;
    }

    /**
     * Compute factorial and return both representations.
     * The returned FactorialResult contains the BigInteger value always, and
     * the long value only when it fits in a signed 64-bit long.
     */
    public static FactorialResult computeFactorial(int n) {
        BigInteger big = factorial(n);
        FactorialResult r = new FactorialResult();
        r.bigValue = big;
        try {
            r.longValue = big.longValueExact();
            r.fitsInLong = true;
        } catch (ArithmeticException ex) {
            r.fitsInLong = false;
        }
        return r;
    }

    public static class FactorialResult {
        public boolean fitsInLong;
        public long longValue;
        public BigInteger bigValue;
        @Override
        public String toString() {
            if (fitsInLong) return longValue + " (fits in long)";
            return bigValue.toString() + " (requires BigInteger)";
        }
    }

    public static void main(String[] args) {
        int[] samples = {0, 1, 5, 10, 20, 21, 50};
        System.out.println("Factorial examples (auto-detected representation):");
        for (int s : samples) {
            FactorialResult res = computeFactorial(s);
            System.out.println(s + "! = " + res.toString());
        }

        // If an argument is provided, compute that factorial as well.
        if (args.length > 0) {
            try {
                int n = Integer.parseInt(args[0]);
                FactorialResult r = computeFactorial(n);
                System.out.println(n + "! = " + r.toString());
            } catch (NumberFormatException e) {
                System.err.println("Invalid integer argument: " + args[0]);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

}
