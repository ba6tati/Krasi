import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int n = scanner.nextInt();

        // VARIANT 1
        int numbers[] = rand.ints(n, 0, 101).toArray();

        /* VARIANT 2
        int numbers[] = new int[n];
        for (int i=0;i<n;i++) {
            numbers[i] = rand.nextInt(1, 101);
        }
        */

        System.out.println(Arrays.toString(numbers));
        System.out.println(arrayMax(numbers, n));
    }

    public static int arrayMax(int[] a, int n) {
        int currentMax = a[0];

        for (int i=0; i<n; i++) {
            if (a[i] > currentMax) {
                currentMax = a[i];
            }
        }

        return currentMax;
    }
}

