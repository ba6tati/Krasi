import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//import ArrayPermutation;

public class Version2 {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input backpack capacity:");
        int m = Integer.parseInt(input.readLine());

        int n = 0;
        //int counter = 0;
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

        ArrayList<int[]> GPermutations = ArrayPermutation.permute(G);

        /*
        for (int[] arr: GPermutations)
        {
            System.out.println(Arrays.toString(arr));
        }
        */


        //String result = new String();
        ArrayList<Dictionary> results = new ArrayList<Dictionary>();

        boolean solution = false;

        for (int i = 0; i < GPermutations.size(); i ++) {
            for (int j = 0; j < G.length; j++) {
                for (int k = 0; k < G.length; k++) {

                    int capacity = m;
                    if (G[j] == G[k]) {
                        if (capacity % G[j] == 0) {
                            //counter++;
                            Dictionary<Integer, Integer> result = new Hashtable<>();
                            result.put(G[j] ,capacity / G[j]);
                            //result += counter + ". " + capacity / G[j] + " times * " + G[j] + " kg\n";
                            results.add(result);
                            solution = true;
                        } else {
                            //System.out.println("No Solution. Next item.");
                        }
                    } else {
                        capacity -= G[j];
                        if (capacity % G[k] == 0) {
                            //counter++;
                            Dictionary<Integer, Integer> result = new Hashtable<>();
                            result.put(G[j], 1);
                            result.put(G[k], capacity / G[k]);
                            //result += counter + ". " + "1 times * " + G[j] + " kg + " + capacity / G[k] + " times * " + G[k] + " kg\n";
                            results.add(result);
                            solution = true;
                        } else {
                            //System.out.println("No Solution. Next item.");
                        }
                    }
                }
            }
        }

        //ArrayList<Dictionary> newResults = results;
        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.size(); j++) {
                //boolean isSame = isTheSame(i, j);

                if (isTheSame(results.get(i), results.get(j))) {
                    results.remove(j);
                }
            }
        }

        int counter = 0;
        for (Dictionary i: results) {
            counter ++;
            Enumeration<Integer> k = i.keys();

            System.out.println("_____________Solution #" + counter + "_____________");

            while (k.hasMoreElements()) {
                Integer key = k.nextElement();
                System.out.println(i.get(key) + " times * " + key + " kg");
            }
        }

        /*
        if (solution) {
            System.out.println("These are the ways to represent " + m + " kg:");
            System.out.println(result);
        } else {
            System.out.println("There are no ways to represent " + m + " kg.");
        }
         */
    }

    public static boolean isTheSame(Dictionary dict1, Dictionary dict2) {
        Enumeration<Integer> k1 = dict1.keys();
        Enumeration<Integer> k2 = dict2.keys();

        boolean isSame = true;

        while (k1.hasMoreElements() && k2.hasMoreElements()) {
            Integer key1 = k1.nextElement();
            Integer val1 = (Integer) dict1.get(key1);

            Integer key2 = k2.nextElement();
            Integer val2 = (Integer) dict2.get(key2);

            if (Objects.equals(key1, key2) && Objects.equals(val1, val2))
            {

            } else {
                isSame = false;
            }
        }

        return isSame;
    }
}