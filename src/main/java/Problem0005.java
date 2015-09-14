/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * @author David Clutter
 */
public class Problem0005 {

    public static void main(final String[] args) {
        int current = 2520;
        boolean found = false;
        while(!found) {
            for(int i = 2; i <= 20; ++i) {
                if(current % i != 0) {
                    break;
                }
                if(i == 20) {
                    found = true;
                }
            }
            if(!found) {
                current += 20;
            }
        }
        System.out.println(current);
    }
}