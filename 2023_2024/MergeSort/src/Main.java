import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] array = Methods.GenerateRandomArray(1, 100);

        Methods.PrintArray(array, "Unsorted Array: ");

        long startTime = System.nanoTime();
        Methods.Sort(array, 0, array.length - 1);
        System.out.println("The process finished in " + (System.nanoTime() - startTime) + " nanoseconds" ); ;

        // Methods.PrintArray(array, "Sorted Array: ");
    }
}

// 42: Manual array copy 5072430900, 6373555200, 4636007800, 7553770000, 6616766400
// AVERAGE: 6050506060