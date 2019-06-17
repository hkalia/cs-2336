import java.util.Scanner;

public class Q6_31 {

    public static void main(String[] args) {
        System.out.println("Enter a credit card number as a long integer: ");
        Scanner input = new Scanner(System.in);
        long creditCardNum = input.nextLong();
        System.out.format(creditCardNum + " is " +
                (CreditCardNumberValidator.isValid(creditCardNum) ? "valid" : "invalid"));
    }
}

class CreditCardNumberValidator {
    /**
     * Return true if the card number is valid
     */
    public static boolean isValid(long number) {
        int numLen = getSize(number);
        return (numLen >= 13 && numLen <= 16
                && (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0
                && (prefixMatched(number, 4) || prefixMatched(number, 5)
                || prefixMatched(number, 37) || prefixMatched(number, 6)));
    }

    /**
     * Get the result from Step 2
     */
    public static int sumOfDoubleEvenPlace(long number) {
        int doubledEvenSum = 0;
        for (int i = 0; number > 0; number /= 10, i++) {
            if (i % 2 != 0) {
                doubledEvenSum += getDigit((int) ((number % 10) * 2));
            }
        }
        return doubledEvenSum;
    }

    /**
     * Return this number if it is a single digit, otherwise,
     * return the sum of the two digits
     */
    public static int getDigit(int number) {
        String numString = String.valueOf(number);
        if (numString.length() == 0) {
            return number;
        }
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    /**
     * Return sum of odd-place digits in number
     */
    public static int sumOfOddPlace(long number) {
        int oddSum = 0;
        for (int i = 0; number > 0; number /= 10, i++) {
            if (i % 2 == 0) {
                oddSum += number % 10;
            }
        }
        return oddSum;
    }

    /**
     * Return true if the digit d is a prefix for number
     */
    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize((long) d)) == d;
    }

    /**
     * Return the number of digits in d
     */
    public static int getSize(long d) {
        return String.valueOf(d).length();
    }

    /**
     * Return the first k number of digits from number. If the
     * number of digits in number is less than k, return number.
     */
    public static long getPrefix(long number, int k) {
        return Long.parseLong(Long.toString(number).substring(0, k));
    }
}