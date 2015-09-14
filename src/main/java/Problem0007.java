/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10,001st prime number?
 *
 * @author David Clutter
 */
public class Problem0007 {

    public static void main(final String[] args) {
        int count = 1;
        long current = 3;
        while (count < 10_001) {
            if (Utilities.isPrime(current)) {
                ++count;
            }
            if(count < 10_001) {
                current += 2;
            }
        }
        System.out.print(current);
    }
}