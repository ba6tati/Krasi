import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Version1 {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input backpack capacity:");
        int m = Integer.parseInt(input.readLine());

        int n = 0;
        int counter = 0;
        int kg = 0;

        while (n < 2 || n > 5) {
            System.out.println("Input the amount of items in the backpack:");
            n = Integer.parseInt(input.readLine());
        }

        int[] G = new int[n];

        for (int i = 0; i < G.length; i++) {

            while (kg < 2 || kg > 9) {
                System.out.println("Input the amount of kg for " + i + " item.");
                kg = Integer.parseInt(input.readLine());
            }

            G[i] = kg;
            kg = 0;
        }

        String result = new String();
        boolean solution = false;

        for (int i = 0; i < G.length; i++) {
            for (int j = 0; j < G.length; j++) {

                int capacity = m;
                if (G[i] == G[j]) {
                    if (capacity % G[i] == 0) {
                        counter ++;
                        result += counter + ". " + capacity / G[i] + " times * " + G[i] + " kg\n";
                        solution = true;
                    }
                    else {
                        //System.out.println("No Solution. Next item.");
                    }
                } else {
                    capacity -= G[i];
                    if (capacity % G[j] == 0) {
                        counter ++;
                        result += counter + ". " + "1 times * " + G[i] + " kg + " + capacity / G[j] + " times * " + G[j] + " kg\n";
                        solution = true;
                    } else {
                        //System.out.println("No Solution. Next item.");
                    }
                }
            }
        }

        if (solution) {
            System.out.println("These are the ways to represent " + m + " kg:");
            System.out.println(result);
        } else {
            System.out.println("There are no ways to represent " + m + " kg.");
        }
    }
}