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

    public static boolean isPrime(final long number) {
        if (number < 2) {
            return false;
        }
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
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
        final Set<Long> primeFactors = new HashSet<>();
        long current = number;
        for (long i = 2; i <= current; i++) {
            if (current % i == 0) {
                primeFactors.add(i);
                current /= i;
                i--;
            }
        }
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