import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        long input;
        if (args.length > 0) {
            try {
                input = Long.parseLong(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number: " + args[0]);
                return;
            }
        } else {
            System.out.print("Enter an integer: ");
            Scanner sc = new Scanner(System.in);
            if (!sc.hasNextLong()) {
                System.err.println("No valid integer provided.");
                sc.close();
                return;
            }
            input = sc.nextLong();
            sc.close();
        }

        // handle Long.MIN_VALUE specially because Math.abs(Long.MIN_VALUE) == Long.MIN_VALUE
        if (input == Long.MIN_VALUE) {
            // use string-based reversal to avoid overflow
            String s = Long.toString(input); // e.g. "-9223372036854775808"
            boolean negative = s.charAt(0) == '-';
            String digits = negative ? s.substring(1) : s;
            String revDigits = new StringBuilder(digits).reverse().toString();
            // remove leading zeros after reversal (e.g. input 1200 -> reversed "0021" -> "21")
            revDigits = revDigits.replaceFirst("^0+(?!$)", "");
            String result = (negative ? "-" : "") + revDigits;
            System.out.println("Reversed: " + result);
        } else {
            long sign = input < 0 ? -1 : 1;
            long n = Math.abs(input);
            long reversed = 0;
            while (n > 0) {
                reversed = reversed * 10 + (n % 10);
                n /= 10;
            }
            reversed *= sign;

            System.out.println("Reversed: " + reversed);
        }
    }
}