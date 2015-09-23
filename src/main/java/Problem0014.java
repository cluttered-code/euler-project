import java.util.LinkedList;
import java.util.List;

/**
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