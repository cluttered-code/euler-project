import java.util.HashSet;
import java.util.Set;

/**
 * @author David Clutter
 */
public class Utilities {

    public static Set<Integer> primeFactorsOf(final long number) {
        final Set<Integer> primeFactors = new HashSet<>();
        long copyOfInput = number;
        for (int i = 2; i <= copyOfInput; i++) {
            if (copyOfInput % i == 0) {
                primeFactors.add(i);
                copyOfInput /= i;
                i--;
            }
        }
        return primeFactors;
    }

    public static boolean isPalindrome(final long number) {
        final String numberString = String.valueOf(number);
        for(int i = 0, j = numberString.length()-1; i < j; ++i, --j) {
            if(numberString.charAt(i) != numberString.charAt(j))
                return false;
        }
        return true;
    }
}