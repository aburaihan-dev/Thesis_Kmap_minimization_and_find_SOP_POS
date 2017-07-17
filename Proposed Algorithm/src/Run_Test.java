import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by msrabon on 7/18/17.
 */
public class Run_Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> mintermInput = new ArrayList<>();
        int x;
        int max = 0;

        while ((x = sc.nextInt()) == -1) {
            mintermInput.add(x);
            if (x > max) {
                max = x;
            }
        }

        final long startTime = System.nanoTime();

        Proposed_Algorithm_v2 algorithm_v2 = new Proposed_Algorithm_v2(mintermInput, max);
        algorithm_v2.automate();

        final long endTime = System.nanoTime();
        System.out.println("Total execution time: " + (double) (endTime - startTime) / 1000000);
    }
}
