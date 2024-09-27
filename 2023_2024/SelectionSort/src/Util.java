import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

public class Util {
    static Random random = new Random();
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static int[] GenerateRandomArray() throws IOException {
        int n = Integer.parseInt(input.readLine());

        return random.ints(n, 1, 100).toArray();
    }

    public static void SelectionSort(int[] arr) {

        //int[] arr = unsortedArray.clone();
        int n = arr.length;

        for (int i = 0; i < n-1; i++)
        {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;

                Swap(arr, minIndex, i);
            }
        }
    }

    public static void Swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void PrintArray(int[] arr, String label) {
        System.out.println(label + ": " + Arrays.toString(arr));
    }
}
