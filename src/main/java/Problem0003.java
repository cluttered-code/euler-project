/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p>
 * What is the largest prime factor of the number 600851475143?
 *
 * @author David Clutter
 */
public class Problem0003 {

    private static final long INPUT = Long.MAX_VALUE;//600851475143L;

    public static void main(final String[] args) {
        final long result = Utilities.primeFactorsOf(INPUT).stream()
                .max(Long::compare)
                .get();
        System.out.println(result);
    }
}