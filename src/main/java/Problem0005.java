/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * <p>
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * @author David Clutter
 */
public class Problem0005 {
    public static void main(final String[] args) {
        int result = 2500;
        boolean found = false;
        while (!found) {
            result += 20;
            for (int i = 2; i <= 20; ++i) {
                if (result % i != 0)
                    break;
                if (i == 20)
                    found = true;
            }
        }
        System.out.println(result);
    }
}