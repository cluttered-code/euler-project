/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * @author David Clutter
 */
public class Problem0004 {

    public static void main(final String[] args) {
        long largestPalindrome = 0;
        for(int i = 100; i < 1000; ++i) {
            for(int j = 100; j < 1000; ++j) {
                final long product = i * j;
                if(Utilities.isPalindrome(product) && product > largestPalindrome) {
                    largestPalindrome = product;
                }
            }
        }
        System.out.println(largestPalindrome);
    }
}