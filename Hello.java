import java.math.BigInteger;

public class Hello {
    /**
     * Compute factorial using BigInteger (handles large n).
     * @param n non-negative integer
     * @return n! as BigInteger
     * @throws IllegalArgumentException if n < 0
     */
    public static BigInteger factorialBig(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments passed.");
            System.out.println("Usage examples:");
            System.out.println("  java Hello 7");
            System.out.println("  java Hello 7 hello world");
            return;
        }

        System.out.println("All args:");
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = '" + args[i] + "'");
        }

        // try to parse first arg as integer and compute factorial
        try {
            int n = Integer.parseInt(args[0]);
            System.out.println("Parsed integer: " + n);
            BigInteger fact = factorialBig(n);
            System.out.println(n + "! = " + fact.toString());
        } catch (NumberFormatException e) {
            System.out.println("First argument is not an integer: " + args[0]);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
