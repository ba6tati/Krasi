import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class App {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static Random random = new Random();

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(input.readLine());

        int[] arr = randomArray(n, 100);

        System.out.println("Unsorted array: " + Arrays.toString(arr));

        long startTimeFF = System.nanoTime();
        int[] sortedArray = Util.BS_sort_FF(arr);
        long endTimeFF = System.nanoTime();
        long durationFF = (endTimeFF - startTimeFF) / 1000000;

        System.out.println("Sorted array (with for-for) for " + durationFF + " ms: " + Arrays.toString(sortedArray));


        int[] newArr = randomArray(n, 100);

        System.out.println("Unsorted array (again): " + Arrays.toString(newArr));

        long startTimeDW = System.nanoTime();
        int[] otherSortedArray = Util.BS_sort_DW(newArr);
        long endTimeDW = System.nanoTime();
        long durationDW = (endTimeDW - startTimeDW) / 1000000;

        System.out.println("Sorted array (with do-while) " + durationDW + " ms:" + Arrays.toString(otherSortedArray));

        /*UNCOMMENT THIS IF YOU WANT TO SEE THE DIFFERENCE IN TIME BETWEEN FF AND DW
        System.out.println("Unsorted array (again): " + Arrays.toString(arr));

        long startTimeDW = System.nanoTime();
        int[] otherSortedArray = Util.BS_sort_DW(arr);
        long endTimeDW = System.nanoTime();
        long durationDW = (endTimeDW - startTimeDW) / 1000000;

        System.out.println("Sorted array (with do-while) " + durationDW + " ms:" + Arrays.toString(otherSortedArray));
        */

        /*
        System.out.println("Sorted array (with for-for) for " + durationFF + " ms: ");
        System.out.println("Sorted array (with do-while) " + durationDW + " ms:");

         */
    }

    public static int[] randomArray(int size, int max) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            int randomNumber = random.nextInt(max+1);
            arr[i] = randomNumber;//random.ints(n, 0, 100).distinct().toArray();
        }
        return arr;
    }
}
