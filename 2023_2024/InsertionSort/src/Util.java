import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Util {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static Random random = new Random();
    public static int[] Input() throws IOException {
        System.out.print("Enter the size of the array: ");
        int n = Integer.parseInt(input.readLine());
        System.out.println();

        return random.ints(n, 1, 100).toArray();
    }

    public static void Print(int[] array, String label) {
        System.out.print(label + ": ");
        System.out.print(Arrays.toString(array));
        System.out.println();
    }

    public static void InsertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }

            array[j+1] = key;
        }
    }
}
