/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a^2 + b^2 = c^2. For example,
 *
 * 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 *
 * Find the product abc.
 *
 * @author David Clutter
 */
public class Problem0009 {

    public static void main(final String[] args) {
        for (int a = 1; a < 1_000; ++a) {
            for (int b = a + 1; 1_000 - a - b > b; ++b) {
                final int c = 1_000 - a - b;
                final long aSquared = (long) Math.pow(a, 2);
                final long bSquared = (long) Math.pow(b, 2);
                final long cSquared = (long) Math.pow(c, 2);
                if (aSquared + bSquared == cSquared) {
                    System.out.println("a=" + a + " b=" + b + " c=" + c);
                    System.out.print(a * b * c);
                    System.exit(0);
                }
            }
        }
    }
}