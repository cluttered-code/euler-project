import java.util.stream.LongStream;

/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * @author David Clutter
 */
public class Problem0004 {

    public static void main(final String[] args) {
        final long largestPalindrome = LongStream.range(100, 1_000)
                .flatMap(i ->
                        LongStream.range(100, 1_000)
                                .map(j -> i * j))
                .filter(Utilities::isPalindrome)
                .max()
                .getAsLong();
        System.out.println(largestPalindrome);
    }
}
