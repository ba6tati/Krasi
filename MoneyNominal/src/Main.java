import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int[] nominals = {50, 20, 10, 5};
        int[] count = {0, 0, 0, 0};
        int index = 0;

        float raw_sum = Float.parseFloat(input.readLine());
        int sum = (int)(raw_sum * 100);

        for (int nom: nominals) {
            for (int i = 0; sum-nom >= 0; i++) {
                count[index] ++;
                sum -= nom;
            }
            index ++;
        }

        System.out.println("The " + raw_sum + "BGN can be represented like that:");
        for (int i = 0; i < nominals.length; i++) {
            System.out.println(nominals[i] + " is used " + count[i] + " times.");
        }

        System.out.println("The amount left is " + sum + " BG cents.");

        /*268 - 50 = 218 218-50 = 168 168-50 = 118 118-50 = 68 68-50 = 18 index = 2 18-10 = 8 index = 4

        while (sum > 0) {
            if (sum - nominals[index] >= 0) {
                sum -= nominals[index];
                count[index]++;
            } else {
                index++;
            }


        }
        /*
        for (int nom: nominals) {

            if (sum - nominals[index] >= 0) {
                //System.out.println(sum + "-" + nom + ">=0");
                sum -= nominals[index];
                count[index]++;
            } else {
                //System.out.println("!" + sum + "-" + nom + ">=0");
                index++;
            }
        }

        for (int i = 0; i < nominals.length-1; i++) {
            System.out.println(nominals[i] + " - " + count[i]);
        }

        /*
        while (sum != 0) {
            if (sum - nominals[index] >= 0) {
                sum -= nominals[index];
                count[index] ++;
            } else {
                index ++;
            }
        }

        for (int i = 0; i < nominals.length; i++) {
            System.out.println(nominals[i] + " - " + count[i]);
        }

        /*
        for (int i = 0; sum == 0; i++) {
            if (sum - nominals[index] >= 0) {
                sum -= nominals[i];
                count[index]++;
            } else {
                index++;
            }
        }

        for (int i = 0; i < nominals.length; i++) {
            System.out.println(nominals[i] + " - " + count[i]);
        }
        */
    }
}
