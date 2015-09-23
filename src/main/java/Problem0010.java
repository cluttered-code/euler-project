/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 * @author David Clutter
 */
public class Problem0010 {

    public static void main(final String[] args) {
        long result = 2;
        for(int i = 3; i < 2_000_000; i += 2) {
            if(Utilities.isPrime(i)) {
                result += i;
            }
        }
        System.out.println(result);
    }
}