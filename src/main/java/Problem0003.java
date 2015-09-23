/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p>
 * What is the largest prime factor of the number 600851475143?
 *
 * @author David Clutter
 */
public class Problem0003 {

    public static void main(final String[] args) {
        final int result = Utilities.primeFactorsOf(600851475143L).stream()
                .max(Integer::compare)
                .get();
        System.out.println(result);
    }
}