import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author David Clutter
 */
public class Utilities {

    /**
     * A number (N) is prime if it cannot be evenly divided by any positive integer greater than 1 and itself (N).
     * I = {x | 2 <= x < N}
     * algorithm: N % I != 0
     * runtime:   O(N)
     * 
     * All even numbers (2k) are evenly divisible by 2 we can remove them from the interval as long as we check N % 2 != 0 once.
     * I' = {x = 2k+1 | 2 < x < N}
     * algorithm: N % 2 != 0 ^ N % I' != 0
     * runtime:   O(N/2)
     * 
     * Using Dirichlet's Theorem with a residue class mod 6, all primes are 6k+1 or 6k+5, with the exception of 2 and 3.
     * 6k+0 even
     * 6k+1 ?
     * 6k+3 divisible by 3
     * 6k+4 even
     * 6k+5 ?
     * 
     * 6k+5 is equivalent to 6k-1. Using this methed we only use 2 of every 6 integers provided we also check N % 3 != 0 once.
     * I'' = {x = (6k+1,6k-1) | 3 < x < N}
     * algorithm: N % 2 != 0 ^ N % 3 != 0 ^ N % I'' != 0
     * runtime:   O(N/3)
     * 
     * While these are all still linear, O(N), 1/3 is still a great improvment especially when using large numbers.
     * 
     * Taking it one step farther, if N is composite (not prime) and therefore factorable.
     * if N = a * b
     * and a <= b
     * then N = a * a = sqrt(N) * sqrt(N)
     * 
     * if N is composite the highest possible factor is sqrt(N)
     * I''' = {x = (6k+1,6k-1) | 2 < x <= sqrt(N)}
     * algorithm: N % 2 != 0 ^ N % 3 != 0 ^ N % I''' != 0
     * runtime:   O(sqrt(N)/3)
     * 
     * @param {number} number integer
     */
    public static boolean isPrime(final long number) {
        if (number == 2 || number == 3) {
            return true;
        }
        if (number < 2 || number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        final long sqrtOfNumber = (long) Math.sqrt(number) + 1;
        for (long i = 6; i <= sqrtOfNumber; i += 6) {
            if (number % (i - 1) == 0 || number % (i + 1) == 0) {
                return false;
            }
        }
        return true;
    }

    public static Set<Long> primeFactorsOf(final long number) {
        final long start = System.currentTimeMillis();
        final Set<Long> primeFactors = new HashSet<>();
        long current = number;
        if ((current & 1) == 0) {
            primeFactors.add(2L);
            current /= 2;
        }
        for (long i = 3; i <= current / i; i += 2) {
            while (current % i == 0) {
                primeFactors.add(i);
                current /= i;
            }
        }
        if (current > 1) {
            primeFactors.add(current);
        }
        System.out.println(System.currentTimeMillis() - start);
        return primeFactors;
    }

    public static Set<Long> factorsOf(final long number) {
        if (number == 1) {
            return Collections.singleton(1L);
        }
        final Set<Long> factors = new HashSet<>();
        long factor = 1;
        long factoredNumber = number;
        while (factor < factoredNumber) {
            if (number % factor == 0) {
                factoredNumber = number / factor;
                factors.add(factor);
                factors.add(factoredNumber);
            }
            ++factor;
        }
        return factors;
    }

    public static boolean isPalindrome(final long number) {
        final String numberString = String.valueOf(number);
        for (int i = 0, j = numberString.length() - 1; i < j; ++i, --j) {
            if (numberString.charAt(i) != numberString.charAt(j))
                return false;
        }
        return true;
    }

    public static BufferedReader getResourceBufferedReader(final String resourceFilename) throws URISyntaxException, IOException {
        final URI resourceURI = ClassLoader.getSystemResource(resourceFilename).toURI();
        final Path resourcePath = Paths.get(resourceURI);
        return Files.newBufferedReader(resourcePath);
    }
}
