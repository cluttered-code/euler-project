import java.util.LinkedList;
import java.util.List;

/**
 * The following iterative sequence is defined for the set of positive integers:
 * <p>
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * <p>
 * Using the rule above and starting with 13, we generate the following sequence:
 * <p>
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * <p>
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * <p>
 * Which starting number, under one million, produces the longest chain?
 * <p>
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 * @author David Clutter
 */
public class Problem0014 {

    public static void main(final String[] args) {
        long startingNumber = 0;
        int collatzSize = 0;
        for (int i = 2; i < 1_000_000; ++i) {
            final int currentCollatzSize = collatzList(i).size();
            if (currentCollatzSize > collatzSize) {
                collatzSize = currentCollatzSize;
                startingNumber = i;
            }
        }
        System.out.println(startingNumber);
    }


    private static List<Long> collatzList(final long number) {
        final List<Long> collatzList = new LinkedList<>();
        collatzList.add(number);
        long current = number;
        while (current != 1) {
            current = collatz(current);
            collatzList.add(current);
        }
        return collatzList;
    }

    private static long collatz(final long number) {
        return (number & 1) == 0 ? number / 2 : 3 * number + 1;
    }
}