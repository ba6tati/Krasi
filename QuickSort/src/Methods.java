import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Methods {
    public static void QuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = Partitioning(arr, low, high);

            QuickSort(arr, low, pi - 1);
            QuickSort(arr, pi + 1, high);
        }
    }

    private static int Partitioning(int[] arr, int low, int high) {
        int pi = low - 1;
        int pivot = arr[high];
             //pi
        //{12, 34, 54, 10, 20}
        for (int i = low; i <= high - 1; i++) {
            if (arr[i] < pivot) {
                pi ++;
                swap(arr, pi, i);
            }
        }

        pi ++;

        swap(arr, pi, high);

        return pi;
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    public static void PrintArray(int[] arr, String label) {
        System.out.print(label + ": ");
        for (int i: arr) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    public static int[] GenerateRandomArray(int length, int min, int max) throws IOException {
        return new Random().ints(length, min, max).toArray();
    }
}