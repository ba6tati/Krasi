import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());

        int[] arr = Methods.GenerateRandomArray(n, 1, 100);

        Methods.PrintArray(arr, "Unsorted Array");

        Methods.QuickSort(arr, 0, arr.length - 1);
        Methods.PrintArray(arr, "Sorted Array");
    }
}
