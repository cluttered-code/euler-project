/**
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is
 * 3025 − 385 = 2640.
 * <p>
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 *
 * @author David Clutter
 */
public class Problem0006 {

    public static void main(final String[] args) {
        long sumOfSquares = 0;
        long squareOfSums = 0;
        for (int i = 1; i <= 100; ++i) {
            sumOfSquares += Math.pow(i, 2);
            squareOfSums += i;
        }
        squareOfSums = (long) Math.pow(squareOfSums, 2);
        long difference = squareOfSums - sumOfSquares;
        System.out.println(difference);
    }
}
