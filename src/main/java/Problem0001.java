import java.util.stream.IntStream;

/**
 * @author David Clutter
 */
public class Problem0001 {

    public static void main(final String[] args) {
        System.out.println(
                IntStream.range(1, 1000)
                        .filter(n -> n % 3 == 0 || n % 5 == 0)
                        .sum()
        );
    }
}
