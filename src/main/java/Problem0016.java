import java.math.BigInteger;

/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 *
 * @author David Clutter
 */
public class Problem0016 {

    public static void main(final String[] args) {
        final String numberString = BigInteger.valueOf(2).pow(1000).toString();
        final int sum = numberString.chars().map(Character::getNumericValue).sum();
        System.out.println(sum);
    }
}