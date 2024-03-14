import java.util.*;

public class Main {

    public static List<String> leftBay = new ArrayList<String>();
    public static List<String> rightBay = new ArrayList<String>();
    public static String boat;
    public static int index = 0;
    public static int step = 1;

    public static void main(String[] args) {
        leftBay.add("W");
        leftBay.add("G");
        leftBay.add("L");

        getObjectLeftBayToBoat();

        // System.out.println(leftBay);
    }

    public static void getObjectLeftBayToBoat() {
        boat = leftBay.get(index);
        leftBay.remove(index);
        checkForConflictsLeftBay();
    }

    public static void checkForConflictsLeftBay() {
        if (leftBay.contains("W") && leftBay.contains("G") || leftBay.contains("G") && leftBay.contains("L")) {
            leftBay.add(boat);
            boat = "";
            getObjectLeftBayToBoat();
        } else {
            // No conflict, move the object
            rightBay.add(boat);
            System.out.println(step + ". L(" + boat + ") -> R");
            step++;
            boat = "";
            checkForEverythingInRightBay();
        }
    }

    public static void checkForConflictsRightBay() {
        if (rightBay.contains("W") && rightBay.contains("G") || rightBay.contains("G") && rightBay.contains("L")) {
            /*
             * Izlishen kod
             * boat = rightBay.get(index);
             * rightBay.remove(index);
             */

            boat = rightBay.get(index);
            rightBay.remove(index);
            leftBay.add(boat);

            System.out.println(step + ". R(" + boat + ") -> L");
            step++;

            boat = "";

            getObjectLeftBayToBoat();

        } else {
            System.out.println(step + ". R(" + boat + ") -> L");
            step++;
            getObjectLeftBayToBoat();
        }
    }

    public static void checkForEverythingInRightBay() {
        if (rightBay.contains("W") && rightBay.contains("G") && rightBay.contains("L")) {
            // The problem is finished, print the result
        } else {
            checkForConflictsRightBay();
        }
    }
}











































/*
    1. 8:00 - 8:45
    2. 9:05 - 9:50
    3. 10:00 - 10:45
    4. 10:55 - 11:40
    5. 11:50 - 12:35
    6. 12:45 - 13:30
 */